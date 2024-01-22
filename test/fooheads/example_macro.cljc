(ns fooheads.example-macro
  (:require
    [fooheads.makro :refer [dialect]])
  #?(:cljs
     (:require-macros
       [fooheads.example-macro])))


(defmacro example-macro []
  `~(dialect &env))

