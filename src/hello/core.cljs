(ns hello.core
  (:require [om.next :as om :refer-macros [defui]]))

(enable-console-print!)

(def React (js/require "react-native"))
(def AppRegistry (aget React "AppRegistry"))
(def StyleSheet (aget React "StyleSheet"))

(def create-element (aget React "createElement"))

(defn view
      [opts & children]
      (apply create-element
             (aget React "View")
             (clj->js opts)
             children))

(defn text
      [opts & children]
      (apply create-element
             (aget React "Text")
             (clj->js opts)
             children))


(def styles (.create StyleSheet (clj->js {
  :container {:flex 1
              :justifyContent "center"
              :alignItems "center"
              :backgroundColor "#F5FCFF"}
  :welcome {:fontSize 24
            :textAlign "center"
            :margin 10}
  :instructions {:textAlign "center"
                 :color "#333333"
                 :marginBottom 5}})))

(defn render
      []
      (view {:style (aget styles "container")}
            (text {:style (aget styles "welcome")}
                  "Welcome to React Native!")
            (text {:style (aget styles "instructions")}
                  "To get started, edit src/hello/core.cljs")
            (text {:style (aget styles "instructions")}
                  "Shake or press menu button for dev menu")))

(def create-class (aget React "createClass"))
(def AwesomeProject (create-class #js {:render render}))


(def register-component (aget AppRegistry "registerComponent"))
(register-component "AwesomeProject" (fn [] AwesomeProject))