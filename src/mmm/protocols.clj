(ns mmm.protocols)

(defprotocol Event
  (event->note [event]))

(defprotocol Consumer
  (handle-event [handler instruments in-chan]))

(defprotocol Publisher
  (send-message [sender note]))
