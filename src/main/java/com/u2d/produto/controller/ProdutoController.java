package com.u2d.produto.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.u2d.produto.dto.ProdutoDTO;
import com.u2d.produto.service.ProdutoService;

@RestController
@RequestMapping("/v1/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@Autowired
	private PagedResourcesAssembler<ProdutoDTO> assembler;
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> save(@Valid @RequestBody ProdutoDTO produtoDTO) {
		ProdutoDTO produto = service.save(produtoDTO);
		produto.add(linkTo(methodOn(ProdutoController.class).findById(produto.getId())).withSelfRel());
		return new ResponseEntity<ProdutoDTO>(produto, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(WebRequest request) {
		var page = service.findAll(request.getParameterMap());
		page.stream().forEach(prod -> prod.add(linkTo(methodOn(ProdutoController.class).findById(prod.getId())).withSelfRel()));
		PagedModel<EntityModel<ProdutoDTO>> pageModel = assembler.toModel(page);
		return !page.getContent().isEmpty() ? new ResponseEntity<>(pageModel, HttpStatus.OK)
				: new ResponseEntity<>(pageModel, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable("id") Long id) {
		ProdutoDTO produtoDTO = service.findById(id);
		return new ResponseEntity<ProdutoDTO>(produtoDTO, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ProdutoDTO> update(@Valid @RequestBody ProdutoDTO produtoDTO) {
		ProdutoDTO produto = service.update(produtoDTO);
		produtoDTO.add(linkTo(methodOn(ProdutoController.class).findById(produto.getId())).withSelfRel());
		return new ResponseEntity<ProdutoDTO>(produto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProdutoDTO> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<ProdutoDTO>(HttpStatus.OK);
	}
}
