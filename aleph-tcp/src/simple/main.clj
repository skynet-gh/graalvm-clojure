(ns simple.main
  (:require 
    [aleph.tcp :as tcp])
  (:gen-class))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;(println "starting tcp client to: 127.0.0.1:3000/")
  ;(tcp/client {:host "127.0.0.1" :port 3000}))
  tcp/client)
