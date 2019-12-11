package ups.edu.ec.accesosDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Libro;
import ups.edu.ec.modelo.Usuarios;
@Stateless
public class LibroDAO {
	
	@Inject
	private EntityManager em;

	public void NuevoLibro(Libro libro) {
	em.persist(libro);	
	
	}
	public void ActualizarLibro(Libro libro) {
	em.merge(libro);	
	}
	public void eliminarLibro(int idLibro) {
	em.remove(leerLibros(idLibro));
	}
	public Libro leerLibros(int idLibro) {
	
	return em.find(Libro.class, idLibro);	
	}
	public List<Libro> listarLibro(){
		String jpql = "SELECT * FROM libros.productos;";
		Query query = em.createNativeQuery(jpql, Libro.class);
		List<Libro> nivel = query.getResultList();
		return nivel;	
	}
	
}
