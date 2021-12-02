-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ServicioWebREST
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ServicioWebREST
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ServicioWebREST` ;
USE `ServicioWebREST` ;

-- -----------------------------------------------------
-- Table `ServicioWebREST`.`director`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ServicioWebREST`.`director` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL,
  `nacionalidad` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ServicioWebREST`.`pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ServicioWebREST`.`pelicula` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL,
  `año` INT NULL,
  `duracion` FLOAT NULL,
  `director_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_pelicula_director_idx` (`director_id` ASC) VISIBLE,
  CONSTRAINT `fk_pelicula_director`
    FOREIGN KEY (`director_id`)
    REFERENCES `ServicioWebREST`.`director` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ServicioWebREST`.`actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ServicioWebREST`.`actor` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NULL,
  `nacionalidad` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ServicioWebREST`.`pelicula_has_actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ServicioWebREST`.`pelicula_has_actor` (
  `pelicula_id` BIGINT(20) NOT NULL,
  `actor_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`pelicula_id`, `actor_id`),
  INDEX `fk_pelicula_has_actor_actor1_idx` (`actor_id` ASC) VISIBLE,
  INDEX `fk_pelicula_has_actor_pelicula1_idx` (`pelicula_id` ASC) VISIBLE,
  CONSTRAINT `fk_pelicula_has_actor_pelicula1`
    FOREIGN KEY (`pelicula_id`)
    REFERENCES `ServicioWebREST`.`pelicula` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pelicula_has_actor_actor1`
    FOREIGN KEY (`actor_id`)
    REFERENCES `ServicioWebREST`.`actor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `ServicioWebREST`.`director`
-- -----------------------------------------------------
START TRANSACTION;
USE `ServicioWebREST`;
INSERT INTO `ServicioWebREST`.`director` (`id`, `nombre`, `nacionalidad`) VALUES (DEFAULT, 'George Lucas', 'Estados Unidos');
INSERT INTO `ServicioWebREST`.`director` (`id`, `nombre`, `nacionalidad`) VALUES (DEFAULT, 'Peter Jackson', 'Nueva Zelanda');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ServicioWebREST`.`pelicula`
-- -----------------------------------------------------
START TRANSACTION;
USE `ServicioWebREST`;
INSERT INTO `ServicioWebREST`.`pelicula` (`id`, `nombre`, `año`, `duracion`, `director_id`) VALUES (DEFAULT, 'Star Wars: Episodio IV', 1977, 121, 1);
INSERT INTO `ServicioWebREST`.`pelicula` (`id`, `nombre`, `año`, `duracion`, `director_id`) VALUES (DEFAULT, 'El Señor de los Anillos: El Retorno del Rey', 2003, 201, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `ServicioWebREST`.`actor`
-- -----------------------------------------------------
START TRANSACTION;
USE `ServicioWebREST`;
INSERT INTO `ServicioWebREST`.`actor` (`id`, `nombre`, `nacionalidad`) VALUES (DEFAULT, 'Mark Hamill', 'Estados Unidos');
INSERT INTO `ServicioWebREST`.`actor` (`id`, `nombre`, `nacionalidad`) VALUES (DEFAULT, 'Harrison Ford', 'Estados Unidos');
INSERT INTO `ServicioWebREST`.`actor` (`id`, `nombre`, `nacionalidad`) VALUES (DEFAULT, 'Carrie Fisher', 'Estados Unidos');
INSERT INTO `ServicioWebREST`.`actor` (`id`, `nombre`, `nacionalidad`) VALUES (DEFAULT, 'Elijah Wood', 'Estados Unidos');
INSERT INTO `ServicioWebREST`.`actor` (`id`, `nombre`, `nacionalidad`) VALUES (DEFAULT, 'Ian McKellen', 'Inglaterra');
INSERT INTO `ServicioWebREST`.`actor` (`id`, `nombre`, `nacionalidad`) VALUES (DEFAULT, 'Liv Tyler', 'Estados Unidos');
INSERT INTO `ServicioWebREST`.`actor` (`id`, `nombre`, `nacionalidad`) VALUES (DEFAULT, 'Viggo Mortensen', 'Estados Unidos, Dinamarca');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ServicioWebREST`.`pelicula_has_actor`
-- -----------------------------------------------------
START TRANSACTION;
USE `ServicioWebREST`;
INSERT INTO `ServicioWebREST`.`pelicula_has_actor` (`pelicula_id`, `actor_id`) VALUES (1, 1);
INSERT INTO `ServicioWebREST`.`pelicula_has_actor` (`pelicula_id`, `actor_id`) VALUES (1, 2);
INSERT INTO `ServicioWebREST`.`pelicula_has_actor` (`pelicula_id`, `actor_id`) VALUES (1, 3);
INSERT INTO `ServicioWebREST`.`pelicula_has_actor` (`pelicula_id`, `actor_id`) VALUES (2, 4);
INSERT INTO `ServicioWebREST`.`pelicula_has_actor` (`pelicula_id`, `actor_id`) VALUES (2, 5);
INSERT INTO `ServicioWebREST`.`pelicula_has_actor` (`pelicula_id`, `actor_id`) VALUES (2, 6);
INSERT INTO `ServicioWebREST`.`pelicula_has_actor` (`pelicula_id`, `actor_id`) VALUES (2, 7);

COMMIT;

