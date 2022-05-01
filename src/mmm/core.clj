(ns mmm.core
  (:require [clojure.core.async :refer [<!! <! go-loop chan]]
            [mmm.protocols :refer [handle-event send-message]]
            [mmm.adapters.out.sonic-pi-osc :refer [sonic-pi-osc]]
            [mmm.adapters.in.node-red-osc :refer [node-red-osc]]
            [mmm.adapters.in.node-red-controls :refer [node-red-controls]])
  (:gen-class))

(defn -main
  "Magical music machine main"
  []
  (let [instruments (atom {})
        in (chan)]
    (handle-event node-red-osc instruments in)
    (handle-event node-red-controls instruments nil)

    (go-loop []
      (let [note (<! in)]
        (send-message sonic-pi-osc note))
      (recur))

    (println "🎵 Magical music machine started 🎵")

    ;; run forever
    <!! (chan)))
