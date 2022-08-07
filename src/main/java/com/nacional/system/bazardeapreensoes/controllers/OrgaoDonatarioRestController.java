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
import com.nacional.system.bazardeapreensoes.models.OrgaoDonatario;
import com.nacional.system.bazardeapreensoes.repositories.OrgaoDonatarioRepository;

@RestController
@CrossOrigin("*")
public class OrgaoDonatarioRestController {

	@Autowired
	private OrgaoDonatarioRepository orgaoDonatarioRepo;
	
	@PostMapping(value="/cadastrarOrgaoDonatario")
	public String cadastroDeOrgaoDonatario(Model m, @RequestBody OrgaoDonatario orgaoDonatario) {
		orgaoDonatarioRepo.save(orgaoDonatario);
		return "OK!";
	}
	
	@PutMapping(value="/alterarCadastroOrgaoDonatario")
	public String alterarCadastroOrgaoDonatario(Model m, @RequestBody OrgaoDonatario orgaoDonatario) {
		orgaoDonatarioRepo.save(orgaoDonatario);
		return "CADASTRO ALTERADO COM SUCESSO!";
	}
	
	@GetMapping(value="/orgaoDonatario/{id}")
	public OrgaoDonatario lerOrgaoDonatario(Model m, @PathVariable("id") Long id) {
		Optional<OrgaoDonatario> orgaoOptional = orgaoDonatarioRepo.findById(id);
		if(orgaoOptional.isPresent()) {
			OrgaoDonatario orgaoEncontrado = orgaoOptional.get();
			return orgaoEncontrado;
		}
		return null;
	}
	
	@DeleteMapping(value="/orgaoDonatario/delete/{id}")
	public String deletarOrgaoDonatario(Model m, @PathVariable("id") Long id) {
		Optional<OrgaoDonatario> orgaoOptional = orgaoDonatarioRepo.findById(id);
		if(orgaoOptional.isPresent()) {
			OrgaoDonatario orgaoEncontrado = orgaoOptional.get();
			orgaoDonatarioRepo.delete(orgaoEncontrado);
			return "CADASTRO DE ORGAO DONATARIO DELETADO COM SUCESSO!";
		}
		return "FALHA AO REALIZAR DELETE!";
	}
	
	@GetMapping(value="/orgaoDonatario/Lista")
	public List<OrgaoDonatario> listaDeOrgaosDonatarios(){
		List<OrgaoDonatario> listaOrgaosDonatarios = orgaoDonatarioRepo.findAll();
		return listaOrgaosDonatarios;
	}
}
