# Fitness Application APIs

Ce projet contiennent des APIs de `suivi de fitness` qui permet de `gérer les exercices`, `les programmes d'entraînement` et `les progrès des utilisateurs`. L'objectif est d'aider les utilisateurs à créer des routines personnalisées, suivre leurs performances, et recevoir des conseils adaptés à leurs besoins.

## Fonctionnalités

- **Création de routines :** Les utilisateurs peuvent créer des plans d'entraînement personnalisés en fonction de leurs objectifs de fitness.
- **Suivi des performances :** Enregistrement des progrès des utilisateurs à travers différents indicateurs comme la fréquence, la durée des séances, et l'intensité des exercices.
- **Conseils personnalisés :** Offrir des recommandations basées sur les performances enregistrées afin d'améliorer les résultats et de rester motivé.

## Prérequis

Avant de lancer ce projet, vous devez avoir installé les éléments suivants :

- **Java 17**
- **Maven** (version `3.8` ou supérieure)
- **PostgreSQL** (version `12` ou supérieure)

## Configuration de la base de données

1. Installez PostgreSQL et créez une base de données.
2. Configurez un `utilisateur` et un `mot de passe` pour la base de données.
3. Configurez votre `port`
4. Mettez à jour le fichier `application.properties` avec les informations de connexion à votre base de données :

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:votre_port/nom_db
   spring.datasource.username=votre_nom_utilisateur
   spring.datasource.password=votre_mot_de_passe
   spring.jpa.hibernate.ddl-auto=create(au premier demmarage), update(apres le premier demmarage)
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

## Installation

Suivez les étapes ci-dessous pour installer et exécuter l'API :

1. Clonez le dépôt Git dans votre répertoire local :

    ```properties
    git clone https://github.com/votre-utilisateur/application-fitness.git

2. Accédez au répertoire du projet :

     ```properties
    cd fitness

3. Compilez le projet avec Maven :

    ```properties
    mvn clean install

4. Démarrez l'application avec Maven :

   ```properties
    mvn spring-boot:run

5. L'application sera disponible sur `http://localhost:votre_port`

## Endpoints des APIs

Routines d'entraînement

  - Créer une nouvelle routine
      - Méthode : `POST`
      - URL : `/api/routines`

  - Récupérer toutes les routines d'entraînement
      - Méthode : `GET`
      - URL : `/api/routines`

Suivi des performances

  - Enregistrer une nouvelle performance
      - Méthode : `POST`
      - URL : `/api/performances`

  -  Récupérer les données de performances de l'utilisateur
      - Méthode : `GET`
      - URL : `/api/performances`

Conseils Personnalisés

  -  Récupérer des conseils adaptés en fonction des performances enregistrées
      - Méthode : `GET`
      - URL : `/api/personalizedAdvices`
        
## Documentation des APIs

La documentation complète de l'API est disponible via un fichier `Postman` que vous pouvez importer dans votre environnement Postman. Téléchargez le fichier ici.

## Contributions
Les contributions sont les bienvenues. Veuillez ouvrir une `issue` pour discuter des changements majeurs avant de soumettre une `pull request`.
