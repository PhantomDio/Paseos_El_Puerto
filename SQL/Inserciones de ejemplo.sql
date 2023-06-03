INSERT INTO Clientes (nombre, ap_pat, ap_mat, direccion, telefono, email, fecha_nac)
VALUES ('Juan', 'Gómez', 'López', 'Calle 123', '555-1234', 'juan@example.com', '1990-05-15'),
       ('María', 'Rodríguez', 'Sánchez', 'Avenida 456', '555-5678', 'maria@example.com', '1988-09-21'),
       ('Pedro', 'Martínez', 'García', 'Boulevard 789', '555-9012', 'pedro@example.com', '1995-12-02'),
       ('Laura', 'Hernández', 'López', 'Calle Principal 10', '555-3456', 'laura@example.com', '1992-07-11'),
       ('Carlos', 'González', 'Ruiz', 'Avenida Central 20', '555-7890', 'carlos@example.com', '1987-03-28');

INSERT INTO Propietarios (nombre, ap_pat, ap_mat, direccion, telefono, email, fecha_nac)
VALUES ('José', 'López', 'García', 'Calle 123', '555-1234', 'jose@example.com', '1975-08-18'),
       ('Ana', 'Martínez', 'Sánchez', 'Avenida 456', '555-5678', 'ana@example.com', '1982-04-29'),
       ('Luis', 'Hernández', 'Gómez', 'Boulevard 789', '555-9012', 'luis@example.com', '1969-11-05'),
       ('Elena', 'González', 'Ruiz', 'Calle Principal 10', '555-3456', 'elena@example.com', '1978-01-22'),
       ('Sofía', 'Rodríguez', 'López', 'Avenida Central 20', '555-7890', 'sofia@example.com', '1985-06-14');

INSERT INTO Embarcaciones (nombre, modelo, longitud, anio, id_propietario)
VALUES ('Yate de lujo', 'ABC123', 25.5, 2022, 1),
       ('Lancha rápida', 'DEF456', 15.8, 2019, 2),
       ('Velero clásico', 'GHI789', 30.2, 1998, 3),
       ('Catamarán familiar', 'JKL012', 18.6, 2015, 4),
       ('Bote de pesca', 'MNO345', 12.4, 2010, 5);

INSERT INTO Contratos (id_embarcacion, fecha_inicio, fecha_fin, costo_hora)
VALUES (1, '2023-05-01', '2023-05-10', 150.00),
       (2, '2023-05-03', '2023-05-08', 120.00),
       (3, '2023-05-05', '2023-05-12', 200.00),
       (4, '2023-05-08', '2023-05-15', 180.00),
       (5, '2023-05-10', '2023-05-18', 100.00);

INSERT INTO Aditamentos (nombre, costo, tipo, id_embarcacion)
VALUES ('Equipo de buceo', 50.00, 'Deportivo', 1),
       ('Chalecos salvavidas', 20.00, 'Seguridad', 2),
       ('Equipo de pesca', 30.00, 'Recreativo', 3),
       ('Parasol', 10.00, 'Accesorio', 4),
       ('Altavoces marinos', 40.00, 'Entretenimiento', 5);

INSERT INTO Embarcaciones_Aditamentos (id_embarcacion, id_aditamento)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5);

INSERT INTO Paseos (id_embarcacion, id_cliente, fecha_inicio, fecha_fin, monto_total)
VALUES (1, 1, '2023-05-01', '2023-05-02', 500.00),
       (2, 2, '2023-05-03', '2023-05-04', 400.00),
       (3, 3, '2023-05-05', '2023-05-06', 600.00),
       (4, 4, '2023-05-07', '2023-05-08', 550.00),
       (5, 5, '2023-05-09', '2023-05-10', 300.00);

INSERT INTO Empleados (nombre, ap_pat, ap_mat, direccion, telefono, email, costo_hora, fecha_nac)
VALUES ('Javier', 'Ramírez', 'González', 'Calle 123', '555-1234', 'javier@example.com', 50.00, '1990-05-15'),
       ('Ana', 'López', 'Martínez', 'Avenida 456', '555-5678', 'ana@example.com', 45.00, '1988-09-21'),
       ('Mario', 'Hernández', 'Sánchez', 'Boulevard 789', '555-9012', 'mario@example.com', 55.00, '1995-12-02'),
       ('Sara', 'Gómez', 'Rodríguez', 'Calle Principal 10', '555-3456', 'sara@example.com', 60.00, '1992-07-11'),
       ('Luis', 'García', 'Pérez', 'Avenida Central 20', '555-7890', 'luis@example.com', 40.00, '1987-03-28');

INSERT INTO Paseos_Empleados (id_paseo, id_empleado)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5);

INSERT INTO Mantenimiento (id_embarcacion, descripcion, costo, fecha_mantenimiento)
VALUES (1, 'Mantenimiento rutinario', 200.00, '2023-05-05'),
       (2, 'Revisión del motor', 150.00, '2023-05-08'),
       (3, 'Pintura y barnizado', 300.00, '2023-05-12'),
       (4, 'Reemplazo de velas', 250.00, '2023-05-15'),
       (5, 'Limpieza y pulido', 100.00, '2023-05-18');

INSERT INTO Reparacion (id_embarcacion, id_paseo, descripcion, costo, fecha_reparacion)
VALUES (1, NULL, 'Reparación de timón', 120.00, '2023-05-03'),
       (2, NULL, 'Reemplazo de batería', 80.00, '2023-05-07'),
       (3, NULL, 'Arreglo de cabina', 200.00, '2023-05-10'),
       (4, NULL, 'Reparación de motor', 300.00, '2023-05-13'),
       (5, NULL, 'Cambio de luces', 50.00, '2023-05-16');