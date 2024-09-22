CREATE DATABASE POOdesafio

USE POOdesafio
go

CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY IDENTITY(1,1),
    nombre_completo VARCHAR(100),
    documento_identidad VARCHAR(20) UNIQUE,
    fecha_nacimiento DATE,
    edad INT,
    direccion_completa VARCHAR(255),
    telefono VARCHAR(15),
    email VARCHAR(100)
);

CREATE TABLE Empleado (
    id_empleado INT PRIMARY KEY IDENTITY(1,1),
    nombre_completo VARCHAR(100),
    documento_identidad VARCHAR(20) UNIQUE,
    fecha_nacimiento DATE,
    edad INT,
    direccion_completa VARCHAR(255),
    puesto VARCHAR(50),
    sueldo DECIMAL(10, 2),
    id_jefe_inmediato INT FOREIGN KEY
    (id_jefe_inmediato) REFERENCES Empleado(id_empleado)
);

CREATE TABLE Menu (
    id_plato INT PRIMARY KEY IDENTITY(1,1),
    nombre_plato VARCHAR(100),
    descripcion TEXT,
    precio DECIMAL(10, 2)
);

CREATE TABLE Pedido (
    id_pedido INT PRIMARY KEY IDENTITY(1,1),
    id_cliente INT FOREIGN KEY 
	(id_cliente) REFERENCES Cliente(id_cliente),
    id_empleado INT FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado),
    fecha_pedido DATE,
    total DECIMAL(10, 2),
    forma_pago VARCHAR(50) CHECK (forma_pago IN ('Tarjeta de crédito', 'Efectivo', 'Transferencia')),
);

CREATE TABLE Detalle_Pedido (
    id_detalle_pedido INT PRIMARY KEY IDENTITY(1,1),
    id_pedido INT FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido),
    id_plato INT  FOREIGN KEY (id_plato) REFERENCES Menu(id_plato),
    cantidad INT,
    precio_unitario DECIMAL(10, 2),
    subtotal DECIMAL(10, 2)
);

INSERT INTO Menu (nombre_plato, descripcion, precio)
VALUES ('Pizza Margherita', 'Pizza clásica con tomate, mozzarella y albahaca fresca', 8.99)

INSERT INTO Menu (nombre_plato, descripcion, precio)
VALUES ('Hamburguesa Clásica', 'Hamburguesa de res con lechuga, tomate y queso cheddar', 6.50);

INSERT INTO Menu (nombre_plato, descripcion, precio)
VALUES ('Ensalada César', 'Ensalada con lechuga romana, aderezo César, crutones y parmesano', 5.00);

INSERT INTO Menu (nombre_plato, descripcion, precio)
VALUES ('Sándwich de Pollo', 'Sándwich de pollo a la parrilla con mayonesa y lechuga', 7.20);

INSERT INTO Menu (nombre_plato, descripcion, precio)
VALUES ('Tacos de Carne', 'Tacos con carne asada, cebolla, cilantro y salsa', 4.75);

INSERT INTO Cliente (nombre_completo, documento_identidad, fecha_nacimiento, edad, direccion_completa, telefono, email, Usuario, Contraseña)
VALUES ('Alfredo Steven Aguilera', '07269921-5', '2006-02-10', 18, '....', '7035-5431', 'alfredo100206@gmail.com', 'Usuario1', 123456)

ALTER TABLE Cliente
ADD Usuario VARCHAR(10)

ALTER TABLE Cliente
ADD Contraseña INT

DELETE Cliente

SELECT * FROM Cliente