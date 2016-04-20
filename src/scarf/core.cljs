(ns scarf.core
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]))

(enable-console-print!)

;;;;;;;;;;;;;;;;
;; https://github.com/omcljs/om/wiki/Components%2C-Identity-%26-Normalization#something-to-look-at
;;;;;;;;;;;;;;;;

(def app-state
  (atom
    {:app/title "Animals"
     :animals/list
                [[1 "Ant"] [2 "Antelope"] [3 "Bird"] [4 "Cat"] [5 "Dog"]
                 [6 "Lion"] [7 "Mouse"] [8 "Monkey"] [9 "Snake"] [10 "Zebra"]]}))

(defmulti read (fn [env key params] key))

(defmethod read :default
  [{:keys [state] :as env} key params]
  (let [st @state]
    (if-let [[_ value] (find st key)]
      {:value value}
      {:value :not-found})))

(defmethod read :animals/list
  [{:keys [state] :as env} key {:keys [start end]}]
  {:value (subvec (:animals/list @state) start end)})

(defui AnimalsList
  static om/IQueryParams
  (params [this]
    {:start 0 :end 10})
  static om/IQuery
  (query [this]
    '[:app/title (:animals/list {:start ?start :end ?end})])
  Object
  (render [this]
    (let [{:keys [app/title animals/list]} (om/props this)]
      (dom/div nil
               (dom/h2 nil title)
               (apply dom/ul nil
                      (map
                        (fn [[i name]]
                          (dom/li nil (str i ". " name)))
                        list))))))

(def width "276px")
(def height "138px")

(defui ScarfExample
  Object
  (render [this]
    (dom/div nil
             (dom/h1 nil "Hello World")
             (dom/svg #js {:enable-background "new 0 0 276 138"
                           :viewBow           "0 0 276 128"
                           :height            "138px"
                           :width             "276px"
                           :x                 "0"
                           :y                 "0"}
                      (dom/g nil
                             (dom/polygon #js {:fill "#FF0000"
                                               :points "266.118,0 138.001,127.452 9.882,0 0,0 138.001,138 276,0"})
                             (dom/polygon #js {:fill "#008800"
                                               :points "266.118,0 246.666,0 138.001,108.833 29.333,0 9.882,0 138.001,127.452"})
                             (dom/polygon #js {:fill "#FF0000"
                                               :points "246.666,0 29.333,0 138.001,108.833"}))))
    ))


(def reconciler
  (om/reconciler
    {:state app-state
     :parser (om/parser {:read read})}))

(om/add-root! reconciler
              AnimalsList (gdom/getElement "app"))

(om/add-root! reconciler
              ScarfExample (gdom/getElement "scarf-example"))



;;; Example with Raphael.js
(defn- attr [object attributes]
  (.attr object (clj->js attributes)))

(defn create-hand [paper]
  (.getColor.reset js/Raphael)
  (-> (.set paper)
      (.push (-> (.path paper "M320,240c-50,100,50,110,0,190")
                 (attr {:fill "none", :stroke-width 2})))
      (.push (-> (.circle paper 320 450 20)
                 (attr {:fill "none", :stroke-width 2})))
      (.push (-> (.circle paper 320 240 5)
                 (attr {:fill "none", :stroke-width 10})))
      (.attr "stroke" (.getColor js/Raphael))))

(defn create-circle [paper angle hand]
  (let [c (.getColor js/Raphael)
        t (str "r" angle " 320 240")
        circle (.circle paper 320 450 20)]
    (-> circle
        (attr {:stroke c, :fill c, :transform t, :fill-opacity .4})
        (.click #(.animate hand (clj->js {:stroke c, :transform t}) 2000 "bounce"))
        (.mouseover #(.animate circle (clj->js {:fill-opacity .75}) 500))
        (.mouseout #(.animate circle (clj->js {:fill-opacity .4}) 500)))))

(defn ^:export draw []
  (let [paper (js/Raphael 0 0 640 480)]
    (let [hand (create-hand paper)]
      (doseq [angle (range 0 360 30)]
        (create-circle paper angle hand)))))

; (draw)