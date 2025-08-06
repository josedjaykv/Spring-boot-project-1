# Line's Revenge

#### Importar imagen de docker
Ejecutar `docker load -i .\bully.tar`

Luego `docker run -p 8080:8080 spring-boot-project-1-api`

---
#### Rutas de la API
- URL base: `http://localhost:8080/revenge-api/api` 
- Pagina principal (dashboard): [/line/dashboard](http://localhost:8080/revenge-api/api/line/dashboard)
- Estadisticas: [/stats/dashboard](http://localhost:8080/revenge-api/api/stats/dashboard)
- Bullies: [/bullies](http://localhost:8080/revenge-api/api/bullies)
- Cliques: [/cliques](http://localhost:8080/revenge-api/api/cliques)
- Revenge plans: [/revenge-plans](http://localhost:8080/revenge-api/api/revenge-plans)
- Media: [/media](http://localhost:8080/revenge-api/api/media)
- Mood tracker: [/mood-tracker](http://localhost:8080/revenge-api/api/mood-tracker)

---
#### Rutas específicas
- Ver Bullies de una Clique específica (clique id=5): [/bullies/clique/5](http://localhost:8080/revenge-api/api/bullies/clique/5)
- Ver Revenge Plans de un Bully específico: [/revenge-plans/bully/5](http://localhost:8080/revenge-api/api/revenge-plans/bully/5)

**Hay más rutas en el archivo requests.http**





