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
		//agrega una nueva isntancia de entidad al contexto de persistencia 
	em.persist(libro);	
	
	}
	public void ActualizarLibro(Libro libro) {
		//actualiza una instancia de entidad persistente con nuevos valores especificados en los campos
	em.merge(libro);	
	}
	public void eliminarLibro(int libro) {
		//Elimina una instancia de entidad persistente
	em.remove(leerLibros(libro));
	}
	public Libro leerLibros(int libro) {
	//Busqueda por clave principal, utilizando las propiedades especificadas (entidad de la clase especifica, clave primaria)
	return em.find(Libro.class, libro);	
	}
	//Listar todos los libros
	public List<Libro> listarLibro(){
		String jpql = "SELECT * FROM libros.productos;";
		Query query = em.createNativeQuery(jpql, Libro.class);
		List<Libro> nivel = query.getResultList();
		return nivel;	
	}
	
}
