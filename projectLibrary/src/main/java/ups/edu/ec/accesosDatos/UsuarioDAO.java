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
		try {
			String jpql = "INSERT INTO usuarios (usu_email, usu_nombre, usu_password, usu_rol, usu_telefono, usu_usuario)\r\n" + 
					"VALUES ('"+usuario.getUsu_email()+"'"+", '"+usuario.getUsu_nombre()+"', '"+usuario.getUsu_password()+"', '"
							+ "usuario','"+usuario.getUsu_telefono()+"'"+", '"+usuario.getUsu_usuario()+"');";
			Query query = em.createNativeQuery(jpql, Usuarios.class);
			query.executeUpdate();
		} catch (Exception e) {
			System.out.println("Se ah dado la siguiente excepción: "+e.toString());
		}
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
	 * Listar todos los Usuarios
	 * @return una lista de tipo Usuarios
	 */
	public List<Usuarios> listarUsuario(){
		String jpql = "SELECT * FROM libros.usuarios";
		Query query = em.createNativeQuery(jpql, Usuarios.class);
		List<Usuarios> nivel = query.getResultList();
		return nivel;	
	}
	/**
	 * 
	 * @param usuario nombre de usuario para iniciar sesion
	 * @param password contrasenia de usuario para iniciar sesion
	 * @return devuelve true si devuelve un resultado y false si no se recibe nada 
	 */
	public boolean confirmarClave(String usuario, String password){
		String jpql = "SELECT * FROM libros.usuarios where usu_usuario=:usuario and usu_password=:psw and usu_rol='Administrador'";
		Query query = em.createNativeQuery(jpql, Usuarios.class);
		query.setParameter("usuario",usuario);
		query.setParameter("psw",password);
		List<Usuarios> us=query.getResultList();
		boolean estado=true;
		if (us.size()<=0) {
			estado=false;
			return estado;
		} else if(us.size()>0){
			return estado;
		}
		return estado;
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
