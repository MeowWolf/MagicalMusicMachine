(ns magical-music-machine.records.instrument
  (:require [magical-music-machine.helpers :refer [clamp-amplitude
                                                   clamp-pan
                                                   numeric?]]))

(defrecord Instrument [label
                       note-identifier
                       pan
                       amplitude
                       attack
                       attack-level
                       decay
                       sustain
                       sustain-level
                       release
                       effects])

(defn new-instrument
  "Constructs a new instrument"
  [{:keys [label
           note-identifier
           amplitude
           pan
           attack
           attack-level
           decay
           sustain
           sustain-level
           release
           effects]}]
  (let [pan (if (numeric? pan) (clamp-pan pan) 0)
        amplitude (if (numeric? amplitude) (clamp-amplitude amplitude) 0.6)
        attack (if (numeric? attack) attack 0)
        attack-level (if (numeric? attack-level) (clamp-amplitude attack-level) amplitude)
        decay (if (numeric? decay) decay 0)
        sustain (if (numeric? sustain) sustain 0)
        sustain-level (if (numeric? sustain-level) (clamp-amplitude sustain-level) attack-level)
        release (if (numeric? release) release 1)]

    (->Instrument label
                  note-identifier
                  pan
                  amplitude
                  attack
                  attack-level
                  decay
                  sustain
                  sustain-level
                  release
                  effects)))


