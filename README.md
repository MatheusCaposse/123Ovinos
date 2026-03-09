                                                       123 OVINOS

O 123Ovinos é um sistema desenvolvido para auxiliar na gestão de rebanhos ovinos, permitindo o controle de animais, tratamentos, características e informações importantes para o manejo da criação.

O projeto tem como objetivo facilitar a organização e acompanhamento do rebanho, centralizando dados relevantes e permitindo uma melhor tomada de decisão na produção pecuária.

Este sistema está sendo desenvolvido como projeto de estudo e prática em desenvolvimento back-end com Java e arquitetura de APIs.

Funcionalidades
O sistema permite:

- Cadastro de ovinos
- Consulta de animais cadastrados
- Atualização de dados do animal
- Remoção de registros
- Registro de tratamentos realizados
- Controle de características e condições do animal
- Registro de raça, sexo e status do ovino
- Organização por lote (Batch)
- Tecnologias Utilizadas

Este projeto foi desenvolvido utilizando as seguintes tecnologias:

1)Back-end

- Java
- Spring Boot
- Spring Data JPA
- Hibernate

2)Banco de Dados

- mySQL

3)Outras Ferramentas

- Maven
- Postman para testes da API
- Versionamento com Git


O projeto segue uma arquitetura organizada em camadas:

- Controller → responsável pelos endpoints da API
- Service → regras de negócio
- Repository → comunicação com o banco de dados
- Entity → modelagem das entidades
- DTO → transferência de dados entre camadas
- Exception → tratamento de erros personalizados
exception

O sistema possui algumas entidades principais:

Sheep

Representa um ovino dentro do sistema que contém informações como:

- identificação
- raça
- sexo
- status
- características
- tratamentos
- lote

Objetivo do Projeto

O 123Ovinos foi criado com o objetivo de oferecer uma solução tecnológica para gestão de rebanhos ovinos, auxiliando produtores no controle e organização das informações do plantel.

O sistema permite centralizar dados importantes como cadastro de animais, tratamentos, características, condição do animal e organização por lotes, facilitando o acompanhamento do rebanho e apoiando a tomada de decisões no manejo da propriedade.

O projeto surge a partir de uma necessidade real de controle e gestão na criação de ovinos, buscando aplicar tecnologia no agronegócio para tornar o gerenciamento mais eficiente, organizado e acessível.

Além de sua aplicação prática, o sistema também representa uma iniciativa de desenvolvimento de software voltada para soluções aplicadas ao setor agropecuário, unindo conhecimento técnico em engenharia de software com demandas reais do campo.

Algumas melhorias planejadas para o projeto:

- Sistema de autenticação (Spring Security)
- Desenvolvimento de front-end em Angular
- Dashboard com métricas do rebanho
- Deploy em nuvem
