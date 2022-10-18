# :coin: Fintech API :coin:

## Sobre o projeto :scroll:
Aplicação back-end para um sistema que permite realizar transferências financeiras.
Esse sistema deve ser utilizando como back-end para o projeto [Fintech front-end](https://github.com/liberatov13/fintech-front-end)

## Tecnologias utilizadas :hammer_and_wrench:
- Java (v1.8)
- Spring Boot (v2.6.3)
- Spring Data JPA (v2.6.3): Para geração de SQLs
- H2 (v2.1.214): Para persistência dos dados em memória
- Lombok (v1.18.22): Para gerar Getters, Setters e Construtores
- Apache Maven (v3.8.4): Para controle das dependências

## Executando projeto 🧑‍💻

### Máquina local :desktop_computer:
#### Pré-requisitos
- Java v1.8
- Maven v3.8.1

```bash
# Clone o projeto
git clone https://github.com/liberatov13/fintech-back-end.git

# Acesse o diretório do projeto
cd fintech-back-end

# Instale as dependencias
mvn clean install

# Execute o projeto com maven
mvn spring-boot:run
```

A API ficará disponível através de http://localhost:8080 ou http://127.0.0.1:8080

### Observações
- As seguintes contas são pré-cadastradas pela API, e podem ser utilizadas para testes:

|		Nome		|		Número		|		Saldo		|
|:---------:|:-----------:|:---------:|
|Roberto		|123456				|20.000,00	|
|Lucas			|000123				|150,00			|
|João				|654321				|15000,00		|
|Jose				|789123				|10.000,00	|

- As informações das contas podem ser consultadas através do recurso `GET` http://localhost:8080/contas da API.
- Foi utilizada uma conta padrão (Conta 789123) para o envio das transferências através do front.
- É possivel ter acesso ao banco de dados em memória através do link http://localhost:8080/h2, as informações para acesso podem ser encontradas no arquivo [application.properties](https://github.com/liberatov13/fintech-back-end/blob/master/src/main/resources/application.properties)

## Autor :pencil2:
[Elvis Liberato de Barros](https://www.linkedin.com/in/elvisbarros/)
