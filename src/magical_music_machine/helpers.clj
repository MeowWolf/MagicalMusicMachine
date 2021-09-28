(ns magical-music-machine.helpers
  (:require [clojure.data.json :as json]
            [clojure.pprint :refer [pprint]]
            [magical-music-machine.constants :refer [notes]]))

(defn abs [x] (if (neg? x) (- x) x))

(defn json->map [j]
  (try
    (json/read-str j :key-fn keyword)
    (catch Exception e (str "could not parse json: " (.getMessage e)))))

;; TODO: This function may be unnecessary
(defn numeric? [v]
  (try
    (cond (true? v) false
          (false? v) false
          (number? v) true
          (nil? (re-matches #"^-?\d+|-?\d+\.\d+$" v)) false
          :else true)
    (catch Exception _ false)))

(defn note-by-label
  "Return a note map item by note label.
   e.g. C#4, Gb6, A4"
  [label]
  (some (fn [note]
          (when (some #(= label  %) (:labels note))
            note)) notes))

(defn note-by-midi-note
  "Return a note map item by midi note number.
  e.g. 55"
  [mn]
  (some #(when (= mn (:midi-note %))
           %) notes))

(defn note-by-wavelength
  "Return a note map item by wavelength value.
   If value given is not an exact match the closest existing value is chosen"
  [wl]
  (if (not (number? wl))
    nil
    (reduce (fn [a c]
              (let [acc (:wavelength a)
                    cur (:wavelength c)]
                (cond
                  (> cur wl) c
                  (= cur wl) (reduced c)
                  :else (if (< (abs (- wl acc)) (abs (- cur wl)))
                          (reduced a)
                          (reduced c)))))
            notes)))

(defn note-by-frequency
  "Return a note map item by frequency value.
   If value given is not an exact match the closest existing value is chosen"
  [freq]
  (if (not (number? freq))
    nil
    (reduce (fn [a c]
              (let [acc (:frequency a)
                    cur (:frequency c)]
                (cond
                  (< cur freq) c
                  (= cur freq) (reduced c)
                  :else (if (< (abs (- freq acc)) (abs (- cur freq)))
                          (reduced a)
                          (reduced c)))))
            notes)))
