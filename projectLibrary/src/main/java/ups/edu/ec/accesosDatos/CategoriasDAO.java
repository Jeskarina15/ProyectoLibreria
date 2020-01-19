 package ups.edu.ec.accesosDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Categorias;



@Stateless
public class CategoriasDAO {

	@Inject
	private EntityManager em;
	
	public void NuevoCategoria(Categorias categoria) {
		//agrega una nueva isntancia de entidad al contexto de persistencia 
	em.persist(categoria);	
	
	}
	public void ActualizarCategoria(Categorias categoria) {
		//actualiza una instancia de entidad persistente con nuevos valores especificados en los campos
	em.merge(categoria);	
	}
	public void eliminarCategoria(int categoria) {
		//Elimina una instancia de entidad persistente
	em.remove(leerCategoria(categoria));
	}
	public Categorias leerCategoria(int categoria) {
	//Busqueda por clave principal, utilizando las propiedades especificadas (entidad de la clase especifica, clave primaria)
	return em.find(Categorias.class, categoria);	
	}
	//Listar todos los libros
	public List<Categorias> listarCategorias(){
		String jpql = "SELECT * FROM libros.categorias;";
		Query query = em.createNativeQuery(jpql, Categorias.class);
		List<Categorias> nivel = query.getResultList();
		return nivel;	
	}
	public List<Categorias> listarCategoriaN(){
		String jpql = "select Categorias from libros.categorias";
		Query query = em.createNativeQuery(jpql, Categorias.class);
		List<Categorias> categorias = query.getResultList();
		return categorias;	
	}
	
	
}
