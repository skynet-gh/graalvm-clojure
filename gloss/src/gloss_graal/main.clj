(ns gloss-graal.main
  (:gen-class)
  (:require 
    [gloss.core :as gloss]
    [gloss.io :as gio]))


(defn -main [& _args]
  (println "Gloss graal test")
  (let [gs (gloss/string :utf-8)
        df (gloss/delimited-frame ["\n"] gs)
        utf8-frame (gloss/compile-frame df)]
    (println "Created utf-8 frame" utf8-frame)
    (println "Encode:" (gio/encode utf8-frame "x\ny\nz\n")))
  (let [bm (gloss/bit-map
             :a 1
             :b 2
             :c 3
             :d 2)
        bits-frame (gloss/compile-frame bm)]
    (println "Created bits frame" bits-frame)
    (println "Encode:" (gio/encode bits-frame {:a true :b 2 :c 3 :d 0})))
  (flush))
