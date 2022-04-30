(ns mmm.records.note
  (:require [mmm.helpers :refer [pitch-by-frequency
                                                   pitch-by-label
                                                   pitch-by-midi-note
                                                   pitch-by-wavelength]]))

(defrecord Note [pitch
                 instrument])

(defn new-note
  "Constructs a new note.
   Raw incoming data must be converted to notes before further processing"
  [{:keys [label
           frequency
           wavelength
           midi-note
           instrument]}]
  (let [pitch (or (pitch-by-label label)
                  (pitch-by-frequency frequency)
                  (pitch-by-wavelength wavelength)
                  (pitch-by-midi-note midi-note))]

    (->Note pitch
            instrument)))
