(ns todo.core-test
  (:require [clojure.test :refer :all]
            [todo.core :refer :all]))

(deftest textarray-to-table-test
  (testing "Converts text array to tabular format"
    (is (= (textarray-to-table '("hello" "hi there"))
           [{:todo "hello" :time "UNKNOWN"} {:todo "hi there" :time "UNKNOWN"}]))))

(deftest line-to-row-test
  (testing "Converts line content to a row obj")
  (is (= (line-to-row "hello \t Today") {:todo "hello" :time "Today"})))
