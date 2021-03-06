(ns scarf.templates.rolled
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [scarf.templates.utils :refer [create-path scarf-background] :as utils]))

;; -----------------------------------------------------------------------------
;; Category: Double stripes

(defui DreieckigEinfarbigDoppelrand
  "Gerolltes Halstuch, dreieckig, einfarbig, mit doppeltem Rand."
  static om/IQuery
  (query [this]
         [:scarf/mid1 :scarf/stripe1 :scarf/stripe2 :color/selected])
  Object
  (render [this]
          (let [id 5004
                {:keys [scarf/mid1 scarf/stripe1 scarf/stripe2 width thumbnail?]} (om/props this)
                cmid1 (:rgb mid1) s1 (:rgb stripe1) s2 (:rgb stripe2)
                height 273
                width 903
                scale (utils/scale-to-width thumbnail? width)
                colorize #(utils/colorize this thumbnail? %)]
            (dom/svg (utils/svg-options this id scale width height thumbnail?)
                     (dom/g #js {:transform (str "scale(" scale ")")}
                            ;; Background
                            scarf-background
                            ;; Far left to mid
                            (create-path this "mid1" s2 "M121.3,55.8c0,0-19.9-1.9-46.4-16.3C64.5,34,34.6,15.3,34.6,15.3S52,18,64.7,25.8  C80.5,35.6,121.3,55.8,121.3,55.8z")
                            (create-path this "stripe1" s1 "M144.2,57.5c0,0-18.9-1.8-45.5-16.1c-10.3-5.6-37.7-21.7-37.7-21.7s15.6,0.2,28.3,8  C105.2,37.5,144.2,57.5,144.2,57.5z")
                            (create-path this "mid1" cmid1 "m 189.59973,65.900534 c 0,0 -8.4912,-1.495361 -18.62594,-3.598765 C 164.7867,61.017674 156.90304,61.026876 152.68704,59.725517 141.32733,54.640237 93.1,26.1 93.1,26.1 c 0,0 45.3,3.7 52.6,11.7 6.2,6.7 43.89973,28.100534 43.89973,28.100534 z")
                            (create-path this "mid1" s2 "M212.3,68.8c0,0-16.3,1.1-46.1-18.8c-9.8-6.5-34.3-26.7-34.3-26.7s14.2-0.1,23,7.3  C170.4,43.5,212.3,68.8,212.3,68.8z")
                            (create-path this "stripe1" s1 "M234,71.3c0,0-8.4,3.1-42.1-18.1c-9.9-6.3-34.1-24.7-34.1-24.7s18,2.3,24.4,7.3  C198.1,48.2,234,71.3,234,71.3z")
                            (create-path this "mid1" cmid1 "m 272.96594,79.380836 c 0,0 -27.33557,-2.71116 -41.70636,-13.290973 C 221.45958,59.589863 184.8,33.5 184.8,33.5 l 51,8.4 c 15.3,14.5 37.16594,37.480836 37.16594,37.480836 z")
                            ;; Far right to mid
                            (create-path this "mid1" s2 "M788.2,55.8c0,0,19.9-1.9,46.4-16.3c10.3-5.6,40.2-24.3,40.2-24.3s-17.4,2.7-30,10.5  C829,35.6,788.2,55.8,788.2,55.8z")
                            (create-path this "stripe1" s1 "M765.2,57.5c0,0,18.9-1.8,45.5-16.1c10.3-5.6,37.7-21.7,37.7-21.7s-15.6,0.2-28.3,8  C804.3,37.5,765.2,57.5,765.2,57.5z")
                            (create-path this "mid1" cmid1 "m 725.16553,63.351127 c 0,0 30.06433,-3.296648 40.07218,-10.087795 C 775.53771,47.663332 816.4,26.1 816.4,26.1 l -45.8,6.5 c -16,13.4 -45.43447,30.751127 -45.43447,30.751127 z")
                            (create-path this "mid1" s2 "M697.2,68.8c0,0,16.3,1.1,46.1-18.8c9.8-6.5,34.3-26.7,34.3-26.7s-14.2-0.1-23,7.3  C739.1,43.5,697.2,68.8,697.2,68.8z")
                            (create-path this "stripe1" s1 "M675.5,71.3c0,0,8.4,3.1,42.1-18.1c9.9-6.3,34.1-24.7,34.1-24.7s-18,2.3-24.4,7.3  C711.4,48.2,675.5,71.3,675.5,71.3z")
                            (create-path this "mid1" cmid1 "m 637.49225,79.228863 c 0,0 30.22875,-4.044421 42.60995,-14.961132 C 689.9022,57.767731 724.7,33.5 724.7,33.5 l -51,8.4 c -15.3,14.5 -36.20775,37.328863 -36.20775,37.328863 z")
                            ;; Mid
                            (create-path this "mid1" cmid1 "m 281.71001,40.952226 c 3.01296,1.787772 88.95741,11.348968 172.93973,11.160864 86.50863,-0.193763 173.50664,-10.683833 173.50664,-10.683833 L 454.7,213.8 c 0.1,0 -181.08334,-178.969984 -172.98999,-172.847774 z")
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe1)
                                              :fill s1
                                              :points "652,38.2 454.8,235.9 258.2,37.9 276.8,40.1 454.8,215.9 632.1,40.6"})
                            (dom/polygon #js {:onClick #(colorize :scarf/mid1)
                                              :fill s2
                                              :points "677.3,34.9 454.8,256.9 232.3,34.8 252.3,37.4 454.8,237.9 657.3,37.4"})
                            (create-path this "mid1" cmid1 ""))))))
