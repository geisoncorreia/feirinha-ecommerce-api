# feirinha-ecommerce-api

Staus: Em desemvolvimento

Api que irá prover a infraestrutura de cadastros, relatórios, login e serviçoes para a criação de campanha de venda de produtos.

Tecnologias aplicadas: Spring boot, Spring data, Spring MVC, Teste de integração com spring e banco H2, Hibernate/JPA, Lombok, Mapstruct, Spring Bean Validation, Banco PostgreSql, Docker, Swagger

Para acesso o os métodos via Swagger: http://localhost:8080/swagger-ui.html

Executar a aplicação

Na raiz do projeto:

- Primeiro passo: Subir a instância do PostgreSql
 -  Execute o camando:
    
    sudo docker-compose up --build -d

- Segundo Passo: Subir a apliacão
  - Execute o seguinte comando:
  
    ./mvnw spring-boot:run




