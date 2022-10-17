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
- Maven

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

## Autor :pencil2:
[Elvis Liberato de Barros](https://www.linkedin.com/in/elvisbarros/)
