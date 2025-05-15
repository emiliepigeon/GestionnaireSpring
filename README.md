
# Premier API

15/05/2025

Je suis débutante voici mon premier projet d'API.
Exercice demandé par mon formateur : mise en place d'une API de Gestionnaire de formation et de centre.

Pour cela un cahier des charges nous a été remis, ainsi qu'un fichier looping de la modélisation et conceptualisation de la base de données relationnelle.

-----------------------------------------------------------------------------------------
JAVA / MAVEN / SPRING BOOT
_________________________________________________________________________
# Demande 1 du formateur
Création via phpMyAdmin de la BDD (entités/tables relationnelles et contraintes).

# Demande 2 du formateur
Mettre en place un dépôt GITHUB propre et pousser régulièrement (sur le dépôt distant).

Pour cela :
- je me connecte à GitHub
- je crée un nouveau repository
- j'ouvre ma console GitBash (sur mon pc je me mais dans le répertoire où je veux travailler. Puis clic droit -> afficher plus d'otion -> ouvrir le GitBash).

- Dans mon bash :
1- git clone [url du dépôt distant]
2- cd [non du dossier] -> je me déplace dans le bon répertoire
3- git init -> j'initialise mon dépôt

- Je ferme mon GitBash et j'ouvre mon projet (dossier de travail) dans mon éditeur de texte ou IDE -> en l'occurence je vais utiliser VsCode.

Nb : j'ai en amont installé mon JDK et mis en place les variables d'environnement pour pouvoir travailler avec le langage Java.

# Demande 3 du formateur
Cette étape à déjà été faite. 

Initier le projet Spring Boot via https://start.spring.io/

Si besoin de packages supplémentaires https://mvnrepository.com/

Je vais donc juste récupérer mon projet précédent.
Pour cela je fais un copier collé de mon ancien projet dans mon nouveau projet.
Je fais cela pour que mon repository soit propre et carré (demande du formateur).

# Pour continuer
et avoir un dépôt propre.

J'ouvre un terminal GitBash dans Vs Code

Je m'assure d'être dans le bon répertoire.


#### AVANT de continuer je vais synchroniser mes dépôt

ATTENTION Ce que je vais poussé ne fonctionne pas.
C'est la base pour recommencer le travail dont je n'avais pas compris les consignes depuis 3 semaines.

git status
git add .
git commit -m "message"
git push

C'est fait!
Je vérifie sur mon GitHub.

Tout est Ok.

Mon gitignore est lui aussi bien pris en compte.

# Consignes du formateur pour la suite:
Pour le 20 mai 2025
- Il faut que pour mardi prochain en présentiel afin de pouvoir avancer soit terminé les modules API suivant : utilisateur, rôle, formation, module, et séquence  + un GitHub propre !

# Structure de base du projet
src/main/java
└── com/emi/GestionnaireFormation/
    ├── controller/
    ├── model/
    ├── repository/
    ├── service/
    └── GestionnaireFormationApplication.java

# Je créer une nouvelle branche de travail
$ git branch [non de la nouvelle branche de travail]

$ git branch
  Api_V1
* main

$ git checkout Api_V1
M       README.md
Switched to branch 'Api_V1'

# Je suis dans ma nouvelle branche de travail

Je vais pousser ma nouvelle branche:
$ git status



