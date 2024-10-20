# Script de Criação de Pastas e Arquivos do Projeto

Dê um nome para o script: Ex: criar_estrutura.sh

    # Definindo o diretório base do projeto
    BASE_DIR="L:/VSCode/JAVA/DIO/Controle_Ferramentas"

    # Criando diretórios e arquivos para o eureka-service
    mkdir -p "$BASE_DIR/eureka-service/src/main/java/com/dio/eureka"
    mkdir -p "$BASE_DIR/eureka-service/src/main/resources"
    touch "$BASE_DIR/eureka-service/src/main/java/com/dio/eureka/EurekaServiceApplication.java"
    touch "$BASE_DIR/eureka-service/src/main/resources/application.yml"
    touch "$BASE_DIR/eureka-service/build.gradle"

    # Criando diretórios e arquivos para o ferramenta-catalog-service
    mkdir -p "$BASE_DIR/ferramenta-catalog-service/src/main/java/com/dio/catalog/controller"
    mkdir -p "$BASE_DIR/ferramenta-catalog-service/src/main/java/com/dio/catalog/model"
    mkdir -p "$BASE_DIR/ferramenta-catalog-service/src/main/java/com/dio/catalog/repository"
    mkdir -p "$BASE_DIR/ferramenta-catalog-service/src/main/java/com/dio/catalog/service"
    mkdir -p "$BASE_DIR/ferramenta-catalog-service/src/main/resources"
    mkdir -p "$BASE_DIR/ferramenta-catalog-service/src/test/java/com/dio/catalog"
    touch "$BASE_DIR/ferramenta-catalog-service/src/main/java/com/dio/catalog/controller/FerramentaController.java"
    touch "$BASE_DIR/ferramenta-catalog-service/src/main/java/com/dio/catalog/model/Ferramenta.java"
    touch "$BASE_DIR/ferramenta-catalog-service/src/main/java/com/dio/catalog/model/CategoriaFerramenta.java"
    touch "$BASE_DIR/ferramenta-catalog-service/src/main/java/com/dio/catalog/repository/FerramentaRepository.java"
    touch "$BASE_DIR/ferramenta-catalog-service/src/main/java/com/dio/catalog/service/FerramentaService.java"
    touch "$BASE_DIR/ferramenta-catalog-service/src/main/resources/application.yml"
    touch "$BASE_DIR/ferramenta-catalog-service/src/main/resources/data.sql" # Arquivo para dados iniciais
    touch "$BASE_DIR/ferramenta-catalog-service/build.gradle"

    # Criando diretórios e arquivos para o api-gateway
    mkdir -p "$BASE_DIR/api-gateway/src/main/java/com/dio/gateway"
    mkdir -p "$BASE_DIR/api-gateway/src/main/resources"
    touch "$BASE_DIR/api-gateway/src/main/java/com/dio/gateway/ApiGatewayApplication.java"
    touch "$BASE_DIR/api-gateway/src/main/resources/application.yml"
    touch "$BASE_DIR/api-gateway/build.gradle"

    # Criando o arquivo docker-compose.yml na raiz do projeto para rodar os microsserviços com Docker
    touch "$BASE_DIR/docker-compose.yml"

    # Criando README.md na raiz do projeto
    touch "$BASE_DIR/README.md"

    # Mensagem final
    echo "Estrutura de microsserviços criada com sucesso em $BASE_DIR"

## O que esse script faz

1. Eureka Service: Cria a estrutura de pastas e arquivos para o serviço de descoberta Eureka.
2. Ferramenta Catalog Service: Cria pastas e arquivos para o microsserviço de catálogo de ferramentas, incluindo um arquivo data.sql para dados iniciais e o serviço de CRUD.
3. API Gateway: Cria o serviço de gateway para gerenciar o roteamento de requisições para os microsserviços.
4. Docker Compose: Adiciona um arquivo docker-compose.yml para facilitar a execução dos serviços.
5. README.md: Cria um arquivo README.md para documentação do projeto.

## Execução do Script

Para executar o script criar_estrutura.sh no seu terminal, siga os seguintes passos:

1. Acesse o diretório onde o arquivo está localizado: No terminal, navegue até o diretório onde o arquivo criar_estrutura.sh foi salvo, usando o comando cd. Exemplo:

    cd L:/VSCode/JAVA/DIO/Controle_Ferramentas

2. Torne o script executável (se ainda não estiver): Dependendo do sistema operacional, pode ser necessário dar permissão para que o script seja executado. Para isso, use o comando:

    chmod +x criar_estrutura.sh

3. Execute o script: Agora, para rodar o script, basta usar o seguinte comando:

    ./criar_estrutura.sh

Se você estiver no Windows e usando um terminal compatível (como o Git Bash ou o Windows Subsystem for Linux - WSL), esse comando funcionará normalmente.

## Banco de Dados

### Considerações do data.sql

Principais pontos considerados:

1. Tabela de Ferramentas:
    - Informações como id, nome, descrição, categoria, estado (disponível ou em uso), entre outros.

2. Tabela de Categorias de Ferramentas:
    - Para classificar as ferramentas em tipos (e.g., elétricas, manuais, de medição).

3. Tabela de Usuários (se aplicável):
    - Para registrar os usuários que podem utilizar ou reservar as ferramentas.

4. Tabela de Reservas ou Movimentações (se aplicável):
    - Para controlar o histórico de uso e movimentação das ferramentas, quem usou, quando foi retirada e devolvida, etc.

