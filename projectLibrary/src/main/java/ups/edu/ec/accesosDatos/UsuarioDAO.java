package ups.edu.ec.accesosDatos;

import java.util.List;


import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Usuarios;
@Stateless
public class UsuarioDAO {

	@Inject
	private EntityManager em;
	
	public void NuevoUsuario(Usuarios usuario) {
		em.persist(usuario);
	}
	public void ActualizarUsuario(Usuarios usuario) {
		em.merge(usuario);
	}
	public void EliminarLibro(int idUsuario) {
		em.remove(leerUsuario(idUsuario));
	}
	
	public Usuarios leerUsuario(int idUsuario) {
		
		return em.find(Usuarios.class, idUsuario);
	}
	public List<Usuarios> listarUsuario(){
		String jpql = "SELECT * FROM libros.usuarios;";
		Query query = em.createNativeQuery(jpql, Usuarios.class);
		List<Usuarios> nivel = query.getResultList();
		return nivel;	
	}
}
