# Controle Financeiro

## Descrição

O Controle Financeiro é uma aplicação web desenvolvida com o objetivo de permitir o registro e a visualização de transações financeiras categorizadas, servindo como um projeto de estudo e consolidação de conceitos de desenvolvimento web full stack.

O projeto foi desenvolvido com foco em boas práticas de organização de código, separação de responsabilidades e utilização de padrões comuns em aplicações backend baseadas em Java e Spring Boot, integrando-se a um frontend simples em HTML, CSS e JavaScript.

## Funcionalidades

- Cadastro de categorias financeiras
- Cadastro de transações financeiras associadas a uma categoria
- Listagem de transações com:
    - descrição
    - valor
    - categoria
    - data
- Comunicação entre frontend e backend via API REST

## Tecnologias Utilizadas
- Backend
  - Java
  - Spring Boot
  - Spring Web
  - Spring Data JPA
  - Hibernate
  - Validação com Jakarta Validation
  - Banco de dados relacional (configurável)
  - Arquitetura em camadas (Controller, Service, Repository)
  - Padrão DTO para entrada e saída de dados

- Frontend
  - HTML5
  - CSS3
  - JavaScript (Fetch API)
  - Comunicação REST com backend

## Ferramentas
- Git
- Maven

## Estrutura do Projeto
O backend segue uma organização em camadas, incluindo:
- Controllers: responsáveis pela exposição da API REST
- Services: responsáveis pelas regras de negócio
- Repositories: acesso aos dados via JPA
- DTOs: objetos de transferência de dados para requisições e respostas
- Mappers: conversão entre entidades e DTOs

O frontend consiste em uma página HTML simples que consome a API por meio de requisições HTTP assíncronas.

## Objetivo do Projeto

Este projeto tem caráter educacional e foi desenvolvido com os seguintes objetivos:
- Praticar desenvolvimento backend com Java e Spring Boot
- Aplicar conceitos de APIs REST
- Trabalhar com persistência de dados e relacionamento entre entidades
- Integrar frontend e backend em uma aplicação full stack
- Consolidar fundamentos de organização de código e boas práticas

## Possíveis Melhorias Futuras
- Implementação de autenticação e autorização
- Filtros por período e categoria
- Resumo financeiro (entradas, saídas e saldo)
- Paginação e ordenação de transações
- Interface gráfica mais elaborada
- Testes automatizados

## Autor
Marcel Setúbal Costa
Graduando em Bacharelado em Tecnologia da Informação – UFRN
