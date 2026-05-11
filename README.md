# Automação de Loja de Carros
Este projeto é uma aplicação Spring Boot voltada para o gerenciamento de uma loja de carros, desenvolvida como parte da disciplina de Testes de Software.

## Tecnologias Utilizadas
- Java 17 & Spring Boot
- Maven (Gerenciador de dependências)
- GitHub Actions (Integração Contínua - CI)
- JUnit 5 (Testes Unitários)

## Pipeline de CI
O projeto conta com um pipeline automatizado via GitHub Actions (ci.yml) que executa as seguintes etapas a cada push ou pull request:
 1. Checkout do código.
 2. Configuração do JDK 17.
 3. Execução dos Testes Unitários via Maven.
 4. Build da aplicação para garantir a integridade do código.

## Como rodar os testes localmente?
./mvnw test
