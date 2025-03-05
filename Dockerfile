# Etapa 1: Construção do projeto com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copia os arquivos do projeto para dentro do container
COPY pom.xml .
COPY src ./src

# Executa a compilação do projeto e gera o JAR
RUN mvn package -DskipTests

# Etapa 2: Container final da aplicação
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia o JAR gerado na etapa de build para o container final
COPY --from=builder /app/target/*.jar app.jar

# Expor a porta 8080
EXPOSE 8080

# Define a variável de ambiente para a porta do Spring Boot
ENV SERVER_PORT=8080

# Define o comando de inicialização da aplicação com o perfil "local" e porta fixa
ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-Dserver.port=8080", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
