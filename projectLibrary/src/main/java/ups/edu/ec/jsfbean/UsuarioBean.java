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

//atributo tipo usuario		
private Usuarios usuario; 
//list =lista de usuarios
private List<Usuarios> listaU;
@Inject
private GestionLibroLocal gestioL;


@PostConstruct
public void init() {
	usuario=new Usuarios();

}

public Usuarios getUsuario() {
	return usuario;
}

public void setUsuario(Usuarios usuario) {
	this.usuario = usuario;
}

public List<Usuarios> getListaU() {
	return listaU;
}

public void setListaU(List<Usuarios> listaU) {
	this.listaU = listaU;
}

public String crearUsuario() {
	System.out.println(usuario);
	gestioL.NuevoUsuario(usuario);
	//ListarUsuarios();
	return null;
}
/*public String actualizarUsuario(int idUsuario, String nombre, String email, String telefono, String User, String password, String Rol) {
	usuario.setIdUsuario(idUsuario);
	usuario.setNombreUsuario(nombre);
	usuario.setEmail(email);
	usuario.setTelefono(telefono);
	usuario.setUsuario(User);
	usuario.setRol(Rol);
	usuario.setContrasenia(password);
	System.out.println("actualizar");
	usuarioDAO.ActualizarUsuario(usuario);
	return null;
}*/
/*public String eliminarUsuario(int idUsuario){
	usuarioDAO.EliminarLibro(idUsuario);
	return null;
}*/
/*spublic String ListarUsuarios() {
	listaU =usuarioDAO.listarUsuario();
	return null;
}*/
}
