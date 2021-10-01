(ns magical-music-machine.adapters.out.sonic-pi-osc
  (:require [overtone.osc :refer [osc-client osc-send]]
            [clojure.pprint :as pp :refer [pprint]]
            [magical-music-machine.helpers :refer [pitch-by-frequency]]
            [magical-music-machine.protocols :refer [Publisher]]))

(defrecord SonicPiOsc [client address]
  Publisher
  (send-message [_ note]
    (let [message
          [(->> note
                (:frequency)
                (pitch-by-frequency)
                (:midi-note))
           (:amplitude note)]]
      (pprint message)
      (apply osc-send client address message))))

(def port 4560)
(def address "/sonic")
(def client (osc-client "localhost" port))
(def sonic-pi-osc (->SonicPiOsc client address))