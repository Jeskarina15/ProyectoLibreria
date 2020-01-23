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
	public List<Integer> getid() {
		String jpql = "Select AUTO_INCREMENT from information_schema.TABLES where table_schema=\"libros\" AND table_name=\"usuarios\"";
		Query query = em.createNativeQuery(jpql, Categorias.class);
		List<Integer> idc=query.getResultList();
		return idc;	
	}
}
