# Ynov Evaluation
Evaluation du module "Méthodologie de tests" réalisé par Necati ÜNLÜ

## Base de donnée mySQL - Docker
Démarrage d'un contenaire docker pour la BDD
```bash
docker run --name mysql -p 3306:3306 -v /chemin/local:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=simplepassword -d mysql:latest
```
