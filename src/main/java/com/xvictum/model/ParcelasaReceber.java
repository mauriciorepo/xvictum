package com.xvictum.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.xvictum.model.ContasBancarias;
import javax.persistence.OneToOne;

@Entity
public class ParcelasaReceber implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String meiopagamento;

	@Column
	private int numpagamento;

	@Column
	private int numparcela;

	@Column
	@Temporal(TemporalType.DATE)
	private Date vencimento;

	@Column
	private double valor;

	@OneToOne
	private ContasBancarias contabancaria;

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
		if (!(obj instanceof ParcelasaReceber)) {
			return false;
		}
		ParcelasaReceber other = (ParcelasaReceber) obj;
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

	public String getMeiopagamento() {
		return meiopagamento;
	}

	public void setMeiopagamento(String meiopagamento) {
		this.meiopagamento = meiopagamento;
	}

	public int getNumpagamento() {
		return numpagamento;
	}

	public void setNumpagamento(int numpagamento) {
		this.numpagamento = numpagamento;
	}

	public int getNumparcela() {
		return numparcela;
	}

	public void setNumparcela(int numparcela) {
		this.numparcela = numparcela;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public ContasBancarias getContabancaria() {
		return contabancaria;
	}

	public void setContabancaria(ContasBancarias contabancaria) {
		this.contabancaria = contabancaria;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (meiopagamento != null && !meiopagamento.trim().isEmpty())
			result += "meiopagamento: " + meiopagamento;
		result += ", numpagamento: " + numpagamento;
		result += ", numparcela: " + numparcela;
		result += ", valor: " + valor;
		return result;
	}
}