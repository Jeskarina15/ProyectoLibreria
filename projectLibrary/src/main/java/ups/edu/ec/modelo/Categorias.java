package ups.edu.ec.modelo;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "categorias")
public class Categorias {

	@Id
	private int idCategoria;
	private String Categorias;

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategorias() {
		return Categorias;
	}

	public void setCategorias(String categorias) {
		Categorias = categorias;
	}

	@Override
	public String toString() {
		return "Categorias [idCategoria=" + idCategoria + ", Categorias=" + Categorias + "]";
	}
	
	
}
