(ns mmm.adapters.out.sonic-pi-osc
  (:require [overtone.osc :refer [osc-client osc-send]]
            [clojure.pprint :refer [pprint]]
            [mmm.protocols :refer [Publisher]]))

(defrecord SonicPiOsc [client address]
  Publisher
  (send-message [_ note]
    (let [message
          [(or (get-in note [:instrument :label])
               "sine")
           (or (->> note
                    (:pitch)
                    (:midi-note))
               60)
           (get-in note [:instrument :amplitude])
           (get-in note [:instrument :pan])]]

      (println "sonic-pi-osc message:")
      (pprint message)
      (println)

      (apply osc-send client address message))))

(def port 4560)
(def address "/sonic")
(def client (osc-client "localhost" port))
(def sonic-pi-osc (->SonicPiOsc client address))
