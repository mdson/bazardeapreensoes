package com.nacional.system.bazardeapreensoes.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nacional.system.bazardeapreensoes.models.Produto;
import com.nacional.system.bazardeapreensoes.repositories.ProdutoRepository;

@RestController
@CrossOrigin("*")
public class ProdutoRestController {

	@Autowired
	private ProdutoRepository produtoRepo;
	
	@PostMapping(value="/cadastrarProduto")
	public String cadastroDeProduto(Model m, @RequestBody Produto produto) {
		produtoRepo.save(produto);
		return "OK!";
	}
	
	@PutMapping(value="/alterarCadastroProduto")
	public String alterarCadastroProduto(Model m, @RequestBody Produto produto) {
		produtoRepo.save(produto);
		return "CADASTRO ALTERADO COM SUCESSO!";
	}
	
	@GetMapping(value="/Produto/{id}")
	public Produto lerProduto(Model m, @PathVariable("id") Long id) {
		Optional<Produto> produtoOptional = produtoRepo.findById(id);
		if(produtoOptional.isPresent()) {
			Produto produtoEncontrado = produtoOptional.get();
			return produtoEncontrado;
		}
		return null;
	}
	
	@DeleteMapping(value="/produto/delete/{id}")
	public String deletarProduto(Model m, @PathVariable("id") Long id) {
		Optional<Produto> produtoOptional = produtoRepo.findById(id);
		if(produtoOptional.isPresent()) {
			Produto produtoEncontrado = produtoOptional.get();
			produtoRepo.delete(produtoEncontrado);
			return "CADASTRO DE PRODUTO DELETADO COM SUCESSO!";
		}
		return "FALHA AO REALIZAR DELETE!";
	}
	
	@GetMapping(value="/produto/Lista")
	public List<Produto> listaDeProdutos(){
		List<Produto> produtos = produtoRepo.findAll();
		return produtos;
	}
}
