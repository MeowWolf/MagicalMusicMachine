(ns magical-music-machine.scratch
  (:require [clojure.core.async
             :refer [chan go <! <!! >! >!! close!]]))

(def echo-chan (chan))
(go (println (<! echo-chan)))
(>!! echo-chan "ketchup")

(def hi-chan (chan))
(doseq [n (range 1000)]
  (go (>! hi-chan (str "hi " n))))

(go (println (<! hi-chan)))

(defn hot-dog-machine-v2
  [hot-dog-count]
  (let [in (chan)
        out (chan)]
    (go (loop [hc hot-dog-count]
          (if (> hc 0)
            (let [input (<! in)]
              (if (= 3 input)
                (do (>! out "hot dog")
                    (recur (dec hc)))
                (do (>! out "wilted lettuce")
                    (recur hc))))
            (do (close! in)
                (close! out)))))
    [in out]))

(let [[in out] (hot-dog-machine-v2 2)]
  (>!! in "pocket lint")
  (println (<!! out))

  (>!! in 3)
  (println (<!! out))

  (>!! in 3)
  (println (<!! out))

  (>!! in 3)
  (<!! out))