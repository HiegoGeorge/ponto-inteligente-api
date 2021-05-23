package com.hiego.pontointeligente.api.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5549464650949471814L;
	
	private long id;
	private String razaoSocial;
	private String cnpj;
	private Date dataCraicao;
	private Date dataAtualizacao;
	private List<Funcionario> funcionario;
	
	public Empresa() {
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "razao_social", nullable = false)
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Column(name = "cnpj", nullable = false)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "data_criacao", nullable = false)
	public Date getDataCraicao() {
		return dataCraicao;
	}

	public void setDataCraicao(Date dataCraicao) {
		this.dataCraicao = dataCraicao;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "data_atualizacao", nullable = false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}


	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Funcionario> getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
		
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCraicao = atual;
		dataAtualizacao = atual;

	}


	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataCraicao=" + dataCraicao
				+ ", dataAtualizacao=" + dataAtualizacao + "]";
	}
	
	
	
	

}
