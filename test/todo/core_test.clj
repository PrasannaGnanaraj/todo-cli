(ns todo.core-test
  (:require [clojure.test :refer :all]
            [todo.core :refer :all]))

(deftest textarray-to-table-test
  (testing "Converts text array to tabular format"
    (is (= (textarray-to-table '("hello" "hi there")) [{:todos "hello"} {:todos "hi there"}]))))
