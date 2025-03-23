# 🚀 Sistema de Reserva e Avaliação de Restaurantes

Este projeto é uma aplicação **back-end** para gerenciamento de reservas e avaliações de restaurantes, desenvolvida utilizando **Java 17**, **Spring Boot**, e padrões modernos de arquitetura e segurança.

## 📌 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.4**
- **Spring Security**
- **PostgreSQL**
- **Docker e Docker Compose**
- **JMeter** (Testes de performance)
- **JUnit e Mockito** (Testes unitários)
- **Swagger/OpenAPI** (Documentação da API)
- **Clean Architecture**

## 🏗️ Arquitetura

O projeto segue a **Clean Architecture**, dividida nas seguintes camadas:

- **api** → Controladores HTTP
- **domain** → Modelos e entidades de domínio
- **aplicacao (use cases)** → Regras de negócio
- **infraestrutura** → Repositórios e integrações

## 🔐 Segurança

A aplicação utiliza **Spring Security** para proteção de endpoints. Atualmente, a autenticação pode ser configurada conforme necessário.

## 📄 Documentação da API

A documentação da API pode ser acessada via **Swagger** após iniciar a aplicação:

🔗 [Swagger UI](http://localhost:8080/swagger-ui.html)

## 🛠️ Como Rodar o Projeto Localmente

### 📌 Pré-requisitos

- Docker e Docker Compose instalados
- Java 17 instalado
- Maven configurado

### 🚀 Passos para Execução

1. **Clonar o repositório**

   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. **Criar o arquivo `.env`** (opcional)

   ```sh
   cp .env.example .env
   ```

3. **Executar com Docker Compose**

   ```sh
   docker-compose up --build
   ```

4. **Acessar a API**

   A API estará rodando em: [http://localhost:8080](http://localhost:8080)

## 📦 Deploy na Render

Para subir o projeto na **Render**, siga os passos abaixo:

1. Configure o arquivo `render.yaml`.
2. Faça o push das alterações para o repositório remoto.
3. Configure o serviço na **Render** e faça o deploy automático.

## 🧪 Testes

Para rodar os testes unitários e de integração:

```sh
mvn test
```

Para testes de performance com **JMeter**, utilize os scripts na pasta `tests/performance`.

## 📌 Contribuição

1. Fork o repositório
2. Crie um branch: `feature/nova-funcionalidade`
3. Commit suas mudanças: `git commit -m 'Adiciona nova funcionalidade'`
4. Envie para revisão: `git push origin feature/nova-funcionalidade`
5. Abra um **Pull Request** 🚀

---

🛠 **Desenvolvido por [Eduardo Sócrates RM358568]**
