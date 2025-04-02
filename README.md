# API PetHub

O **PetHub** é uma API desenvolvida com **Spring Boot** para auxiliar médicos veterinários no gerenciamento de informações sobre tutores e tutelados (pets), incluindo espécies, raças, temperamentos, vacinas, pesos e consultas. Esta aplicação foi desenvolvida como parte de um **Trabalho de Conclusão de Curso (TCC)**.

## Tecnologias

- **Spring Boot**: Framework para criação da aplicação.
- **Java**: Versão 17 ou superior.
- **Gradle**: Gerenciador de dependências e build.
- **H2**: Banco de dados em memória para armazenamento.
- **MySql**: Banco de dados relacional.
- **JWT**: Autenticação com tokens.
- **Lombok**: Redução de código _boilerplate_.
- **Swagger**: Interface de documentação e testes dos endpoints.

## Funcionalidades

1. **Gerenciamento de Tutores e Tutelados**
   - Cadastro, edição, listagem, exclusão e visualização de tutores e pets.

2. **Gerenciamento de Vacinas, Pesagens e Consultas**
   - Registro e controle de informações clínicas dos pets.

3. **Listagens Auxiliares**
   - Listagem de espécies, raças, pelagens e temperamentos.

4. **Autenticação via JWT**
   - Autenticação segura com tokens para controle de acesso.

## Como Executar

### 1. Clonar o Repositório

```bash
git clone https://github.com/KardecAlan/hubpet-backend.git
cd pethub
```

### 2. Configurar o Banco de Dados

Edite o arquivo `application.yml` em `src/main/resources`:

```yaml
spring:
  datasource:
    url: jdbc:your_database_url
    username: your_database_username
    password: your_database_password
```

### 3. Build do Projeto

```bash
./gradlew build
```

### 4. Executar a Aplicação

```bash
./gradlew bootRun
```

## Documentação da API com Swagger

Para facilitar o entendimento e a integração com a API, a documentação da API é gerada automaticamente usando o Swagger.

## Acessando a Documentação Swagger

Após iniciar a aplicação, você pode acessar a interface Swagger em:

```
http://localhost:8080/api/v1/swagger-ui.html
```

## Endpoints da API

### Tutor

- `GET /tutor` – Lista todos os tutores
- `GET /tutor/combo` – Lista todos os tutores no formato de combo
- `GET /tutor/{id}` – Busca tutor por ID
- `POST /tutor` – Cadastra novo tutor
- `PUT /tutor/{id}` – Atualiza um tutor existente
- `DELETE /tutor/{id}` – Deleta (lógico) um tutor

### Tutelado

- `GET /tutelado` – Lista todos os tutelados
- `GET /tutelado/{id}` – Busca tutelado por ID
- `POST /tutelado` – Cadastra novo tutelado
- `PUT /tutelado/{id}` – Atualiza um tutelado existente
- `DELETE /tutelado/{id}` – Deleta (lógico) um tutelado

#### Dados Auxiliares do Tutelado

- `GET /tutelado/especie` – Lista todas as espécies
- `GET /tutelado/pelagem` – Lista todas as pelagens
- `GET /tutelado/raca` – Lista todas as raças
- `GET /tutelado/temperamento` – Lista todos os temperamentos

### Peso

- `GET /tutelado/{idTutelado}/peso` – Lista todos os pesos de um tutelado
- `GET /tutelado/{idTutelado}/peso/{idPeso}` – Busca um peso por ID
- `POST /tutelado/{idTutelado}/peso` – Cadastra novo peso
- `PUT /tutelado/{idTutelado}/peso/{idPeso}` – Atualiza peso existente
- `DELETE /tutelado/{idTutelado}/peso/{idPeso}` – Deleta (lógico) um peso

### Vacina

- `GET /tutelado/{idTutelado}/vacina` – Lista todas as vacinas de um tutelado
- `GET /tutelado/{idTutelado}/vacina/{idVacina}` – Busca uma vacina por ID
- `POST /tutelado/{idTutelado}/vacina` – Cadastra nova vacina
- `PUT /tutelado/{idTutelado}/vacina/{idVacina}` – Atualiza vacina existente
- `DELETE /tutelado/{idTutelado}/vacina/{idVacina}` – Deleta (lógico) uma vacina

### Consulta

- `GET /consulta` – Lista todas as consultas
- `GET /consulta/{idConsulta}` – Busca consulta por ID
- `POST /consulta` – Cadastra nova consulta
- `PUT /consulta/{idConsulta}` – Atualiza consulta existente
- `DELETE /consulta/{idConsulta}` – Deleta (lógico) uma consulta

## Dúvidas

Caso tenha dúvidas, sugestões ou queira contribuir com o projeto, sinta-se à vontade para entrar em contato!
