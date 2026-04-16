# 🎬 SerMaisFlix (Catálogo de Filmes)

# Catalago_SerMaisFlix_AdaSerTech
Projeto desenvolvido como parte do programa Ser + Tech 2026, uma parceria entre as empresas ADA e Núclea.


> **Projeto desenvolvido como parte do programa Ser + Tech 2026, uma parceria entre as empresas ADA e Núclea.**

---

## 🎯 Sobre o Projeto

O SerMaisFlix é uma aplicação de console inspirada no IMDB. Ele permite que os usuários do sistema gerenciem um ecossistema completo de filmes, diretores e atores.

O foco central deste desenvolvimento foi aplicar as melhores práticas de POO, transformando regras de negócio em código limpo e organizado, com trabalho em equipe e versionamento via Git.

---

## ✨ Funcionalidades

O sistema oferece um menu interativo onde o usuário pode realizar as seguintes operações:

- **🎬 Cadastrar Filmes:** Inserir obras com título, data de lançamento, orçamento financeiro e sinopse/descrição.
- **🎭 Cadastrar Atores & Diretores:** Registrar os talentos que dão vida às obras.
- **🔗 Associar Entidades:** Conectar um Filme aos seus respectivos Atores (elenco) e ao seu Diretor, criando um relacionamento estruturado.
- **🔍 Busca Inteligente:** Pesquisar filmes pelo nome de forma flexível (ignorando diferenças entre letras maiúsculas e minúsculas - *case-insensitive*).

---

## 🧠 Arquitetura e Conceitos Aplicados (POO)

A base tecnológica deste sistema respira Orientação a Objetos. Para garantir um design elegante e funcional, aplicamos os 4 pilares principais:

### 1. Abstração e Classes Abstratas
Criamos uma classe abstrata `Pessoa` que serve como molde. Como no mundo real não instanciamos uma "Pessoa" genérica no set de filmagem, mas sim um *Ator* ou um *Diretor*, essa classe não pode ser instanciada diretamente. Ela centraliza atributos comuns (como `nome`, `data de nascimento` e `nacionalidade`).

### 2. Herança
As classes `Ator` e `Diretor` **herdam** (`extends`) da classe `Pessoa`. Isso evita a duplicação de código, reaproveitando os atributos e métodos da superclasse, enquanto adicionam suas próprias especificidades (ex: `Diretor` pode ter um atributo de `estiloDeDirecao`, enquanto `Ator` pode ter `quantidadeDeOscars`).

### 3. Encapsulamento
A integridade dos dados é fundamental. Todos os atributos das nossas classes (`Filme`, `Pessoa`, etc.) são privados (`private`). O acesso e a modificação desses dados ocorrem exclusivamente através de métodos `Getters` e `Setters`, permitindo a validação das regras de negócio (ex: não permitir o cadastro de um filme com orçamento negativo).

### 4. Polimorfismo
Utilizamos polimorfismo para tratar diferentes tipos de objetos de forma unificada. Por exemplo, podemos ter um método ou lista que aceita objetos do tipo `Pessoa`, permitindo iterar tanto sobre atores quanto diretores com um único bloco de código, chamando métodos sobrescritos (`@Override`) que se comportam de maneira específica para cada classe.

---


## ⚙️ Stack Tecnológico e Execução

* **Linguagem:** Java (JDK 17+)
* **Paradigma:** Programação Orientada a Objetos (POO)
* **Controle de Versão:** Git / GitHub


## 🚀 Como Executar o Projeto

1. Clone este repositório para sua máquina local:
   ```bash
   git clone [https://github.com/seu-usuario/nome-do-repositorio.git](https://github.com/seu-usuario/nome-do-repositorio.git)
2. Importe o projeto em uma IDE com suporte à JVM (IntelliJ, Eclipse, VS Code).
3. Localize e execute o método *main* na classe principal do sistema.
4. Navegue pelo sistema através da interface interativa apresentada no terminal.

---

## 🚀 A Equipe de Engenharia

Este projeto foi arquitetado e desenvolvido em colaboração. O histórico de *commits* reflete a divisão de responsabilidades de cada integrante do time:

| Integrante         | Role                              | GitHub                                                | LinkedIn                                               |
|:-------------------|:----------------------------------|:------------------------------------------------------|:-------------------------------------------------------|
| Ludimila Araújo    | Backend Developer / Product Owner | [Ludimila-Araujo](https://github.com/Ludimila-Araujo) | [LinkedIn](https://linkedin.com/in/seu-perfil)         |
| Enei Pereira       | Backend Developer                 | [Enei Pereira Júnior](https://github.com/eneipereira) | [LinkedIn](https://www.linkedin.com/in/eneipereira)    |
| Maria Brenda Silva | Backend Developer                 | [MarBrenda](https://github.com/MarBrenda)             | [LinkedIn](https://www.linkedin.com/in/mariabrcsilva/) |
| Nankin Zane        | Backend Developer                 | [KimZanee](https://github.com/kimzanee)               | [LinkedIn](https://www.linkedin.com/in/nankin-zane)    |
