package ups.edu.ec.accesosDatos;

import java.util.List;


import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Categorias;
import ups.edu.ec.modelo.Usuarios;
@Stateless
public class UsuarioDAO {
	
	@Inject
	private EntityManager em;
	
	/**
	 * metodo para crear un nuevo usuario
	 * agrega una nueva isntancia de entidad al contexto de persistencia
	 * @param usuario
	 */
	public void NuevoUsuario(Usuarios usuario) {
		em.persist(usuario);
	}
	/**
	 * actualiza una instancia de entidad persistente con nuevos valores especificados en los campos
	 * @param usuario
	 */
	public void ActualizarUsuario(Usuarios usuario) {
		em.merge(usuario);
	}
	/**
	 * Elimina una instancia de entidad persistente
	 * @param idUsuario
	 */
	public void EliminarUsuario(int idUsuario) {
		em.remove(leerUsuario(idUsuario));
	}
	/**
	 * Busqueda por clave principal, utilizando las propiedades especificadas (entidad de la clase especifica, clave primaria)
	 * @param idUsuario
	 * @return
	 */
	public Usuarios leerUsuario(int idUsuario) {
		return em.find(Usuarios.class, idUsuario);
	}
	/**
	 * Listar todos los libros
	 * @return
	 */
	public List<Usuarios> listarUsuario(){
		String jpql = "SELECT * FROM libros.usuarios";
		Query query = em.createNativeQuery(jpql, Usuarios.class);
		List<Usuarios> nivel = query.getResultList();
		return nivel;	
	}
	/**
	 * Devuelve el id de la tabla usuarios
	 * @return
	 */
	public int getid() {
		String jpql = "Select AUTO_INCREMENT from information_schema.TABLES where table_schema=\"libros\" AND table_name=\"usuarios\"";
		Query query = em.createNativeQuery(jpql);
		Integer v= new Integer(query.getResultList().get(0).toString());
		return v;	
	}
	
	public int loguear(String email, String contra) {
		String jpql = "select usu_id from usuarios where usu_email=\""+email+"\" AND usu_password=\""+contra+"\";";
		Query query = em.createNativeQuery(jpql);
		
		if(query.getResultList().size()!=0) {
			return (Integer)query.getResultList().get(0);
		}
		return -1;
	}
}
