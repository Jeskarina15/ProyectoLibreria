package ups.edu.ec.negocio;

import java.util.List;

import javax.ejb.Local;

import ups.edu.ec.modelo.Libro;
import ups.edu.ec.modelo.Usuarios;

@Local
public interface GestionLibroLocal {

	public void NuevoLibro(Libro libro);
	public List<Libro> listarLibro();
	public void NuevoUsuario(Usuarios usuario);
	public Libro leerLibros(int libro);
}
