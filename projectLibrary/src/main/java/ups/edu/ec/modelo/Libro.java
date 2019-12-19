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

@Entity
@Table(name="productos")
public class Libro {
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name= "id_Libro")
private int idLibro;
@NotNull
@Column(name= "DescLibro")
private String descLibro;
@NotNull
@Column(name= "Edicion")
private String edicion;
@NotNull
@Column(name= "isbn")
private String isbn;
@NotNull
@Column(name= "NumeroPag")
private int numeroP;
@NotNull
@Column(name= "TituloLibro")
private String nombreLibro;
@NotNull
@Column(name= "ImageURL")
private String imageURL;


@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
@JoinColumn(name="productos", referencedColumnName = "id_Libro")
private Set<Autor> autor;

@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
@JoinColumn(name="productos", referencedColumnName = "id_Libro")
private Set<Categorias> categoria;

public int getIdLibro() {
	return idLibro;
}
public void setIdLibro(int idLibro) {
	this.idLibro = idLibro;
}
public String getDescLibro() {
	return descLibro;
}
public void setDescLibro(String descLibro) {
	this.descLibro = descLibro;
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
public String getNombreLibro() {
	return nombreLibro;
}
public void setNombreLibro(String nombreLibro) {
	this.nombreLibro = nombreLibro;
}
public String getImageURL() {
	return imageURL;
}
public void setImageURL(String imageURL) {
	this.imageURL = imageURL;
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
public void addCategorias(Categorias categorias) {
	if(categoria==null) 
		categoria=new HashSet<>() ;
	categoria.add(categorias);
	
}
public void addAutor(Autor autores) {
	if(autor==null) 
		autor=new  HashSet<>();
	autor.add(autores);
}
@Override
public String toString() {
	return "Libro [idLibro=" + idLibro + ", descLibro=" + descLibro + ", edicion=" + edicion + ", isbn=" + isbn
			+ ", numeroP=" + numeroP + ", nombreLibro=" + nombreLibro + ", imageURL=" + imageURL + ", autor=" + autor
			+ ", categoria=" + categoria + "]";
}

}
