(ns pinkgorilla.aggrid.goldly
  (:require
   [pinkie.pinkie :refer-macros [register-component]]
   [pinkgorilla.aggrid.aggrid :refer [aggrid-boxed]]))

(register-component :p/aggrid aggrid-boxed)
