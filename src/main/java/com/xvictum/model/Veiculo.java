package com.xvictum.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import com.xvictum.model.marca;
import javax.persistence.OneToOne;
import com.xvictum.model.Modelo;
import com.xvictum.model.AnoModelo;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "veiculo")
@XmlRootElement
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String cor;

	@Column
	private String chassi;

	@Column
	private long km;

	@Column
	private String combustivel;

	@Column
	private String renavam;

	@Column
	private String nummotor;

	@Column
	private String placa;

	@Column
	private String portas;

	@Column
	private Long volume;

	@Column
	private Long potencia;

	@Column
	private Long altura;

	@Column
	private Long pesomax;
	
	@Column
	private Long comprimento;

	
	@OneToOne
	@JoinColumn(name = "marca_id")
	private marca marca;

	@OneToOne
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;

	@OneToOne
	@JoinColumn(name = "anomodelo_id")
	private AnoModelo anomodelo;

	@Column(nullable = false)
	private boolean ativo;

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
		if (!(obj instanceof Veiculo)) {
			return false;
		}
		Veiculo other = (Veiculo) obj;
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

	
	public Long getComprimento() {
		return comprimento;
	}

	public void setComprimento(Long comprimento) {
		this.comprimento = comprimento;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public long getKm() {
		return km;
	}

	public void setKm(long km) {
		this.km = km;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getNummotor() {
		return nummotor;
	}

	public void setNummotor(String nummotor) {
		this.nummotor = nummotor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPortas() {
		return portas;
	}

	public void setPortas(String portas) {
		this.portas = portas;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public Long getPotencia() {
		return potencia;
	}

	public void setPotencia(Long potencia) {
		this.potencia = potencia;
	}

	public Long getAltura() {
		return altura;
	}

	public void setAltura(Long altura) {
		this.altura = altura;
	}

	public Long getPesomax() {
		return pesomax;
	}

	public void setPesomax(Long pesomax) {
		this.pesomax = pesomax;
	}

	public marca getMarca() {
		return marca;
	}

	public void setMarca(marca marca) {
		this.marca = marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public AnoModelo getAnomodelo() {
		return anomodelo;
	}

	public void setAnomodelo(AnoModelo anomodelo) {
		this.anomodelo = anomodelo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (cor != null && !cor.trim().isEmpty())
			result += "cor: " + cor;
		if (chassi != null && !chassi.trim().isEmpty())
			result += ", chassi: " + chassi;
		result += ", km: " + km;
		if (combustivel != null && !combustivel.trim().isEmpty())
			result += ", combustivel: " + combustivel;
		if (renavam != null && !renavam.trim().isEmpty())
			result += ", renavam: " + renavam;
		if (nummotor != null && !nummotor.trim().isEmpty())
			result += ", nummotor: " + nummotor;
		if (placa != null && !placa.trim().isEmpty())
			result += ", placa: " + placa;
		if (portas != null && !portas.trim().isEmpty())
			result += ", portas: " + portas;
		if (volume != null)
			result += ", volume: " + volume;
		if (potencia != null)
			result += ", potencia: " + potencia;
		if (altura != null)
			result += ", altura: " + altura;
		if (pesomax != null)
			result += ", pesomax: " + pesomax;
		result += ", ativo: " + ativo;
		return result;
	}
}