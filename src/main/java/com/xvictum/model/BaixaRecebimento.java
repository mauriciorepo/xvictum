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
import com.xvictum.model.ContasaReceber;
import javax.persistence.ManyToOne;

@Entity
public class BaixaRecebimento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	@Temporal(TemporalType.DATE)
	private Date databaixa;

	@Column
	private double valor;

	@ManyToOne
	@JoinColumn(name = "contasareceber_id")
	private ContasaReceber contasareceber;

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
		if (!(obj instanceof BaixaRecebimento)) {
			return false;
		}
		BaixaRecebimento other = (BaixaRecebimento) obj;
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

	public Date getDatabaixa() {
		return databaixa;
	}

	public void setDatabaixa(Date databaixa) {
		this.databaixa = databaixa;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		result += "valor: " + valor;
		return result;
	}

	public ContasaReceber getContasareceber() {
		return this.contasareceber;
	}

	public void setContasareceber(final ContasaReceber contasareceber) {
		this.contasareceber = contasareceber;
	}
}