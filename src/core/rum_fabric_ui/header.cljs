(ns rum-fabric-ui.header
  (:require
   ["@fluentui/react" :as f]
   [goog.object :as gobj]
   [clojure.string :as str]
   [rum-fabric-ui.state :as state]
   [rum.core :as rum]
   ))

(defn focus-new-todo []
  (.focus (.getElementById js/document "newTodo")))

(defn pivot-filter [pivot-item]
  (state/update-filter (gobj/getValueByKeys pivot-item "props" "headerText")))

(defn textfield-change [_event new-value]
  (state/update-label-input new-value))

(defn add-btn-handler []
  (let [text (get @state/state :labelInput)]
    (when-not (str/blank? text)
      (state/add-todo text)
      (state/update-label-input "")
      (focus-new-todo))))

(rum/defc todo-header
  []
  (rum/adapt-class
    f/Stack
    (rum/adapt-class
      f/Stack {:horizontal true :horizontalAlign "center"}
      (rum/adapt-class
        f/Stack.Item {:align "center"}
        (rum/adapt-class
          f/Text {:variant "xxLarge"} "todos")))
    (rum/adapt-class
      f/Stack {:horizontal "horizontal"}
      (rum/adapt-class
        f/Stack.Item {:grow true}
        (rum/adapt-class
          f/TextField {:id "newTodo"
                       :placeholder "What needs to be done?"
                       :value (state/new-todo-value)
                       :onKeyDown #(when (= 13 (.-which %)) (add-btn-handler))
                       :onChange textfield-change}))
      (rum/adapt-class f/PrimaryButton {:onClick add-btn-handler} "Add"))
    (rum/adapt-class
      f/Pivot {:onLinkClick pivot-filter}
      (rum/adapt-class f/PivotItem {:headerText "all"})
      (rum/adapt-class f/PivotItem {:headerText "active"})
      (rum/adapt-class f/PivotItem {:headerText "completed"}))))
