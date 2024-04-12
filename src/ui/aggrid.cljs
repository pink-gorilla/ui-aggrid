(ns ui.aggrid
  (:require
   [clojure.set :refer [rename-keys]]
   [re-frame.core :as rf]
   ["ag-grid-react" :as rs :refer [AgGridReact]]
   [pinkie.ui.core :refer [apply-box-style]]))

(defn col-kw->aggrid-column
  ([k]
   {:headerName (name k)
    :field (name k)
   ;:valueGetter "data.metrics.a"
    :resizable true
    :sortable true
    :filter true
   ;:width 50 
   ;:valueFormatter currency-formatter
   ;:lockPosition true 
   ;:pinned "left"
    })
  ([k m]
   (merge m (col-kw->aggrid-column k))))

;; formatter

(defn add-formatter [formatter]
  (fn [params]
    ;(println "formatting: " params)
    (let [p (js->clj params)
          v (get p "value")]
      (formatter v))))

(defn preprocess-col [{:keys [format field] :as col}]
  (if (keyword? col)
    (col-kw->aggrid-column col)
    (let [col  (if (keyword? field)
                 (col-kw->aggrid-column field col)
                 col)]
      (if format
        (->
         (assoc col :valueFormatter (add-formatter format))
         (dissoc :format))
        col))))

(defn preprocess-cols [cols]
  ;(println "preprocessing cols: " cols)
  (into []
        (map preprocess-col cols)))

;; auto generate columns

(defn all-cols [data]
  (let [row1 (first data)
        col-keys (keys row1)
        columns (into []
                      (map col-kw->aggrid-column col-keys))]
    ;(println "all-cols: " all-cols)
    columns))

(defn default-cols [spec]
  (let [spec (rename-keys spec  {:columns :columnDefs
                                 :data :rowData})
        {:keys [columnDefs rowData]} spec]
    (if (and (not columnDefs) rowData)
      (assoc spec :columnDefs (all-cols rowData))
      (assoc spec :columnDefs (preprocess-cols columnDefs)))))

(defn on-grid-ready [p]
  ; https://www.ag-grid.com/javascript-grid/column-sizing/
  ; It is possible to have the grid auto size the columns to fill the width by default. 
  ; Do this by calling api.sizeColumnsToFit () on the gridReady event.
  (let [cols  (.. p -columnApi getAllColumns)
        col-ids (into []
                      (map #(. % -colId) cols))]
    (.. p -columnApi (autoSizeColumns (clj->js col-ids) true))))

(defn ^{:category :viz}
  aggrid
  "displays a seq in a table, uses ag-grid"
  [spec]
  (let [spec (default-cols spec)
        ;spec (assoc spec :onFirstDataRendered on-grid-ready)
        spec (if (:autosize-columns spec)
               (assoc spec :onGridReady on-grid-ready)
               spec)]
    [:> AgGridReact spec]))

(defn ag-theme-classname [theme]
  (if (= theme true)
    ""
    (str "ag-theme-" theme)))

(defn aggrid-styled [{:keys [style] :as spec}]
  (let [theme (rf/subscribe [:css/theme-component :aggrid])]
    (fn [{:keys [style] :as spec}]
      [:div {:className (ag-theme-classname @theme)
             :style style}
       [aggrid spec]])))

; simple wraper to create default box size
(defn aggrid-boxed [{:keys [box] :as spec
                     :or {box :md}}]
  [aggrid-styled (apply-box-style spec)])

