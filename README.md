<div align="center" id="top"> <img src="https://www.linkimagem.com/imagem-projeto-energyquest.jpg" alt="EnergyQuest" width="200" /> <h1 align="center">EnergyQuest</h1> </div> <p align="center"> <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/CharCarvalho/GlobalSolution4?color=56BEB8"> <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/CharCarvalho/GlobalSolution4?color=56BEB8"> <img alt="Repository size" src="https://img.shields.io/github/repo-size/CharCarvalho/GlobalSolution4?color=56BEB8"> </p> <p align="center"> <a href="https://github.com/CharCarvalho" target="_blank">Autor</a> </p>
📝 Sobre
EnergyQuest é uma API desenvolvida em Java utilizando o framework Spring Boot. Este projeto foi criado para gerenciar perguntas e respostas relacionadas a dados de usuários e questões energéticas, integrando funcionalidades de autenticação e armazenamento seguro.

Link para o Deploy: EnergyQuest API

✨ Funcionalidades
✅ Endpoints RESTful para CRUD de perguntas e respostas.
✅ Gerenciamento de usuários com campos seguros, incluindo senhas.
✅ Relacionamentos definidos entre perguntas e respostas.
✅ Integração com banco de dados relacional para persistência dos dados.
✅ Suporte para inicialização e configuração de ambiente usando variáveis.
🚀 Tecnologias
As seguintes tecnologias foram utilizadas na construção do projeto:

Java 17
Spring Boot 3
Jakarta Persistence API (JPA)
Banco de Dados Relacional
Lombok para simplificar o código de boilerplate
Maven para gerenciamento de dependências
⚙️ Configuração
Pré-requisitos
Java 17 ou superior
Maven
Banco de dados relacional (configurado com variáveis de ambiente)
Variáveis de Ambiente
O projeto utiliza variáveis de ambiente para configuração de credenciais e URL do banco de dados. Certifique-se de definir as seguintes variáveis:

SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
Como rodar localmente
Clone o repositório:
bash
Copiar código
git clone https://github.com/CharCarvalho/GlobalSolution4.git
Navegue até o diretório do projeto:
bash
Copiar código
cd GlobalSolution4
Compile o projeto com Maven:
bash
Copiar código
mvn clean install
Execute a aplicação:
bash
Copiar código
mvn spring-boot:run
📁 Estrutura do Projeto
O projeto possui a seguinte estrutura:

css
Copiar código
src
├── main
│   ├── java
│   │   └── com.globalsolution2.fiap
│   │       ├── controller
│   │       ├── model
│   │       │   ├── PerguntaModel.java
│   │       │   └── UsuarioModel.java
│   │       ├── repository
│   │       └── service
│   └── resources
│       ├── application.properties
│       └── static
└── test
🛠️ Melhorias Futuras
Implementar autenticação JWT para maior segurança.
Adicionar paginação e filtros nos endpoints de perguntas e respostas.
