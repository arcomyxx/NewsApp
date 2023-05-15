# NewsApp

Une application qui affiche les infos récupérées depuis l'API : https://newsapi.org/docs.

J'ai profité de ce projet pour découvrir Jetpack Compose que j'ai utilisé pour la première fois.

Cette application est structurée selon un mix entre l'architecture MVVM et l'architecture hexagonale que je maîtrise plus. Il y a plusieurs similitudes entre ces 2 architectures donc j'ai décidé de tenter de mêler les 2.

J'ai utilisé la version 8 d'Android pour qu'elle soit utilisable par 90% des utilisateurs, car l'application est simple et ne nécessite pas dez features récentes.

J'ai réalisé cette application en environ 7 heures en prenant en compte le temps d'apprentissage de certaines notions, en particulier Jetpack Compose.

# Libraires

- retrofit2 : pour faire un appel à l'API
- coil : pour récupérer l'image depuis l'url
- jUnit : pour les tests
- mockk : pour améliorer les tests

# Choses à améliorer

Utiliser les termes de l'architecture MVVM au lieu de ceux que j'ai repris de l'architecture hexagonale :
- retirer le package `infra`
- port -> repository 
- adapter -> repositoryImpl

Utiliser le système d'injection pour fournir les adapters...

Réaliser un vrai système de cache pour réutiliser les articles dans `NewsDetailsViewModel` plutôt que de réutiliser `NewsListViewModel`

Pour la navigation je suis passé par l'url de l'article comme Id, mais ce serait mieux d'en générer un aléatoire ou en fonction de l'url de l'article.

Centraliser les erreurs dans une enum

Améliorer le design et créer des thèmes

Rajouter un affichage pour le chargement des donénes

Rajouter les tests d'intégration AndroidTest

Rajouter des tests unitaires
