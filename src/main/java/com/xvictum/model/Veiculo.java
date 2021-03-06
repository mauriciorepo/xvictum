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
    private String anofabricacao;
    
    @Column
    private Long anomodelo;
    	
    
    public Long getAnomodelo() {
		return anomodelo;
	}

	public void setAnomodelo(Long anomodelo) {
		this.anomodelo = anomodelo;
	}

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

	/*@OneToOne
	@JoinColumn(name = "anomodelo_id")
	private AnoModelo anomodelo;
*/
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (altura == null) {
			if (other.altura != null)
				return false;
		} else if (!altura.equals(other.altura))
			return false;
		if (ativo != other.ativo)
			return false;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (combustivel == null) {
			if (other.combustivel != null)
				return false;
		} else if (!combustivel.equals(other.combustivel))
			return false;
		if (comprimento == null) {
			if (other.comprimento != null)
				return false;
		} else if (!comprimento.equals(other.comprimento))
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (km != other.km)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (nummotor == null) {
			if (other.nummotor != null)
				return false;
		} else if (!nummotor.equals(other.nummotor))
			return false;
		if (pesomax == null) {
			if (other.pesomax != null)
				return false;
		} else if (!pesomax.equals(other.pesomax))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (portas == null) {
			if (other.portas != null)
				return false;
		} else if (!portas.equals(other.portas))
			return false;
		if (potencia == null) {
			if (other.potencia != null)
				return false;
		} else if (!potencia.equals(other.potencia))
			return false;
		if (renavam == null) {
			if (other.renavam != null)
				return false;
		} else if (!renavam.equals(other.renavam))
			return false;
		if (version != other.version)
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((altura == null) ? 0 : altura.hashCode());
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + ((combustivel == null) ? 0 : combustivel.hashCode());
		result = prime * result + ((comprimento == null) ? 0 : comprimento.hashCode());
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (km ^ (km >>> 32));
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((nummotor == null) ? 0 : nummotor.hashCode());
		result = prime * result + ((pesomax == null) ? 0 : pesomax.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((portas == null) ? 0 : portas.hashCode());
		result = prime * result + ((potencia == null) ? 0 : potencia.hashCode());
		result = prime * result + ((renavam == null) ? 0 : renavam.hashCode());
		result = prime * result + version;
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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


	public String getAnofabricacao() {
		return anofabricacao;
	}

	public void setAnofabricacao(String anofabricacao) {
		this.anofabricacao = anofabricacao;
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

	/*public AnoModelo getAnomodelo() {
		return anomodelo;
	}

	public void setAnomodelo(AnoModelo anomodelo) {
		this.anomodelo = anomodelo;
	}*/

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