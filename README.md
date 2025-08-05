# Auto Elétrica Garcia - Backend

## 📝 Descrição do Projeto

Este é o backend do sistema de gestão para a Auto Elétrica Garcia, desenvolvido como um software sob medida que, no futuro, será evoluído para um SaaS (Software as a Service) multi-tenant.

O sistema é construído para gerenciar o fluxo de trabalho de uma oficina, incluindo o cadastro de clientes, veículos, ordens de serviço, agendamentos, e o controle de usuários.

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **Framework:** Spring Boot 3+
* **Controle de Versão:** Git e GitHub
* **Banco de Dados:** PostgreSQL
* **Ferramenta de Build:** Maven
* **Ambiente de Desenvolvimento:** Docker para o banco de dados

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas (Monolito Modular) para garantir a separação de responsabilidades e a manutenibilidade do código. As camadas principais são:

* **Controller:** Responsável por receber requisições HTTP e roteá-las.
* **Service:** Contém a lógica de negócio da aplicação.
* **Repository:** Responsável pela persistência e acesso aos dados no banco de dados.

## ⚙️ Configuração para Desenvolvimento

Para rodar o projeto localmente, você precisará ter o **JDK 17** e o **Docker Desktop** instalados.

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/garcfelip/gestao-oficina-backend.git](https://github.com/SEU_USUARIO/gestao-oficina-backend.git)
    cd gestao-oficina-backend
    ```
2.  **Inicie o banco de dados PostgreSQL com Docker:**
    ```bash
    docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres
    ```
3.  **Configurar o projeto:**
    * Abra o projeto no seu IDE (como IntelliJ).
    * Verifique se o arquivo `src/main/resources/application.properties` está configurado corretamente para o banco de dados local.

4.  **Executar o projeto:**
    * Execute a classe principal `GestaoOficinaBackendApplication.java` no seu IDE.

## 🤝 Contribuições

No momento, o projeto está sendo desenvolvido por um único colaborador. No futuro, guidelines para contribuições serão adicionadas aqui.

---

Sinta-se à vontade para ajustar este `README.md` conforme o projeto evolui, adicionando mais detalhes, funcionalidades e instruções de uso.

Quando o arquivo estiver pronto, pode me avisar para começarmos a criar a entidade `User` e o `UserRepository` que discutimos.