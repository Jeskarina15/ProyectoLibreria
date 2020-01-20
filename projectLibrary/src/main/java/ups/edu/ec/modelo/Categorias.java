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
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name="idcategorialibro", referencedColumnName = "idcategoria")
	private List<Libro> categorialibro;
	/**
	 * 
	 * @return
	 */
	public int getIdcategoria() {
		return idcategoria;
	}
	/**
	 * 
	 * @param idcategoria
	 */
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	/**
	 * 
	 * @return
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * 
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * 
	 * @return
	 */
	public List<Libro> getCategorialibro() {
		return categorialibro;
	}
	/**
	 * 
	 * @param categorialibro
	 */
	public void setCategorialibro(List<Libro> categorialibro) {
		this.categorialibro = categorialibro;
	}
	@Override
	public String toString() {
		return "Categorias [idcategoria=" + idcategoria + ", categoria=" + categoria + ", categorialibro="
				+ categorialibro + "]";
	}
	
}
