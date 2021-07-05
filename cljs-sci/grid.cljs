(defn link-href [href text]
  [:a.bg-blue-300.cursor-pointer.hover:bg-red-700.m-1
   {:href href} text])

(def data [{:make "Toyota" :model "Celica" :price 35000}
           {:make "Ford" :model "Mondeo" :price 32000}
           {:make "Porsche" :model "Boxter" :price 72000}])

(def data2 [{:make "Toyota" :model "Celica" :price 35000 :date (t/now)}
           {:make "Ford" :model "Mondeo" :price 32000}
           {:make "Porsche" :model "Boxter" :price 72000 :date (t/now)}])

(defmethod reagent-page :user/grid [{:keys [route-params query-params handler] :as route}]
  [:div
   ;[:div.text-green-300 "grid1"]
   
   [:div.grid.grid-cols-2 {:class "h-screen"}
    [link-href "/" "main"]
    [:p "time: " (t/now)]

    [aggrid {:data data}]
    [:div.bg-red-300 "2"]
    [:div.bg-blue-300 "3"]
    [aggrid {:data data2 :box :fl}]]])
