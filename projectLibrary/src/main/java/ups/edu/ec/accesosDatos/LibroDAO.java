package ups.edu.ec.accesosDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Categorias;
import ups.edu.ec.modelo.Libro;
import ups.edu.ec.modelo.Usuarios;
@Stateless
/**
 * 
 * @author china
 *
 */
public class LibroDAO {

	@Inject
	private EntityManager em;
	/**
	 * metodo para crear un nuevo libro	
	 * @param libro
	 */
	public void NuevoLibro(Libro libro) {
	em.persist(libro);	
	}
	/**
	 * Actualizar datos de la entidad libro, pasando como parametro un objeto tipo libro
	 * 
	 * @param libro
	 */
	public void ActualizarLibro(Libro libro) {
	em.merge(libro);	
	}
	/**
	 * Elimina un libro, pasando como parametro un atributo tipo entero
	 * @param libro
	 */
	public void eliminarLibro(int libro) {
	em.remove(leerLibros(libro));
	}
	/**
	 * Buscar un libro, pasando como parametro un atributo tipo entero 
	 * @param libro
	 * @return
	 */
	public Libro leerLibros(int libro) {
	return em.find(Libro.class, libro);	
	}
	/**
	 * Lista todos los libros
	 * @return
	 */
	public List<Libro> listarLibro(){
		String jpql = "SELECT * FROM libros.libro";
		Query query = em.createNativeQuery(jpql, Libro.class);
		List<Libro> nivel = query.getResultList();
		return nivel;	
	}
	/**
	 * Listar libros por titulo 
	 * @param titulo
	 * @return
	 */
	public List<Libro> listarLibroid(String titulo){
		String jpql = "SELECT * FROM libros.libro WHERE titulolibro=:titulo";
		Query query = em.createNativeQuery(jpql, Libro.class);
		query.setParameter("titulo", titulo);
		List<Libro> nivel = query.getResultList();
		return nivel;
	}
	/**
	 * Listar libro por categoria
	 * @param categoria
	 * @return
	 */
	public List<Libro> listarLibroPC(String categoria){
		String jpql = "SELECT p.id_Libro FROM libros.libro p, libros.categoria c where c.Categoria=:categoria";
		Query query = em.createNativeQuery(jpql, Libro.class);
		query.setParameter("categoria", categoria);
		List<Libro> listc = query.getResultList();
		return listc;
	}
	/**
	 * Devuelve el id de la tabla libro
	 * @return
	 */
	public int getid() {
		String jpql = "Select AUTO_INCREMENT from information_schema.TABLES where table_schema=\"libros\" AND table_name=\"libro\"";
		Query query = em.createNativeQuery(jpql, Categorias.class);
		int idc = query.getFirstResult();
		return idc;	
	}
}
