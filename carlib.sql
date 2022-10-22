-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : sam. 22 oct. 2022 à 11:50
-- Version du serveur : 10.6.5-MariaDB
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `carlib`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `categorie_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`categorie_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`categorie_id`, `nom`) VALUES
(1, 'Standard'),
(2, 'Special'),
(3, 'JeunesConducteurs'),
(4, 'Promotion'),
(6, '-25 ans');

-- --------------------------------------------------------

--
-- Structure de la table `categorie_produit`
--

DROP TABLE IF EXISTS `categorie_produit`;
CREATE TABLE IF NOT EXISTS `categorie_produit` (
  `categorie_id` int(11) NOT NULL,
  `produit_id` int(11) NOT NULL,
  PRIMARY KEY (`categorie_id`,`produit_id`),
  KEY `produitid_idx` (`produit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `categorie_produit`
--

INSERT INTO `categorie_produit` (`categorie_id`, `produit_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(3, 4),
(6, 7);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `commentaire_id` int(11) NOT NULL AUTO_INCREMENT,
  `contenu` varchar(255) DEFAULT NULL,
  `produit_id` int(11) NOT NULL,
  PRIMARY KEY (`commentaire_id`),
  KEY `produitid_idx` (`produit_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`commentaire_id`, `contenu`, `produit_id`) VALUES
(1, 'Assurance avec un bon rapport qualité prix', 2),
(2, 'Minimum du minimum, un peu deçu', 1),
(3, 'Ce qu\'on peut attendre d\'une assurance au tiers, ni plus, ni moins', 1),
(4, 'Excellente assurance tous risques ! Prix compétitif vis à vis des autres assureurs', 3),
(5, 'L\'assurance est bien, mais les délais de traitement ne me conviennent pas, trop d\'attente!', 3),
(6, 'Assurance trés fiable', 6);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `produit_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `cout` int(11) DEFAULT NULL,
  PRIMARY KEY (`produit_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`produit_id`, `nom`, `description`, `cout`) VALUES
(1, 'AssuranceAuTiersSimple', 'Assurance couvrant uniquement les dégats matériels et corporels que vous êtes susceptible de causer à autrui avec votre véhicule.', 500),
(2, 'AssuranceAuTiersEtendue', 'Assurance couvrant le minimum de la garantie responsabilité civile et le bris de glace, le vol, l\'attentat, les catastrophes naturelles et technologiques', 800),
(3, 'AssuranceTousRisques', 'Assurance qui reprend les garanties de l\'assurance au tiers étendue et auxquelles on ajoute la garantie dommage tous accidents (responsable ou non).', 1500),
(4, 'AssuranceTousRisquesJeunes', 'L\'assurance tous risques pour les jeunes conducteurs (- 2 ans de permis de conduire)', 2200),
(6, 'AssuranceAuTiersFidelité', 'assurance normale', 1100),
(7, 'AssuranceAuTiers-25ans', 'Assurance aux tiers reservés aux conducteurs de -25ans', 400);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
