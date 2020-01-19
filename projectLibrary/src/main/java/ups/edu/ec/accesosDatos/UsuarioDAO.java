package ups.edu.ec.accesosDatos;

import java.util.List;


import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Usuarios;
@Stateless
public class UsuarioDAO {
	// para crear y eliminar instancias de entidades persistentes
		//para encontrar entidades por su clave principal y para consultar sobre entidades.
	@Inject
	private EntityManager em;
	//metodo para crear un nuevo usuario	
	public void NuevoUsuario(Usuarios usuario) {
		//agrega una nueva isntancia de entidad al contexto de persistencia 
		em.persist(usuario);
	}
	public void ActualizarUsuario(Usuarios usuario) {
		//actualiza una instancia de entidad persistente con nuevos valores especificados en los campos
		em.merge(usuario);
	}
	public void EliminarUsuario(int idUsuario) {
		//Elimina una instancia de entidad persistente
		em.remove(leerUsuario(idUsuario));
	}
	
	public Usuarios leerUsuario(int idUsuario) {
		//Busqueda por clave principal, utilizando las propiedades especificadas (entidad de la clase especifica, clave primaria)
		return em.find(Usuarios.class, idUsuario);
	}
	//Listar todos los libros
	public List<Usuarios> listarUsuario(){
		String jpql = "SELECT * FROM libros.usuarios;";
		Query query = em.createNativeQuery(jpql, Usuarios.class);
		List<Usuarios> nivel = query.getResultList();
		return nivel;	
	}
	
}
