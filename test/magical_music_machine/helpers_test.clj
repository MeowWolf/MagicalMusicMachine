(ns magical-music-machine.helpers-test
  (:require [clojure.test :refer :all]
            [magical-music-machine.helpers :refer :all]))

(deftest helpers
  (testing "abs"
    (are [n] (abs n)
      0 0
      -1 1
      1 1
      -4.4 4.4
      -0.99 0.99))

  (testing "json->map"
    (let [json-string "{\"a\": \"value\"}"
          json-map {:a "value"}]
      (is (json->map json-string) json-map))))


