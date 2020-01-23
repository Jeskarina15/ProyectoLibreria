package ups.edu.ec.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FacturasCabecera")
public class FacturaCabecera {
	@Id
	@Column(name="fac_cab_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="fac_cab_fecha")
	private String fecha;
	
	@Column(name="fac_cab_total")
	private double total;
	
	@Column(name="fac_cab_iva")
	private double iva;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="fac_cab_id", referencedColumnName = "fac_cab_id")
	private List<FacturaDetalle> listaFacturas;
	@JoinColumn(name="fac_cab_id")
	private List<FacturaDetalle> listaDetalles;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
	public List<FacturaDetalle> getListaFacturas() {
		return listaFacturas;
	}
	public List<FacturaDetalle> getListaDetalles() {
		return listaDetalles;

	}
	public void setListaFacturas(List<FacturaDetalle> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
	public void setListaDetalles(List<FacturaDetalle> listaDetalles) {
		this.listaDetalles = listaDetalles;

	}

	@Override
	public String toString() {
		return "FacturaCabecera [codigo=" + codigo + ", fecha=" + fecha + ", total=" + total + ", iva=" + iva
				+ ", listaDetalles=" + listaDetalles + "]";
	}
}