**Código do data.sql:**

Este arquivo é utilizado para popular o banco de dados H2 com dados iniciais. Ele contém instruções SQL para a criação e inserção de dados nas tabelas.

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

Esse arquivo é executado quando o Spring Boot sobe o banco H2, criando as tabelas e populando com dados iniciais, que depois serão acessados pelos repositórios e expostos pelos controladores.

**Legenda:**

1. Ferramentas: A tabela contém o nome, descrição e estado (disponível ou em uso).
2. Categorias: Para facilitar o agrupamento de ferramentas em diferentes tipos.
3. Usuários: Para gerenciar quem está usando as ferramentas, caso isso seja necessário.
4. Movimentações: Essa tabela ajuda a controlar o histórico de quem retirou e devolveu a ferramenta.

**Normalização:**

1. **Chaves Primárias:**

    1. Cada tabela tem sua chave primária para garantir a unicidade de registros.
        - CategoriaFerramenta(id) → Chave primária da tabela CategoriaFerramenta.
        - Ferramenta(id) → Chave primária da tabela Ferramenta.
        - Usuario(id) → Chave primária da tabela Usuario.
        - Movimentacao(id) → Chave primária da tabela Movimentacao.

2. **Chaves Estrangeiras:**

    1. As chaves estrangeiras garantem o relacionamento entre tabelas e mantém a integridade referencial.
        - Ferramenta(categoria_id) → Chave estrangeira que referencia a tabela CategoriaFerramenta.
        - Movimentacao(ferramenta_id) → Chave estrangeira que referencia a tabela Ferramenta.
        - Movimentacao(usuario_id) → Chave estrangeira que referencia a tabela Usuario.

3. **Explicação dos Relacionamentos:**

    - **Ferramenta -> CategoriaFerramenta (Relacionamento 1):** Cada ferramenta pertence a uma categoria, mas uma categoria pode ter várias ferramentas. Por isso, a tabela Ferramenta tem uma chave estrangeira categoria_id que referencia CategoriaFerramenta(id).

    - **Movimentacao -> Ferramenta (Relacionamento N:1):** Várias movimentações podem ocorrer para uma ferramenta, mas cada movimentação está ligada a uma ferramenta específica. A chave estrangeira ferramenta_id faz a referência a Ferramenta(id).

    - **Movimentacao -> Usuario (Relacionamento N:1):** Um usuário pode realizar várias movimentações de ferramentas, mas cada movimentação está vinculada a um único usuário, através da chave estrangeira usuario_id referenciando Usuario(id).

4. **Padrões de Normalização Aplicados:**

    - **1ª Forma Normal (1NF):** Todas as tabelas estão em 1NF, já que os atributos são atômicos (ou seja, cada coluna contém um único valor).
    - **2ª Forma Normal (2NF):** Cada tabela tem uma chave primária e todos os atributos dependem dessa chave primária.
    - **3ª Forma Normal (3NF):** Não há dependência transitiva, ou seja, todas as colunas dependem diretamente da chave primária.

## Configuração do H2 como Banco de Dados no Projeto

    spring:
  datasource:
    url: jdbc:h2:mem:controle_ferramentas  # Banco H2 rodando em memória
    driver-class-name: org.h2.Driver
    username: sa
    password:
    schema: classpath:data.sql  # Arquivo data.sql para criação de tabelas
    initialization-mode: always  # Executar o arquivo SQL na inicialização
  h2:
    console:
      enabled: true  # Habilita o console do H2
      path: /h2-console  # Caminho para acessar o console
  jpa:
    hibernate:
      ddl-auto: none  # Desativamos a criação automática das tabelas
    show-sql: true  # Exibe as queries SQL no console (opcional)

### Explicação

    url: jdbc:h2:mem:controle_ferramentas: Banco de dados H2 em memória, que será usado durante a execução da aplicação.
    h2.console.enabled: Habilita o console H2 para que você possa visualizar e executar queries no banco de dados.
    schema: classpath:data.sql: Executa o arquivo data.sql ao iniciar a aplicação, para criar as tabelas.
    path: /h2-console: Define o caminho para acessar o console do H2 (localhost:8080/h2-console).
    ddl-auto: none: O Hibernate não irá criar ou modificar as tabelas automaticamente, pois o script SQL fará isso.

### Acesso ao H2 Console

Depois de iniciar a aplicação, você poderá acessar o H2 Console através do navegador, indo para:

    <http://localhost:8080/h2-console>

Você pode usar a URL configurada (jdbc:h2:mem:controle_ferramentas) e deixar o username como sa sem senha para acessar o banco.

Com isso, o projeto está configurado para usar o H2 e futuramente, migrar para o MySQL se for necessário.

**OBS:**

A forma como o arquivo .yml está exibido na imagem parece correta no VSCode, pois o YAML utiliza indentação com espaços para definir a hierarquia das configurações. O VSCode realça as seções conforme as chaves estão aninhadas.

No entanto, é muito importante garantir que a indentação seja feita somente com espaços e não com tabulações, pois o formato YAML não suporta tabs. Caso haja inconsistência na indentação, isso pode causar erros de leitura.

**Pontos importantes:**

- **Indentação com espaços:** Certifique-se de que está utilizando apenas espaços (normalmente 2 ou 4 espaços por nível de indentação, conforme preferido).
- **Estrutura correta:** A hierarquia está correta, com datasource, h2, e jpa bem organizados sob spring.
