package com.xvictum.model.suprimentos;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Version;
import java.math.BigDecimal;

@Entity
public class ConversaoMedidas implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private static final long serialVersionUID = 1L;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private int unidade_entrada;

	@Column
	private BigDecimal fator_entrada;

	@Column
	private int unidade_estoque;

	@Column
	private int unidade_saida;

	@Column
	private int fator_saida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ConversaoMedidas)) {
			return false;
		}
		ConversaoMedidas other = (ConversaoMedidas) obj;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getUnidade_entrada() {
		return unidade_entrada;
	}

	public void setUnidade_entrada(int unidade_entrada) {
		this.unidade_entrada = unidade_entrada;
	}

	public BigDecimal getFator_entrada() {
		return fator_entrada;
	}

	public void setFator_entrada(BigDecimal fator_entrada) {
		this.fator_entrada = fator_entrada;
	}

	public int getUnidade_estoque() {
		return unidade_estoque;
	}

	public void setUnidade_estoque(int unidade_estoque) {
		this.unidade_estoque = unidade_estoque;
	}

	public int getUnidade_saida() {
		return unidade_saida;
	}

	public void setUnidade_saida(int unidade_saida) {
		this.unidade_saida = unidade_saida;
	}

	public int getFator_saida() {
		return fator_saida;
	}

	public void setFator_saida(int fator_saida) {
		this.fator_saida = fator_saida;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		result += "unidade_entrada: " + unidade_entrada;
		result += ", unidade_estoque: " + unidade_estoque;
		result += ", unidade_saida: " + unidade_saida;
		result += ", fator_saida: " + fator_saida;
		return result;
	}
}