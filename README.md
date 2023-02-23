# Clean Architecture - Arquitetura Limpa
***
Projeto para colocar em prática os conceitos de Clean Architecture para dar continuidade a um projeto que foi inteiramente adequado ao DDD tático. O que em comum nesse assunto? o DDD se torna uma premissa de aplicação em projetos Clean Arch, até mesmo por quê, as aquiteturas em camadas dispostas no mercado hoje em dia são todas DDD Friendly.

## Exemplos de projetos com arquitetura limpa - clean architecture
***
Baseando-se no artigo: [Multiple ways of defining Clean Architecture layers](https://proandroiddev.com/multiple-ways-of-defining-clean-architecture-layers-bbb70afa5d4a) temos 4 branches que exemplificam maneiras possíveis de aplicar os conceitos de clean architecture em seus projetos.
1. CA-layers-single-module - Camadas em um único módulo
![CleanArchi-CA layers in a single module.png](imagens%2FCleanArchi-CA%20layers%20in%20a%20single%20module.png)
2. CA-one-layer-per-module - Uma camada por módulo
![CleanArchi-One CA layer per module.png](imagens%2FCleanArchi-One%20CA%20layer%20per%20module.png)
3. CA-layers-inside-feature-module - Camadas em um módulo de feature
![CleanArchi- CA layers inside the feature module.png](imagens%2FCleanArchi-%20CA%20layers%20inside%20the%20feature%20module.png)
4. CA-layers-per-feature-module - Camadas nos módulos das features
![CleanArchi-CA layers per feature modules.png](imagens%2FCleanArchi-CA%20layers%20per%20feature%20modules.png)

# Simulacao
***

A solução desse código foi feita com base na jornada:
![simulacao-jornada.png](imagens/simulacao-jornada.png)

Nesse código fonte você irá encontrar as seguintes modelagens implementadas:

### Domínio
![simulacao-dominio.png](imagens/simulacao-dominio.png)

### Agregados
![simulacao-agregados.png](imagens/simulacao-agregados.png)

### Entidades
![simulacao-entidades.png](imagens/simulacao-entidades.png)

### Fábricas
![simulacao-fabricaCase.png](imagens/simulacao-fabricaCase.png)

### Módulos
![simulacao-modulos.png](imagens/simulacao-modulos.png)

### Repositórios
![simulacao-repositorios.png](imagens/simulacao-repositorios.png)

# Run
***
Após executar a aplicação Springboot acesse: http://localhost:8080/swagger-ui/#/ ára ler a documentação da API


# Database
***
Após executar a aplicação caso queira acessar o banco de dados vá por essa url: http://localhost:8080/h2-console/