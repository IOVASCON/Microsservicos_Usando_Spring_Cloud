-- Criação da tabela de Categorias de Ferramentas
CREATE TABLE CATEGORIA_FERRAMENTA (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT
);

-- Criação da tabela de Ferramentas
CREATE TABLE FERRAMENTA (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    estado VARCHAR(20) DEFAULT 'DISPONIVEL',
    categoria_id BIGINT,
    FOREIGN KEY (categoria_id) REFERENCES CATEGORIA_FERRAMENTA(id)
);

-- Criação da tabela de Usuários (se aplicável)
CREATE TABLE USUARIO (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

-- Criação da tabela de Movimentações de Ferramentas (se aplicável)
CREATE TABLE MOVIMENTACAO (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    ferramenta_id BIGINT,
    usuario_id BIGINT,
    data_retirada TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_devolucao TIMESTAMP,
    FOREIGN KEY (ferramenta_id) REFERENCES FERRAMENTA(id),
    FOREIGN KEY (usuario_id) REFERENCES USUARIO(id)
);

-- Populando a tabela de categorias
INSERT INTO CATEGORIA_FERRAMENTA (nome, descricao) VALUES ('Ferramentas Manuais', 'Ferramentas utilizadas manualmente');
INSERT INTO CATEGORIA_FERRAMENTA (nome, descricao) VALUES ('Ferramentas Elétricas', 'Ferramentas que funcionam com eletricidade');

-- Populando a tabela de ferramentas
INSERT INTO FERRAMENTA (nome, descricao, estado, categoria_id) VALUES ('Martelo', 'Martelo de aço forjado com cabo de madeira', 'DISPONIVEL', 1);
INSERT INTO FERRAMENTA (nome, descricao, estado, categoria_id) VALUES ('Serra Elétrica', 'Serra elétrica para cortes precisos', 'EM_USO', 2);
INSERT INTO FERRAMENTA (nome, descricao, estado, categoria_id) VALUES ('Chave de Fenda', 'Chave de fenda com ponta plana', 'DISPONIVEL', 1);

-- Populando a tabela de usuários
INSERT INTO USUARIO (nome, email) VALUES ('João Silva', 'joao.silva@email.com');
INSERT INTO USUARIO (nome, email) VALUES ('Maria Oliveira', 'maria.oliveira@email.com');

-- Populando a tabela de movimentações
INSERT INTO MOVIMENTACAO (ferramenta_id, usuario_id, data_retirada, data_devolucao) VALUES (1, 1, '2024-10-17', NULL);
INSERT INTO MOVIMENTACAO (ferramenta_id, usuario_id, data_retirada, data_devolucao) VALUES (2, 2, '2024-10-17', '2024-10-18');
