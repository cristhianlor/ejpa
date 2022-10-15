package com.algaworks.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class NotaFiscal {

    @EqualsAndHashCode.Include
    @Id
    private Integer id;
    @Column(name = "pedido_id")
    private Integer pedidoId;
    private String xml;
    @Column(name = "data_emissao")
    private Date dataEmissao;

}
