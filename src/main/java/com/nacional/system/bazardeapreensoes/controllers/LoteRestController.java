package com.nacional.system.bazardeapreensoes.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

import com.nacional.system.bazardeapreensoes.models.Lote;
import com.nacional.system.bazardeapreensoes.models.Produto;
import com.nacional.system.bazardeapreensoes.repositories.LoteRepository;
import com.nacional.system.bazardeapreensoes.repositories.ProdutoRepository;

@CrossOrigin("*")
@RestController
public class LoteRestController {

	@Autowired
	private LoteRepository loteRepo;
	
	@Autowired
	private ProdutoRepository produtosRepo;
	
	@CrossOrigin("*")
	@PostMapping(value="/cadastrarLote")
	public String cadastroDeLote(Model m, @RequestBody Lote lote) {
		List<Produto> produtos = lote.getProdutos();
		List<Produto> produtosAll = produtosRepo.findAll();
		List<Produto> produtosAdd = new ArrayList<>();
		for(Produto produtoAux : produtos) {
			for(Produto produtoAux2 : produtosAll) {
				if(produtoAux.getId() == produtoAux2.getId()) {
					produtosAdd.add(produtoAux2);
				}
			}
		}
		lote.setProdutos(produtosAdd);
		lote.setDataEntrega(LocalDateTime.now());
		loteRepo.save(lote);
		return "OK!";
	}
	
	@CrossOrigin("*")
	@PutMapping(value="/alterarCadastroLote")
	public String alterarCadastroLote(Model m, @RequestBody Lote lote) {
		loteRepo.save(lote);
		return "CADASTRO ALTERADO COM SUCESSO!";
	}
	
	@CrossOrigin("*")
	@GetMapping(value="/lote/{id}")
	public Lote lerLote(Model m, @PathVariable("id") Long id) {
		Optional<Lote> loteOptional = loteRepo.findById(id);
		if(loteOptional.isPresent()) {
			Lote loteEncontrado = loteOptional.get();
			return loteEncontrado;
		}
		return null;
	}
	
	@CrossOrigin("*")
	@DeleteMapping(value="/lote/delete/{id}")
	public String deletarLote(Model m, @PathVariable("id") Long id) {
		Optional<Lote> loteOptional = loteRepo.findById(id);
		if(loteOptional.isPresent()) {
			Lote loteEncontrado = loteOptional.get();
			loteRepo.delete(loteEncontrado);
			return "CADASTRO DE LOTE DELETADO COM SUCESSO!";
		}
		return "FALHA AO REALIZAR DELETE!";
	}
	
	@CrossOrigin("*")
	@GetMapping(value="/lote/Lista")
	public List<Lote> listaDeLotes(){
		List<Lote> listaDeLotes = loteRepo.findAll();
		return listaDeLotes;
	}
	
	@CrossOrigin("*")
	@GetMapping(value="/lote/Lista/{id}")
	public List<Lote> listaDeLotesDeOrgaoDonatario(@PathVariable("id") Long id){
		List<Lote> listaDeLotes = loteRepo.findAll();
		List<Lote> listaDeLotesDaEntidade = new ArrayList<>();
		for(Lote loteAux : listaDeLotes) {
			if(loteAux.getOrgaoDonatario().getId() == id) {
				listaDeLotesDaEntidade.add(loteAux);
			}
		}
		
		return listaDeLotesDaEntidade;
	}
}
