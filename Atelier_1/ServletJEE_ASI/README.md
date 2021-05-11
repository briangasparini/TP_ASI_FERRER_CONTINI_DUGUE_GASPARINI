# Membre du groupe : 
- DORIAN	DUGUE
- ENZO	CONTINI
- HUGO	FERRER
- BRIAN	GASPARINI-BARRELON

# ATELIER 1
## Cahier des charges :
- [X] Représentation de l’IHM en Web Statique en interaction avec un Web Service existant (après l’avoir commenté) via javascript et AJAX.
- [X] Utilisation du Web Dynamique avec JEE avec connexion à une base de données existante via JDBC
- [X] Réalisation d’un formulaire de création de cartes (en Web Statique et en Web Service)
- [X] Réalisation d’un formulaire de création de cartes (en Web Dynamique)
- [X] Réalisation de la visualisation de cartes (en Web Statique et en Web Service)
- [X] Réalisation de la visualisation de cartes (en Web Dynamique)
- [ ] Justification du principe MVC sur chaque prototype
- [X] Explication avantages / inconvénients Web Statique
- [X] Explication avantages / inconvénients Web Service et Dynamique




|               | STATIQUE                                                                                                                                                                       | DYNAMIQUE                                                                                                                                         |
|---------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| AVANTAGES     | - Moins de ressources consommées - Pas de problème de données non affichées - Sécurité plus grande - Veille technologique non contraignante                                    | - Interaction avec l'utilisateur - Possibilité de personnaliser l'affichage - Moins de fichier à créer - Mise à jour plus facile - Plus flexibles |
| INCONVENIENTS | - Grand nombre de pages ( 1 par besoin) - Peu d'interaction - Plus grande difficulté à maintenir - Besoin d'un développeur pour changer le contenu (intervention dans le code) | - Couteux(économiquement et en ressources) - Complexe dans sa structure (peut faire intervenir plusieurs acteurs)                                 |

## RESPECT DU MVC  

MODEL:
- Java beans

SERVICE METIER:
- DAO

VIEW:  
- JSP
  
CONTROLLER:
- Servlet (plutôt que d'implémenter du la business logic directement dans les servlets, on préférera la déléguer à des services)

link:https://github.com/EnzoContinho/ServletJEE_ASI.gitq