delete from DietaEntity;
delete from PagoEntity;

insert into DietaEntity (id, nombre, tipo, objetivo, diasSuspendida, persona_id) values (1, 'Sylas', 'eu tincidunt in leo maecenas', 'Halcyon smyrnesis', 1, 1);
insert into DietaEntity (id, nombre, tipo, objetivo, diasSuspendida, persona_id) values (2, 'Ebony', 'nisi eu orci mauris lacinia sapien quis libero nullam sit', 'Meles meles', 2, 1);
insert into DietaEntity (id, nombre, tipo, objetivo, diasSuspendida, persona_id) values (3, 'Krysta', 'id sapien in sapien iaculis congue vivamus metus', 'Casmerodius albus', 3, 3);
insert into DietaEntity (id, nombre, tipo, objetivo, diasSuspendida, persona_id) values (4, 'Nanni', 'eros suspendisse accumsan tortor quis turpis', 'Rangifer tarandus', 4, 4);
insert into DietaEntity (id, nombre, tipo, objetivo, diasSuspendida, persona_id) values (5, 'Maryjo', 'libero nullam sit amet turpis', 'Phasianus colchicus', 5, 5);

insert into PagoEntity (id, modoPago, persona_id) values (1, 'Efectivo', 1);
insert into PagoEntity (id, modoPago, persona_id) values (2, 'Electrónico', 2);
insert into PagoEntity (id, modoPago, persona_id) values (3, 'Efectivo', 1);

