(ns scarf.templates.halved.triangle
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [scarf.templates.utils :as utils]))

(defui OhneDekor
  "Dreieck ohne Dekor."
  static om/IQuery
  (query [this]
         [:scarf/mid1 :scarf/mid1 :scarf/current :color/selected])
  Object
  (render [this]
          (let [id 5009
                {:keys [scarf/mid1 scarf/mid2 scarf/current thumbnail?]} (om/props this)
                c1 (:rgb mid1) c2 (:rgb mid2)
                width 266
                height 130
                scale (utils/scale-to-width thumbnail? width)
                colorize #(utils/colorize this thumbnail? %)]
            (dom/svg (utils/svg-options this id scale width height thumbnail?)
                     (dom/g #js {:transform (str "scale(" scale ")")}
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill c1
                                              :points "0,0 133,127 133,0"})
                            (dom/polygon #js {:onClick #(colorize :scarf/mid2)
                                              :fill c2
                                              :points "133,127 266,0 133,0"}))))))
(def ohne-dekor (om/factory OhneDekor))
