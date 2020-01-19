package ups.edu.ec.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "categoria")
public class Categorias {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="idcategoria")
	@Id
	private int idcategoria;
	@NotNull
	@Pattern(regexp = "[^0-9]*", message = "Debe ingresar letras") 
	@Column(name="categoria")
	private String categoria;
	
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Categorias [idcategoria=" + idcategoria + ", categoria=" + categoria + "]";
	}
}
