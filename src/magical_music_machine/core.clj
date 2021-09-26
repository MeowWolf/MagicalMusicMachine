(ns magical-music-machine.core
  (:require [clojure.pprint :refer [pprint]]
            [clojure.core.async :refer [<!! <! go-loop chan]]
            [magical-music-machine.protocols :refer [handle-event send-message]]
            [magical-music-machine.adapters.out.sonic-pi-osc :refer [sonic-pi-osc]]
            [magical-music-machine.adapters.in.node-red-osc :refer [node-red-osc]])
  (:gen-class))

(defn -main
  "Magical music machine main"
  [& args]
  (let [in (chan)]
    (handle-event node-red-osc in)

    (go-loop []
      (let [note (<! in)]
        (send-message sonic-pi-osc note))

      (recur))

    (println "Magical music machine started!")

    ;; run forever
    (<!! (chan))))