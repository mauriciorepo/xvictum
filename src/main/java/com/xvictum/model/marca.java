package com.xvictum.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
//import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

import com.xvictum.model.Modelo;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;


@Entity
@XmlRootElement
public class marca implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(
		    name = "native",
		    strategy = "native"
		)
	@GeneratedValue(
		    strategy= GenerationType.AUTO, generator="native")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	
	private long codigo;

	/*
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marca_id", referencedColumnName = "id")
    private Address address;
	
	*/
	@OneToMany( cascade= {CascadeType.REFRESH , CascadeType.PERSIST, CascadeType.DETACH })
	@JoinColumn(name = "marca_id",  nullable=false)
	private Set<Modelo> modelo = new HashSet<Modelo>();

	
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
		if (!(obj instanceof marca)) {
			return false;
		}
		marca other = (marca) obj;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		if (nome != null && !nome.trim().isEmpty())
			result += "nome: " + nome;
		result += ", codigo: " + codigo;
		return result;
	}

	public Set<Modelo> getModelo() {
		return this.modelo;
	}

	/*public void setModelo(final Set<Modelo> modelo) {
		this.modelo = modelo;
	}*/
    public void criaModelo(Modelo mod){
		
		if(this.modelo == null){
			modelo = new HashSet<Modelo>();
		}
		
		modelo.add(mod);
			
	}


	
}