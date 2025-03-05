#!/bin/bash

# Criar rede Docker (ignora erro caso já exista)
docker network create meu-network || true

# Iniciar o banco de dados
echo "Iniciando o banco de dados..."
docker run -d \
  --name db \
  --network meu-network \
  -e POSTGRES_USER=myuser \
  -e POSTGRES_PASSWORD=secret \
  -e POSTGRES_DB=mydatabase \
  -p 5432:5432 \
  --health-cmd="pg_isready -U myuser -d mydatabase" \
  --health-interval=10s \
  --health-timeout=10s \
  --health-retries=5 \
  postgres:13

# Aguardar o banco de dados estar pronto
echo "Aguardando o banco de dados iniciar..."
until docker exec db pg_isready -U myuser -d mydatabase; do
  sleep 2
done

# Construir a aplicação
echo "Construindo a aplicação..."
docker build -t meu-app .

# Executar a aplicação
echo "Iniciando a aplicação..."
docker run -d \
  --name app \
  --network meu-network \
  -e SPRING_PROFILES_ACTIVE=local \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/mydatabase \
  -e SPRING_DATASOURCE_USERNAME=myuser \
  -e SPRING_DATASOURCE_PASSWORD=secret \
  -p 8080:8080 \
  meu-app

echo "Aplicação iniciada! Acesse http://localhost:8080"
