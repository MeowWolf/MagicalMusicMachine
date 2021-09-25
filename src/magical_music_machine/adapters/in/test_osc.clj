(ns magical-music-machine.adapters.in.test-osc
  (:require [clojure.core.async
             :as a
             :refer [>!!]]
            [clojure.pprint :as pp
             :refer [pprint]]
            [overtone.osc
             :refer [osc-server osc-handle]]
            [magical-music-machine.helpers
             :refer [note-by-label json->map]]))

(defn event->Note [msg note-constructor]
  (let [{:keys [volume note]} (json->map (first (:args msg)))]
    (note-constructor {:frequency (:frequency (note-by-label note))
                       :amplitude  volume})))

(def port 4242)
(def address "/test")
(def server (osc-server port))

(defn handle-event [ch note-constructor]
  (osc-handle
   server
   address
   (fn [msg] (>!! ch (event->Note msg note-constructor)))))


