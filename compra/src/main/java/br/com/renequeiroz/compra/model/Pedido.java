package br.com.renequeiroz.compra.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "tb_pedido")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pedido implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @Min(1)
    private Long produto;

    @NotNull
    @Min(1)
    private BigDecimal valor;

    @NotNull
    //@JsonProperty("dataCompra")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataCompra;

    //@JsonProperty("cpfCliente")
    @NotBlank
    private String cpfCliente;

    @NotBlank
    private String cep;

    @NotBlank
    private String email;

}