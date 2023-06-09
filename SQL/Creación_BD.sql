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
	nombre VARCHAR(50) NOT NULL,
	modelo VARCHAR(50) NOT NULL,
	longitud FLOAT NOT NULL,
	anio INT NOT NULL,
	id_propietario INT NOT NULL,
	CONSTRAINT FK_ID_PROPIETARIO FOREIGN KEY (id_propietario) 
	REFERENCES Propietarios(id_propietario) ON DELETE CASCADE
);

CREATE TABLE Contratos (
	id_contrato SERIAL PRIMARY KEY,
	id_embarcacion INT NOT NULL,
	fecha_inicio DATE NOT NULL,
	fecha_fin DATE NOT NULL,
	costo_hora FLOAT NOT NULL,
	CONSTRAINT FK_ID_EMBARCACION FOREIGN KEY (id_embarcacion)
	REFERENCES Embarcaciones(id_embarcacion) ON DELETE CASCADE
);

CREATE TABLE Aditamentos (
	id_aditamento SERIAL PRIMARY KEY,
	nombre VARCHAR(40) NOT NULL,
	costo FLOAT NOT NULL,
	tipo VARCHAR(50) NOT NULL,
	id_embarcacion INT NOT NULL,
	CONSTRAINT FK_ID_EMBARCACION FOREIGN KEY (id_embarcacion)
	REFERENCES Embarcaciones(id_embarcacion) ON DELETE CASCADE
);

CREATE TABLE Embarcaciones_Aditamentos (
	id_embarcacion INT NOT NULL,
	id_aditamento INT NOT NULL,
	PRIMARY KEY (id_embarcacion, id_aditamento),
	CONSTRAINT FK_ID_EMBARCACION FOREIGN KEY (id_embarcacion)
	REFERENCES Embarcaciones(id_embarcacion) ON DELETE CASCADE,
	CONSTRAINT FK_ID_ADITAMENTO FOREIGN KEY (id_aditamento)
	REFERENCES Aditamentos(id_aditamento) ON DELETE CASCADE
);

CREATE TABLE Paseos (
	id_paseo SERIAL PRIMARY KEY,
	id_embarcacion INT NOT NULL,
	id_cliente INT NOT NULL,
	fecha_inicio DATE NOT NULL,
	fecha_fin DATE NOT NULL,
	CONSTRAINT FK_ID_EMBARCACION FOREIGN KEY (id_embarcacion)
	REFERENCES Embarcaciones(id_embarcacion) ON DELETE CASCADE,
	CONSTRAINT FK_ID_CLIENTE FOREIGN KEY (id_cliente)
	REFERENCES Clientes(id_cliente) ON DELETE CASCADE
);

CREATE TABLE Personal (
	id_personal SERIAL PRIMARY KEY,
	nombre VARCHAR(20) NOT NULL,
	ap_pat VARCHAR(20) NOT NULL,
	ap_mat VARCHAR(20) NOT NULL,
	sexo VARCHAR(20) NOT NULL,
	direccion VARCHAR(100) NOT NULL,
	telefono VARCHAR(15) NOT NULL,
	email VARCHAR(50) NOT NULL,
	fecha_nac DATE NOT NULL,
	costo_hora FLOAT NOT NULL
);

CREATE TABLE Paseos_Personal (
	id_paseo INT NOT NULL,
	id_personal INT NOT NULL,
	CONSTRAINT FK_ID_PASEO FOREIGN KEY (id_paseo)
	REFERENCES Paseos(id_paseo) ON DELETE CASCADE,
	CONSTRAINT FK_ID_PERSONAL FOREIGN KEY (id_personal)
	REFERENCES Personal(id_personal) ON DELETE CASCADE
);

CREATE TABLE Mantenimiento (
	id_mantenimiento SERIAL PRIMARY KEY,
	id_embarcacion INT NOT NULL,
	descripcion VARCHAR(100) NOT NULL,
	costo FLOAT NOT NULL,
	fecha_mantenimiento DATE NOT NULL,
	CONSTRAINT FK_ID_EMBARCACION FOREIGN KEY (id_embarcacion)
	REFERENCES Embarcaciones(id_embarcacion) ON DELETE CASCADE
);

CREATE TABLE Reparacion (
	id_reparacion SERIAL PRIMARY KEY,
	id_embarcacion INT NOT NULL,
	id_paseo INT,
	descripcion VARCHAR(100) NOT NULL,
	costo FLOAT NOT NULL,
	fecha_reparacion DATE NOT NULL,
	CONSTRAINT FK_ID_EMBARCACION FOREIGN KEY (id_embarcacion)
	REFERENCES Embarcaciones(id_embarcacion) ON DELETE CASCADE,
	CONSTRAINT FK_ID_PASEO FOREIGN KEY (id_paseo)
	REFERENCES Paseos(id_paseo) ON DELETE CASCADE
);