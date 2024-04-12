(ns demo.page.formatter
  (:require
   [pinkgorilla.repl.cljs.js :refer [to-fixed]]
   [ui.aggrid :refer [aggrid-boxed]]
   [demo.lib.ui :refer [link-href link-dispatch]]))

(def rates
  [{:tenor "1D" :rate 1 :vol-factor 1 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "5D" :rate 3 :vol-factor 1.5 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "1M" :rate 6 :vol-factor 0.9444443333 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "6M" :rate 4 :vol-factor 2.1234567890123456789 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "1Y" :rate 5 :vol-factor 3 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "2Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "5Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "10Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "30Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "50Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "60Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "70Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "80Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "90Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "90Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "90Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "90Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "90Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "90Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "90Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "90Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "90Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "90Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "90Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}
   {:tenor "90Y" :rate 2 :vol-factor 2 :s "asdköfj adkfj alkdsfj löasfj ölkdjaf löksdfj löa f" :metrics {:a 1} :report-metrics {:a 1}}])

; ROUND NUMBER

(defn round-number-digits
  [digits number] ; digits is first parameter, so it can easily be applied (data last)
  (if (nil? number) "" (to-fixed number digits)))

(defn round-number
  [number]
  (round-number-digits 0 number))

(def rateCols [{:headerName "MyTenor" :field "tenor" :width 100 :sortable true :filter true :lockPosition true :pinned "left"}
               {:headerName "Metric/A" :valueGetter "data.metrics.a" :width 50 :sortable false :filter false}
               {:headerName "Rate" :field "rate" :width 50 :sortable true :filter false}
               {:headerName "Vol-F" :field "vol-factor" :width 50 :format (partial round-number-digits 2) :sortable false :filter false}
               {:headerName "Comment" :field "s" :width 300 :sortable false :filter false}])



(defn formatter-page [{:keys [handler route-params query-params] :as route}]
  [:div
   [:h1.text-2xl.text-red-600.m-5 "grid with custom column formatter"]
   [link-href "/" "main"]
   [aggrid-boxed {:box :lg
            :columns  rateCols
            :data rates
            :pagination true
            :paginationAutoPageSize true}]])

