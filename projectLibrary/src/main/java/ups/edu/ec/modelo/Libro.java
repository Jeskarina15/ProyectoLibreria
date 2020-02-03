package ups.edu.ec.modelo;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="libros")
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

@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
private Categorias categorialibro;

@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
private Autor autorlibro;
@Column(name= "megusta")
private int megusta;
@Column(name= "stock")
private int stock;
public int getMegusta() {
	return megusta;
}
public void setMegusta(int megusta) {
	this.megusta = megusta;
}
/**
 * 
 * @return
 */
public int getIdlibro() {
	return idlibro;
}
/**
 * 
 * @param idlibro
 */
public void setIdlibro(int idlibro) {
	this.idlibro = idlibro;
}
/**
 * 
 * @return
 */
public String getDesclibro() {
	return desclibro;
}
/**
 * 
 * @param desclibro
 */
public void setDesclibro(String desclibro) {
	this.desclibro = desclibro;
}
/**
 * 
 * @return
 */
public String getEdicion() {
	return edicion;
}
/**
 * 
 * @param edicion
 */
public void setEdicion(String edicion) {
	this.edicion = edicion;
}
/**
 * 
 * @return
 */
public String getIsbn() {
	return isbn;
}
/**
 * 
 * @param isbn
 */
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
/**
 * 
 * @return
 */
public int getNumeroP() {
	return numeroP;
}
/**
 * 
 * @param numeroP
 */
public void setNumeroP(int numeroP) {
	this.numeroP = numeroP;
}
/**
 * 
 * @return
 */
public String getTitulolibro() {
	return titulolibro;
}
/**
 * 
 * @param titulolibro
 */
public void setTitulolibro(String titulolibro) {
	this.titulolibro = titulolibro;
}
/**
 * 
 * @return
 */
public String getImage() {
	return image;
}
/**
 * 
 * @param image
 */
public void setImage(String image) {
	this.image = image;
}
public Categorias getCategorialibro() {
	return categorialibro;
}
public void setCategorialibro(Categorias categorialibro) {
	this.categorialibro = categorialibro;
}
public Autor getAutorlibro() {
	return autorlibro;
}
public void setAutorlibro(Autor autorlibro) {
	this.autorlibro = autorlibro;
}

public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
@Override
public String toString() {
	return "Libro [idlibro=" + idlibro + ", desclibro=" + desclibro + ", edicion=" + edicion + ", isbn=" + isbn
			+ ", numeroP=" + numeroP + ", titulolibro=" + titulolibro + ", image=" + image + ", categorialibro="
			+ categorialibro + ", autorlibro=" + autorlibro + ", megusta=" + megusta + ", stock=" + stock + "]";
}

}
