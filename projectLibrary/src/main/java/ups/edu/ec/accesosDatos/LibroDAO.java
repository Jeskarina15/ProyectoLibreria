package ups.edu.ec.accesosDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Libro;
import ups.edu.ec.modelo.Usuarios;
@Stateless
/**
 * 
 * @author china
 *
 */
public class LibroDAO {
	// para crear y eliminar instancias de entidades persistentes
	//para encontrar entidades por su clave principal y para consultar sobre entidades.
	@Inject
	private EntityManager em;

	//metodo para crear un nuevo libro	
	/**
	 * 
	 * @param libro
	 */
	public void NuevoLibro(Libro libro) {
	em.persist(libro);	
	
	}
	public void ActualizarLibro(Libro libro) {
	em.merge(libro);	
	}
	public void eliminarLibro(int libro) {
	em.remove(leerLibros(libro));
	}
	public Libro leerLibros(int libro) {
	return em.find(Libro.class, libro);	
	}
	public List<Libro> listarLibro(){
		String jpql = "SELECT * FROM libros.productos;";
		Query query = em.createNativeQuery(jpql, Libro.class);
		List<Libro> nivel = query.getResultList();
		return nivel;	
	}
	public List<Libro> listarLibroid(String titulo){
		String jpql = "SELECT * FROM libros.productos WHERE titulolibro=:titulo";
		Query query = em.createNativeQuery(jpql, Libro.class);
		query.setParameter("titulo", titulo);
		List<Libro> nivel = query.getResultList();
		return nivel;
	}
	public List<Libro> listarLibroPC(String categoria){
		String jpql = "SELECT p.id_Libro FROM libros.productos p, libros.categorias c where c.Categorias=:categoria";
		Query query = em.createNativeQuery(jpql, Libro.class);
		query.setParameter("categoria", categoria);
		List<Libro> listc = query.getResultList();
		return listc;
	}
}
