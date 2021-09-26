(ns magical-music-machine.core
  (:require [clojure.pprint :refer [pprint]]
            [clojure.core.async :refer [<!! <! go-loop chan]]
            [magical-music-machine.note :refer [new-note]]
            [magical-music-machine.protocols :refer [handle-event]]
            [magical-music-machine.adapters.in.node-red-osc :refer [node-red-osc]])
  (:gen-class))

(defn -main
  "Magical music machine main"
  [& args]
  (let [in (chan)]
    (handle-event node-red-osc in new-note)

    (go-loop []
      (let [event (<! in)]
        (println "Message:")
        (pprint event))
      (recur))

    (println "Magical music machine started!")

    ;; run forever
    (<!! (chan))))