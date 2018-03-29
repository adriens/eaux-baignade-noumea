[![Build Status](https://travis-ci.org/adriens/eaux-baignade-noumea.svg?branch=master)](https://travis-ci.org/adriens/eaux-baignade-noumea)
[![Dependency Status](https://beta.gemnasium.com/badges/github.com/adriens/eaux-baignade-noumea.svg)](https://beta.gemnasium.com/projects/github.com/adriens/eaux-baignade-noumea)

# eaux-baignade-noumea

API pour accéder à la qualité des eaux de baignade, via le crawling de www.noumea.nc (http://www.noumea.nc/actualites/qualite-des-eaux-de-baignade-0)

# Endpoints

```
/plages
/plages/{plageId}
/drapeaux
/drapeaux/{drapeauId}
/metadatas
```

Sur Heroku :

```
https://eaux-baignade-noumea.herokuapp.com/plages
https://eaux-baignade-noumea.herokuapp.com/plages/{plageId}
https://eaux-baignade-noumea.herokuapp.com/drapeaux
https://eaux-baignade-noumea.herokuapp.com/drapeaux/{drapeauId}
https://eaux-baignade-noumea.herokuapp.com/metadatas
```