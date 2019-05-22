delete from PagoEntity;
delete from ComidaEntity;
delete from CocinaEntity;
delete from TipoDietaEntity_DietaEntity;
delete from TipoDietaEntity;
delete from DiaEntity;
delete from SemanaEntity;
delete from DietaEntity;
delete from PersonaEntity;
delete from HallOfFameEntity;
delete from QuejaYReclamoEntity;
delete from CalificacionYComentarioEntity;
delete from FotoEntity;
delete from SuspensionEntity;


insert into CocinaEntity (id, direccion) values (100, '021 Magdeline Way');
insert into CocinaEntity (id, direccion) values (200, '8 Susan Terrace');
insert into CocinaEntity (id, direccion) values (300, '470 Texas Road');
insert into CocinaEntity (id, direccion) values (400, '168 Chinook Center');
insert into CocinaEntity (id, direccion) values (500, '847 Cardinal Road');

insert into HallOfFameEntity (id, mensaje) values (100, 'sollicitudin vitae');
insert into HallOfFameEntity (id, mensaje) values (200, 'Duis aliquam convallis nunc.');
insert into HallOfFameEntity (id, mensaje) values (300, 'sit amet lobortis sapien sapien non mi.');
insert into HallOfFameEntity (id, mensaje) values (400, 'Curabitur gravida nisi at nibh.');
insert into HallOfFameEntity (id, mensaje) values (50, 'Ffelis. Fusce posuere felis sed lacus.');

insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (100, '2018-12-24 06:58:48', 'Perritoa', 'Praesent lectus. Vestibulum quam sapien, varius uta',0, 1,14, 'Doctor', 100);
insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (200, '2018-11-24 06:58:48', 'Perritob', 'Praesent lectus. Vestibulum quam sapien, varius utb', 1,0,21, 'Doctor',200);
insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (300, '2018-10-24 06:58:48', 'Perritoc', 'Praesent lectus. Vestibulum quam sapien, varius utc', 0, 0,23, 'Cliente',300);
insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (400, '2018-09-24 06:58:48', 'Perritod', 'Praesent lectus. Vestibulum quam sapien, varius utd', 0, 1,6, 'Cliente',400);
insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (500, '2018-08-24 06:58:48', 'Perritoe', 'Praesent lectus. Vestibulum quam sapien, varius ute', 0, 0,7, 'Cliente',500);

insert into PagoEntity (id, modoPago,persona_id) values (1, 'Efectivo',100);
insert into PagoEntity (id, modoPago,persona_id) values (2, 'Electrónico',200);
insert into PagoEntity (id, modoPago,persona_id) values (3, 'Efectivo',300);
insert into PagoEntity (id, modoPago,persona_id) values (4, 'Electrónico',400);
insert into PagoEntity (id, modoPago,persona_id) values (5, 'Efectivo',5);

insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (100, 'Posuere cubilia Curae; Mauris viverra diam vitae quam.', 100);
insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (200, 'Laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', 200);
insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (300, 'Nullam sit amet turpis elementum ligula vehicula consequat.', 300);
insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (400, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 400);
insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (500, 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 500);

insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (100, 3, 'Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo', 100);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (200, 2, 'Praesent id massa id nisl venenatis laciniao.', 200);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (300, 1, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit', 300);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (400,5, 'Proin eu mi.', 400);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (500, 5, 'Donec quis orci eget orci vehicula condimentum.', 500);

insert into FotoEntity (id, nombre, url, persona_id) values (100, '645', 'http://dummyimage.com/165x240.jpg/ff4444/ffffff', 100);
insert into FotoEntity (id, nombre, url, persona_id) values (200, '80309', 'http://dummyimage.com/137x202.jpg/5fa2dd/ffffff', 200);
insert into FotoEntity (id, nombre, url, persona_id) values (300, '01609', 'http://dummyimage.com/166x198.jpg/dddddd/000000', 300);
insert into FotoEntity (id, nombre, url, persona_id) values (400, '140', 'http://dummyimage.com/226x131.jpg/ff4444/ffffff', 400);
insert into FotoEntity (id, nombre, url, persona_id) values (500, '4791', 'http://dummyimage.com/172x230.jpg/dddddd/000000', 500);

insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (100, 14, 'Dieta1', 'bajar','celiaca' , 100);
insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (200, 21, 'Dieta2', 'subir','celiaca' , 200);
insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (300, 32, 'Dieta3', 'comer','celiaca' , 300);
insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (400, 19, 'Dieta4', 'masa muscular', 'celiaca' , 400);
insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (500, 24, 'Dieta5', 'brazos','celiaca' , 500);

insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (100, 'In hac habitasse platea dictumstA', 'Food Chemist', 'In hac habitasse platea dictumst.');
insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (200, 'In hac habitasse platea dictumstB', 'Clinical Specialist', 'Nunc purus.');
insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (300,'In hac habitasse platea dictumstC', 'Nurse Practicioner', 'Aenean lectus.');
insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (400, 'In hac habitasse platea dictumstD', 'Cost Accountant', 'Morbi vestibulum, velito.');
insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (500, 'In hac habitasse platea dictumstE', 'Payment Adjustment Coordinator', 'Praesent id massa id nis');

insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (100,'Condimentum id, luctus nec, molestie sed, justo.',3,0,100 );
insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (200,'Condimentum id, luctus nec, molestie sed, justo.',6,1,200);
insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (300,'Condimentum id, luctus nec, molestie sed, justo.',25,1,300);
insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (400,'Condimentum id, luctus nec, molestie sed, justo.',78,0,400);
insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (500,'Condimentum id, luctus nec, molestie sed, justo.',14,1,500);

insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (100,14 ,'2018-12-24 06:58:48', '80329 Sutteridge Pass', 100);
insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (200,15 ,'2018-12-24 06:58:48', '6980 Northland Crossing', 200);
insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (300,16 ,'2018-12-24 06:58:48', '5 Lien Pass', 300);
insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (400,17 ,'2018-12-24 06:58:48', '613 Kim Point', 400);
insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (500, 18,'2018-12-24 06:58:48', '8742 Mallory Way',  500);

insert into DiaEntity (id, especial, semana_id) values (100, 0, 100);
insert into DiaEntity (id, especial, semana_id) values (200, 1, 200);
insert into DiaEntity (id, especial, semana_id) values (300, 1, 300);
insert into DiaEntity (id, especial, semana_id) values (400, 0, 400);
insert into DiaEntity (id, especial, semana_id) values (500, 1, 500);

insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (100, 'jcb', 'Elementum pellentesque. Quisque porta volutpat erat.', 100, 100);
insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (200, 'mastercard', 'Consectetuer adipiscing elit. Proin risus.', 200, 200);
insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (300, 'jcb', 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 300, 300);
insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (400, 'jcb', 'Donec posuere metus vitae ipsum.', 400, 400);
insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (500, 'switch', 'Donec vitae nisi.', 500, 500);

insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (100, 100);
insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (200, 200);
insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (300, 300);
insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (400, 400);
insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (500, 500);


