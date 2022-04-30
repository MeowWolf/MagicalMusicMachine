(ns mmm.adapters.in.node-red-osc
  (:require [clojure.core.async :refer [>!!]]
            [clojure.pprint :refer [pprint]]
            [mmm.records.note :refer [new-note]]
            [mmm.records.instrument :refer [new-instrument]]
            [overtone.osc :refer [osc-server osc-handle]]
            [mmm.protocols :refer [Consumer Event event->note]]
            [mmm.helpers :refer [pitch-by-label json->map]]))

(defrecord NodeRedOscEvent [msg instruments]
  Event
  (event->note [_]
    (let [topic (first (:args msg))
          {:keys [note]} (json->map (second (:args msg)))]
      (new-note {:frequency (:frequency (pitch-by-label note))
                 :instrument (or (->> topic
                                      (int)
                                      (find @instruments)
                                      (second))
                                 (new-instrument {}))}))))

(defrecord NodeRedOsc [server address]
  Consumer
  (handle-event [_ instruments ch]
    (osc-handle
     server
     address
     (fn [msg]
       (println)
       (println msg)
       (println (str "Instruments: " @instruments))
       (>!! ch (event->note (->NodeRedOscEvent msg instruments)))))))

(def port 4242)
(def address "/notes")
(def server (osc-server port))
(def node-red-osc (->NodeRedOsc server address))
