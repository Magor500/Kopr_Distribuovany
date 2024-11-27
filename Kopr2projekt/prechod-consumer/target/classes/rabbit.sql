-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema rabbit
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rabbit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rabbit` DEFAULT CHARACTER SET utf8 ;
USE `rabbit` ;

-- -----------------------------------------------------
-- Table `rabbit`.`Karta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rabbit`.`Karta` (
  `id_karta` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_karta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rabbit`.`Prechod`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rabbit`.`Prechod` (
  `id_prechod` INT NOT NULL AUTO_INCREMENT,
  `datum_cas` DATETIME NULL,
  `id_lokacia` INT NOT NULL,
  `id_karta` INT NOT NULL,
  PRIMARY KEY (`id_prechod`),
  INDEX `fk_Prechod_Karta1_idx` (`id_karta` ASC) ,
  CONSTRAINT `fk_Prechod_Karta1`
    FOREIGN KEY (`id_karta`)
    REFERENCES `rabbit`.`Karta` (`id_karta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
