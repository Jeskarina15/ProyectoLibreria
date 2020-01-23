 package ups.edu.ec.accesosDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Categorias;



@Stateless
public class CategoriasDAO {

	@Inject
	private EntityManager em;
	/**
	 * agrega una nueva isntancia de entidad al contexto de persistencia 
	 * @param categoria
	 */
	public void NuevoCategoria(Categorias categoria) {
		em.persist(categoria);	
	}
	/**
	 * actualiza una instancia de entidad persistente con nuevos valores especificados en los campos
	 * @param categoria
	 */
	public void ActualizarCategoria(Categorias categoria) {
	em.merge(categoria);	
	}
	/**
	 * Elimina una instancia de entidad persistente
	 * @param categoria
	 */
	public void eliminarCategoria(int categoria) {
	em.remove(leerCategoria(categoria));
	}
	/**
	 * Busqueda por clave principal, utilizando las propiedades especificadas (entidad de la clase especifica, clave primaria)
	 * @param categoria
	 * @return
	 */
	public Categorias leerCategoria(int categoria) {
	return em.find(Categorias.class, categoria);	
	}
	/**
	 * Listar todas los datos de la tabla categoria
	 * @return
	 */
	public List<Categorias> listarCategorias(){
		String jpql = "SELECT * FROM libros.categoria";
		Query query = em.createNativeQuery(jpql, Categorias.class);
		List<Categorias> nivel = query.getResultList();
		return nivel;	
	}
	public List<String> listarCt(){
		String jpql = "SELECT categoria FROM libros.categoria";
		Query query = em.createNativeQuery(jpql);
		List<String> nivel = query.getResultList();
		return nivel;	
	}
	/**
	 * @return  Devuelve el id de la tabla categoria
	 */
	public int getid() {
		String jpql = "Select AUTO_INCREMENT from information_schema.TABLES where table_schema=\"libros\" AND table_name=\"categoria\"";
		Query query = em.createNativeQuery(jpql);
		Integer v= new Integer(query.getResultList().get(0).toString());
		return v;	
	}
	public int getidcategoria(String categoria) {
		String jpql = "select idcategoria from libros.categoria where categoria=:categoria";
		Query query = em.createNativeQuery(jpql);
		query.setParameter("categoria", categoria);
		List<Integer> nivel = query.getResultList();
		return nivel.get(0);
	}
	
	
}
