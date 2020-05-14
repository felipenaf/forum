
# Forum

API desenvolvida para um desafio com Java Spring Boot.

## Requisitos

Ter o gerenciador de pacotes `maven`

Ter o `JDK(Java Development Kit)`

## Inciar a aplicação

Após clonar o projeto, acessar a raiz pelo terminal e executar o seguinte comando:

- `mvn spring-boot:run`

## Observações

- A aplicação é inciada na porta 8080.

- A base de dados é em memória
	- endpoint: `/h2-console`
	- username: `forum`
	- password: `123` 

- Endpoint para acessar a dosumentação da API: `/swagger-ui.html#`

- Rodar o teste unitário com o comando `mvn test`

- A [collection](https://www.getpostman.com/collections/b7138159dde24860eed9) do Postman com todas as requisições disponíveis.

## Problemas que não consegui resolver
- No swagger ele trará o controller `basic-error-controller`, procurei alguns tutoriais pra remover ele, mas nenhum me ajudou.
