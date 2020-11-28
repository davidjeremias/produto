package com.u2d.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.cdi.Eager;

import com.u2d.produto.model.Produto;

@Eager
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
