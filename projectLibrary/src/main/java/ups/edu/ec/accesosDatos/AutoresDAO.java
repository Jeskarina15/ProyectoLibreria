package ups.edu.ec.accesosDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Autor;
import ups.edu.ec.modelo.Categorias;



@Stateless
public class AutoresDAO {

	@Inject
	private EntityManager em;
	
	/**
	 * agrega una nueva isntancia de entidad al contexto de persistencia 
	 * @param autor 
	 */
	public void NuevoAutor(Autor autor) {
	em.persist(autor);	
	}
	/**
	 *actualiza una instancia de entidad persistente con nuevos valores especificados en los campos
	 * @param autor
	 */
	public void ActualizarAutor(Autor autor) {
	em.merge(autor);	
	}
	/**
	 * Eliminar un autor, pasando como parametro un objeto tipo autor
	 * Elimina una instancia de entidad persistente
	 * @param autor
	 */
	public void eliminarAutor(int autor) {
	em.remove(leerAutor(autor));
	}
	/**
	 * Busqueda por clave principal, utilizando las propiedades especificadas (entidad de la clase especifica, clave primaria)
	 * @param autor
	 * @return
	 */
	public Autor leerAutor(int autor) {
	return em.find(Autor.class,autor);	
	}
	/**
	 * Listar todos los autores
	 * @return devuelve una lista del resultado del query
	 */
	public List<Autor> listarAutor(){
		String jpql = "SELECT * FROM libros.autor";
		Query query = em.createNativeQuery(jpql, Autor.class);
		List<Autor> nivel = query.getResultList();
		return nivel;	
	}
	/**
	 * listar nombres de autores
	 * @returndevuelve una lista del resultado del query
	 */
	public List<String> listarNAutor(){
		String jpql = "select nombreautor from libros.autor";
		Query query = em.createNativeQuery(jpql);
		List<String> nombre = query.getResultList();
		return nombre;	
	}
	/**
	 * devuelve el valor de id de la tabla autor
	 * @return
	 */
	public int getid() {
		String jpql = "Select AUTO_INCREMENT from information_schema.TABLES where table_schema=\"libros\" AND table_name=\"autor\"";
		Query query = em.createNativeQuery(jpql);
		Integer v= new Integer(query.getResultList().get(0).toString());
		return v;	
	}
	/**
	 * @param autor nombre del autor del cual se extraera el id
	 * @return devuelve el id del autor
	 */
	public int getidautor(String autor) {
		String jpql = "SELECT idautor FROM libros.autor where nombreautor=:autor";
		Query query = em.createNativeQuery(jpql);
		query.setParameter("autor", autor);
		Integer v= new Integer(query.getResultList().get(0).toString());
		System.out.println("mi valor de v="+v);
		return v;
	}
}
