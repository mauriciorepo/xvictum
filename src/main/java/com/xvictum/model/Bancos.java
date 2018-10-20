package com.xvictum.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;

@Entity
public class Bancos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 5, nullable = false)
	private String codbacen;

	@Column
	private String nome;

	@Column
	private String site;

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
		if (!(obj instanceof Bancos)) {
			return false;
		}
		Bancos other = (Bancos) obj;
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

	public String getCodbacen() {
		return codbacen;
	}

	public void setCodbacen(String codbacen) {
		this.codbacen = codbacen;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (codbacen != null && !codbacen.trim().isEmpty())
			result += "codbacen: " + codbacen;
		if (nome != null && !nome.trim().isEmpty())
			result += ", nome: " + nome;
		if (site != null && !site.trim().isEmpty())
			result += ", site: " + site;
		return result;
	}
}