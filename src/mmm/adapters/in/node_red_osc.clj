(ns mmm.adapters.in.node-red-osc
  (:require [clojure.core.async :refer [>!!]]
            [mmm.records.note :refer [new-note]]
            [mmm.records.instrument :refer [new-instrument]]
            [overtone.osc :refer [osc-server osc-handle]]
            [mmm.protocols :refer [Consumer Event event->note]]
            [mmm.tonal-structures :refer [major-scale minor-scale minor-pentatonic-scale]]
            [mmm.helpers :refer [pitch-by-midi-note list-from-middle-of-list]]))

(defrecord NodeRedOscEvent [msg instruments]
  Event
  (event->note [_]
    (let [topic (first (:args msg))
          instrument (->> topic
                          (int)
                          (find @instruments)
                          (second))
          {:keys [scale root]} instrument
          notes (cond (= scale "major") (major-scale root)
                      (= scale "minor") (minor-scale root)
                      (= scale "pentatonic") (minor-pentatonic-scale root)
                      :else (major-scale "A"))
          note (:midi-note (rand-nth (list-from-middle-of-list 16 notes)))]
      (new-note {:frequency (:frequency (pitch-by-midi-note note))
                 :instrument (or instrument
                                 (new-instrument {}))}))))

(defrecord NodeRedOsc [server address]
  Consumer
  (handle-event [_ instruments ch]
    (osc-handle
     server
     address
     (fn [msg]
       (>!! ch (event->note (->NodeRedOscEvent msg instruments)))))))

(def port 4242)
(def address "/notes")
(def server (osc-server port))
(def node-red-osc (->NodeRedOsc server address))
