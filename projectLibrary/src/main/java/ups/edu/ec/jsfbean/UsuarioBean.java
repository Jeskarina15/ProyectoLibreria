package ups.edu.ec.jsfbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.accesosDatos.UsuarioDAO;
import ups.edu.ec.modelo.Usuarios;
import ups.edu.ec.negocio.GestionLibroLocal;


@ManagedBean
@ViewScoped
public class UsuarioBean {

private List<Integer> idc;
private Usuarios usuario; 
private List<Usuarios> listaU;
@Inject
private UsuarioDAO usuarioDAO;

@PostConstruct
public void init() {
	usuario=new Usuarios();
	idc=usuarioDAO.getid();
}

public List<Integer> getIdc() {
	return idc;
}

public void setIdc(List<Integer> idc) {
	this.idc = idc;
}

/**
 * 
 * @return
 */
public Usuarios getUsuario() {
	return usuario;
}
/**
 * 
 * @param usuario
 */
public void setUsuario(Usuarios usuario) {
	this.usuario = usuario;
}
/**
 * 
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
/**
 * 
 * @return
 */
public String crearUsuario() {
	System.out.println(usuario);
	usuarioDAO.NuevoUsuario(usuario);
	return "se ha creado el usuario";
}
/**
 * 
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
	usuario.setIdusuario(idUsuario);
	usuario.setNombreu(nombre);
	usuario.setEmail(email);
	usuario.setTelefono(telefono);
	usuario.setUsuario(User);
	usuario.setRol(Rol);
	usuario.setPassword(password);
	System.out.println("actualizar");
	usuarioDAO.ActualizarUsuario(usuario);
	return null;
}
/**
 * 
 * @param idUsuario
 * @return
 */
public String eliminarUsuario(int idUsuario){
	usuarioDAO.EliminarUsuario(idUsuario);
	return "se ha eliminado el usuario";
}
/**
 * 
 * @return
 */
public String ListarUsuarios() {
	listaU =usuarioDAO.listarUsuario();
	return null;
}
}

