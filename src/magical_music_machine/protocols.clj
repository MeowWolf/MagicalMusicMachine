(ns magical-music-machine.protocols)

(defprotocol Note
  (event->Note [event]))

(defprotocol Consumer
  (handle-event [handler in-chan note-constructor]))