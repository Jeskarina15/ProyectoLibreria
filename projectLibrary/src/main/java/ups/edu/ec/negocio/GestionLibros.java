package ups.edu.ec.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.ec.accesosDatos.LibroDAO;
import ups.edu.ec.accesosDatos.UsuarioDAO;
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
		libroDAO.NuevoLibro(libro);
		
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

}
