
; main page 

(defn  demo-page [{:keys [handler route-params query-params] :as route}]
  [:div
   [:h1.text-2xl.text-red-600.m-5 "demo user app"]
   [link-href "devtools/help" "goldly developer tools"]
   [link-href "/grid" "grid"]
   [link-href "/grid-formatter" "grid (with custom formatter)"]
   ;[link-href "/fortune" "fortune cookies"]
   ;[link-href "/experiment" "experiment"]
   ])
(add-page demo-page :user/main)