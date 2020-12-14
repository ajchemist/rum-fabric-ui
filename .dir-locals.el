((nil
  (cider-default-cljs-repl . shadow)
  (cider-shadow-default-options . "app")
  )
 (clojure-mode
  ;; (cider-clojure-cli-global-options . "")
  (cider-clojure-cli-parameters . "-M:test:test/interactive:cljs/figwheel-main -m nrepl.cmdline --middleware '%s'")
  (cider-default-cljs-repl . shadow)
  (clojure-local-source-test-path . "src/test")))
