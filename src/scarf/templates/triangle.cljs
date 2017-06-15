(ns scarf.templates.triangle
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [scarf.templates.utils :as utils]
            [scarf.config :as config]))

(def width (:thumbnail/width config/scarf))
(def height (:thumbnail/height config/scarf))

;; -----------------------------------------------------------------------------

(defui EinfarbigOhneDekor
  "Dreieck ohne Dekor."
  static om/IQuery
  (query [this]
         [:scarf/mid1 :scarf/current :color/selected])
  Object
  (render [this]
          (let [id 5000
                {:keys [scarf/mid1 scarf/current thumbnail?]} (om/props this)
                c1 (:rgb mid1)
                width 266
                height 130
                scale (utils/scale-to-width thumbnail? width)
                colorize #(utils/colorize this thumbnail? %)]
            (dom/svg (utils/svg-options this id scale width height thumbnail?)
                     (dom/g #js {:transform (str "scale(" scale ")")}
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill c1
                                              :points  "266,0 0,0 133,127"}))))))
(def einfarbig-ohne-dekor (om/factory EinfarbigOhneDekor))

(defui EinfarbigRand
  "Dreieck mit Randstreifen."
  static om/IQuery
  (query [this]
         [:scarf/mid1 :scarf/stripe1 :scarf/current :color/selected])
  Object
  (render [this]
          (let [id 5002
                {:keys [scarf/mid1 scarf/stripe1 scarf/current thumbnail?]} (om/props this)
                c1 (:rgb mid1) c2 (:rgb stripe1)
                width 266
                height 130
                scale (utils/scale-to-width thumbnail? width)
                colorize #(utils/colorize this thumbnail? %)]
            (dom/svg (utils/svg-options this id scale width height thumbnail?)
                     (dom/g #js {:transform (str "scale(" scale ")")}
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe1)
                                              :fill c2
                                              :points  "266,0 247,0 138,109 29,0 10,0 138,127"})
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill c1
                                              :points  "258,0 18,0 138,118"}))))))
(def einfarbig-rand (om/factory EinfarbigRand))

(defui EinfarbigBorte
  "Dreieck mit Borte."
  static om/IQuery
  (query [this]
         [:scarf/mid1 :scarf/stripe1 :scarf/current :color/selected])
  Object
  (render [this]
          (let [id 5001
                {:keys [scarf/mid1 scarf/stripe1 scarf/current thumbnail?]} (om/props this)
                c1 (:rgb mid1) c2 (:rgb stripe1)
                width 276
                height 140
                scale (utils/scale-to-width thumbnail? width)
                colorize #(utils/colorize this thumbnail? %)]
            (dom/svg (utils/svg-options this id scale width height thumbnail?)
                     (dom/g #js {:transform (str "scale(" scale ")")}
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill c1
                                              :points  "266,0 138,127 10,0 3,0 138,135 273,0"})
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe1)
                                              :fill c2
                                              :points  "266,0 258,0 138,117 18,0 10,0 138,127"})
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill c1
                                              :points  "258,0 18,0 138,118"}))))))
(def einfarbig-borte (om/factory EinfarbigBorte))


;; -----------------------------------------------------------------------------
;; Kategorie: Doppelte Borte / Rand

(defui EinfarbigDoppelrand
  "Dreieck mit Borte."
  static om/IQuery
  (query [this]
         [:scarf/mid1 :scarf/stripe1 :scarf/stripe2 :scarf/current :color/selected])
  Object
  (render [this]
          (let [id 5001
                {:keys [scarf/mid1 scarf/stripe1 scarf/stripe2 scarf/current thumbnail?]} (om/props this)
                c1 (:rgb mid1) c2 (:rgb stripe1) c3 (:rgb stripe2)
                width 276
                height 140
                scale (utils/scale-to-width thumbnail? width)
                colorize #(utils/colorize this thumbnail? %)]
            (dom/svg (utils/svg-options this id scale width height thumbnail?)
                     (dom/g #js {:transform (str "scale(" scale ")")}
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe2)
                                              :fill c3
                                              :points  "266,0 138,127 10,0 3,0 138,135 273,0"})
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe1)
                                              :fill c2
                                              :points  "266,0 258,0 138,117 18,0 10,0 138,127"})
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill c1
                                              :points  "258,0 18,0 138,118"}))))))
