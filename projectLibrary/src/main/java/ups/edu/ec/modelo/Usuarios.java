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
private int idusuario;
@NotNull
@Column(name = "usu_nombre")
@NotEmpty
@Pattern(regexp = "[^0-9]*", message = "Debe ingresar letras") 
private String nombreu;
@NotNull
@Column(name = "usu_email")
@NotEmpty
@Email(message="El correo ingresado no es valido")
private String email;
@NotNull
@Column(name = "usu_telefono")
@NotEmpty
@Size(min = 8, max = 12, message = "El numero de telefono es incorrecto")
private String telefono;
@NotNull
@Column(name = "usu_usuario")
@NotEmpty
@Pattern(regexp = "[^0-9]*", message = "Debe ingresar letras") 
private String usuario;
@NotNull
@Column(name = "usu_password")
@NotEmpty
private String password;
@NotNull
@Column(name = "usu_rol")
@NotEmpty
private String rol;


public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}
public String getNombreu() {
	return nombreu;
}
public void setNombreu(String nombreu) {
	this.nombreu = nombreu;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRol() {
	return rol;
}
public void setRol(String rol) {
	this.rol = rol;
}
@Override
public String toString() {
	return "Usuarios [idusuario=" + idusuario + ", nombreu=" + nombreu + ", email=" + email + ", telefono=" + telefono
			+ ", usuario=" + usuario + ", password=" + password + ", rol=" + rol + "]";
}
}
