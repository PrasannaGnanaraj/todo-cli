(ns todo.core
  (:gen-class)
  (:require [clojure.string :refer [split]])
  (:require [clojure.java.io :refer [writer reader]]))

(use 'clojure.pprint)

(def file-location (System/getenv "TODO_LOCATION"))

(defn now [] (new java.util.Date))

(defn add-content
  "appends content to todo file"
  [file-location text-content]
  (with-open [file (writer file-location :append true)]
    (.write file (str text-content "\t" (now) "\n"))))

(defn print-helper
  "Converts line content to a row obj"
  [line-content]
  (let [[todo created_at] (split line-content #"\t")]
    {:todo todo :created_at (or created_at "UNKNOWN")}))

(defn read-content
  "reads content from todo file"
  [file-location]
  (with-open [file (reader file-location)]
    (let [file-content (slurp file)]
      (print-table
       (map print-helper
            (split file-content #"\n"))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (if (nil? file-location)
    (throw (AssertionError. "empty $TODO_LOCATION")))
  (case (first args)
    "a" (do
          (add-content file-location (rest args))
          (read-content file-location))
    "ls" (read-content file-location)
    (println "Choose either a or ls")))
