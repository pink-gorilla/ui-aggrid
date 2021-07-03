# ui-aggrid [![GitHub Actions status |pink-gorilla/ui-aggrid](https://github.com/pink-gorilla/ui-aggrid/workflows/CI/badge.svg)](https://github.com/pink-gorilla/ui-aggrid/actions?workflow=CI)[![Clojars Project](https://img.shields.io/clojars/v/org.pinkgorilla/ui-aggrid.svg)](https://clojars.org/org.pinkgorilla/ui-aggrid)

https://www.ag-grid.com/

## Demo

```
clojure -X:goldly
```

Navigate your webbrowser to port 8000. 
Snippets are in `running systems` / `snippet-registry`

## In Goldly as a ui extension

In deps.edn add ui-aggrid as dependency and add goldly alias

```
:goldly
  {:extra-deps {org.pinkgorilla/goldly {:mvn/version "RELEASE"}
               {org.pinkgorilla/ui-aggrid {:mvn/version "0.0.2"}}
   :exec-fn goldly-server.app/goldly-server-run!
   :exec-args {:profile "watch"
               :config {:goldly {}}}}
```




