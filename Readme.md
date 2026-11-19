# 🎬 Screenmatch

Aplicação backend desenvolvida em Java com Spring Boot para busca, consumo, filtragem, tradução automática e persistência de dados de filmes e séries a partir de APIs externas (OMDb API e OpenAI API).

Projeto desenvolvido ao longo da formação de desenvolvimento Java backend na Alura, evoluindo de uma aplicação de linha de comando (CLI) para uma arquitetura integrada com banco de dados relacional PostgreSQL e inteligência artificial.

---

## 🚀 Tecnologias Utilizadas

* **Java 25** (Recursos modernos como *Records*, *Streams*, *Lambdas* e `Optional`)
* **Spring Boot 3** & **Spring Data JPA**
* **PostgreSQL** (Banco de dados relacional para persistência das séries e episódios)
* **Maven** (Gerenciamento de dependências e build via `pom.xml`)
* **Jackson** (Serialização e desserialização de dados JSON)
* **Java `HttpClient`** (Consumo de APIs REST externas)
* **OpenAI Java SDK** (Integração com a API da OpenAI para tradução automática de sinopses para o português)

---

## ⚙️ Funcionalidades

- [x] Consumo da OMDb API para busca de títulos, temporadas e episódios.
- [x] Desserialização de respostas JSON para *Records* e entidades Java utilizando **Jackson**.
- [x] Tradução automática da sinopse das séries para o português via **OpenAI API**.
- [x] Filtragem, ordenação (por gênero) e estatísticas utilizando **Java Streams**.
- [x] Persistência e listagem de séries no PostgreSQL com **Spring Data JPA** (`ddl-auto=update`).
- [ ] Busca e persistência de episódios vinculados às séries no banco de dados.
- [ ] Consultas derivadas (*Derived Queries*) e JPQL personalizadas.

---

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado e configurado em sua máquina:

1. **JDK 25** configurado nas variáveis de ambiente.
2. **Maven** (ou utilize o Maven Wrapper incluído no projeto).
3. **PostgreSQL** rodando localmente com um banco de dados criado para a aplicação.
4. Uma chave de API gratuita da [OMDb API](https://www.omdbapi.com/apikey.aspx).
5. Uma chave de API ativa da [OpenAI](https://platform.openai.com/api-keys) para o recurso de tradução de sinopses.

---

## 🔧 Como Configurar e Executar

### 1. Clone o repositório
```bash
git clone https://github.com/john-aso/Screenmatch.git
cd Screenmatch
```
*(Nota: ajuste a URL acima caso o repositório tenha outro nome no seu GitHub).*

### 2. Configure as Variáveis de Ambiente
Para manter suas credenciais seguras e evitar expor chaves ou senhas nos commits, o projeto utiliza variáveis de ambiente configuradas no `application.properties` e nas classes de serviço.

Configure as seguintes variáveis no seu sistema operacional ou nas configurações de execução (*Run/Debug Configurations -> Environment variables*) da sua IDE (IntelliJ IDEA):

```env
DB_HOST=localhost:5432
DB_NAME=screenmatch
DB_USER=seu_usuario_postgres
DB_PASSWORD=sua_senha_postgres
API_KEY_OMDB=sua_chave_omdb
OPENAI_API_KEY=sua_chave_openai
```

O Spring Boot utilizará essas variáveis automaticamente para conectar ao PostgreSQL e criar/atualizar as tabelas (`spring.jpa.hibernate.ddl-auto=update`).

### 3. Execute a aplicação
Via terminal utilizando o Maven Wrapper:
```bash
./mvnw spring-boot:run
```
Ou execute diretamente a classe principal (`ScreenmatchApplication.java`) pelo botão **Run** da sua IDE.

---

## 💻 Como Usar

1. Ao iniciar a aplicação, um menu interativo será exibido no console:
    * `1 - Buscar séries`: Consulta uma série na OMDb API, traduz a sinopse automaticamente para o português via OpenAI, salva no PostgreSQL e exibe os detalhes no terminal.
    * `2 - Buscar episódios`: Busca todas as temporadas e episódios de uma série na API.
    * `3 - Listar Séries Buscadas`: Consulta todas as séries salvas no PostgreSQL e as exibe ordenadas por gênero.
    * `0 - Sair`: Encerra a aplicação.
2. Digite o número da opção desejada e siga as instruções no terminal.

---

## 👨‍💻 Autor

Desenvolvido por **John Altemy Silva de Oliveira**  
[![GitHub](https://img.shields.io/badge/GitHub-john--aso-181717?style=flat&logo=github)](https://github.com/john-aso)
