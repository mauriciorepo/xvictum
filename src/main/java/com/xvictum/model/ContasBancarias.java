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
import com.xvictum.model.Bancos;
import javax.persistence.OneToOne;

@Entity
public class ContasBancarias implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 20, nullable = false)
	private String conta;

	@Column(length = 10, nullable = false)
	private String agencia;

	@Column
	private String cheques;

	@Column
	private boolean ativo;

	@Column
	private String telefone;

	@Column
	private String nome;

	@Column
	@Temporal(TemporalType.DATE)
	private Date datasaldoabertura;

	@Column
	private double valorsaldoabertura;

	@Column
	@Temporal(TemporalType.DATE)
	private Date vencimentolimite;

	@Column
	private double limitecredito;

	@Column
	private String dvconta;

	@Column
	private String dvagencia;

	@OneToOne
	private Bancos banco;

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
		if (!(obj instanceof ContasBancarias)) {
			return false;
		}
		ContasBancarias other = (ContasBancarias) obj;
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

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getCheques() {
		return cheques;
	}

	public void setCheques(String cheques) {
		this.cheques = cheques;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatasaldoabertura() {
		return datasaldoabertura;
	}

	public void setDatasaldoabertura(Date datasaldoabertura) {
		this.datasaldoabertura = datasaldoabertura;
	}

	public double getValorsaldoabertura() {
		return valorsaldoabertura;
	}

	public void setValorsaldoabertura(double valorsaldoabertura) {
		this.valorsaldoabertura = valorsaldoabertura;
	}

	public Date getVencimentolimite() {
		return vencimentolimite;
	}

	public void setVencimentolimite(Date vencimentolimite) {
		this.vencimentolimite = vencimentolimite;
	}

	public double getLimitecredito() {
		return limitecredito;
	}

	public void setLimitecredito(double limitecredito) {
		this.limitecredito = limitecredito;
	}

	public String getDvconta() {
		return dvconta;
	}

	public void setDvconta(String dvconta) {
		this.dvconta = dvconta;
	}

	public String getDvagencia() {
		return dvagencia;
	}

	public void setDvagencia(String dvagencia) {
		this.dvagencia = dvagencia;
	}

	public Bancos getBanco() {
		return banco;
	}

	public void setBanco(Bancos banco) {
		this.banco = banco;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (conta != null && !conta.trim().isEmpty())
			result += "conta: " + conta;
		if (agencia != null && !agencia.trim().isEmpty())
			result += ", agencia: " + agencia;
		if (cheques != null && !cheques.trim().isEmpty())
			result += ", cheques: " + cheques;
		result += ", ativo: " + ativo;
		if (telefone != null && !telefone.trim().isEmpty())
			result += ", telefone: " + telefone;
		if (nome != null && !nome.trim().isEmpty())
			result += ", nome: " + nome;
		result += ", valorsaldoabertura: " + valorsaldoabertura;
		result += ", limitecredito: " + limitecredito;
		if (dvconta != null && !dvconta.trim().isEmpty())
			result += ", dvconta: " + dvconta;
		if (dvagencia != null && !dvagencia.trim().isEmpty())
			result += ", dvagencia: " + dvagencia;
		return result;
	}
}