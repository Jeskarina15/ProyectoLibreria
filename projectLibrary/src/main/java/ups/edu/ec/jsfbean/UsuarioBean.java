package ups.edu.ec.jsfbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.accesosDatos.UsuarioDAO;
import ups.edu.ec.modelo.Usuarios;
import ups.edu.ec.negocio.GestionLibroLocal;


@ManagedBean
@RequestScoped
public class UsuarioBean {

private Usuarios usuario; 
private List<Usuarios> listaU;
@Inject
private UsuarioDAO usuarioDAO;
private boolean estado=true;
@PostConstruct
public void init() {
	usuario=new Usuarios();
	ListarUsuarios();
}
/**
 * metodo getUsuario para obtener el campo
 * @return
 */
public Usuarios getUsuario() {
	return usuario;
}
/**
 * Metodo setUsuario para especificar el campo del atributo
 * @param usuario
 */
public void setUsuario(Usuarios usuario) {
	this.usuario = usuario;
}
/**
 * obtiene la lista de los usuarios
 * @return
 */
public List<Usuarios> getListaU() {
	return listaU;
}
/**
 * 
 * @param listaU
 */
public void setListaU(List<Usuarios> listaU) {
	this.listaU = listaU;
}

public boolean isEstado() {
	return estado;
}
public void setEstado(boolean estado) {
	this.estado = estado;
}
/**
 * Metodo crear usuario en el que referenciamos al DAO respectivo pasando un objeto para persistir 
 * @return mensaje para verificar si se creo el usuario
 */
public String crearUsuario() {
	System.out.println(usuario);
	usuarioDAO.NuevoUsuario(usuario);
	return "se ha creado el usuario";
}
/**
 * parametros a usar para actualizar el usuario
 * @param idUsuario
 * @param nombre
 * @param email
 * @param telefono
 * @param User
 * @param password
 * @param Rol
 * @return
 */
public String actualizarUsuario(int idUsuario, String nombre, String email, String telefono, String User, String password, String Rol) {
	usuario.setUsu_id(idUsuario);
	usuario.setUsu_nombre(nombre);
	usuario.setUsu_email(email);
	usuario.setUsu_telefono(telefono);
	usuario.setUsu_usuario(User);
	usuario.setUsu_rol(Rol);
	usuario.setUsu_password(password);
	System.out.println("actualizar");
	usuarioDAO.ActualizarUsuario(usuario);
	return null;
}
/**
 * 
 * @param idUsuario
 * @return elimina un usuario en base al idusuario
 */
public String eliminarUsuario(int idUsuario){
	System.out.println("......................."+idUsuario);
	usuarioDAO.EliminarUsuario(idUsuario);
	return "se ha eliminado el usuario";
}
/**
 * Devuelve una lista con todos los usuarios 
 * @return
 */
public String ListarUsuarios() {
	listaU =usuarioDAO.listarUsuario();
	return null;
}
/**
 * 
 * @param usuario nombre de usuario de inicio de sesion
 * @param password contrasenia de usuario para inicio de sesion
 * @return retorna al index de la pagina o al login dependiendo del resultado del metodo en el DAO
 */
public String iniciarsesion(String usuario, String password) {
	estado=usuarioDAO.confirmarClave(usuario, password);
	String p="";
	if (estado) {
		p="index";
		return p;
	}else if(!estado) {
		p="login";
		return p;
	}
	return p;
}
public String CerrarSesion() {
	return "login";
}
}

