package br.com.exemplos.models;

import lombok.*;

import java.math.BigDecimal;

/**
 * Created by bruno on 20/07/17.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"codigo"})
@NoArgsConstructor
@AllArgsConstructor
public class Talhao {

    private String codigo;
    private BigDecimal area;
    private String codigoSetor;
}
