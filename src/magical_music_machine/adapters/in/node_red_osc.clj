(ns magical-music-machine.adapters.in.node-red-osc
  (:require [clojure.core.async :refer [>!!]]
            [clojure.pprint :refer [pprint]]
            [overtone.osc :refer [osc-server osc-handle]]
            [magical-music-machine.protocols :refer [Consumer Note event->Note]]
            [magical-music-machine.helpers :refer [note-by-label json->map]]))

(defrecord NodeRedOscEvent [msg note-constructor]
  Note
  (event->Note [_]
    (let [{:keys [volume note]} (json->map (first (:args msg)))]
      (note-constructor {:frequency (:frequency (note-by-label note))
                         :amplitude  volume}))))

(defrecord NodeRedOsc [server address]
  Consumer
  (handle-event [_ ch note-constructor]
    (osc-handle
     server
     address
     (fn [msg] (>!! ch (event->Note (->NodeRedOscEvent msg note-constructor)))))))

(def port 4242)
(def address "/test")
(def server (osc-server port))
(def node-red-osc (->NodeRedOsc server address))


