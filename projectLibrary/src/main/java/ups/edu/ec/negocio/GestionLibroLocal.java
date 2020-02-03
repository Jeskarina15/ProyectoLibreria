package ups.edu.ec.negocio;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.modelo.Autor;
import ups.edu.ec.modelo.Categorias;
import ups.edu.ec.modelo.Libro;
import ups.edu.ec.modelo.Usuarios;

@Local
public interface GestionLibroLocal {

	public void NuevoLibro(Libro libro);
	public List<Libro> listarLibro();
	public void NuevoUsuario(Usuarios usuario);
	public void ActualizarUsuario(Usuarios usuario);
	public void EliminarUsuario(int idUsuario);
	public Usuarios leerUsuario(int idUsuario);
	public List<Usuarios> listarUsuario();
	public Libro leerLibros(int libro);
	public void NuevoAutor(Autor autor);
	public void ActualizarAutor(Autor autor);
	public void eliminarAutor(int autor);
	public Autor leerAutor(int autor);
	public List<Autor> listarAutor();
	public void NuevoCategoria(Categorias categoria);
	public void ActualizarCategoria(Categorias categoria);
	public void eliminarCategoria(int categoria);
	public Categorias leerCategoria(int categoria);
	public List<Categorias> listarCategorias();
	public int loguear(Usuarios usuario);
	
}
