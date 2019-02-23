[![Build Status](https://travis-ci.org/adriens/eaux-baignade-noumea.svg?branch=master)](https://travis-ci.org/adriens/eaux-baignade-noumea)


# eaux-baignade-noumea

API pour accéder à la qualité des eaux de baignade, via le crawling de www.noumea.nc (http://www.noumea.nc/actualites/qualite-des-eaux-de-baignade-0)

# Badges

Pour avoir le badge au format svg du status de la plage :

```
/plages/{plageId}/badge.svg
```

# Shield Endpoint

[Shield endpoint](https://shields.io/endpoint) is implemented for an optimal experience :

```
https://eaux-baignade-noumea.herokuapp.com/plages/{plageId}/shield
```

En html :

```html
<a href="https://www.noumea.nc/actualites/qualite-des-eaux-de-baignade-0">
  <img src="https://eaux-baignade-noumea.herokuapp.com/plages/0/badge.svg"/>
</a>
```

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

# Documentation swagger

Bien que minimaliste et très perfectible, la doc swagger : https://eaux-baignade-noumea.herokuapp.com/swagger-ui.html
