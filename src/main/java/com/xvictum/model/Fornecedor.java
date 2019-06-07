package com.xvictum.model;

import javax.persistence.Entity;
import java.io.Serializable;


import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Version;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;




@Entity
@XmlRootElement
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	
	/*@GeneratedValue(generator="myGenerator")
	@GenericGenerator(name="myGenerator", strategy="com.xvictum.rest.util.UseExistingIdOtherwiseGenerateUsingIdentity") 
	*/
	
	@GenericGenerator(
		    name = "native",
		    strategy = "native"
		)
	@GeneratedValue(
		    strategy= GenerationType.AUTO, generator="native")
	@Column(name = "id",  nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(nullable = false)
	private String fantasia;

	@Column
	private String razaosocial;
	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	@Column(nullable = false)
	private String tipo;

	@Column
	private String tipoatividade;

	@Column
	private String cnpj;

	@Column
	private String ie;

	@Column
	private String im;

	@Column
	private String suframa;

	@Column
	private String rg;

	@Column
	private boolean ativo;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Column
	private String cep;

	@Column
	private String logradouro;

	@Column
	private String numero;

	@Column
	private String complemento;

	@Column
	private String bairro;

	@Column
	private String ibge;

	@Column
	private String telefone;

	@Column
	private String telefone2;

	@Column
	private String optensn;

	@Column
	private double retpis;

	@Column
	private double retconfins;

	@Column
	private double retcsll;

	@Column
	private double retirrf;

	@Column
	private double retinss;

	@Column
	@Temporal(TemporalType.DATE)
	private Date datainc2;

	@Column
	@Temporal(TemporalType.DATE)
	private Date databloqueio;

	@Column
	@Temporal(TemporalType.DATE)
	private Date datainativo;

	@Column
	private String homepage;

	@Column
	@Temporal(TemporalType.DATE)
	private Date datainc;

	@Column
	private String cpf;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoatividade() {
		return tipoatividade;
	}

	public void setTipoatividade(String tipoatividade) {
		this.tipoatividade = tipoatividade;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getIm() {
		return im;
	}

	public void setIm(String im) {
		this.im = im;
	}

	public String getSuframa() {
		return suframa;
	}

	public void setSuframa(String suframa) {
		this.suframa = suframa;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getOptensn() {
		return optensn;
	}

	public void setOptensn(String optensn) {
		this.optensn = optensn;
	}

	public double getRetpis() {
		return retpis;
	}

	public void setRetpis(double retpis) {
		this.retpis = retpis;
	}

	public double getRetconfins() {
		return retconfins;
	}

	public void setRetconfins(double retconfins) {
		this.retconfins = retconfins;
	}

	public double getRetcsll() {
		return retcsll;
	}

	public void setRetcsll(double retcsll) {
		this.retcsll = retcsll;
	}

	public double getRetirrf() {
		return retirrf;
	}

	public void setRetirrf(double retirrf) {
		this.retirrf = retirrf;
	}

	public double getRetinss() {
		return retinss;
	}

	public void setRetinss(double retinss) {
		this.retinss = retinss;
	}

	public Date getDatainc2() {
		return datainc2;
	}

	public void setDatainc2(Date datainc2) {
		this.datainc2 = datainc2;
	}

	public Date getDatabloqueio() {
		return databloqueio;
	}

	public void setDatabloqueio(Date databloqueio) {
		this.databloqueio = databloqueio;
	}

	public Date getDatainativo() {
		return datainativo;
	}

	public void setDatainativo(Date datainativo) {
		this.datainativo = datainativo;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public Date getDatainc() {
		return datainc;
	}

	public void setDatainc(Date datainc) {
		this.datainc = datainc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (fantasia != null && !fantasia.trim().isEmpty())
			result += "fantasia: " + fantasia;
		result += ", tipo: " + tipo;
		result += ", tipoatividade: " + tipoatividade;
		if (cnpj != null && !cnpj.trim().isEmpty())
			result += ", cnpj: " + cnpj;
		if (ie != null && !ie.trim().isEmpty())
			result += ", ie: " + ie;
		if (im != null && !im.trim().isEmpty())
			result += ", im: " + im;
		if (suframa != null && !suframa.trim().isEmpty())
			result += ", suframa: " + suframa;
		if (rg != null && !rg.trim().isEmpty())
			result += ", rg: " + rg;
		result += ", ativo: " + ativo;
		if (cep != null && !cep.trim().isEmpty())
			result += ", cep: " + cep;
		if (logradouro != null && !logradouro.trim().isEmpty())
			result += ", logradouro: " + logradouro;
		if (numero != null && !numero.trim().isEmpty())
			result += ", numero: " + numero;
		if (complemento != null && !complemento.trim().isEmpty())
			result += ", complemento: " + complemento;
		if (bairro != null && !bairro.trim().isEmpty())
			result += ", bairro: " + bairro;
		if (ibge != null && !ibge.trim().isEmpty())
			result += ", ibge: " + ibge;
		if (telefone != null && !telefone.trim().isEmpty())
			result += ", telefone: " + telefone;
		if (telefone2 != null && !telefone2.trim().isEmpty())
			result += ", telefone2: " + telefone2;
		result += ", optensn: " + optensn;
		result += ", retpis: " + retpis;
		result += ", retconfins: " + retconfins;
		result += ", retcsll: " + retcsll;
		result += ", retirrf: " + retirrf;
		result += ", retinss: " + retinss;
		if (homepage != null && !homepage.trim().isEmpty())
			result += ", homepage: " + homepage;
		if (cpf != null && !cpf.trim().isEmpty())
			result += ", cpf: " + cpf;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Fornecedor)) {
			return false;
		}
		Fornecedor other = (Fornecedor) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

}