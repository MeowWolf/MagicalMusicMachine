(ns magical-music-machine.note
  (:require [magical-music-machine.helpers :refer [numeric?]]))

(defrecord Note [frequency amplitude])

(defn new-note
  "Constructs a new Event.
   Raw incoming data must be converted to notes before further processing"
  [{:keys [frequency amplitude]}]
  {:pre [(numeric? frequency)
         (numeric? amplitude)]}
  (->Note frequency amplitude))
