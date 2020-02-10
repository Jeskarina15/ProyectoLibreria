package ups.edu.ec.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.accesosDatos.LibroDAO;
import ups.edu.ec.accesosDatos.UsuarioDAO;
import ups.edu.ec.modelo.Autor;
import ups.edu.ec.modelo.Categorias;
import ups.edu.ec.modelo.Libro;
import ups.edu.ec.modelo.Usuarios;

@Stateless
public class GestionLibros implements GestionLibroLocal {


	@Inject
	private LibroDAO libroDAO;
	@Inject
	private UsuarioDAO usuarioDAO;
	private List<Libro> libros;
	@Override
	public void NuevoLibro(Libro libro) {
		//libroDAO.NuevoLibro(libro);
	}

	@Override
	public List<Libro> listarLibro() {
		libros= libroDAO.listarLibro();
		return libros;
	}

	@Override
	public void NuevoUsuario(Usuarios usuario) {
		usuarioDAO.NuevoUsuario(usuario);
		
	}

	@Override
	public Libro leerLibros(int libro) {
		return libroDAO.leerLibros(libro);
	}

	@Override
	public void ActualizarUsuario(Usuarios usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuarios leerUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuarios> listarUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void NuevoAutor(Autor autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ActualizarAutor(Autor autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarAutor(int autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Autor leerAutor(int autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Autor> listarAutor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void NuevoCategoria(Categorias categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ActualizarCategoria(Categorias categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCategoria(int categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categorias leerCategoria(int categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorias> listarCategorias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int loguear(Usuarios usuario) {
		return usuarioDAO.loguear(usuario.getUsu_email(), usuario.getUsu_password());
	}

	@Override
	public int crearCabecera(String codUsuario, String total, String cantidad) {
		return libroDAO.crearCabecera(codUsuario, total, cantidad);
	}

	@Override
	public boolean crearDetalle(ArrayList<String> datos, int codCabecera) {
		libroDAO.crearDetalle(datos, codCabecera);
		return false;
	}

	@Override
	public boolean darLike(String libro, int codigo) {
		libroDAO.darMegusta(libro, codigo);
		return false;
	}
}
