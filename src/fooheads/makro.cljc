(ns fooheads.makro)


(defn dialect
  "Takes the &env from a macro, and returns the dialect we are expanding into.
  Currently supports :clj and :cljs"
  [env]
  (cond
    (:js-globals env) :cljs
    :else :clj))


(defn ex-symbol
  "Useful to catch a generic exception in a macro."
  [env]
  (case (dialect env)
    :cljs :default
    :clj  'Exception))

