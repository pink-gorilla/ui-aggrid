(ns pinkgorilla.aggrid.box)

(defn container-style [size]
  ; either both pixels, or both percentage.
  (case  size
    :small  {:style {:width "400px" :max-width "400px" :height "300px" :width-px 400 :height-px 300}}
    :medium {:style {:width "600px" :max-width "600px" :height "500px" :width-px 600 :height-px 500}}
    :large  {:style {:width "100%"  :max-width "100%" :height "100%"}}
    :full   {:style {:width "100%"  :max-width "100%" :height "100%"
                     :position "absolute"
                     :top 0
                     :left 0
                     :bottom 0
                     :right 0
                     :z-index 5000}}
    {:style {:width "600px" :max-width "600px" :height "150px"  :width-px 600 :height-px 500}}))
