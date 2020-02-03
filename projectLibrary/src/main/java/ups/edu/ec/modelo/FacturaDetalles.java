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
@Table (name = "factura_detalles")
public class FacturaDetalles {

	@Id
	@Column(name = "fac_det_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fac_det_id;
	@Column(name = "fac_det_cantidad")
	private int fac_det_cantidad;
	@Column(name = "fac_det_prec_unitario")
	private double fac_det_prec_unitario;
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "fac_det_libro")
	private Libro fac_det_libro;
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "fac_det_usuario")
	private Usuarios fac_det_usuario;
	@Column(name = "fac_det_estado")
	private int estado;
	public int getFac_det_id() {
		return fac_det_id;
	}
	public void setFac_det_id(int fac_det_id) {
		this.fac_det_id = fac_det_id;
	}
	public int getFac_det_cantidad() {
		return fac_det_cantidad;
	}
	public void setFac_det_cantidad(int fac_det_cantidad) {
		this.fac_det_cantidad = fac_det_cantidad;
	}
	public double getFac_det_prec_unitario() {
		return fac_det_prec_unitario;
	}
	public void setFac_det_prec_unitario(double fac_det_prec_unitario) {
		this.fac_det_prec_unitario = fac_det_prec_unitario;
	}
	public Libro getFac_det_libro() {
		return fac_det_libro;
	}
	public void setFac_det_libro(Libro fac_det_libro) {
		this.fac_det_libro = fac_det_libro;
	}
	public Usuarios getFac_det_usuario() {
		return fac_det_usuario;
	}
	public void setFac_det_usuario(Usuarios fac_det_usuario) {
		this.fac_det_usuario = fac_det_usuario;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "FacturaDetalles [fac_det_id=" + fac_det_id + ", fac_det_cantidad=" + fac_det_cantidad
				+ ", fac_det_prec_unitario=" + fac_det_prec_unitario + ", fac_det_libro=" + fac_det_libro
				+ ", fac_det_usuario=" + fac_det_usuario + ", estado=" + estado + "]";
	}
	
}