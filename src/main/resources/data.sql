	INSERT INTO cliente (id, nombre) VALUES
	(1, 'Bar Pepe');

	INSERT INTO maquina (id, nombre, cliente_id) VALUES
	(1, 'Supermáquina', 1);

	INSERT INTO contador_manuales (id, maquina_id, entradas, salidas, fecha) VALUES
	(1, 1, 100, 99, '2023-01-21 10:00:00');

	INSERT INTO historico_recaudaciones (id, maquina_id, fecha, importe, contador_manuales_id, cliente_id) VALUES
	(1, 1, '2023-01-21', 5, 1, 1);

	INSERT INTO historico_contadores_automaticos (id, maquina_id, entradas, salidas, fecha) VALUES
	(1, 1, 80, 90, '2023-01-21 09:46:00'),
	(2, 1, 85, 91, '2023-01-21 09:51:00'),
	(3, 1, 100, 98, '2023-01-21 09:56:00'),
	(4, 1, 100, 99, '2023-01-21 10:01:00'),
	(5, 1, 101, 100, '2023-01-21 10:06:00'),
	(6, 1, 102, 101, '2023-01-21 10:11:00'),
	(7, 1, 103, 102, '2023-01-21 10:16:00'),
	(8, 1, 104, 103, '2023-01-21 10:21:00');
