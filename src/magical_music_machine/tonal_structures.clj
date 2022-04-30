(ns magical-music-machine.tonal_structures
  (:require [clojure.pprint :refer [pprint]]
            [clojure.string :as str]
            [magical-music-machine.helpers :refer [pitch-by-label]]
            [magical-music-machine.constants :refer [pitches]]))

(def lowest 12) ;; lowest midi note

;; scale masks
(def major "101011010101")
(def minor "101101011010")
(def melodic-minor "101101011011")
(def hungarian-minor "101100111001")
(def minor-pentatonic "100101010010")
(def major-pentatonic "101010010100")
(def ionian major)
(def dorian "101101010110")
(def phrygian "110101011010")
(def lydian "101010110101")
(def mixolydian "101011010110")
(def aeolian minor)
(def locrian "110101101010")

(defn- move-one-octave [operator midi-note]
  (operator midi-note 12))

(defn up-one-octave [midi-note]
  (move-one-octave + midi-note))

(defn down-one-octave [midi-note]
  (move-one-octave - midi-note))

(defn- scale-mask->vec [scale]
  (->> scale
       (char-array)
       (map str)
       (map read-string)
       (vec)))

(defn- pitch->midi-note
  "Convert numberless label (e.g. c#) to a midi-note.
   If given a midi-note to start with just send it through"
  [pitch]
  (if (number? pitch)
    pitch
    (as-> pitch n
      (str/upper-case n)
      (str n "1")
      (pitch-by-label n)
      (:midi-note n))))

(defn- scale-root
  "Get the lowest octave of a given pitch."
  [midi-note]
  (loop [down-one (down-one-octave midi-note)]
    (if (< down-one lowest)
      (up-one-octave down-one)
      (recur (down-one-octave down-one)))))

(defn traditional-scale
  "Get a scale using `scale-mask` as a template and `starting-pitch` as root"
  [scale-mask starting-pitch]
  (let [midi-note (pitch->midi-note starting-pitch)
        root (scale-root midi-note)
        scale (scale-mask->vec scale-mask)]
    (filter (fn [pitch]
              (let [current-midi-note (:midi-note pitch)
                    index (-> current-midi-note
                              (- root)
                              (mod 12))]
                (and (>= current-midi-note root)
                     (= 1 (nth scale index)))))
            pitches)))

(defn major-scale
  "Traditional major scale with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale major starting-pitch))

(defn minor-scale
  "Traditional minor scale with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale minor starting-pitch))

(defn melodic-minor-scale
  "Melodic minor scale with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale melodic-minor starting-pitch))

(defn hungarian-minor-scale
  "Hungarian minor scale with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale hungarian-minor starting-pitch))

(defn minor-pentatonic-scale
  "Minor pentatonic scale with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale minor-pentatonic starting-pitch))

(defn major-pentatonic-scale
  "Major pentatonic scale with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale major-pentatonic starting-pitch))

(defn ionian-mode
  "Ionian mode with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale ionian starting-pitch))

(defn dorian-mode
  "Dorian mode with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale dorian starting-pitch))

(defn phrygian-mode
  "Phrygian mode with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale phrygian starting-pitch))

(defn lydian-mode
  "Lydian mode with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale lydian starting-pitch))

(defn mixolydian-mode
  "Mixolydian mode with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale mixolydian starting-pitch))

(defn aeolian-mode
  "Aeolian mode with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale aeolian starting-pitch))

(defn locrian-mode
  "Locrian mode with `starting-pitch` as root"
  [starting-pitch]
  (traditional-scale locrian starting-pitch))

(defn whole-tone-scale
  "Whole tone scale with `starting-pitch` as root"
  [starting-pitch]
  (let [midi-note (pitch->midi-note starting-pitch)
        pred (if (even? midi-note) even? odd?)]
    (filter (fn [pitch]
              (pred (:midi-note pitch)))
            pitches)))

(defn chromatic-scale
  "All the notes"
  []
  pitches)
