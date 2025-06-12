CREATE TABLE `usuarios` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(45) DEFAULT NULL,
                            `address` varchar(45) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO usuarios (name, address) VALUES ('kevin j pina c', 'Caracas - Venezuela');
INSERT INTO usuarios (name, address) VALUES ('javier calatrava', 'Santiago de Chile - Chile');
INSERT INTO usuarios (name, address) VALUES ('kevin pina', 'Madrid - Espana');
