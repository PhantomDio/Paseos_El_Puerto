CREATE TABLE Propietarios (
id_propietario SERIAL PRIMARY KEY,
nombre VARCHAR(20) NOT NULL,
ap_pat VARCHAR(20) NOT NULL,
ap_mat VARCHAR(20) NOT NULL,
direccion VARCHAR(100) NOT NULL,
telefono VARCHAR(15) NOT NULL,
email VARCHAR(50) NOT NULL,
fecha_nac DATE NOT NULL
);

CREATE TABLE Embarcaciones (
id_embarcacion SERIAL PRIMARY KEY,
modelo VARCHAR(50) NOT NULL,
longitud FLOAT NOT NULL,
anio INT NOT NULL,
id_propietario INT NOT NULL,
CONSTRAINT FK_ID_PROPIETARIO FOREIGN KEY (id_propietario) REFERENCES Propietarios(id_propietario)
);

CREATE TABLE Clientes (
id_cliente SERIAL PRIMARY KEY,
nombre VARCHAR(20) NOT NULL,
ap_pat VARCHAR(20) NOT NULL,
ap_mat VARCHAR(20) NOT NULL,
direccion VARCHAR(100) NOT NULL,
telefono VARCHAR(15) NOT NULL,
email VARCHAR(50) NOT NULL,
fecha_nac DATE NOT NULL
);

CREATE TABLE Alquileres (
id_alquiler SERIAL PRIMARY KEY,
id_embarcacion INT NOT NULL,
id_cliente INT NOT NULL,
fecha_inicio DATE NOT NULL,
fecha_fin DATE NOT NULL,
monto_total FLOAT NOT NULL,
CONSTRAINT FK_ID_EMBARCACION FOREIGN KEY (id_embarcacion) REFERENCES Embarcaciones(id_embarcacion),
CONSTRAINT FK_ID_CLIENTE FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

CREATE TABLE Equipamiento (
id_equipamiento SERIAL PRIMARY KEY,
descripcion VARCHAR(100) NOT NULL,
costo FLOAT NOT NULL,
tipo VARCHAR(50) NOT NULL,
id_embarcacion INT NOT NULL,
CONSTRAINT FK_ID_EMBARCACION FOREIGN KEY (id_embarcacion) REFERENCES Embarcaciones(id_embarcacion)
);


CREATE TABLE Mantenimiento (
id_mantenimiento SERIAL PRIMARY KEY,
id_embarcacion INT NOT NULL,
id_proveedor INT NOT NULL,
fecha_inicio DATE NOT NULL,
fecha_fin DATE NOT NULL,
costo FLOAT NOT NULL,
CONSTRAINT FK_ID_EMBARCACION FOREIGN KEY (id_embarcacion) REFERENCES Embarcaciones(id_embarcacion)
);

CREATE TABLE Reparacion (
id_reparacion SERIAL PRIMARY KEY,
id_mantenimiento INT NOT NULL,
descripcion VARCHAR(100) NOT NULL,
costo FLOAT NOT NULL,
CONSTRAINT FK_ID_MANTENIMIENTO FOREIGN KEY (id_mantenimiento) REFERENCES Mantenimiento(id_mantenimiento)
);

CREATE TABLE Personal (
id_personal SERIAL PRIMARY KEY,
nombre VARCHAR(20) NOT NULL,
ap_pat VARCHAR(20) NOT NULL,
ap_mat VARCHAR(20) NOT NULL,
direccion VARCHAR(100) NOT NULL,
telefono VARCHAR(15) NOT NULL,
email VARCHAR(50) NOT NULL,
costo_hora FLOAT NOT NULL,
fecha_nac DATE NOT NULL
);