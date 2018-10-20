package com.xvictum.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import com.xvictum.model.PlanodeContas;
import javax.persistence.OneToOne;
import com.xvictum.model.CentrodeCusto;

@Entity
public class RateioPlanoCentroContasaReceber implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(nullable = false)
	private double valor;

	@Column
	private String observacao;

	@OneToOne
	private PlanodeContas planodecontas;

	@OneToOne
	private CentrodeCusto centrodecusto;

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
		if (!(obj instanceof RateioPlanoCentroContasaReceber)) {
			return false;
		}
		RateioPlanoCentroContasaReceber other = (RateioPlanoCentroContasaReceber) obj;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public PlanodeContas getPlanodecontas() {
		return planodecontas;
	}

	public void setPlanodecontas(PlanodeContas planodecontas) {
		this.planodecontas = planodecontas;
	}

	public CentrodeCusto getCentrodecusto() {
		return centrodecusto;
	}

	public void setCentrodecusto(CentrodeCusto centrodecusto) {
		this.centrodecusto = centrodecusto;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		result += "valor: " + valor;
		if (observacao != null && !observacao.trim().isEmpty())
			result += ", observacao: " + observacao;
		return result;
	}
}