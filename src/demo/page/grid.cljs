(defn link-href [href text]
  [:a.bg-blue-300.cursor-pointer.hover:bg-red-700.m-1
   {:href href} text])

(defn link-fn [fun text]
  [:a.bg-blue-300.cursor-pointer.hover:bg-red-700.m-1
   {:on-click fun} text])

(defn link-dispatch [rf-evt text]
  (link-fn #(rf/dispatch rf-evt) text))

(def data [{:make "Toyota" :model "Celica" :price 35000}
           {:make "Ford" :model "Mondeo" :price 32000}
           {:make "Porsche" :model "Boxter" :price 72000}])

(def data2 [{:make "Toyota" :model "Celica" :price 35000 :date (t/now)}
            {:make "Ford" :model "Mondeo" :price 32000 :date (t/now)}
            {:make "Porsche" :model "Boxter" :price 72000 :date (t/now)}])

(defn round-number-digits
  [digits number] ; digits is first parameter, so it can easily be applied (data last)
  (if (nil? number) "" (to-fixed number digits)))

(defn fmt-yyyymmdd [dt]
  (when dt
    (dt-format "YYYYMMdd" dt)))

(defmethod reagent-page :user/grid [{:keys [route-params query-params handler] :as route}]
  [:div.h-screen.w-screen.bg-blue-100.grid.grid-cols-1
   {:style {:grid-template-rows "auto 1fr"}}
   [:div.h-8.w-full.bg-blue-300
    [link-href "/" "main"]
    [link-dispatch [:css/set-theme-component :aggrid true] "default"]
    [link-dispatch [:css/set-theme-component :aggrid "balham"] "balham"]
    [link-dispatch [:css/set-theme-component :aggrid "balham-dark"] "balham-dark"]
    [link-dispatch [:css/set-theme-component :aggrid "fresh"] "fresh"]
    [:span "time: " (t/now)]]
   [:div.grid.grid-cols-2.h-full.w-full.bg-yellow-300
    [aggrid {:data data}]
    [aggrid {:data data2
             :box :fl
             :columns [:make
                       :model
                       {:field :price
                        :format (partial round-number-digits 2)}
                       {:field :date
                        :format fmt-yyyymmdd}]}]]])
