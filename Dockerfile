# Etapa 1: Construção do projeto com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copia os arquivos do projeto para dentro do container
COPY pom.xml .
COPY src ./src

# Executa a compilação do projeto e gera o JAR
RUN mvn clean package -DskipTests

# Etapa 2: Container final da aplicação
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia o JAR gerado na etapa de build para o container final
COPY --from=builder /app/target/*.jar app.jar

# Expor a porta 8080 para a aplicação Spring Boot
EXPOSE 8080

# Define o comando de inicialização da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
