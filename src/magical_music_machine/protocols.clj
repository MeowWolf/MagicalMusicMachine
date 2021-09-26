(ns magical-music-machine.protocols)

(defprotocol Event
  (event->note [event]))

(defprotocol Consumer
  (handle-event [handler in-chan]))

(defprotocol Publisher
  (send-message [sender note]))