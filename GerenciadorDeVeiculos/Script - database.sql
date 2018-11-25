-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: gerenciadorveiculos
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Carros, vans e utilitários'),(2,'Motos'),(3,'Barcos e Aeronaves'),(4,'Ônibus e caminhões');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculos`
--

DROP TABLE IF EXISTS `veiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `veiculos` (
  `id_veiculo` int(11) NOT NULL AUTO_INCREMENT,
  `nm_veiculo` varchar(255) NOT NULL,
  `ano_modelo` int(11) NOT NULL,
  `ano_fabrica` int(11) NOT NULL,
  `km_veiculo` int(11) NOT NULL,
  `vl_veiculo` decimal(10,2) NOT NULL,
  `tp_combustivel` varchar(50) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `imagem` varchar(255) NOT NULL,
  `desc_veiculo` varchar(500) DEFAULT NULL,
  `data_postagem` datetime DEFAULT NULL,
  PRIMARY KEY (`id_veiculo`),
  KEY `fk_categoria` (`id_categoria`),
  CONSTRAINT `fk_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculos`
--

LOCK TABLES `veiculos` WRITE;
/*!40000 ALTER TABLE `veiculos` DISABLE KEYS */;
INSERT INTO `veiculos` VALUES (1,'Cruze LTZ',2014,2014,300,34500.00,'GASOLINA',1,'1105.jpg','Vidro e travas eletricas, cambio automatico, direção hidraulica e revisado.','2018-11-23 22:16:58'),(4,'Civic',2016,2016,3000,55000.00,'FLEX',1,'civic.jpeg','Carro em perfeitas condições, trava elétrica e ar-condicionado. ','2018-11-23 22:34:06'),(5,'Honda CBR600RR',2013,2013,3000,50000.00,'GASOLINA',2,'honda cbr6000rr.jpg','Somente um dono, bem conservada e poderosa.','2018-11-23 22:36:09'),(7,'Boeing 787',2013,2013,78000,4500.00,'FLEX',3,'Boeing-747.jpg','Aeronave em perfeitas condições, somente um acidente e um fantasma.','2018-11-24 20:29:27'),(8,'Jardineira amarela',1981,1981,89999999,9000.00,'DIESEL',4,'Jardineira.jpg','Jardineira daqueles filmes que você assistia quando era pequeno.','2018-11-24 20:50:41'),(9,'Mercedez-Benz 1113',1977,1977,3000,60000.00,'DIESEL',4,'mercedes-benz 1113.jpg','Totalmente conservado, revisado, faz 10km por litro.','2018-11-24 22:23:32');
/*!40000 ALTER TABLE `veiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gerenciadorveiculos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-24 22:53:14
