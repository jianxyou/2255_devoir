# Feedback DM1

> **ASeriousName**  
> Jianxin YOU (20134401)  
> Zeinab TALEB (20102655)  
> Harold JOSE-CRUZ (20227229)  

## Cadre du projet

- Le cadre du projet est bien défini
- Les hypothèses sont des suppositions ou assomptions faites en réponse à un manque d'information (ex: infos ambiguës). Ce que vous décrivez est plutôt la solution envisagée.
- L'échéancier est bien organisé et présente suffisamment d'informations pour le jalon 1, mais ne s'étend sur toute la durée prévue du projet.
  - Les éléments connus ou planifiés à date pour les jalons futurs doivent aussi être présentés
- Bonne priorisation

## Compréhension du domaine

### Glossaire

Le glossaire est assez complet, mais trop long.
Certains termes essentiels sont absents du glossaire:

- Bineco
- Activités
- Bacs

### Persona

- Bon persona

## Modélisation du domaine

### Cas d'utilisation

Tous les acteurs sont présents, ainsi que les principaux CUs du système

- Le système se nomme Bineco
- Le résident devait aussi pouvoir *Supprimer un bac*
- La ville (Municipal) n'a pas besoin d'intervenir dans la mise à jour de l'usage des déchets par les capteurs (sensor)
- Les consommateurs devraient mettre à jour leurs informations (pas Municipal)
- Le Résident et Consommateur peuvent être généralisés
  - Actions communes: Se connecter, Modifier son profil

### Scénarios

- Les scénarios doivent l'objectif du CU
- Le scénario principal doit commencer à l'étape 1
- Les étapes doivent alterner entre le système et les acteurs. Éviter d'avoir plus de 2 étapes successives pour le même acteur.
- La plupart des CUs devraient avoir la précondition *Résident est connecté*
- Les scénarios sont parfois trop simples et ne démontre pas une véritable interaction entre acteur et système
- Ajoutez une étape de validation des entrées de l'utilisateur (surtout pour la soumission de formulaire ou l'inscription)

## Analyse

### Risques

Très bien

### Exigences non-fonctionnelles

Très bien

### Ressources

Très bien

### Contraintes

Bien, mais pourrait etre enrichies.
- Les contraintes conceptuelles pourraient porter sur:
  - Compatibilité avec le système municipal (API)
  - Format des données pour les capteurs: CSV
  - Langage de programmation
  - Abstraction choisie pour encapsuler les entités du domaine
  - Opérations possibles et jeu de rôle (contrôle d'accès)
  - Interaction en ligne de commande

### Proposition

- Les métriques écologiques ne sont pas suffisamment détaillées
  - mesures utilisées pour fabriquer la métrique
- Les métriques au niveau municipal doivent refléter l'efficacité du traitement des déchets
- Les métriques de l'application ne sont pas nécessaires

### Prototype

Bon prototype.

## Rapport

- Le rapport doit être en HTML

## Git

- Bon usage de Git
- Tous les membres doivent participer
