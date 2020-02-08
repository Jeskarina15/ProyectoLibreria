package ups.edu.ec.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Facturas_Cabecera")
public class FacturaCabecera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fac_cab_id")
	private int fac_cab_id;
	
	@Column(name="fac_cab_fecha")
	private String fac_cab_fecha;
	
	@Column(name="fac_cab_subtotal")
	private double fac_cab_total;
	
	@Column(name="fac_cab_total")
	private double fac_cab_subtotal;
	
	@Column(name="fac_cab_iva")
	private int fac_cab_iva;
	
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private Usuarios fac_cab_usuario;

	public int getFac_cab_id() {
		return fac_cab_id;
	}

	public void setFac_cab_id(int fac_cab_id) {
		this.fac_cab_id = fac_cab_id;
	}

	public String getFac_cab_fecha() {
		return fac_cab_fecha;
	}

	public void setFac_cab_fecha(String fac_cab_fecha) {
		this.fac_cab_fecha = fac_cab_fecha;
	}

	public double getFac_cab_total() {
		return fac_cab_total;
	}

	public void setFac_cab_total(double fac_cab_total) {
		this.fac_cab_total = fac_cab_total;
	}

	public double getFac_cab_subtotal() {
		return fac_cab_subtotal;
	}

	public void setFac_cab_subtotal(double fac_cab_subtotal) {
		this.fac_cab_subtotal = fac_cab_subtotal;
	}

	public int getFac_cab_iva() {
		return fac_cab_iva;
	}

	public void setFac_cab_iva(int fac_cab_iva) {
		this.fac_cab_iva = fac_cab_iva;
	}

	public Usuarios getFac_cab_usuario() {
		return fac_cab_usuario;
	}

	public void setFac_cab_usuario(Usuarios fac_cab_usuario) {
		this.fac_cab_usuario = fac_cab_usuario;
	}

	@Override
	public String toString() {
		return "FacturaCabecera [fac_cab_id=" + fac_cab_id + ", fac_cab_fecha=" + fac_cab_fecha + ", fac_cab_total="
				+ fac_cab_total + ", fac_cab_subtotal=" + fac_cab_subtotal + ", fac_cab_iva=" + fac_cab_iva
				+ ", fac_cab_usuario=" + fac_cab_usuario + "]";
	}
}
