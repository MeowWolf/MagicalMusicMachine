(ns magical-music-machine.adapters.in.node-red-controls
  (:require [clojure.pprint :refer [pprint]]
            [overtone.osc :refer [osc-server osc-handle]]
            [magical-music-machine.protocols :refer [Consumer]]))

(defrecord NodeRedControls [server address]
  Consumer
  (handle-event [_ instruments _]
    (osc-handle
     server
     address
     (fn [msg]
       (swap! instruments
              (fn [current-state]
                (conj current-state (:args msg))))))))

(def port 4243)
(def address "/test")
(def server (osc-server port))
(def node-red-controls (->NodeRedControls server address))
