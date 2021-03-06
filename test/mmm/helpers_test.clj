(ns mmm.helpers-test
  (:require [clojure.test :refer :all]
            [clojure.string :refer [includes?]]
            [clojure.pprint :refer [pprint]]
            [mmm.helpers :refer :all]))

(deftest helpers
  (testing "abs"
    (are [x y] (= (abs x) y)
      0 0
      -1 1
      1 1
      -4.4 4.4
      -0.99 0.99))

  (testing "json->map"
    (let [json-string "{\"a\": \"value\"}"
          not-json-string "okay"
          json-map {:a "value"}]
      (is (= (json->map json-string) json-map))
      (is (includes? (json->map not-json-string) "JSON error"))))

  (testing "numeric?"
    (are [x y] (= (numeric? x) y)
      0 true
      1 true
      1.23 true
      -44 true
      -987.44 true
      "22" true
      "1.23" true
      "-123" true
      "-1.44" true
      ".4" false
      false false
      true false
      "no" false
      ['hello] false
      '("nine") false
      "12.33.44" false))

  (testing "pitch-by-label-test"
    (are [x] (not= (pitch-by-label x) nil)
      "C4"
      "D#7"
      "F#2"
      "B5"
      "Bb5")
    (are [x] (= (pitch-by-label x) nil)
      "no"
      88
      false
      "A:B"
      "C:#4"
      '("C#4")
      [9 9]))

  (testing "pitch-by-midi-note"
    (are [x] (not= (pitch-by-midi-note x) nil)
      12
      21
      44
      73
      99
      119)
    (are [x] (= (pitch-by-midi-note x) nil)
      11
      "hello"
      false
      [4 5]
      '("111")
      120
      44.44))

  (testing "pitch-by-wavelength"
    (are [x] (not= (pitch-by-wavelength x) nil)
      1991.46
      1991.47
      1991.48
      -44
      888
      0
      100000)
    (are [x] (= (pitch-by-wavelength x) nil)
      "1991.46"
      "no"
      false
      true
      '("hi")
      ["okay" 44]))

  (testing "pitch-by-frequency"
    (are [x] (not= (pitch-by-frequency x) nil)
      20.59
      20.60
      20.61
      -44
      888
      0
      440
      100000)
    (are [x] (= (pitch-by-frequency x) nil)
      "20.60"
      "no"
      false
      true
      '("hi")
      ["sure" 440])))
