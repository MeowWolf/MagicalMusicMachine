(ns magical-music-machine.adapters.out.sonic-pi-osc
  (:require [overtone.osc :refer [osc-client osc-send]]
            [clojure.pprint :as pp :refer [pprint]]
            [magical-music-machine.protocols :refer [Publisher]]))

(defrecord SonicPiOsc [client address]
  Publisher
  (send-message [_ note]
    (let [message
          [(or (get-in note [:instrument :label])
               "sine")
           (->> note
                (:pitch)
                (:midi-note))
           (get-in note [:instrument :amplitude])
           (get-in note [:instrument :pan])]]

      (println "Message:")
      (pprint message)
      (apply osc-send client address message))))

(def port 4560)
(def address "/sonic")
(def client (osc-client "localhost" port))
(def sonic-pi-osc (->SonicPiOsc client address))