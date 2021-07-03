
;; babashka script to generate css config.
(defn add-themes [m theme-base themes]
  (let [theme-link (fn [theme]
                     (format theme-base theme))
        add-theme (fn [acc theme]
                    ;(println "adding:" theme)
                    (assoc acc theme [(theme-link theme)]))]
    (reduce add-theme m themes)))

(def themes-aggrid
  ["alpine-dark" "alpine"
   "balham" "balham-dark"
   "blue" "bootstrap"
   "dark" "fresh"
   "material"])

(def fonts-aggrid
  ["Alpine"
   "Balham"
   "Classic"
   "Material"])

(println (pr-str (add-themes
 {true ["ag-grid-community/dist/styles/ag-grid.css"]
              ;"default" ["ag-grid-community/dist/styles/ag-grid.css"]
  }
 "ag-grid-community/dist/styles/ag-theme-%s.css"
 themes-aggrid)))