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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name= "usuarios")
public class Usuarios {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="usu_id")
private int usu_id;

@NotNull
@Column(name = "usu_nombre")
@NotEmpty
@Pattern(regexp = "[^0-9]*", message = "Debe ingresar letras") 
private String usu_nombre;

@NotNull
@Column(name = "usu_email")
@NotEmpty
@Email(message="El correo ingresado no es valido")
private String usu_email;

@NotNull
@Column(name = "usu_telefono")
@NotEmpty
@Size(min = 8, max = 12, message = "El numero de telefono es incorrecto")
private String usu_telefono;

@NotNull
@Column(name = "usu_usuario")
@NotEmpty
@Pattern(regexp = "[^0-9]*", message = "Debe ingresar letras") 
private String usu_usuario;

@NotNull
@Column(name = "usu_password")
@NotEmpty
private String usu_password;

@NotNull
@Column(name = "usu_rol")
@NotEmpty
private String usu_rol;

public int getUsu_id() {
	return usu_id;
}



public void setUsu_id(int usu_id) {
	this.usu_id = usu_id;
}



public String getUsu_nombre() {
	return usu_nombre;
}



public void setUsu_nombre(String usu_nombre) {
	this.usu_nombre = usu_nombre;
}



public String getUsu_email() {
	return usu_email;
}



public void setUsu_email(String usu_email) {
	this.usu_email = usu_email;
}



public String getUsu_telefono() {
	return usu_telefono;
}



public void setUsu_telefono(String usu_telefono) {
	this.usu_telefono = usu_telefono;
}



public String getUsu_usuario() {
	return usu_usuario;
}



public void setUsu_usuario(String usu_usuario) {
	this.usu_usuario = usu_usuario;
}



public String getUsu_password() {
	return usu_password;
}



public void setUsu_password(String usu_password) {
	this.usu_password = usu_password;
}



public String getUsu_rol() {
	return usu_rol;
}



public void setUsu_rol(String usu_rol) {
	this.usu_rol = usu_rol;
}



@Override
public String toString() {
	return "Usuarios [usu_id=" + usu_id + ", usu_nombre=" + usu_nombre + ", usu_email=" + usu_email + ", usu_telefono="
			+ usu_telefono + ", usu_usuario=" + usu_usuario + ", usu_password=" + usu_password + ", usu_rol=" + usu_rol
			+ "]";
}
}
