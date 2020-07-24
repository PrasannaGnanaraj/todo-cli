(defproject todo "0.1.0-SNAPSHOT"
  :description "a todo cli"
  :url "https://github.com/PrasannaGnanaraj/todo-cli"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot todo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :bin {:name "todo"
        :bin-path "~/bin"
        :bootclasspath true})
