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

# Define as variáveis de ambiente para o PostgreSQL
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://dpg-cv48v08gph6c73acjm8g-a:5432/controle_restaurante_16uj
ENV SPRING_DATASOURCE_USERNAME=controle_restaurante_16uj_user
ENV SPRING_DATASOURCE_PASSWORD=CIY9LGsASviws5OUosdY8cbBRYsSjyoa

# Define o comando de inicialização da aplicação com o perfil "local"
ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-Dserver.port=8080", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
