package com.xvictum.model.geral;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Produto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private static final long serialVersionUID = 1L;
	@Version
	@Column(name = "version")
	private int version;

	@Column(nullable = false)
	private String descricao;

	@Column
	private String codbarras;

	@Column
	private String fabricante;

	@Column(nullable = false)
	private boolean ativo;

	@Column
	private BigDecimal peso_bruto;

	@Column
	@Temporal(TemporalType.DATE)
	private Date data_inclusao;

	@Column
	@Temporal(TemporalType.DATE)
	private Date data_alteracao;

	@Column
	private String ean;

	@Column
	private BigDecimal volume;

	@Column
	private BigDecimal preco_base;

	@Column
	private BigDecimal preco_fornecedor;

	@Column
	private BigDecimal margem_preco_base;

	@Column
	private BigDecimal margem_preco_promocional;

	@Column
	private boolean lote;

	@Column
	private boolean serie;

	@Column
	private BigDecimal estoque_minimo;

	@Column
	private BigDecimal estoque_maximo;

	@Column
	private BigDecimal lote_compra;

	@Column
	@Temporal(TemporalType.DATE)
	private Date validade;

	@Column
	@Temporal(TemporalType.DATE)
	private Date data_fabricacao;

	@Column
	private BigDecimal icms;

	@Column(length = 1)
	private String sticms;

	@Column
	private BigDecimal icmsst;

	@Column
	private BigDecimal aliqipi;

	@Column
	private BigDecimal aliqpis;

	@Column
	private BigDecimal aliqconfins;

	@Column
	private String observacao;

	@Column
	@Temporal(TemporalType.DATE)
	private Date data_atualiza_custo;

	@Column
	private BigDecimal preco_varejo;

	@Column
	private boolean materia_prima;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public BigDecimal getPeso_bruto() {
		return peso_bruto;
	}

	public void setPeso_bruto(BigDecimal peso_bruto) {
		this.peso_bruto = peso_bruto;
	}

	public Date getData_inclusao() {
		return data_inclusao;
	}

	public void setData_inclusao(Date data_inclusao) {
		this.data_inclusao = data_inclusao;
	}

	public Date getData_alteracao() {
		return data_alteracao;
	}

	public void setData_alteracao(Date data_alteracao) {
		this.data_alteracao = data_alteracao;
	}

	public BigDecimal getPreco_base() {
		return preco_base;
	}

	public void setPreco_base(BigDecimal preco_base) {
		this.preco_base = preco_base;
	}

	public BigDecimal getPreco_fornecedor() {
		return preco_fornecedor;
	}

	public void setPreco_fornecedor(BigDecimal preco_fornecedor) {
		this.preco_fornecedor = preco_fornecedor;
	}

	public BigDecimal getMargem_preco_base() {
		return margem_preco_base;
	}

	public void setMargem_preco_base(BigDecimal margem_preco_base) {
		this.margem_preco_base = margem_preco_base;
	}

	public void setLote(boolean lote) {
		this.lote = lote;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodbarras() {
		return codbarras;
	}

	public void setCodbarras(String codbarras) {
		this.codbarras = codbarras;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getMargem_preco_promocional() {
		return margem_preco_promocional;
	}

	public void setMargem_preco_promocional(BigDecimal margem_preco_promocional) {
		this.margem_preco_promocional = margem_preco_promocional;
	}

	public Boolean getLote() {
		return lote;
	}

	public void setLote(Boolean lote) {
		this.lote = lote;
	}

	public boolean isSerie() {
		return serie;
	}

	public void setSerie(boolean serie) {
		this.serie = serie;
	}

	public BigDecimal getEstoque_minimo() {
		return estoque_minimo;
	}

	public void setEstoque_minimo(BigDecimal estoque_minimo) {
		this.estoque_minimo = estoque_minimo;
	}

	public BigDecimal getEstoque_maximo() {
		return estoque_maximo;
	}

	public void setEstoque_maximo(BigDecimal estoque_maximo) {
		this.estoque_maximo = estoque_maximo;
	}

	public BigDecimal getLote_compra() {
		return lote_compra;
	}

	public void setLote_compra(BigDecimal lote_compra) {
		this.lote_compra = lote_compra;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Date getData_fabricacao() {
		return data_fabricacao;
	}

	public void setData_fabricacao(Date data_fabricacao) {
		this.data_fabricacao = data_fabricacao;
	}

	public BigDecimal getIcms() {
		return icms;
	}

	public void setIcms(BigDecimal icms) {
		this.icms = icms;
	}

	public String getSticms() {
		return sticms;
	}

	public void setSticms(String sticms) {
		this.sticms = sticms;
	}

	public BigDecimal getIcmsst() {
		return icmsst;
	}

	public void setIcmsst(BigDecimal icmsst) {
		this.icmsst = icmsst;
	}

	public BigDecimal getAliqipi() {
		return aliqipi;
	}

	public void setAliqipi(BigDecimal aliqipi) {
		this.aliqipi = aliqipi;
	}

	public BigDecimal getAliqpis() {
		return aliqpis;
	}

	public void setAliqpis(BigDecimal aliqpis) {
		this.aliqpis = aliqpis;
	}

	public BigDecimal getAliqconfins() {
		return aliqconfins;
	}

	public void setAliqconfins(BigDecimal aliqconfins) {
		this.aliqconfins = aliqconfins;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getData_atualiza_custo() {
		return data_atualiza_custo;
	}

	public void setData_atualiza_custo(Date data_atualiza_custo) {
		this.data_atualiza_custo = data_atualiza_custo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aliqconfins == null) ? 0 : aliqconfins.hashCode());
		result = prime * result + ((aliqipi == null) ? 0 : aliqipi.hashCode());
		result = prime * result + ((aliqpis == null) ? 0 : aliqpis.hashCode());
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result
				+ ((codbarras == null) ? 0 : codbarras.hashCode());
		result = prime * result
				+ ((data_alteracao == null) ? 0 : data_alteracao.hashCode());
		result = prime
				* result
				+ ((data_atualiza_custo == null) ? 0 : data_atualiza_custo
						.hashCode());
		result = prime * result
				+ ((data_fabricacao == null) ? 0 : data_fabricacao.hashCode());
		result = prime * result
				+ ((data_inclusao == null) ? 0 : data_inclusao.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((ean == null) ? 0 : ean.hashCode());
		result = prime * result
				+ ((estoque_maximo == null) ? 0 : estoque_maximo.hashCode());
		result = prime * result
				+ ((estoque_minimo == null) ? 0 : estoque_minimo.hashCode());
		result = prime * result
				+ ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((icms == null) ? 0 : icms.hashCode());
		result = prime * result + ((icmsst == null) ? 0 : icmsst.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (lote ? 1231 : 1237);
		result = prime * result
				+ ((lote_compra == null) ? 0 : lote_compra.hashCode());
		result = prime
				* result
				+ ((margem_preco_base == null) ? 0 : margem_preco_base
						.hashCode());
		result = prime
				* result
				+ ((margem_preco_promocional == null)
						? 0
						: margem_preco_promocional.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result
				+ ((peso_bruto == null) ? 0 : peso_bruto.hashCode());
		result = prime * result
				+ ((preco_base == null) ? 0 : preco_base.hashCode());
		result = prime
				* result
				+ ((preco_fornecedor == null) ? 0 : preco_fornecedor.hashCode());
		result = prime * result + (serie ? 1231 : 1237);
		result = prime * result + ((sticms == null) ? 0 : sticms.hashCode());
		result = prime * result
				+ ((validade == null) ? 0 : validade.hashCode());
		result = prime * result + version;
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (aliqconfins == null) {
			if (other.aliqconfins != null)
				return false;
		} else if (!aliqconfins.equals(other.aliqconfins))
			return false;
		if (aliqipi == null) {
			if (other.aliqipi != null)
				return false;
		} else if (!aliqipi.equals(other.aliqipi))
			return false;
		if (aliqpis == null) {
			if (other.aliqpis != null)
				return false;
		} else if (!aliqpis.equals(other.aliqpis))
			return false;
		if (ativo != other.ativo)
			return false;
		if (codbarras == null) {
			if (other.codbarras != null)
				return false;
		} else if (!codbarras.equals(other.codbarras))
			return false;
		if (data_alteracao == null) {
			if (other.data_alteracao != null)
				return false;
		} else if (!data_alteracao.equals(other.data_alteracao))
			return false;
		if (data_atualiza_custo == null) {
			if (other.data_atualiza_custo != null)
				return false;
		} else if (!data_atualiza_custo.equals(other.data_atualiza_custo))
			return false;
		if (data_fabricacao == null) {
			if (other.data_fabricacao != null)
				return false;
		} else if (!data_fabricacao.equals(other.data_fabricacao))
			return false;
		if (data_inclusao == null) {
			if (other.data_inclusao != null)
				return false;
		} else if (!data_inclusao.equals(other.data_inclusao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (ean == null) {
			if (other.ean != null)
				return false;
		} else if (!ean.equals(other.ean))
			return false;
		if (estoque_maximo == null) {
			if (other.estoque_maximo != null)
				return false;
		} else if (!estoque_maximo.equals(other.estoque_maximo))
			return false;
		if (estoque_minimo == null) {
			if (other.estoque_minimo != null)
				return false;
		} else if (!estoque_minimo.equals(other.estoque_minimo))
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (icms == null) {
			if (other.icms != null)
				return false;
		} else if (!icms.equals(other.icms))
			return false;
		if (icmsst == null) {
			if (other.icmsst != null)
				return false;
		} else if (!icmsst.equals(other.icmsst))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lote != other.lote)
			return false;
		if (lote_compra == null) {
			if (other.lote_compra != null)
				return false;
		} else if (!lote_compra.equals(other.lote_compra))
			return false;
		if (margem_preco_base == null) {
			if (other.margem_preco_base != null)
				return false;
		} else if (!margem_preco_base.equals(other.margem_preco_base))
			return false;
		if (margem_preco_promocional == null) {
			if (other.margem_preco_promocional != null)
				return false;
		} else if (!margem_preco_promocional
				.equals(other.margem_preco_promocional))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (peso_bruto == null) {
			if (other.peso_bruto != null)
				return false;
		} else if (!peso_bruto.equals(other.peso_bruto))
			return false;
		if (preco_base == null) {
			if (other.preco_base != null)
				return false;
		} else if (!preco_base.equals(other.preco_base))
			return false;
		if (preco_fornecedor == null) {
			if (other.preco_fornecedor != null)
				return false;
		} else if (!preco_fornecedor.equals(other.preco_fornecedor))
			return false;
		if (serie != other.serie)
			return false;
		if (sticms == null) {
			if (other.sticms != null)
				return false;
		} else if (!sticms.equals(other.sticms))
			return false;
		if (validade == null) {
			if (other.validade != null)
				return false;
		} else if (!validade.equals(other.validade))
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

	public BigDecimal getPreco_varejo() {
		return preco_varejo;
	}

	public void setPreco_varejo(BigDecimal preco_varejo) {
		this.preco_varejo = preco_varejo;
	}

	public boolean isMateria_prima() {
		return materia_prima;
	}

	public void setMateria_prima(boolean materia_prima) {
		this.materia_prima = materia_prima;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (descricao != null && !descricao.trim().isEmpty())
			result += "descricao: " + descricao;
		if (codbarras != null && !codbarras.trim().isEmpty())
			result += ", codbarras: " + codbarras;
		if (fabricante != null && !fabricante.trim().isEmpty())
			result += ", fabricante: " + fabricante;
		result += ", ativo: " + ativo;
		if (ean != null && !ean.trim().isEmpty())
			result += ", ean: " + ean;
		result += ", lote: " + lote;
		result += ", serie: " + serie;
		if (sticms != null && !sticms.trim().isEmpty())
			result += ", sticms: " + sticms;
		if (observacao != null && !observacao.trim().isEmpty())
			result += ", observacao: " + observacao;
		result += ", materia_prima: " + materia_prima;
		return result;
	}
}