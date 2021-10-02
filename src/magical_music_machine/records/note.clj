(ns magical-music-machine.records.note
  (:require [magical-music-machine.helpers :refer [pitch-by-frequency
                                                   pitch-by-label
                                                   pitch-by-midi-note
                                                   pitch-by-wavelength
                                                   clamp-amplitude
                                                   clamp-pan
                                                   numeric?]]))

(defrecord Note [pitch
                 pan
                 amplitude
                 attack
                 attack-level
                 decay
                 sustain
                 sustain-level
                 release
                 effects])

(defn new-note
  "Constructs a new note.
   Raw incoming data must be converted to notes before further processing"
  [{:keys [label
           frequency
           wavelength
           midi-note
           amplitude
           pan
           attack
           attack-level
           decay
           sustain
           sustain-level
           release
           effects]}]
  (let [pitch (or (pitch-by-label label)
                  (pitch-by-frequency frequency)
                  (pitch-by-wavelength wavelength)
                  (pitch-by-midi-note midi-note))
        pan (if (numeric? pan) (clamp-pan pan) 0)
        amplitude (if (numeric? amplitude) (clamp-amplitude amplitude) 0.6)
        attack (if (numeric? attack) attack 0)
        attack-level (if (numeric? attack-level) (clamp-amplitude attack-level) amplitude)
        decay (if (numeric? decay) decay 0)
        sustain (if (numeric? sustain) sustain 0)
        sustain-level (if (numeric? sustain-level) (clamp-amplitude sustain-level) attack-level)
        release (if (numeric? release) release 1)]

    (println (str "pitch: " pitch))
    (println (str "pan: " pan))
    (println (str "amplitude: " amplitude))
    (println (str "attack: " attack))
    (println (str "attack-level: " attack-level))
    (println (str "decay: " decay))
    (println (str "sustain: " sustain))
    (println (str "sustain-level: " sustain-level))
    (println (str "release: " release))

    (->Note pitch
            pan
            amplitude
            attack
            attack-level
            decay
            sustain
            sustain-level
            release
            effects)))

