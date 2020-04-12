insert into Endereco values ('e9a4fd4a-118e-49db-a473-4c6607d4ace7', 'CE', 'Fortaleza', 'Rua Azul', '20');
insert into Pessoa values ('14ec51ec-5bef-4ae3-90c4-c862803fdcbd', 'luiza@gmail.com', 7, 'Luiza Correia', 'e9a4fd4a-118e-49db-a473-4c6607d4ace7');
insert into Cliente values ('74fc3892-0929-4f07-b66f-eac4b21ada0d', 'Luiza Correia', '14ec51ec-5bef-4ae3-90c4-c862803fdcbd');

insert into Endereco values ('18b3c9e0-8969-46d9-bfc2-66faee9d0175', 'CE', 'Fortaleza', 'Av Esquina hum', '752');
insert into Pessoa values ('e9a4fd4a-118e-49db-a473-4c6607d4ace7', 'fornecedor1@gmail.com', null, 'fornecedor1', '18b3c9e0-8969-46d9-bfc2-66faee9d0175');
insert into Fornecedor values ('60266679-9b74-469c-a96d-6f6cc45779a2', 'Fornecedor 1', 'e9a4fd4a-118e-49db-a473-4c6607d4ace7');

insert into Preco values ('b8627e52-ddf2-4bc2-a833-4003d632bcbd', '2020-12-04 00:00:00', 50.00 );

insert into Produto values ('b43cbb2d-efbe-4d60-a455-023ee650ddfa', 'Castanha de Cajú Orgâncica Natural', 'Castanha de Cajú', '60266679-9b74-469c-a96d-6f6cc45779a2', 'b8627e52-ddf2-4bc2-a833-4003d632bcbd');