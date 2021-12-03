DROP DATABASE PSP_EV1;
create database PSP_EV1;
use PSP_EV1;



create table categoria(
	codigo integer auto_increment,
    nombre varchar(20),
    estado tinyint, 
    primary key(codigo)
);


INSERT INTO `PSP_EV1`.`categoria` (`codigo`, `nombre`, `estado`) VALUES ('1', 'MANTENIMIENTO', '1');
INSERT INTO `PSP_EV1`.`categoria` (`codigo`, `nombre`, `estado`) VALUES ('2', 'PRODUCCIÓN', '1');
INSERT INTO `PSP_EV1`.`categoria` (`codigo`, `nombre`) VALUES ('3', 'LOGÍSTICA');


commit;
