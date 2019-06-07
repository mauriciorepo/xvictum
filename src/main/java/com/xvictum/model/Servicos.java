package com.xvictum.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;

import com.xvictum.model.suprimentos.Tipo_servico;

@Entity
public class Servicos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String descricao;

	@Column(nullable = false)
	private String tipo_servicos;
	
	@OneToOne
	@JoinColumn(name = "tipo_sistema_id")
	private Tipo_sistema tipo_sistema;

	public Tipo_sistema getTipo_sistema() {
		return tipo_sistema;
	}

	public void setTipo_sistema(Tipo_sistema tipo_sistema) {
		this.tipo_sistema = tipo_sistema;
	}

	public Tipo_servico getTipo_servico() {
		return tipo_servico;
	}

	public void setTipo_servico(Tipo_servico tipo_servico) {
		this.tipo_servico = tipo_servico;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@OneToOne
	@JoinColumn(name = "tipo_servico_id")
	private Tipo_servico tipo_servico;
	
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
		if (!(obj instanceof Servicos)) {
			return false;
		}
		Servicos other = (Servicos) obj;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo_servicos() {
		return tipo_servicos;
	}

	public void setTipo_servicos(String tipo_servicos) {
		this.tipo_servicos = tipo_servicos;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (descricao != null && !descricao.trim().isEmpty())
			result += "descricao: " + descricao;
		if (tipo_servicos != null && !tipo_servicos.trim().isEmpty())
			result += ", tipo_servicos: " + tipo_servicos;
		return result;
	}
}