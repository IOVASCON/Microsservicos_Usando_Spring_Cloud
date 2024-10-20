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
