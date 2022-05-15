(ns demo.notebook.aggrid-size)

;; SMALL

^:R
[:p/aggrid {:data [{:make "Toyota" :model "Celica" :price 35000}
                   {:make "Ford" :model "Mondeo" :price 32000}
                   {:make "Porsche" :model "Boxter" :price 72000}]}]

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

;; LARGE

^:R
[:p/aggrid {:data rates
            :box :lg}]

;; CUSTOM 

^:R
['user/aggrid {:style {:width "100%"
                       :height "250px"}
               :data [{:make "Toyota" :model "Celica" :price 35000}
                      {:make "Ford" :model "Mondeo" :price 32000}
                      {:make "Porsche" :model "Boxter" :price 72000}]}]
