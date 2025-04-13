# Barber Shop App

Sistema de agendamento para barbearias, com funcionalidades para cadastrar clientes, serviços e gerenciar os horários dos atendimentos.

---

## Tecnologias Utilizadas

### 🔙 Back-end
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**

### Front-end *(em desenvolvimento)*
- **Angular**
- **Bootstrap 5**

---

## Sobre o Projeto

Este projeto foi desenvolvido como parte do meu aprendizado na plataforma **DIO (Digital Innovation One)**. A ideia surgiu para aplicar conceitos de desenvolvimento fullstack, integrando um back-end robusto com um front-end moderno e responsivo.

---

## Funcionalidades

### Back-end:
- Cadastro de clientes
- Cadastro de serviços
- Criação de agendamentos com vínculo entre cliente e serviço
- Exclusão automática de agendamentos ao remover cliente ou serviço (via relacionamento `cascade`)

### Front-end (Angular + Bootstrap):
- Formulário de agendamento
- Listagem de clientes e serviços
- Interface responsiva para desktop e mobile

---

## Modelo de Dados

### Entidades:

#### `Cliente`
- `id: Long`
- `nome: String`
- `telefone: String`
- `email: String`

#### `Servico`
- `id: Long`
- `nome: String`
- `preco: Double`
- `duracao: Duration`

#### `Agendamento`
- `id: Long`
- `dataHora: LocalDateTime`
- `observacao: String`
- `cliente: Cliente`
- `servico: Servico`

---

## Como Rodar o Projeto

### Pré-requisitos:
- Java 17
- Maven
- PostgreSQL
- Node.js + Angular CLI (caso deseje rodar o front-end)

### Back-end:
1. Clone o repositório
2. Configure o banco no arquivo `application.properties`
3. Rode o projeto com o comando:

```bash
./mvnw spring-boot:run
```

### Front-end (em breve):
1. Acesse a pasta frontend

2. Instale as dependências:

```bash
npm install
```

3. Rode o projeto:

```bash
ng serve
```
