(ns todo.core-test
  (:require [clojure.test :refer :all]
            [todo.core :refer :all]))

(deftest textArrayToTableTest
  (testing "Converts text array to tabular format"
    (is (= (textArrayToTable '("hello" "hi there")) [{:todos "hello"} {:todos "hi there"}]))))
