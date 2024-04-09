# NeuroChatIA: Documentação do Projeto

## Índice
1. [Introdução](#introdução)
2. [Diagrama Arquitetural](#diagrama-arquitetural)
3. [Estrutura de Diretórios do Projeto](#estrutura-de-diretórios-do-projeto-neurochatia)
4. [Configuração do Spring Boot](#configuração-do-spring-boot)
5. [Integração com Bancos de Dados SQL](#integração-com-bancos-de-dados-sql)
6. [API REST para Campeões do League of Legends](#api-rest-para-campeões-do-league-of-legends)
7. [Inteligência Artificial com Spring Cloud OpenFeign](#inteligência-artificial-com-spring-cloud-openfeign)
8. [Interface do Usuário com HTML, CSS e JavaScript](#interface-do-usuário-com-html-css-e-javascript)

## Introdução
O projeto **NeuroChatIA** é um sistema que combina os fundamentos da linguagem de programação Java com as configurações do framework Spring Boot. Nosso foco principal está na Programação Orientada a Objetos e na integração com Bancos de Dados SQL por meio do Spring Data JDBC. O objetivo é desenvolver uma API REST abordando o design, desenvolvimento e documentação, com ênfase em campeões do jogo League of Legends. A API será implantada no AWS Elastic Beanstalk. Além disso, incorporaremos uma camada de Inteligência Artificial (IA) para otimizar a API, utilizando o Spring Cloud OpenFeign para integração com APIs de IA fornecidas por grandes provedores, como OpenAI (GPT) e Google (Gemini). A interface do usuário será construída para interagir com a API, explorando os conceitos básicos de HTML, CSS e JavaScript.

## Diagrama Arquitetural
A seguir, apresentamos o diagrama arquitetural do projeto, destacando a separação das responsabilidades entre as camadas. Desde a interface de usuário até os mecanismos de interação com sistemas externos, passando por adaptadores, casos de uso e as entidades centrais do domínio, cada elemento é estrategicamente posicionado para reforçar a modularidade, a escalabilidade e a manutenibilidade do sistema. Esta estrutura facilita a compreensão de como os componentes colaboram para a realização dos objetivos do software, alinhando-se aos princípios da Clean Architecture.

## Estrutura de Diretórios do Projeto NeuroChatIA

O projeto **NeuroChatIA** segue uma estrutura de diretórios inspirada nos princípios da Clean Architecture, visando à clara separação de responsabilidades e à promoção da autonomia das camadas em um projeto Spring Boot. Essa abordagem não apenas facilita a manutenção e evolução do código, mas também sustenta a integração e colaboração eficaz entre as diferentes partes da aplicação. A seguir, detalhamos a disposição dos diretórios que compõem a aplicação, cada um desempenhando um papel específico dentro do ecossistema de software:

- **adapters/**: Adaptadores para comunicação entre a aplicação e o mundo externo, incluindo controladores REST e componentes de persistência.

- **in/**: Adaptadores de entrada, lidando com requisições de usuários.

- **out/**: Adaptadores de saída, responsáveis pela interação com bancos de dados e APIs externas.

- **application/**: Casos de uso da aplicação, encapsulando a lógica de negócios.

- **domain/**: Entidades, exceções e interfaces que definem as regras de negócio do domínio.

- **exception/**: Exceções personalizadas pertinentes ao domínio.

- **model/**: Modelos de dados que representam conceitos centrais da aplicação.

- **ports/**: Interfaces que delineiam os contratos para adaptadores e serviços externos.

- **Application.java**: Classe principal que configura e inicia a aplicação Spring Boot.

## Configuração do Spring Boot

A configuração do Spring Boot no projeto **NeuroChatIA** envolve a definição de diversas classes e componentes que permitem a inicialização e execução da aplicação de forma eficiente e robusta. Algumas das principais configurações incluem:

- **Classe Principal (`Application.java`)**: Esta classe contém o método `main()` responsável por iniciar a aplicação Spring Boot. Ela também é utilizada para configurar os componentes principais do Spring, como beans, escaneamento de pacotes e propriedades de aplicação.

- **Configuração do Banco de Dados**: O Spring Boot permite configurar facilmente a conexão com o banco de dados por meio de propriedades no arquivo `application.properties` ou `application.yml`. No caso do **NeuroChatIA**, estamos utilizando o banco de dados H2 para armazenar dados dos campeões do League of Legends.

- **Configuração da API REST**: Utilizando anotações como `@RestController`, `@RequestMapping`, e `@Autowired`, definimos endpoints REST que expõem funcionalidades relacionadas aos campeões. O Spring Boot gerencia automaticamente a serialização e desserialização de dados JSON.

- **Configuração da Segurança**: Podemos integrar e configurar facilmente módulos de segurança, como autenticação e autorização, utilizando as dependências do Spring Security.

## Integração com Bancos de Dados SQL
No projeto **NeuroChatIA**, utilizamos o banco de dados H2 para modelar o domínio dos campeões do League of Legends. Isso facilita a prototipação rápida e eficiente, permitindo armazenar informações detalhadas sobre cada campeão.

## API REST para Campeões do League of Legends

A API REST no **NeuroChatIA** fornece operações para acessar informações sobre os campeões do League of Legends. Alguns exemplos de endpoints que podem ser implementados incluem:

- `GET /api/champions`: Retorna a lista de todos os campeões disponíveis.
- `GET /api/champions/{id}`: Retorna os detalhes de um campeão específico com o ID fornecido.
- `POST /api/champions`: Cria um novo campeão com base nos dados fornecidos.
- `PUT /api/champions/{id}`: Atualiza as informações de um campeão existente com o ID fornecido.
- `DELETE /api/champions/{id}`: Remove um campeão com o ID fornecido.

Esses endpoints são implementados nos controladores REST do Spring Boot e são acessíveis por meio de requisições HTTP.

## Inteligência Artificial com Spring Cloud OpenFeign

Para incorporar Inteligência Artificial (IA) ao **NeuroChatIA**, utilizamos o Spring Cloud OpenFeign para integrar-se facilmente com APIs de IA de grandes provedores, como OpenAI (GPT) e Google (Gemini). Algumas etapas importantes desta integração incluem:

- **Definição das Interfaces de Cliente**: Criamos interfaces de cliente com anotações Feign para definir os endpoints e as operações que serão consumidas das APIs de IA.

- **Configuração do Feign Client**: Utilizando anotações como `@FeignClient` e `@RequestMapping`, configuramos e injetamos os clientes Feign para se comunicar com as APIs de IA externas.

- **Integração com os Serviços de IA**: Podemos então chamar diretamente os métodos dos clientes Feign em nosso código para interagir com os serviços de IA externos, como gerar texto com base em uma entrada específica.

## Interface do Usuário com HTML, CSS e JavaScript

A interface do usuário (UI) do **NeuroChatIA** é construída utilizando conceitos básicos de HTML, CSS e JavaScript para fornecer uma experiência interativa e amigável aos usuários. Alguns elementos importantes da interface incluem:

- **Páginas HTML**: Criamos várias páginas HTML para representar diferentes partes da aplicação, como página inicial, visualização de campeões e formulários de interação.

- **Estilização com CSS**: Utilizamos folhas de estilo CSS para estilizar os elementos HTML, como cores, fontes, tamanhos e layouts.

- **Interações Dinâmicas com JavaScript**: Incorporamos scripts JavaScript para adicionar comportamentos dinâmicos à interface do usuário, como validação de formulários, carregamento assíncrono de dados e interatividade com elementos da página.

# Contribuidores

O projeto **NeuroChatIA** foi desenvolvido com a contribuição de:

- **Daniel Martins** - Desenvolvedor Full Stack, especializado em Java e Spring Boot. Contribuiu com a implementação da lógica de negócios, integração com bancos de dados e configuração do Spring Boot.
- Veja o perfil de Daniel Martins no [GitHub](https://github.com/Danielmadr).

- **Yasmin Barcelos** - Desenvolvedor Full Stack, especializado em Java e Spring Boot. Contribuiu com a implementação da lógica de negócios, integração com bancos de dados e configuração do Spring Boot.
- Veja o perfil de Yasmin Barcelos no [GitHub](https://github.com/yxsbx).
