(ns todo.core
  (:gen-class))
(use 'clojure.pprint)

(def file-location (System/getenv "TODO_LOCATION"))

(defn now [] (new java.util.Date))

(defn add-content
  "appends content to todo file"
  [file-location text-content]
  (with-open [file (clojure.java.io/writer file-location :append true)]
    (.write file (str (first text-content) "\t" (now) "\n"))))

(defn line-to-row
  "Converts line content to a row obj"
  [line-content]
  (let [splitter (fn [string] (clojure.string/split string #"\t"))
        split-line (map #(clojure.string/trim %) (splitter line-content))
        time (second split-line)]
    
    {:todo (first split-line) :time (if (nil? time) "UNKNOWN" time)}))

                                        ;TODO refactor below function
(defn textarray-to-table
  "Converts text array to object format for pretty printing"
  [content-array]
  (reduce #(conj %1 (line-to-row %2)) [] content-array))

(defn read-content
  "reads content from todo file"
  [file-location]
  (with-open [file (clojure.java.io/reader file-location)]
    (print-table (textarray-to-table (line-seq file)))))

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
    (println "Choose either >> or ls")))
