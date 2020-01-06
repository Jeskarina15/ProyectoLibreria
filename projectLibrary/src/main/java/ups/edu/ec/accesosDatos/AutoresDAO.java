package ups.edu.ec.accesosDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Autor;



@Stateless
public class AutoresDAO {

	@Inject
	private EntityManager em;
	
	public void NuevoAutor(Autor autor) {
		//agrega una nueva isntancia de entidad al contexto de persistencia 
	em.persist(autor);	
	
	}
	public void ActualizarAutor(Autor autor) {
		//actualiza una instancia de entidad persistente con nuevos valores especificados en los campos
	em.merge(autor);	
	}
	public void eliminarAutor(int autor) {
		//Elimina una instancia de entidad persistente
	em.remove(leerAutor(autor));
	}
	public Autor leerAutor(int autor) {
	//Busqueda por clave principal, utilizando las propiedades especificadas (entidad de la clase especifica, clave primaria)
	return em.find(Autor.class,autor);	
	}
	//Listar todos los libros
	public List<Autor> listarAutor(){
		String jpql = "SELECT * FROM libros.categorias;";
		Query query = em.createNativeQuery(jpql, Autor.class);
		List<Autor> nivel = query.getResultList();
		return nivel;	
	}
}
