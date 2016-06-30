create DATABASE facturacion;
create table producto (id_producto int(10) PRIMARY KEY not null AUTO_INCREMENT , nombre varchar(100), descripcion varchar(300), precio double,stock int(10));

create table factura (id_factura int(10) PRIMARY KEY not null AUTO_INCREMENT, fecha date ,monto double, tipo_pago varchar(20), estado varchar(10) ) ;
alter table producto modify column id_producto int(11) AUTO_INCREMENT ;

create table usuario(id_usuario int(10) primary KEY NOT NULL AUTO_INCREMENT,nombre varchar(100), password blob );

alter table usuario modify column nombre varchar(99) unique ;


create table detalle_prodxfac(
id_detalle int(10) not null AUTO_INCREMENT,
id_factura int(10) not null ,
id_producto int(10) ,
cantidad int(40),
precio double,
PRIMARY KEY(id_detalle,id_factura),
FOREIGN KEY(id_factura) REFERENCES  factura(id_factura),
FOREIGN KEY(id_producto) REFERENCES producto(id_producto)
);

insert into producto (nombre,descripcion,precio,stock) values("laptop","marca hp , color gris",3000,50);
insert into producto (nombre,descripcion,precio,stock) values("TV","tv smart, con camara",5000,50);
insert into producto (nombre,descripcion,precio,stock)values("radio","ultima generación 2000 watts  stereo control,, color gris",1000,50);
insert into producto (nombre,descripcion,precio,stock)values("Smarthpone","Iphone , color gris",2000,50);

insert into factura (fecha,tipo_pago,estado) values (current_date, "efectivo","cancelada");
insert into factura (fecha,tipo_pago,estado) values (current_date+1, "deposito","pendiente");
insert into factura (fecha,tipo_pago,estado) values (current_date-5, "tarjeta de credito","cancelada");
insert into factura (fecha,tipo_pago,estado) values (current_date-23, "efectivo","pendiente");

insert into detalle_prodxfac (id_factura,id_producto,cantidad,precio) values (1,2,10,5000);
insert into detalle_prodxfac (id_factura,id_producto,cantidad,precio) values (1,3,8,1000);
insert into detalle_prodxfac (id_factura,id_producto,cantidad,precio) values (1,4,6,2000);
insert into detalle_prodxfac (id_factura,id_producto,cantidad,precio) values (2,1,12,3000);
insert into detalle_prodxfac (id_factura,id_producto,cantidad,precio) values (3,4,9,2000);
insert into detalle_prodxfac (id_factura,id_producto,cantidad,precio) values (1,2,10,5000);



insert into usuario (nombre,password) values ("usuario",md5(1234));


