package com.xvictum.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Version;

import com.xvictum.model.AnoModelo;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;

@Entity

public class Modelo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(nullable = false)
	private String modelo;

	@Column(nullable = false)
	
	private long codigo;
	@Column(nullable = false)
	
	

	@OneToMany( fetch=FetchType.LAZY)
	@JoinColumn(name="Modelo_id")
	private Set<AnoModelo> AnoModelo = new HashSet<AnoModelo>();

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
		if (!(obj instanceof Modelo)) {
			return false;
		}
		Modelo other = (Modelo) obj;
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (modelo != null && !modelo.trim().isEmpty())
			result += "modelo: " + modelo;
		result += ", codigo: " + codigo;
		return result;
	}

	public Set<AnoModelo> getAnoModelo() {
		return this.AnoModelo;
	}

	public void setAnoModelo(final Set<AnoModelo> AnoModelo) {
		this.AnoModelo = AnoModelo;
	}
}