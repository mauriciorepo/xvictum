package com.xvictum.model;

import javax.persistence.Entity;
//import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Version;




@Entity

public class AnoModelo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(nullable = false)
	private String anomodelo;

	@Column(nullable = false)
	private String codigo;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}
	@Column(nullable=false)
   private long Modelo_id;
	public long getModelo_id() {
		return Modelo_id;
	}

	public void setModelo_id(long modelo_id) {
		Modelo_id = modelo_id;
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
		if (!(obj instanceof AnoModelo)) {
			return false;
		}
		AnoModelo other = (AnoModelo) obj;
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

	public String getAnomodelo() {
		return anomodelo;
	}

	public void setAnomodelo(String anomodelo) {
		this.anomodelo = anomodelo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (anomodelo != null && !anomodelo.trim().isEmpty())
			result += "anomodelo: " + anomodelo;
		if (codigo != null && !codigo.trim().isEmpty())
			result += ", codigo: " + codigo;
		return result;
	}
}