(def einfarbig-doppelrand (om/factory EinfarbigDoppelrand))

(defui EinfarbigDoppelborte
  "Dreieck mit Borte."
  static om/IQuery
  (query [this]
         [:scarf/mid1 :scarf/stripe1 :scarf/stripe2 :scarf/current :color/selected])
  Object
  (render [this]
          (let [id 5001
                {:keys [scarf/mid1 scarf/stripe1 scarf/stripe2 scarf/current thumbnail?]} (om/props this)
                c1 (:rgb mid1) s1 (:rgb stripe1) s2 (:rgb stripe2)
                width 276
                height 140
                scale (utils/scale-to-width thumbnail? width)
                colorize #(utils/colorize this thumbnail? %)]
            (dom/svg (utils/svg-options this id scale width height thumbnail?)
                     (dom/g #js {:transform (str "scale(" scale ")")}
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill c1
                                              :points  "266,0 138,127 10,0 3,0 138,135 273,0"})
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe2)
                                              :fill s2
                                              :points  "266,0 258,0 138,117 18,0 10,0 138,127"})
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe1)
                                              :fill s1
                                              :points  "258,0 250,0 138,107 26,0 18,0 138,118"})
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill c1
                                              :points  "250,0 26,0 138,110"}))))))
(def einfarbig-doppelborte (om/factory EinfarbigDoppelborte))


;; -----------------------------------------------------------------------------
;; Kategorie: Gekreuzte Borten

(defui EinfarbigBorteGekreuzt
  "Dreieck mit gekreuzter Borte."
  static om/IQuery
  (query [this]
         [:scarf/mid1 :scarf/stripe1 :scarf/current :color/selected])
  Object
  (render [this]
          (let [id 5007
                {:keys [scarf/mid1 scarf/stripe1 scarf/current thumbnail?]} (om/props this)
                c1 (:rgb mid1) c2 (:rgb stripe1)
                width 276
                height 140
                scale (utils/scale-to-width thumbnail? width)
                colorize #(utils/colorize this thumbnail? %)]
            (dom/svg (utils/svg-options this id scale width height thumbnail?)
                     (dom/g #js {:transform (str "scale(" scale ")")}
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill c1
                                              :points "266,0 138,127 10,0 3,0 138,135 273,0"})
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill c1
                                              :points "258,0 18,0 138,118"})
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe1)
                                              :fill c2
                                              :points "266,0 258,0 129,126 134,131"})
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe1)
                                              :fill c2
                                              :points  "10,0 18,0 147,126 142,131"}))))))
(def einfarbig-borte-gekreuzt (om/factory EinfarbigBorteGekreuzt))

(defui EinfarbigBorteDoppeltGekreuzt
  "Dreieck mit gekreuzter Doppelborte."
  static om/IQuery
  (query [this]
         [:scarf/mid1 :scarf/stripe1 :scarf/current :color/selected])
  Object
  (render [this]
          (let [id 5008
                {:keys [scarf/mid1 scarf/stripe1 scarf/current thumbnail?]} (om/props this)
                c1 (:rgb mid1) c2 (:rgb stripe1)
                width 276
                height 140
                scale (utils/scale-to-width thumbnail? width)
                colorize #(utils/colorize this thumbnail? %)]
            (dom/svg (utils/svg-options this id scale width height thumbnail?)
                     (dom/g #js {:transform (str "scale(" scale ")")}
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill c1
                                              :points "266,0 138,127 10,0 3,0 138,135 273,0"})
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill c1
                                              :points "258,0 18,0 138,118"})
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe1)
                                              :fill c2
                                              :points "266,0 258,0 129,126 134,131"})
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe1)
                                              :fill c2
                                              :points  "10,0 18,0 147,126 142,131"}))))))
(def einfarbig-borte-doppelt-gekreuzt (om/factory EinfarbigBorteDoppeltGekreuzt))
