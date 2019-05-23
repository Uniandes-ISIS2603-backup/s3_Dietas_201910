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




insert into CocinaEntity (id, direccion) values (100, '5912 Thackeray Court');
insert into CocinaEntity (id, direccion) values (200, '078 Sutteridge Crossing');
insert into CocinaEntity (id, direccion) values (300, '470 Texas Road');
insert into CocinaEntity (id, direccion) values (400, '168 Chinook Center');
insert into CocinaEntity (id, direccion) values (500, '847 Cardinal Road');

insert into HallOfFameEntity (id, mensaje) values (100, 'Los piernas locas');
insert into HallOfFameEntity (id, mensaje) values (200, 'Los grandes perdedores');
insert into HallOfFameEntity (id, mensaje) values (300, 'Los voladores del congreso');
insert into HallOfFameEntity (id, mensaje) values (400, 'Los dioses griegos');
insert into HallOfFameEntity (id, mensaje) values (500, 'No pain no gain');

insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (100, '2018-12-24 06:58:48', 'Oscar Cardenas', 'Reducción de grasaa',0, 1,14, 'Doctor', 100);
insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (200, '2018-11-24 06:58:48', 'Fernando Romero', 'Aumentar Masa Muscular', 1,0,21, 'Doctor',200);
insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (300, '2018-10-24 06:58:48', 'Luisa Velandia', 'Mejorar Diabetes', 0, 0,23, 'Cliente',300);
insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (400, '2018-09-24 06:58:48', 'Camila Florez', 'Controlar niveles de úrea en la sangre', 0, 1,6, 'Cliente',400);
insert into PersonaEntity (id, fechaIngreso, nombre, objetivos, solicitudEspecial, TarjetaFidelidad, tiempoEsperadoMejora,tipo,hall_id) values (500, '2018-08-24 06:58:48', 'Sebastian Britto', 'Controlar la tensión', 0, 0,7, 'Cliente',500);

insert into PagoEntity (id, modoPago,persona_id) values (1, 'Efectivo',100);
insert into PagoEntity (id, modoPago,persona_id) values (2, 'Electrónico',200);
insert into PagoEntity (id, modoPago,persona_id) values (3, 'Efectivo',300);
insert into PagoEntity (id, modoPago,persona_id) values (4, 'Electrónico',400);
insert into PagoEntity (id, modoPago,persona_id) values (5, 'Efectivo',5);

insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (100, 'La comida llegó fría.', 100);
insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (200, 'La comida sabe feo.', 200);
insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (300, 'Nunca llegaron mis comidas del día.', 300);
insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (400, 'El pedido tardó mucho.', 400);
insert into QuejaYReclamoEntity (id, especificacion, persona_id) values (500, 'Un pelo en la papa y una uña en el jugo de guayaba.', 500);

insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (100, 5, 'Excelente Servicio.', 100);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (200, 4, 'Muy buena la atención al cliente.', 200);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (300, 4, 'La comida está deliciosa.', 300);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (400,5, 'Me ha ayudado mucho a bajar de paso.', 400);
insert into CalificacionYComentarioEntity (id, calificacion, comentario, persona_id) values (500, 5, 'He sido más feliz y productivo gracias a uds. ', 500);

insert into FotoEntity (id, nombre, url, persona_id) values (100, '645', 'https://i.ibb.co/zHcQpBr/DEFPROB2.png', 100);
insert into FotoEntity (id, nombre, url, persona_id) values (200, '80309', 'https://i.ibb.co/6D6b6wW/DEFPROB.png', 200);
insert into FotoEntity (id, nombre, url, persona_id) values (300, '01609', 'http://dummyimage.com/166x198.jpg/dddddd/000000', 300);
insert into FotoEntity (id, nombre, url, persona_id) values (400, '140', 'http://dummyimage.com/226x131.jpg/ff4444/ffffff', 400);
insert into FotoEntity (id, nombre, url, persona_id) values (500, '4791', 'http://dummyimage.com/172x230.jpg/dddddd/000000', 500);

insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (100, 0, 'Abajo Diabetes', 'Controlar los cambios de insulina','Diabetes' , 100);
insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (200, 21, 'Control de úrea', 'Controlar el ácido úrico en la sangre','celiaca' , 200);
insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (300, 32, 'Vegetariana', 'Omitir carne','Esteñimiento' , 300);
insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (400, 2, 'Deficit Calórico', 'masa muscular', 'Rendimiento deportivo' , 400);
insert into DietaEntity (id, diasSuspendida, nombre, objetivo,tipo, personaDieta_id) values (500, 24, 'Baja grasa', 'Bajar colesterol','Colesterol' , 500);

insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (100, 'Controlar los cambios de insulina', 'Diabetes', 'In hac habitasse platea dictumst.');
insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (200, 'Controlar el ácido úrico en la sangre', 'Celiaquía', 'Nunc purus.');
insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (300,'Omitir carne', 'Estreñimiento', 'Aenean lectus.');
insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (400, 'Deficit Calórico', 'masa muscular', 'Rendimiento deportivo');
insert into TipoDietaEntity (id, descripcion, nombre, tipo) values (500, 'Disminución de dolor', 'Bajar colesterol', 'Colesterol');

insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (100,'Viaje a las Bahamas.',3,0,100 );
insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (200,'Ruptura Emocional',6,1,200);
insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (300,'Cena de Negocios',25,1,300);
insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (400,'Embarazo Repentino',78,0,400);
insert into SuspensionEntity (id, comentarios, numDias, vigente, dieta_id) values (500,'Deficit Económico',14,1,500);

insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (100,14 ,'2018-12-07 07:58:48', '80329 Sutteridge Pass', 100);
insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (200,15 ,'2018-11-16 06:58:48', '6980 Northland Crossing', 200);
insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (300,16 ,'2018-06-24 06:58:48', '5 Lien Pass', 300);
insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (400,17 ,'2018-12-15 06:58:48', '613 Kim Point', 400);
insert into SemanaEntity (id, costo, horaEntrega, lugarEntrega, dieta_id) values (500, 18,'2018-04-24 06:58:48', '8742 Mallory Way',  500);

insert into DiaEntity (id, especial, semana_id) values (100, 0, 100);
insert into DiaEntity (id, especial, semana_id) values (200, 1, 200);
insert into DiaEntity (id, especial, semana_id) values (300, 1, 300);
insert into DiaEntity (id, especial, semana_id) values (400, 0, 400);
insert into DiaEntity (id, especial, semana_id) values (500, 1, 500);

insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (100, 'Queso: 150g; Pollo: 350g; Arroz: 200g; Vegetales: 170g', 'Elementum pellentesque. Quisque porta volutpat erat.', 100, 100);
insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (200, 'Arroz: 200g; Res: 500g; Piña: 250g; Vegetales: 270g', 'Consectetuer adipiscing elit. Proin risus.', 200, 200);
insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (300, 'Tofu: 350g; Arroz: 200g; Vegetales: 170g; Lentejas: 200g', 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 300, 300);
insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (400, 'Arroz: 200g; Vegetales: 170g; Salmón: 270g; Papa: 150g', 'Donec posuere metus vitae ipsum.', 400, 400);
insert into ComidaEntity (id, alimentosYCantidad, tipo, cocina_id, dia_id) values (500, 'Arroz: 200g; Vegetales: 170g; Platano: 50g; Cerdo: 320g', 'Donec vitae nisi.', 500, 500);

insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (100, 100);
insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (200, 200);
insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (300, 300);
insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (400, 400);
insert into TipoDietaEntity_DietaEntity (tDietas_id, dietas_id) values (500, 500);

