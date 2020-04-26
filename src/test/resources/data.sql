insert into Endereco values ('e9a4fd4a-118e-49db-a473-4c6607d4ace7', 'CE', 'Fortaleza', 'Rua Azul', '20');
insert into Endereco values ('18b3c9e0-8969-46d9-bfc2-66faee9d0175', 'CE', 'Fortaleza', 'Av Esquina hum', '752');

insert into
    Pessoa(id,
           email,
           idade,
           nome,
           tipo_pessoa,
           endereco_id,
           data_exclusao)
    values ('e9a4fd4a-118e-49db-a473-4c6607d4ace7', 'fornecedor1@gmail.com', null, 'Fornecedor 1', 2, '18b3c9e0-8969-46d9-bfc2-66faee9d0175', null);

insert into
    Pessoa(id,
           email,
           idade,
           nome,
           tipo_pessoa,
           endereco_id,
           data_exclusao)
values ('14ec51ec-5bef-4ae3-90c4-c862803fdcbd', 'luiza@gmail.com', 7, 'Luiza Correia', 1, 'e9a4fd4a-118e-49db-a473-4c6607d4ace7', null);

insert into Preco values ('b8627e52-ddf2-4bc2-a833-4003d632bcbd', '2020-12-04 00:00:00', 50.00 );
insert into Produto values ('b43cbb2d-efbe-4d60-a455-023ee650ddfa', 'Castanha de Cajú Orgâncica Natural', 'Castanha de Cajú', 'e9a4fd4a-118e-49db-a473-4c6607d4ace7', 'b8627e52-ddf2-4bc2-a833-4003d632bcbd');
