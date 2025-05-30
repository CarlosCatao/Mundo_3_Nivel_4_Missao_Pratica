<img src="./Estacio horizontal.png" align="left" height="64px" /><br><br>
# Curso: Desenvolvimento Full Stack
## Mundo 3 - Nível 4 - Missão Prática

## RPG0017  - Vamos integrar sistema

**Autor:** Carlos Altomare Catao

**Curso:** Desenvolvedor Full Stack (Estácio - Mundo 3)

**Matrícula:** 202403460912

**Polo:** Santa Luzia - Vitória/ES

---

## ✅ Descrição

Projeto desenvolvido como parte da Missão Prática do Mundo 3 - Nível 4 do curso de Desenvolvimento Full Stack, com foco na criação de uma aplicação web completa utilizando Jakarta EE.

O sistema implementa as operações CRUD para a entidade **Produto**, integrando:

- **Persistência** com JPA e SQL Server.
- **Regras de negócio** encapsuladas em EJBs.
- **Interface web** com Servlets, JSP e estilização com Bootstrap.

## 🚀 Tecnologias

- Jakarta EE 10
- Servlets
- EJB (Enterprise JavaBeans)
- JPA
- SQL Server
- JDBC
- NetBeans
- GlassFish
- JSP, HTML, Bootstrap
- Java 17

## 🛠️ Funcionalidades

- CRUD de produtos.
- Integração completa entre camadas: apresentação, controle e persistência.
- Interface responsiva com Bootstrap.
- Deploy modular (.ear).

## 🧩 Estrutura do Projeto

```
Para cada um dos Procedimentos, teremos:

CadastroEE/
├── modelo/
│ ├── Produto.java # Classe entidade JPA
│ ├── ProdutoDAO.java # Classe de acesso a dados (DAO)
│
├── ejb/
│ ├── ProdutoFacade.java # Classe de negócios com padrão Facade
│ ├── ProdutoFacadeLocal.java # Interface local do EJB
│
├── controle/
│ └── ServletProdutoFC.java # Servlet controlador (Front Controller)
│
├── web/
│ ├── ProdutoDados.jsp # Formulário para inclusão e edição de produtos
│ └── ProdutoLista.jsp # Página de listagem e gerenciamento
│
├── META-INF/
│ └── persistence.xml # Configuração da persistência JPA
│
├── WEB-INF/
│ └── web.xml # Configuração do módulo web
│
├── build.xml # Script Ant para build
├── RELATORIO_DO_ORCEDIMENTO.pdf
└── RESULTADOS.pdf # Arquivo com os resultados dos testes

---

## 📄 Relatório Completo

Para mais detalhes sobre o desenvolvimento, desafios, arquitetura e resultados, consulte o **Relatório Final da Prática**:

👉 [RELATÓRIO COMPLETO - Missão Prática Mundo 3 - Nível 4](https://github.com/CarlosCatao/Mundo_3_Nivel_4_Missao_Pratica)

## 🧪 Testes

Testes funcionais realizados para validar todas as operações do CRUD, além de verificações de integração entre os módulos.

## 🖥️ Execução

- Configurar SQL Server e JDBC.
- Deploy no GlassFish.
- Acessar via navegador: `http://localhost:8080/CadastroEE`.

---

## 🔗 Repositório Git

> https://github.com/CarlosCatao/Mundo_3_Nivel_4_Missao_Pratica

---