delete from DietaEntity;
delete from PagoEntity;
delete from TipoDietaEntity;
delete from SuspensionEntity;
delete from SemanaEntity;
delete from DiaEntity;
delete from ComidaEntity;
delete from CocinaEntity;
delete from QuejaYReclamoEntity;
delete from HallOfFameEntity;
delete from PersonaEntity;
-- delete from HallOfFamePersonaEntity;
delete from CalificacionYComentarioEntity;
delete from FotoEntity;
-- delete from PersonaPagoEntity;

insert into DietaEntity (id, tipo, objetivo, diasSupendida, id_persona, id_tipodieta) values (1, 'Executive Secretary', 'Nulla ut erat id mauris vulputate elementum. Nullam varius.', '08', 1, 1);
insert into DietaEntity (id, tipo, objetivo, diasSupendida, id_persona, id_tipodieta) values (2, 'Structural Analysis Engineer', 'In blandit ultrices enim.', '55', 2, 2);
insert into DietaEntity (id, tipo, objetivo, diasSupendida, id_persona, id_tipodieta) values (3, 'Pharmacist', 'Nulla tellus. In sagittis dui vel nisl.', '435', 3, 3);
insert into DietaEntity (id, tipo, objetivo, diasSupendida, id_persona, id_tipodieta) values (4, 'VP Product Management', 'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia.', '611', 4, 4);
insert into DietaEntity (id, tipo, objetivo, diasSupendida, id_persona, id_tipodieta) values (5, 'Media Manager IV', 'Integer ac leo. Pellentesque ultrices mattis odio.', '452', 5, 5);

insert into PagoEntity (id, modoPago) values (1, 'Efectivo');
insert into PagoEntity (id, modoPago) values (2, 'Electrónico');


insert into TipoDietaEntity (id, nombre, tipo, descripcion) values (1, 'Arlana', 'Food Chemist', 'In hac habitasse platea dictumst.');
insert into TipoDietaEntity (id, nombre, tipo, descripcion) values (2, 'Ulrike', 'Clinical Specialist', 'Nunc purus.');
insert into TipoDietaEntity (id, nombre, tipo, descripcion) values (3, 'Kristine', 'Nurse Practicioner', 'Aenean lectus.');
insert into TipoDietaEntity (id, nombre, tipo, descripcion) values (4, 'Svend', 'Cost Accountant', 'Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.');
insert into TipoDietaEntity (id, nombre, tipo, descripcion) values (5, 'Ambrosi', 'Payment Adjustment Coordinator', 'Praesent id massa id nisl venenatis lacinia.');

