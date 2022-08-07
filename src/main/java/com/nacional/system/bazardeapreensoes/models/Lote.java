package com.nacional.system.bazardeapreensoes.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Lote implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dataEntrega;
	private String observacao;
	
	@ManyToMany(mappedBy="lotes", fetch=FetchType.EAGER)
	private List<Produto> produtos = new ArrayList<Produto>();
	
	@ManyToOne
	private OrgaoDonatario orgaoDonatario;
	
	@ManyToOne
	private OrgaoFiscalizador orgaoFiscalizador;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public OrgaoDonatario getOrgaoDonatario() {
		return orgaoDonatario;
	}
	public void setOrgaoDonatario(OrgaoDonatario orgaoDonatario) {
		this.orgaoDonatario = orgaoDonatario;
	}
	public OrgaoFiscalizador getOrgaoFiscalizador() {
		return orgaoFiscalizador;
	}
	public void setOrgaoFiscalizador(OrgaoFiscalizador orgaoFiscalizador) {
		this.orgaoFiscalizador = orgaoFiscalizador;
	}

}
