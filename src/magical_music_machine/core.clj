(ns magical-music-machine.core
  (:require [clojure.pprint :as pp
             :refer [pprint]]
            [clojure.core.async
             :as a
             :refer [<!! <! go-loop chan]]
            [magical-music-machine.note
             :refer [new-note]]
            [magical-music-machine.adapters.in.test-osc
             :refer [handle-event]])
  (:gen-class))

(defn -main
  "Magical music machine main"
  [& args]
  (let [in (chan)]
    (handle-event in new-note)

    (go-loop []
      (let [event (<! in)]
        (println "Message:")
        (pprint event))
      (recur))

    (println "Magical music machine started!")

    ;; run forever
    (<!! (chan))))