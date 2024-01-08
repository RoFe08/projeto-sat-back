CREATE TABLE tasks (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    category VARCHAR(255)
);

INSERT INTO tasks (id, name, description, category)
VALUES ('8ca6024e-6a92-46f5-a81f-7583055a6e0f', 'Tomar banho', 'Banho as 06', 'Limpeza');

INSERT INTO tasks (id, name, description, category)
VALUES ('8ca6024e-6a92-46f5-a82f-7583055a6e0f', 'Daily', 'Daily as 08', 'Trabalho');

INSERT INTO tasks (id, name, description, category)
VALUES ('8ca6024e-6a92-46f5-a83f-7583055a6e0f', 'Almoçar', 'Almoçar as 12', 'Lazer');

INSERT INTO tasks (id, name, description, category)
VALUES ('8ca6024e-6a92-46f5-a84f-7583055a6e0f', 'Academia', 'Academia as 18', 'Esportes');