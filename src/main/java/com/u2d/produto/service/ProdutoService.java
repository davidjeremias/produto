package com.u2d.produto.service;

import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.u2d.produto.dto.ProdutoDTO;
import com.u2d.produto.exception.ResourceNotFoundException;
import com.u2d.produto.model.Produto;
import com.u2d.produto.repository.ProdutoRepository;
import com.u2d.produto.util.PageableUtil;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	ModelMapper mapper;
	
	public ProdutoDTO save(ProdutoDTO produtoDTO) {
		Produto produto = repository.save(mapper.map(produtoDTO, Produto.class));
		return mapper.map(produto, ProdutoDTO.class);
	}
	
	public Page<ProdutoDTO> findAll(Map<String, String[]> filter) {
		var page = repository.findAll(PageableUtil.getPageableParams(filter, Direction.ASC, "nome"));
		return page.map(this::convertToProdutoDTO);
	}
	
	public ProdutoDTO convertToProdutoDTO(Produto produto) {
		return mapper.map(produto, ProdutoDTO.class);
	}
	
	public ProdutoDTO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return mapper.map(entity, ProdutoDTO.class);
	}
	
	public ProdutoDTO update(ProdutoDTO produtoDTO) {
		final Optional<Produto> optionalProduto = repository.findById(produtoDTO.getId());
		if(!optionalProduto.isPresent()) {
			new ResourceNotFoundException("No records found for this ID");
		}
		return mapper.map(repository.save(mapper.map(produtoDTO, Produto.class)), ProdutoDTO.class) ;
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
