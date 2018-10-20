package com.xvictum.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.xvictum.model.RateioPlanoCentroContasaReceber;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;

@Entity
public class ContasaReceber implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private boolean pago;

	@Column(nullable = false)
	private double valor;

	@Column(nullable = false)
	private double valorliquido;

	@Column
	private String notafiscal;

	@Column
	@Temporal(TemporalType.DATE)
	private Date data_emissao;

	@Column
	private String titulo;

	@Column
	private int parcelas;

	@Column
	private double multa;

	@Column
	private double juros;

	@Column
	private double desconto;

	@Column
	private String situacao;

	@Column
	private double irrf;

	@Column
	private double csll;

	@Column
	private double confins;

	@Column
	private String pls;

	@OneToMany
	@JoinColumn(name = "contasareceber_id")
	private Set<RateioPlanoCentroContasaReceber> rateioplanocentrocontasareceber = new HashSet<RateioPlanoCentroContasaReceber>();

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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ContasaReceber)) {
			return false;
		}
		ContasaReceber other = (ContasaReceber) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValorliquido() {
		return valorliquido;
	}

	public void setValorliquido(double valorliquido) {
		this.valorliquido = valorliquido;
	}

	public String getNotafiscal() {
		return notafiscal;
	}

	public void setNotafiscal(String notafiscal) {
		this.notafiscal = notafiscal;
	}

	public Date getData_emissao() {
		return data_emissao;
	}

	public void setData_emissao(Date data_emissao) {
		this.data_emissao = data_emissao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public double getIrrf() {
		return irrf;
	}

	public void setIrrf(double irrf) {
		this.irrf = irrf;
	}

	public double getCsll() {
		return csll;
	}

	public void setCsll(double csll) {
		this.csll = csll;
	}

	public double getConfins() {
		return confins;
	}

	public void setConfins(double confins) {
		this.confins = confins;
	}

	public String getPls() {
		return pls;
	}

	public void setPls(String pls) {
		this.pls = pls;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		result += "pago: " + pago;
		result += ", valor: " + valor;
		result += ", valorliquido: " + valorliquido;
		if (titulo != null && !titulo.trim().isEmpty())
			result += ", titulo: " + titulo;
		result += ", parcelas: " + parcelas;
		result += ", multa: " + multa;
		result += ", juros: " + juros;
		result += ", desconto: " + desconto;
		if (situacao != null && !situacao.trim().isEmpty())
			result += ", situacao: " + situacao;
		result += ", irrf: " + irrf;
		result += ", csll: " + csll;
		result += ", confins: " + confins;
		if (pls != null && !pls.trim().isEmpty())
			result += ", pls: " + pls;
		return result;
	}

	public Set<RateioPlanoCentroContasaReceber> getRateioplanocentrocontasareceber() {
		return this.rateioplanocentrocontasareceber;
	}

	public void setRateioplanocentrocontasareceber(
			final Set<RateioPlanoCentroContasaReceber> rateioplanocentrocontasareceber) {
		this.rateioplanocentrocontasareceber = rateioplanocentrocontasareceber;
	}
}