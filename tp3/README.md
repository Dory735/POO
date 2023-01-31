# Reponses du TP3 (lien du github à la fin du README)
## Spring Web
Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
-> Module de développement et d'api web, il utilise le modèle MVC (Modèle Vue Contrôleur)

## Spring Data JPA
Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
->JPA permet de créer des entités par l'annotation @Entity devant la création de la classe

## Validation
Bean Validation with Hibernate validator.
->Permet de valider la longueur des champs par exemple en mettant des annotation telles que
@NotNull.

## H2 Database
Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. 
Supports embedded and server modes as well as a browser based console application.
->H2 est une base de données rapide et légère avec une interface web pour voir sa base et exécuter des requêtes

## Spring Boot DevTools
Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
->Spring Boot est un framework permettant de faciliter le développement avec Spring


## Thymeleaf
A modern server-side Java template engine for both web and standalone environments. 
Allows HTML to be correctly displayed in browsers and as static prototypes.
->Thymeleaf est un moteur de rendu pour produire des vues Web.

## 1. Avec quelle partie du code avons-nous paramétré l'url d'appel /greeting ?
@RequestParam(name="nameGET", required=false, defaultValue="World") 


## 2. Avec quelle partie du code avons-nous choisi le fichier HTML à afficher ?
@GetMapping("/greeting")

## 3. Comment envoyons-nous le nom à qui nous disons bonjour avec le second lien ?
http://localhost:8080/greeting?nameGET=ENSIM


## Etape 17:
La table ADDRESSE est apparue dans le menu de gauche
Pourquoi est est-elle apparue?
La création de la classe Adresse est la cause de cette apparition

## ETAPE 20:
Le contenu n'est plus présent


## ETAPE 22:
A quoi sert l'annotation @Autowired dans AddressController?
Dépendance d'injection automatique, il fait le lien entre le controller et son interface en 
repérant les tags

## ETAPE 30:
Expliquez la méthode utilisé ajouter Bootstrap.

-Création d'une navbar (liste de liens) dans un fichier html
-Ajout de th:fragment="navbar" dans <nav> avec navbar le nom du fragment
-ajout dans les pages addresses et greeting d'un div qui va être remplacé par le 
fragment à l'aide de th:replace="fragment/navbar :: navbar"

# Reponses du TP4
## Faut-il une clé API pour appeler MeteoConcept ?
Il y a besoin d'une clé API limitant ainsi l'accès à l'API MeteoConcept.

## Quelle URL appeler ?
On appelle l'url suivant:
https://api.meteo-concept.com/api/forecast/daily?token=notretoken&nosparamètres

## Quelle méthode HTTP utiliser ?
On va utiliser la méthode GET

## Comment passer les paramètres d'appels ?
Pour spécifier la longitude et la latitude de la ville on va passer le paramètre latlng dans notre url comme ceci:
https://api.meteo-concept.com/api/forecast/daily?token=notretoken&latlng=140,10

## Où est l'information dont j'ai besoin dans la réponse :
La réponse est composée d'informations de la ville dans city puis de la météo pour les 13 prochains jours chacune dans un item.




### Pour afficher la température du lieu visé par les coordonnées GPS
Les informations intéréssantes pour ceci peuvent être la température minimum et maximum (tmin et tmax).

### Pour afficher la prévision de météo du lieu visé par les coordonnées GPS
L'attribut weather est intéréssant, nous pouvons récupérer le code temps avec cet attribut et le faire correspondre avec sa description.
Par exemple 0= Soleil.


## Lien vers projet GitHub
https://github.com/Dory735/POO.git
