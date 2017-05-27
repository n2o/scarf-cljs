(ns scarf.views
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [scarf.components.calculator :as calc]
            [scarf.components.nav :as nav]
            [scarf.templates.triangle :as triangle]
            [scarf.templates.rolled :as rolled]
            [scarf.templates.scarfs :as scarfs]
            [scarf.lib :as lib]))
(enable-console-print!)

(defn dispatch-current-scarf [this]
  (let [{:keys [scarf/current]} (om/props this)]
    (when current
      (case current
        5000 (rolled/ohne-dekor (om/props this))
        5001 (rolled/einfache-borte (om/props this))
        5002 (rolled/einfacher-rand (om/props this))
        5004 (rolled/einfarbig-doppelrand (om/props this))
        5006 (rolled/einfarbig-doppelborte (om/props this))
        nil))))

;; -----------------------------------------------------------------------------

(defui ColorBlock
  static om/IQuery
  (query [this]
         [:rgb :name :price])
  static om/Ident
  (ident [this {:keys [id]}]
         [:color/by-id id])
  Object
  (render [this]
          (let [{:keys [rgb name price id selected] :as color-complete} (om/props this)
                color (dissoc color-complete :selected)]
            (dom/div #js {:className (str "color-block-wrapper" (when (= id (:id selected)) " block-active"))
                          :onClick #(om/transact! this `[(color/selected ~color)])
                          :style #js {:backgroundColor rgb}}
                     (dom/div #js {:className "color-block"})
                     (dom/span #js {:className "tooltiptext"} name)))))
(def color-block (om/factory ColorBlock {:keyfn :id}))

(defui Colors
  static om/IQuery
  (query [this]
         `[{:color/items ~(om/get-query ColorBlock)}
           :color/selected :scarf/current :nav/category])
  Object
  (render [this]
          (let [{:keys [color/items color/selected scarf/current nav/category]} (om/props this)]
            (dom/div nil
                     (when (and current category)
                       (map #(color-block (merge % {:selected selected})) items))))))
(def colors (om/factory Colors))

(defui Selection
  static om/IQuery
  (query [this]
         [:color/selected])
  Object
  (render [this]
          (let [{:keys [color/selected]} (om/props this)]
            (dom/div #js {:className "smooth text-center"}
                     (when-not selected
                       (dom/p nil "Bitte wähle zunächst eine Farbe aus"))))))
(def selection (om/factory Selection))

(defui Main
  Object
  (render [this]
          (dom/div nil
                   (nav/products (om/props this))
                   (dom/hr nil)
                   (selection (om/props this))
                   (dom/div #js {:className "text-center"
                                 :style #js {:padding "5rem"}}
                            (dispatch-current-scarf this))
                   (dom/div #js {:className "text-center"}
                            (colors (om/props this)))
                   (dom/hr nil)
                   (calc/view (om/props this)))))


;; (def norm-data (om/tree->db Scarf scarf.parser/init-data true))
;; norm-data
