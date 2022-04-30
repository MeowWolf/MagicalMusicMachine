(ns mmm.adapters.in.node-red-controls
  (:require [clojure.pprint :refer [pprint]]
            [overtone.osc :refer [osc-server osc-handle]]
            [mmm.helpers :refer [json->map]]
            [mmm.protocols :refer [Consumer]]))

(defrecord NodeRedControls [server address]
  Consumer
  ;; TODO: add functionality to delete an instrument
  (handle-event [_ instruments _]
    (osc-handle
     server
     address
     (fn [msg]
       (swap! instruments
              (fn [current-instruments]
                (let [{:keys [id instrument]} (json->map (first (:args msg)))]
                  (if (find @instruments id)
                    (assoc current-instruments id instrument)
                    (conj current-instruments {id instrument})))))))))

(def port 4243)
(def address "/controls")
(def server (osc-server port))
(def node-red-controls (->NodeRedControls server address))
