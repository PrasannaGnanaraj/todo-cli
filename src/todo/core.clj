(ns todo.core
  (:gen-class))
(use 'clojure.pprint)

(def fileLocation (System/getenv "TODO_LOCATION"))

(defn addContent
  "appends content to todo file"
  [fileLocation textContent]
  (with-open [file (clojure.java.io/writer fileLocation :append true)]
    (.write file (str (first textContent) "\n"))))

(defn textArrayToTable
  "Converts text array to object format for pretty printing"
  [contentArray]
  (reduce #(conj %1 {:todos %2}) [] contentArray))

(defn readContent
  "reads content from todo file"
  [fileLocation]
  (with-open [file (clojure.java.io/reader fileLocation)]
    (print-table (textArrayToTable (line-seq file)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (if (nil? fileLocation)
    (throw (AssertionError. "empty $TODO_LOCATION")))
  (case (first args)
    "a" (do
          (addContent fileLocation (rest args))
          (readContent fileLocation))
    "ls" (readContent fileLocation)
    (println "Choose either >> or ls")))
