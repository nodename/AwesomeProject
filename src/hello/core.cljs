(ns hello.core)

(enable-console-print!)

(def React (js/require "react-native"))
(def AppRegistry (aget React "AppRegistry"))
(def StyleSheet (aget React "StyleSheet"))

(def create-element (aget React "createElement"))

(def Text (partial create-element (aget React "Text")))
(def View (partial create-element (aget React "View")))


(def styles (.create StyleSheet (clj->js {
  :container {:flex 1
              :justifyContent "center"
              :alignItems "center"
              :backgroundColor "#F5FCFF"}
  :welcome {:fontSize 20
            :textAlign "center"
            :margin 10}
  :instructions {:textAlign "center"
                 :color "#F5FCFF"
                 :marginBottom 5}})))

(defn render
      []
      (View #js {:style (aget styles "container")}
            (Text {:style (aget styles "welcome")}
                  "Welcome to React Native!")
            (Text {:style (aget styles "instructions")}
                  "To get started, edit src/hello/core.cljs")
            (Text {:style (aget styles "instructions")}
                  "Shake or press menu button for dev menu")))

(def create-class (aget React "createClass"))
(def AwesomeProject (create-class #js {:render render}))

(def register-component (aget AppRegistry "registerComponent"))
(register-component "AwesomeProject" (fn [] AwesomeProject))