insert into SuspensionEntity (id, vigente, comentarios, numDias, id_dieta) values (1, true, 'Nulla tellus. In sagittis dui vel nisl.', '10-487-8163', 1);
insert into SuspensionEntity (id, vigente, comentarios, numDias, id_dieta) values (2, true, 'Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.', '91-043-6224', 2);
insert into SuspensionEntity (id, vigente, comentarios, numDias, id_dieta) values (3, true, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', '85-580-3132', 3);
insert into SuspensionEntity (id, vigente, comentarios, numDias, id_dieta) values (4, false, 'Nulla mollis molestie lorem.', '17-407-3399', 4);
insert into SuspensionEntity (id, vigente, comentarios, numDias, id_dieta) values (5, true, 'Aliquam sit amet diam in magna bibendum imperdiet.', '69-190-7125', 5);

insert into SemanaEntity (id, horaEntrega, lugarEntrega, costo, id_dieta) values (1, '2:58 AM', '80329 Sutteridge Pass', '$7.60', 1);
insert into SemanaEntity (id, horaEntrega, lugarEntrega, costo, id_dieta) values (2, '5:02 PM', '6980 Northland Crossing', '$7.35', 2);
insert into SemanaEntity (id, horaEntrega, lugarEntrega, costo, id_dieta) values (3, '9:17 AM', '5 Lien Pass', '$6.15', 3);
insert into SemanaEntity (id, horaEntrega, lugarEntrega, costo, id_dieta) values (4, '6:52 AM', '613 Kim Point', '$7.03', 4);
insert into SemanaEntity (id, horaEntrega, lugarEntrega, costo, id_dieta) values (5, '9:13 PM', '8742 Mallory Way', '$1.95', 5);

insert into DiaEntity (id, especial, id_semana) values (1, true, 1);
insert into DiaEntity (id, especial, id_semana) values (2, true, 2);
insert into DiaEntity (id, especial, id_semana) values (3, false, 3);
insert into DiaEntity (id, especial, id_semana) values (4, false, 4);
insert into DiaEntity (id, especial, id_semana) values (5, true, 5);

insert into ComidaEntity (id, tipo, alimentosYCantidad, id_dia, id_cocina) values (1, 'jcb', 'Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat.', 1, 1);
insert into ComidaEntity (id, tipo, alimentosYCantidad, id_dia, id_cocina) values (2, 'mastercard', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus.', 2, 2);
insert into ComidaEntity (id, tipo, alimentosYCantidad, id_dia, id_cocina) values (3, 'jcb', 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 3, 3);
insert into ComidaEntity (id, tipo, alimentosYCantidad, id_dia, id_cocina) values (4, 'jcb', 'Donec posuere metus vitae ipsum.', 4, 4);
insert into ComidaEntity (id, tipo, alimentosYCantidad, id_dia, id_cocina) values (5, 'switch', 'Donec vitae nisi.', 5, 5);

insert into CocinaEntity (id, direccion) values (1, '021 Magdeline Way');
insert into CocinaEntity (id, direccion) values (2, '8 Susan Terrace');
insert into CocinaEntity (id, direccion) values (3, '470 Texas Road');
insert into CocinaEntity (id, direccion) values (4, '168 Chinook Center');
insert into CocinaEntity (id, direccion) values (5, '847 Cardinal Road');

insert into QuejaYReclamoEntity (id, especificacion, id_persona) values (1, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.', 1);
insert into QuejaYReclamoEntity (id, especificacion, id_persona) values (2, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', 2);
insert into QuejaYReclamoEntity (id, especificacion, id_persona) values (3, 'Nullam sit amet turpis elementum ligula vehicula consequat.', 3);
insert into QuejaYReclamoEntity (id, especificacion, id_persona) values (4, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 4);
insert into QuejaYReclamoEntity (id, especificacion, id_persona) values (5, 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 5);

insert into HallOfFameEntity (id, mensaje) values (1, 'In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.');
insert into HallOfFameEntity (id, mensaje) values (2, 'Duis aliquam convallis nunc.');
insert into HallOfFameEntity (id, mensaje) values (3, 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.');
insert into HallOfFameEntity (id, mensaje) values (4, 'Curabitur gravida nisi at nibh.');
insert into HallOfFameEntity (id, mensaje) values (5, 'Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus.');

insert into PersonaEntity (id, nombre, tipo, fechaIngreso, objetivos, tiempoEsperadoMejora, solicitudEspecial, TarjetaFidelidad) values (1, 'Selestina', 'Food Chemist', '11/12/2018', 'Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.', '836', false, false);
insert into PersonaEntity (id, nombre, tipo, fechaIngreso, objetivos, tiempoEsperadoMejora, solicitudEspecial, TarjetaFidelidad) values (2, 'Maurits', 'Recruiting Manager', '11/23/2018', 'Donec semper sapien a libero. Nam dui.', '54', true, false);
insert into PersonaEntity (id, nombre, tipo, fechaIngreso, objetivos, tiempoEsperadoMejora, solicitudEspecial, TarjetaFidelidad) values (3, 'Gustave', 'VP Product Management', '10/5/2018', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', '095', false, true);
insert into PersonaEntity (id, nombre, tipo, fechaIngreso, objetivos, tiempoEsperadoMejora, solicitudEspecial, TarjetaFidelidad) values (4, 'Xenia', 'Technical Writer', '10/31/2018', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus.', '49593', false, false);
insert into PersonaEntity (id, nombre, tipo, fechaIngreso, objetivos, tiempoEsperadoMejora, solicitudEspecial, TarjetaFidelidad) values (5, 'Trisha', 'Physical Therapy Assistant', '8/14/2018', 'Nulla mollis molestie lorem.', '5010', false, true);

-- insert into HallOfFamePersonaEntity (id_halloffame, id_persona) values (1, 1);
-- insert into HallOfFamePersonaEntity (id_halloffame, id_persona) values (2, 2);
-- insert into HallOfFamePersonaEntity (id_halloffame, id_persona) values (3, 3);
-- insert into HallOfFamePersonaEntity (id_halloffame, id_persona) values (4, 4);
-- insert into HallOfFamePersonaEntity (id_halloffame, id_persona) values (5, 5);

insert into CalificacionYComentarioEntity (id, calificacion, comentario, id_persona) values (1, '63040', 'Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.', 1);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, id_persona) values (2, '9639', 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo.', 2);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, id_persona) values (3, '2804', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.', 3);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, id_persona) values (4, '4', 'Proin eu mi.', 4);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, id_persona) values (5, '402', 'Donec quis orci eget orci vehicula condimentum.', 5);

insert into FotoEntity (id, nombre, url, id_persona) values (1, '645', 'http://dummyimage.com/165x240.jpg/ff4444/ffffff', 1);
insert into FotoEntity (id, nombre, url, id_persona) values (2, '80309', 'http://dummyimage.com/137x202.jpg/5fa2dd/ffffff', 2);
insert into FotoEntity (id, nombre, url, id_persona) values (3, '01609', 'http://dummyimage.com/166x198.jpg/dddddd/000000', 3);
insert into FotoEntity (id, nombre, url, id_persona) values (4, '140', 'http://dummyimage.com/226x131.jpg/ff4444/ffffff', 4);
insert into FotoEntity (id, nombre, url, id_persona) values (5, '4791', 'http://dummyimage.com/172x230.jpg/dddddd/000000', 5);

-- insert into PersonaPagoEntity (id_persona, id_pago) values (1, 1);
-- insert into PersonaPagoEntity (id_persona, id_pago) values (2, 2);
-- insert into PersonaPagoEntity (id_persona, id_pago) values (3, 1);
-- insert into PersonaPagoEntity (id_persona, id_pago) values (4, 2);
-- insert into PersonaPagoEntity (id_persona, id_pago) values (5, 2);