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
@Table(name="autor")
public class Autor {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@NotNull
@Column(name="idautor")
private int idautor;
@NotNull
@Pattern(regexp = "[^0-9]*", message = "Debe ingresar letras") 
@Column(name="nombreautor")
private String nombreautor;
public int getIdautor() {
	return idautor;
}
public void setIdautor(int idautor) {
	this.idautor = idautor;
}
public String getNombreautor() {
	return nombreautor;
}
public void setNombreautor(String nombreautor) {
	this.nombreautor = nombreautor;
}
@Override
public String toString() {
	return "Autor [idautor=" + idautor + ", nombreautor=" + nombreautor + "]";
}
}
