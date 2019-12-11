package ups.edu.ec.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name= "usuarios")
public class Usuarios {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="idUsuario")
private int idUsuario;

@NotNull
@Column(name = "nombreU")
@NotEmpty
private String nombreUsuario;
@Email
@NotNull
@Column(name = "email")
@NotEmpty
private String email;
@NotNull
@Column(name = "telefono")
@NotEmpty
private String telefono;
@NotNull
@Column(name = "NameUser")
@NotEmpty
private String usuario;
@NotNull
@Column(name = "password")
@NotEmpty
private String contrasenia;

@NotNull
@Column(name = "rol")
@NotEmpty
private String rol;



public int getIdUsuario() {
	return idUsuario;
}



public void setIdUsuario(int idUsuario) {
	this.idUsuario = idUsuario;
}



public String getNombreUsuario() {
	return nombreUsuario;
}



public void setNombreUsuario(String nombreUsuario) {
	this.nombreUsuario = nombreUsuario;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getTelefono() {
	return telefono;
}



public void setTelefono(String telefono) {
	this.telefono = telefono;
}



public String getUsuario() {
	return usuario;
}



public void setUsuario(String usuario) {
	this.usuario = usuario;
}



public String getContrasenia() {
	return contrasenia;
}



public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}



public String getRol() {
	return rol;
}



public void setRol(String rol) {
	this.rol = rol;
}



@Override
public String toString() {
	return "Usuarios [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", email=" + email + ", telefono="
			+ telefono + ", usuario=" + usuario + ", contrasenia=" + contrasenia + ", rol=" + rol + "]";
}




}
