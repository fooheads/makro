(ns fooheads.makro-test
  (:require
    [clojure.test :refer [deftest is]]
    [fooheads.example-macro :refer [example-macro]])
  #?(:cljs
     (:require-macros
       [fooheads.example-macro])))


(deftest dialect-test
  #?(:clj  (is (= :clj  (example-macro)))
     :cljs (is (= :cljs (example-macro)))))


