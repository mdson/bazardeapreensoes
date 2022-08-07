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
import com.nacional.system.bazardeapreensoes.models.OrgaoFiscalizador;
import com.nacional.system.bazardeapreensoes.repositories.OrgaoFiscalizadorRepository;

@RestController
@CrossOrigin("*")
public class OrgaoFiscalizadorRestController {

	@Autowired
	private OrgaoFiscalizadorRepository orgaoFiscalizadorRepo;
	
	@PostMapping(value="/cadastrarOrgaoFiscalizador")
	public String cadastroDeOrgaoFiscalizador(Model m, @RequestBody OrgaoFiscalizador orgaoFiscalizador) {
		orgaoFiscalizadorRepo.save(orgaoFiscalizador);
		return "OK!";
	}
	
	@PutMapping(value="/alterarCadastroOrgaoFiscalizador")
	public String alterarCadastroOrgaoFiscalizador(Model m, @RequestBody OrgaoFiscalizador orgaoFiscalizador) {
		orgaoFiscalizadorRepo.save(orgaoFiscalizador);
		return "CADASTRO ALTERADO COM SUCESSO!";
	}
	
	@GetMapping(value="/orgaoFiscalizador/{id}")
	public OrgaoFiscalizador lerOrgaoFiscalizador(Model m, @PathVariable("id") Long id) {
		Optional<OrgaoFiscalizador> orgao = orgaoFiscalizadorRepo.findById(id);
		if(orgao.isPresent()) {
			OrgaoFiscalizador orgaoEncontrado = orgao.get();
			return orgaoEncontrado;
		}
		return null;
	}
	
	@DeleteMapping(value="/orgaoFiscalizador/delete/{id}")
	public String deletarOrgaoFiscalizador(Model m, @PathVariable("id") Long id) {
		Optional<OrgaoFiscalizador> orgao = orgaoFiscalizadorRepo.findById(id);
		if(orgao.isPresent()) {
			OrgaoFiscalizador orgaoEncontrado = orgao.get();
			orgaoFiscalizadorRepo.delete(orgaoEncontrado);
			return "CADASTRO DE ORGAO FISCALIZADOR DELETADO COM SUCESSO!";
		}
		return "FALHA AO REALIZAR DELETE!";
	}
	
	@GetMapping(value="/orgaoFiscalizador/Lista")
	public List<OrgaoFiscalizador> listaDeOrgaosFiscalizadores(){
		List<OrgaoFiscalizador> listaOrgaosFiscalizadores = orgaoFiscalizadorRepo.findAll();
		return listaOrgaosFiscalizadores;
	}
}
