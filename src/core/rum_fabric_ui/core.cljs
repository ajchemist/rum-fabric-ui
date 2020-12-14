(ns rum-fabric-ui.core
  (:require
   ["@fluentui/react" :as f]
   ["@uifabric/icons" :as ui]
   [rum.core :as rum]
   [rum-fabric-ui.header :as header]
   ))


(defn todo-app
  []
  (rum/adapt-class
    f/Stack {:horizontalAlign "center"}
    (rum/adapt-class
      f/Stack {:style {:width 400} :tokens {:childrenGap 25}}
      (header/todo-header))))


(defn mount-root
  []
  (rum/mount (todo-app) (.getElementById js/document "app")))


(defn init-ui
  []
  (mount-root))


(defn main!
  []
  (println "starting...")
  (ui/initializeIcons)
  (init-ui))


(defn ^:dev/after-load reload!
  []
  (println "reloading..."))
