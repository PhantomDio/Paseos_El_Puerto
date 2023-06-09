INSERT INTO Clientes (nombre, ap_pat, ap_mat, direccion, telefono, email, fecha_nac)
VALUES ('Juan', 'González', 'Pérez', 'Calle 123', '1234567890', 'juan@example.com', '1990-05-10'),
       ('María', 'López', 'García', 'Avenida XYZ', '9876543210', 'maria@example.com', '1988-11-25'),
       ('Pedro', 'Ramírez', 'Martínez', 'Calle ABC', '5555555555', 'pedro@example.com', '1995-02-15');

INSERT INTO Propietarios (nombre, ap_pat, ap_mat, direccion, telefono, email, fecha_nac)
VALUES ('Carlos', 'Martínez', 'Gómez', 'Colonia 456', '1111111111', 'carlos@example.com', '1975-09-12'),
       ('Laura', 'Hernández', 'Gutiérrez', 'Paseo 789', '2222222222', 'laura@example.com', '1982-07-21'),
       ('Roberto', 'Sánchez', 'Rodríguez', 'Avenida MNO', '3333333333', 'roberto@example.com', '1992-04-08');

INSERT INTO Embarcaciones (nombre, modelo, longitud, anio, id_propietario)
VALUES ('Yate A', 'Modelo 1', 10.5, 2020, 1),
       ('Lancha B', 'Modelo 2', 8.2, 2018, 2),
       ('Velero C', 'Modelo 3', 12.0, 2019, 3);

INSERT INTO Contratos (id_embarcacion, fecha_inicio, fecha_fin, costo_hora)
VALUES (1, '2023-01-01', '2023-02-28', 50.0),
       (2, '2023-03-15', '2023-04-30', 40.0),
       (3, '2023-02-01', '2023-03-31', 60.0);

INSERT INTO Aditamentos (nombre, costo, tipo, id_embarcacion)
VALUES ('Equipo de pesca', 100.0, 'Deportivo', 1),
       ('Equipo de buceo', 150.0, 'Recreativo', 2),
       ('Equipo de snorkel', 50.0, 'Recreativo', 3);

INSERT INTO Embarcaciones_Aditamentos (id_embarcacion, id_aditamento)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 1),
       (3, 3);

INSERT INTO Paseos (id_embarcacion, id_cliente, fecha_inicio, fecha_fin)
VALUES (1, 1, '2023-05-01', '2023-05-03'),
       (2, 2, '2023-05-02', '2023-05-04'),
       (3, 3, '2023-05-03', '2023-05-05');

INSERT INTO Personal (nombre, ap_pat, ap_mat, sexo, direccion, telefono, email, fecha_nac, costo_hora)
VALUES ('Juan', 'Pérez', 'Mendez', 'Masculino', 'Calle 123', '123456789', 'juan@example.com', '1990-01-15', 15.50),
       ('María', 'González', 'Pagueros', 'Femenino', 'Avenida 456', '987654321', 'maria@example.com', '1992-03-10', 18.75),
       ('Pedro', 'López', 'Gómez', 'Masculino', 'Plaza Principal', '55555555', 'pedro@example.com', '1985-07-22', 12.35),
       ('Ana', 'Martínez', 'García', 'Femenino', 'Calle Central', '987654321', 'ana@example.com', '1995-12-05', 20.00),
       ('Luis', 'Ramírez', 'Hernández', 'Masculino', 'Avenida 789', '123456789', 'luis@example.com', '1988-09-18', 16.80);


INSERT INTO Paseos_Personal (id_paseo, id_personal)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (3, 1),
       (3, 3);

INSERT INTO Mantenimiento (id_embarcacion, descripcion, costo, fecha_mantenimiento)
VALUES (1, 'Mantenimiento de motor', 200.0, '2023-05-06'),
       (2, 'Revisión general', 150.0, '2023-05-07'),
       (3, 'Limpieza y pulido', 100.0, '2023-05-08');

INSERT INTO Reparacion (id_embarcacion, id_paseo, descripcion, costo, fecha_reparacion)
VALUES (1, NULL, 'Reparación de timón', 300.0, '2023-05-09'),
       (2, 1, 'Reparación de motor', 250.0, '2023-05-10'),
       (3, 3, 'Reemplazo de velas', 180.0, '2023-05-11');
