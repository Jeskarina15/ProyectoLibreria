package ups.edu.ec.modelo;



import java.util.HashSet;
import java.util.Set;

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
@Table(name="productos")
public class Libro {
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name= "idlibro")
private int idlibro;
@NotNull
@Column(name= "desclibro")
private String desclibro;
@NotNull
@Column(name= "edicion")
private String edicion;
@NotNull
@Column(name= "isbn")
private String isbn;
@NotNull
@Column(name= "numeropag")
private int numeroP;
@NotNull
@Pattern(regexp = "[^0-9]*", message = "Debe ingresar letras") 
@Column(name= "titulolibro")
private String titulolibro;
@NotNull
@Column(name= "image")
private String image;


@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
@JoinColumn(name="idautor", referencedColumnName = "id_Libro")
private Set<Autor> autor;

@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
@JoinColumn(name="idcategoria", referencedColumnName = "id_Libro")
private Set<Categorias> categoria;

public int getIdlibro() {
	return idlibro;
}

public void setIdlibro(int idlibro) {
	this.idlibro = idlibro;
}

public String getDesclibro() {
	return desclibro;
}

public void setDesclibro(String desclibro) {
	this.desclibro = desclibro;
}

public String getEdicion() {
	return edicion;
}

public void setEdicion(String edicion) {
	this.edicion = edicion;
}

public String getIsbn() {
	return isbn;
}

public void setIsbn(String isbn) {
	this.isbn = isbn;
}

public int getNumeroP() {
	return numeroP;
}

public void setNumeroP(int numeroP) {
	this.numeroP = numeroP;
}

public String getTitulolibro() {
	return titulolibro;
}

public void setTitulolibro(String titulolibro) {
	this.titulolibro = titulolibro;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public Set<Autor> getAutor() {
	return autor;
}

public void setAutor(Set<Autor> autor) {
	this.autor = autor;
}

public Set<Categorias> getCategoria() {
	return categoria;
}

public void setCategoria(Set<Categorias> categoria) {
	this.categoria = categoria;
}

@Override
public String toString() {
	return "Libro [idlibro=" + idlibro + ", desclibro=" + desclibro + ", edicion=" + edicion + ", isbn=" + isbn
			+ ", numeroP=" + numeroP + ", titulolibro=" + titulolibro + ", image=" + image + ", autor=" + autor
			+ ", categoria=" + categoria + "]";
}
}
