# Controle de Presença - Backend

## 📌 Sobre o projeto

API REST desenvolvida com **Spring Boot** para um sistema de controle de presença escolar.

O objetivo do sistema é substituir processos manuais de chamada e reposição de aulas, trazendo automação, organização e rastreabilidade dos registros.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Swagger
- Maven
- Docker
- Docker Compose

---

## ⚙️ Funcionalidades

- Cadastro de professores
- Cadastro de alunos
- Relacionamento entre professores e alunos
- Registro de presença (em evolução)
- Estrutura preparada para evolução do sistema

---

## 🧱 Arquitetura

O projeto segue arquitetura em camadas:

- Controller → exposição da API REST
- Service → regras de negócio
- Repository → acesso ao banco de dados
- DTOs → transferência de dados
- Entities → modelagem do domínio
- Exception Handling → tratamento de erros

---

## 🐳 Execução com Docker

O projeto pode ser executado com Docker e Docker Compose:

```bash
docker compose up --build
