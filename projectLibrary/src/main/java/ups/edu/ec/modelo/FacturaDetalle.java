package ups.edu.ec.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="FacturasDetalle")
public class FacturaDetalle {
	@Id
	@Column(name="fac_det_id")
	private int codigo;
	
	@Column(name="fac_det_precio")
	private double precio;
	
	@Column(name="fac_det_cantidad")
	private int cantidad;
	
	@Column(name="fac_det_producto")
	private Libro producto;
	
	@Column(name="fac_det_factura_cabecera")
	private FacturaCabecera facturaCabecera;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Libro getProducto() {
		return producto;
	}

	public void setProducto(Libro producto) {
		this.producto = producto;
	}

	public FacturaCabecera getFacturaCabecera() {
		return facturaCabecera;
	}

	public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
		this.facturaCabecera = facturaCabecera;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [codigo=" + codigo + ", precio=" + precio + ", cantidad=" + cantidad + ", producto="
				+ producto + ", facturaCabecera=" + facturaCabecera + "]";
	}
}
