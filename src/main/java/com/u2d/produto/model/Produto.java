package com.u2d.produto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "TB001_PRODUTO")
public class Produto implements Serializable{

	private static final long serialVersionUID = -3999108977025639654L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "CO_PRODUTO")
	private Long id;
	
	@Column(name = "NO_NOME", nullable = false)
	private String nome;
	
	@Column(name = "NU_ESTOQUE")
	@Builder.Default
	private Integer estoque = 0;
	
	@Column(name = "VL_PRECO", nullable = false)
	private Double preco;
}
