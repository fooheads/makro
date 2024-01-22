(ns fooheads.makro-test
  (:require
    [clojure.test :refer [deftest is]]
    [fooheads.example-macro :refer [dialect catch-ex-symbol]])
  #?(:cljs
     (:require-macros
       [fooheads.example-macro])))


(deftest dialect-test
  #?(:clj  (is (= :clj  (dialect)))
     :cljs (is (= :cljs (dialect)))))


(deftest ex-symbol-test
  #?(:clj
     (do
       (is (= :error (catch-ex-symbol (ex-info "error" {})))))
     :cljs
     (do
       (is (= :error (catch-ex-symbol "error")))
       (is (= :error (catch-ex-symbol (ex-info "error" {}))))
       (is (= :error (catch-ex-symbol (js/Error. "error" {})))))))

