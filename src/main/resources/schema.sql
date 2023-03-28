CREATE TABLE cliente (
    id INT NOT NULL,
    nombre VARCHAR(100)  NULL,
    PRIMARY KEY (id)
);

CREATE TABLE maquina (
    id INT NOT NULL,
    nombre VARCHAR(100)  NULL,
    cliente_id INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE contador_manuales (
    id INT NOT NULL,
    maquina_id INT NOT NULL,
    entradas INT NOT NULL,
    salidas INT NOT NULL,
    fecha DATETIME NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE historico_recaudaciones (
    id INT NOT NULL,
    maquina_id INT NOT NULL,
    fecha DATETIME NOT NULL,
    importe INT NOT NULL,
    contador_manuales_id INT NOT NULL,
    cliente_id INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE historico_contadores_automaticos (
    id INT NOT NULL,
    maquina_id INT NOT NULL,
    entradas INT NOT NULL,
    salidas INT NOT NULL,
    fecha DATETIME NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE maquina ADD CONSTRAINT fk_maquina_cliente_id FOREIGN KEY (cliente_id) REFERENCES cliente (id);
ALTER TABLE contador_manuales ADD CONSTRAINT fk_contador_manuales_maquina_id FOREIGN KEY (maquina_id) REFERENCES maquina (id);
ALTER TABLE historico_recaudaciones ADD CONSTRAINT fk_historico_recaudaciones_maquina_id FOREIGN KEY (maquina_id) REFERENCES maquina (id);
ALTER TABLE historico_recaudaciones ADD CONSTRAINT fk_historico_recaudaciones_contador_manuales_id FOREIGN KEY (contador_manuales_id) REFERENCES contador_manuales (id);
ALTER TABLE historico_recaudaciones ADD CONSTRAINT fk_historico_recaudaciones_cliente_id FOREIGN KEY (cliente_id) REFERENCES cliente (id);
ALTER TABLE historico_contadores_automaticos ADD CONSTRAINT fk_historico_contadores_automaticos_maquina_id FOREIGN KEY (maquina_id) REFERENCES maquina (id);

