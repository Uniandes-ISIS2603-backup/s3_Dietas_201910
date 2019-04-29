delete from PagoEntity;
delete from CocinaEntity;
delete from TipoDietaEntity;
delete from HallOfFameEntity;
delete from PersonaEntity;
delete from QuejaYReclamoEntity;
delete from CalificacionYComentarioEntity;
delete from FotoEntity;
delete from DietaEntity;
delete from SuspensionEntity;
delete from SemanaEntity;
delete from DiaEntity;
delete from ComidaEntity;


insert into CocinaEntity (id, direccion) values (1, '021 Magdeline Way');
insert into CocinaEntity (id, direccion) values (2, '8 Susan Terrace');
insert into CocinaEntity (id, direccion) values (3, '470 Texas Road');
insert into CocinaEntity (id, direccion) values (4, '168 Chinook Center');
insert into CocinaEntity (id, direccion) values (5, '847 Cardinal Road');

insert into HallOfFameEntity (id, mensaje) values (1, 'sollicitudin vitae');
insert into HallOfFameEntity (id, mensaje) values (2, 'Duis aliquam convallis nunc.');
insert into HallOfFameEntity (id, mensaje) values (3, 'sit amet lobortis sapien sapien non mi.');
insert into HallOfFameEntity (id, mensaje) values (4, 'Curabitur gravida nisi at nibh.');
insert into HallOfFameEntity (id, mensaje) values (5, 'Ffelis. Fusce posuere felis sed lacus.');

insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (1, '2018-12-24 06:58:48', 'Perritoa', 'Praesent lectus. Vestibulum quam sapien, varius uta',0, 1,14, 'Doctor', 1);
insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (2, '2018-11-24 06:58:48', 'Perritob', 'Praesent lectus. Vestibulum quam sapien, varius utb', 1,0,21, 'Doctor',2);
insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (3, '2018-10-24 06:58:48', 'Perritoc', 'Praesent lectus. Vestibulum quam sapien, varius utc', 0, 0,23, 'Cliente',3);
insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (4, '2018-09-24 06:58:48', 'Perritod', 'Praesent lectus. Vestibulum quam sapien, varius utd', 0, 1,6, 'Cliente',4);
insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (5, '2018-08-24 06:58:48', 'Perritoe', 'Praesent lectus. Vestibulum quam sapien, varius ute', 0, 0,7, 'Cliente',5);

insert into PagoEntity (id, modoPago,persona_id) values (1, 'Efectivo',1);
insert into PagoEntity (id, modoPago,persona_id) values (2, 'Electrónico',2);
insert into PagoEntity (id, modoPago,persona_id) values (3, 'Efectivo',3);
insert into PagoEntity (id, modoPago,persona_id) values (4, 'Electrónico',4);
insert into PagoEntity (id, modoPago,persona_id) values (5, 'Efectivo',5);

insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (1, 'Posuere cubilia Curae; Mauris viverra diam vitae quam.', 1);
insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (2, 'Laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', 2);
insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (3, 'Nullam sit amet turpis elementum ligula vehicula consequat.', 3);
insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (4, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 4);
insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (5, 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 5);

insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (1, 3, 'Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo', 1);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (2, 2, 'Praesent id massa id nisl venenatis laciniao.', 2);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (3, 1, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit', 3);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (4,5, 'Proin eu mi.', 4);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (5, 5, 'Donec quis orci eget orci vehicula condimentum.', 5);

insert into FotoEntity (id, nombre, url, persona_id) values (1, '645', 'http://dummyimage.com/165x240.jpg/ff4444/ffffff', 1);
insert into FotoEntity (id, nombre, url, persona_id) values (2, '80309', 'http://dummyimage.com/137x202.jpg/5fa2dd/ffffff', 2);
insert into FotoEntity (id, nombre, url, persona_id) values (3, '01609', 'http://dummyimage.com/166x198.jpg/dddddd/000000', 3);
insert into FotoEntity (id, nombre, url, persona_id) values (4, '140', 'http://dummyimage.com/226x131.jpg/ff4444/ffffff', 4);
insert into FotoEntity (id, nombre, url, persona_id) values (5, '4791', 'http://dummyimage.com/172x230.jpg/dddddd/000000', 5);

insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (1, 14, 'Dieta1', 'bajar','celiaca' , 1);
insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (2, 21, 'Dieta2', 'subir','celiaca' , 2);
insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (3, 32, 'Dieta3', 'comer','celiaca' , 3);
insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (4, 19, 'Dieta4', 'masa muscular', 'celiaca' , 4);
insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (5, 24, 'Dieta5', 'brazos','celiaca' , 5);

insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (1, 'In hac habitasse platea dictumstA', 'Food Chemist', 'In hac habitasse platea dictumst.');
insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (2, 'In hac habitasse platea dictumstB', 'Clinical Specialist', 'Nunc purus.');
insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (3,'In hac habitasse platea dictumstC', 'Nurse Practicioner', 'Aenean lectus.');
insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (4, 'In hac habitasse platea dictumstD', 'Cost Accountant', 'Morbi vestibulum, velito.');
insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (5, 'In hac habitasse platea dictumstE', 'Payment Adjustment Coordinator', 'Praesent id massa id nis');

insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (1,'Condimentum id, luctus nec, molestie sed, justo.',3,0,1 );
insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (2,'Condimentum id, luctus nec, molestie sed, justo.',6,1,2);
insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (3,'Condimentum id, luctus nec, molestie sed, justo.',25,1,3);
insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (4,'Condimentum id, luctus nec, molestie sed, justo.',78,0,4);
insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (5,'Condimentum id, luctus nec, molestie sed, justo.',14,1,5);

insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (1,14 ,'2018-12-24 06:58:48', '80329 Sutteridge Pass', 1);
insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (2,15 ,'2018-12-24 06:58:48', '6980 Northland Crossing', 2);
insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (3,16 ,'2018-12-24 06:58:48', '5 Lien Pass', 3);
insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (4,17 ,'2018-12-24 06:58:48', '613 Kim Point', 4);
insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (5, 18,'2018-12-24 06:58:48', '8742 Mallory Way',  5);

insert into DiaEntity (id, especial, semana_id) values (1, 0, 1);
insert into DiaEntity (id, especial, semana_id) values (2, 1, 2);
insert into DiaEntity (id, especial, semana_id) values (3, 1, 3);
insert into DiaEntity (id, especial, semana_id) values (4, 0, 4);
insert into DiaEntity (id, especial, semana_id) values (5, 1, 5);

insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (1, 'jcb', 'Elementum pellentesque. Quisque porta volutpat erat.', 1, 1);
insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (2, 'mastercard', 'Consectetuer adipiscing elit. Proin risus.', 2, 2);
insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (3, 'jcb', 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 3, 3);
insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (4, 'jcb', 'Donec posuere metus vitae ipsum.', 4, 4);
insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (5, 'switch', 'Donec vitae nisi.', 5, 5);

insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (1, 1);
insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (2, 2);
insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (3, 3);
insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (4, 4);
insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (5, 5);

