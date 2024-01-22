(ns fooheads.example-macro
  (:require
    [fooheads.makro :as makro])
  #?(:cljs
     (:require-macros
       [fooheads.example-macro])))


(defmacro dialect []
  `~(makro/dialect &env))


(defmacro catch-ex-symbol [e]
  `(try
     (throw ~e)
     (catch ~(makro/ex-symbol &env) e#
       :error)))


