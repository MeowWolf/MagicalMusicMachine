(ns magical-music-machine.adapters.in.node-red-osc
  (:require [clojure.core.async :refer [>!!]]
            [clojure.pprint :refer [pprint]]
            [magical-music-machine.records.note :refer [new-note]]
            [overtone.osc :refer [osc-server osc-handle]]
            [magical-music-machine.protocols :refer [Consumer Event event->note]]
            [magical-music-machine.helpers :refer [pitch-by-label json->map]]))

(defrecord NodeRedOscEvent [msg]
  Event
  (event->note [_]
    (let [{:keys [volume note]} (json->map (first (:args msg)))]
      (new-note {:frequency (:frequency (pitch-by-label note))
                 :amplitude  volume}))))

(defrecord NodeRedOsc [server address]
  Consumer
  (handle-event [_ ch]
    (osc-handle
     server
     address
     (fn [msg] (>!! ch (event->note (->NodeRedOscEvent msg)))))))

(def port 4242)
(def address "/test")
(def server (osc-server port))
(def node-red-osc (->NodeRedOsc server address))


