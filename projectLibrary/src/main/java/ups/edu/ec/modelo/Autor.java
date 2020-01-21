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
@Table(name="autor")
public class Autor {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="idautor")
private int idautor;
@NotNull
@Pattern(regexp = "[^0-9]*", message = "Debe ingresar letras") 
@Column(name="nombreautor")
private String nombreautor;
@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
@JoinColumn(name="idautorlibro", referencedColumnName = "idautor")
private List<Libro> autorlibro;

/**
 * 
 * @return
 */
public int getIdautor() {
	return idautor;
}
/**
 * 
 * @param idautor
 */
public void setIdautor(int idautor) {
	this.idautor = idautor;
}
/**
 * 
 * @return
 */
public String getNombreautor() {
	return nombreautor;
}
/**
 * 
 * @param nombreautor
 */
public void setNombreautor(String nombreautor) {
	this.nombreautor = nombreautor;
}
/**
 * 
 * @return
 */
public List<Libro> getAutorlibro() {
	return autorlibro;
}
/**
 * 
 * @param autorlibro
 */
public void setAutorlibro(List<Libro> autorlibro) {
	this.autorlibro = autorlibro;
}
@Override
public String toString() {
	return "Autor [idautor=" + idautor + ", nombreautor=" + nombreautor + ", autorlibro=" + autorlibro + "]";
}
}