(def einfarbig-doppelrand (om/factory DreieckigEinfarbigDoppelrand))


;; -----------------------------------------------------------------------------
;; Halbierte Halstücher

(defui DreiStreifenHalbiert
  "Rolled triangle, three outer stripes and a vertical line in the middle.
   Original size: 903x273 px.
   ID: 2"
  static om/IQuery
  (query [this]
         [:scarf/mid1 :scarf/mid2 :scarf/stripe1 :scarf/stripe2 :scarf/stripe3
          :color/selected])
  Object
  (render [this]
          (let [id 2
                {:keys [scarf/mid1 scarf/mid2 scarf/stripe1 scarf/stripe2 scarf/stripe3
                        width thumbnail?]} (om/props this)
                cmid1 (:rgb mid1) cmid2 (:rgb mid2) cstripe1 (:rgb stripe1)
                cstripe2 (:rgb stripe2) cstripe3 (:rgb stripe3)
                height 273
                width 903
                scale (utils/scale-to-width thumbnail? width)
                colorize #(utils/colorize this thumbnail? %)]
            (dom/svg (utils/svg-options this id scale width height thumbnail?)
                     (dom/g #js {:transform (str "scale(" scale ")")}
                            ;; Background
                            scarf-background
                            ;; Far left to mid
                            (create-path this "stripe1" cstripe1 "M121.3,55.8c0,0-19.9-1.9-46.4-16.3C64.5,34,34.6,15.3,34.6,15.3S52,18,64.7,25.8
	C80.5,35.6,121.3,55.8,121.3,55.8z")
                            (create-path this "stripe2" cstripe2 "M144.2,57.5c0,0-18.9-1.8-45.5-16.1c-10.3-5.6-37.7-21.7-37.7-21.7s15.6,0.2,28.3,8
	C105.2,37.5,144.2,57.5,144.2,57.5z")
                            (create-path this "stripe3" cstripe3 "M169.8,62.8c0,0-12.5-0.7-39-15c-10.3-5.6-37.7-21.7-37.7-21.7l21.1,2.8C130.2,39.8,169.8,62.8,169.8,62.8z")
                            (create-path this "mid1" cmid1 "M189.3,66.5c0,0-5.6,0.7-32.2-13.6c-10.3-5.6-37.9-23.6-37.9-23.6s19.2,0.5,26.5,8.5
	C151.9,44.5,189.3,66.5,189.3,66.5z")
                            (create-path this "stripe1" cstripe1 "M212.3,68.8c0,0-16.3,1.1-46.1-18.8c-9.8-6.5-34.3-26.7-34.3-26.7s14.2-0.1,23,7.3
	C170.4,43.5,212.3,68.8,212.3,68.8z")
                            (create-path this "stripe2" cstripe2 "M234,71.3c0,0-8.4,3.1-42.1-18.1c-9.9-6.3-34.1-24.7-34.1-24.7s18,2.3,24.4,7.3
	C198.1,48.2,234,71.3,234,71.3z")
                            (create-path this "stripe3" cstripe3 "M265.2,77.6c-0.2,1-18.5-0.1-48.3-20c-9.8-6.5-32.1-24.1-32.1-24.1s16.6,0.5,25.4,7.8
	C225.6,54.2,265.5,76,265.2,77.6z")
                            (create-path this "mid1" cmid1 "M266.8,73.9c0,0-3.1,0.8-32.8-19.2c-9.8-6.5-23.2-17.3-23.2-17.3l25,4.5C251.1,56.4,266.8,73.9,266.8,73.9z")
                            ;; Far right to mid
                            (create-path this "stripe1" cstripe1 "M788.2,55.8c0,0,19.9-1.9,46.4-16.3c10.3-5.6,40.2-24.3,40.2-24.3s-17.4,2.7-30,10.5
	C829,35.6,788.2,55.8,788.2,55.8z")
                            (create-path this "stripe2" cstripe2 "M765.2,57.5c0,0,18.9-1.8,45.5-16.1c10.3-5.6,37.7-21.7,37.7-21.7s-15.6,0.2-28.3,8
	C804.3,37.5,765.2,57.5,765.2,57.5z")
                            (create-path this "stripe3" cstripe3 "M739.7,62.8c0,0,12.5-0.7,39-15c10.3-5.6,37.7-21.7,37.7-21.7l-21.1,2.8C779.3,39.8,739.7,62.8,739.7,62.8z")
                            (create-path this "mid2" cmid2 "M720.2,66.5c0,0,5.6,0.7,32.2-13.6c10.3-5.6,37.9-23.6,37.9-23.6l-19.7,3.3C754.6,46,720.2,66.5,720.2,66.5z")
                            (create-path this "stripe1" cstripe1 "M697.2,68.8c0,0,16.3,1.1,46.1-18.8c9.8-6.5,34.3-26.7,34.3-26.7s-14.2-0.1-23,7.3
	C739.1,43.5,697.2,68.8,697.2,68.8z")
                            (create-path this "stripe2" cstripe2 "M675.5,71.3c0,0,8.4,3.1,42.1-18.1c9.9-6.3,34.1-24.7,34.1-24.7s-18,2.3-24.4,7.3
	C711.4,48.2,675.5,71.3,675.5,71.3z")
                            (create-path this "stripe3" cstripe3 "M644.3,77.6c0.2,1,18.5-0.1,48.3-20c9.8-6.5,32.1-24.1,32.1-24.1s-16.6,0.5-25.4,7.8
	C683.9,54.2,644,76,644.3,77.6z")
                            (create-path this "mid2" cmid2 "M642.7,73.9c0,0,3.1,0.8,32.8-19.2c9.8-6.5,23.2-17.3,23.2-17.3l-25,4.5C658.4,56.4,642.7,73.9,642.7,73.9z")
                            ;; Mid-left
                            (create-path this "mid1" cmid1 "M309.8,44.3c7.1,2.4,144.2,8,144.2,8v139.6C454.1,191.9,298.8,40.6,309.8,44.3z")
                            ;; Mid-right
                            (create-path this "mid2" cmid2 "M599.5,44.3c-7.1,2.4-144.2,8-144.2,8v139.6C455.3,191.9,610.6,40.6,599.5,44.3z")
                            ;; Outer to inner stripes
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe1)
                                              :fill cstripe1
                                              :points "677.3,34.9 454.8,256.9 232.3,34.8 252.3,37.4 454.8,237.9 657.3,37.4"})
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe2)
                                              :fill cstripe2
                                              :points "652,38.2 454.8,235.9 258.2,37.9 276.8,40.1 454.8,215.9 632.1,40.6"})
                            (dom/polygon #js {:onClick #(colorize :scarf/stripe3)
                                              :fill cstripe3
                                              :points "627.3,42.2 454.7,213.8 282.8,41.8 300.8,44 455.4,196.4 610.3,43.5"}))))))
(def drei-streifen-mitte-halbiert (om/factory DreiStreifenHalbiert))
