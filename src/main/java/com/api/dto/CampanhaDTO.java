package com.api.dto;
import com.api.model.Pessoa;
import com.api.model.Produto;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class CampanhaDTO {

    private String descricao;
    private String fornecedor;
    private UUID produto;
    private BigDecimal preco;
    private Date dataFinal;
    private Date dataCricao;
    private String localEntrega;
    private List<UUID> interessados;
}
