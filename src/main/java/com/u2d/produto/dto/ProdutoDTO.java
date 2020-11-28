package com.u2d.produto.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProdutoDTO extends RepresentationModel<ProdutoDTO> implements Serializable {

	private static final long serialVersionUID = 5281705337762211262L;
	
	private Long id;
	@NotNull
	@NotBlank
	private String nome;
	@NotNull
	private Integer estoque;
	@NotNull
	private Double preco;	
}
