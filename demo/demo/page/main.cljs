(ns demo.page.main
  (:require
   [demo.lib.ui :refer [link-dispatch]]))

; main page 

(defn  main-page [{:keys [handler route-params query-params] :as route}]
  [:div
   [:h1.text-2xl.text-red-600.m-5 "aggrid demo"]
   [link-dispatch [:bidi/goto 'demo.page.grid/grid-page] "grid"]
   [link-dispatch [:bidi/goto 'demo.page.formatter/formatter-page] "grid (with custom formatter)"]])


