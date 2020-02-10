package ups.edu.ec.accesosDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Categorias;
import ups.edu.ec.modelo.Libro;
import ups.edu.ec.modelo.Like;
import ups.edu.ec.modelo.Usuarios;
@Stateless
/**
 * 
 * @author china
 *
 */
public class LibroDAO {

	@Inject
	private EntityManager em;
	
	private Like like;
	
	
	public LibroDAO() {
		like = new Like();
	}
	/**
	 * metodo para crear un nuevo libro	
	 * @param libro
	 */
	public void NuevoLibro(Libro libro, int cat, int autor) {
		String jpql = "INSERT INTO libros.libros (desclibro,edicion,image,isbn,lib_precio,megusta,numeropag,stock,titulolibro,autorlibro_idautor,categorialibro_idcategoria)\r\n" + 
				"VALUES ('"+libro.getDesclibro()+"'"+", '"+libro.getEdicion()+"','"+libro.getImage()+"', '"+libro.getIsbn()+"', "+libro.getLib_precio()+","+libro.getMegusta()+","+libro.getNumeropag()+","+libro.getStock()+", '"+libro.getTitulolibro()+"',"
						+ ""+autor+","+cat+");";
		Query query = em.createNativeQuery(jpql, Libro.class);
		query.executeUpdate();
	}
	
	public boolean darMegusta(String libro, int usuario) {
		try {
			String conLikes = "SELECT * from likes where lik_isbn = '"+libro+"' and lik_usuario_usu_id = "+usuario+";";
			String conCodigo = "SELECT max(lik_id) from likes;";
			Query queLikes = em.createNativeQuery(conLikes, Like.class);
			Query queCodigo = em.createNativeQuery(conCodigo, Like.class);
			List<Like> likes = queLikes.getResultList();
			int codigo = (int)queCodigo.getSingleResult();
			if(likes.isEmpty()) {
				like.setLik_id(codigo+1);
				like.setEstado(1);
				like.setLik_isbn(libro);
				like.setLik_usuario(em.find(Usuarios.class, usuario));
				em.persist(like);
				return true;
			}
			else {
				like = likes.get(0);
				if(like.getEstado()==0) {
					like.setEstado(1);
					em.merge(like);
					return true;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println("Se ah producido la siguiente excepción: "+e.toString());
			return false;
		}
	}
	
	/**
	 * Actualizar datos de la entidad libro, pasando como parametro un objeto tipo libro
	 * 
	 * @param libro
	 */
	public void ActualizarLibro(Libro libro) {
	em.merge(libro);	
	}
	/**
	 * Elimina un libro, pasando como parametro un atributo tipo entero
	 * @param libro
	 */
	public void eliminarLibro(int libro) {
		System.out.println("estoy aqui");
		String jpql = "update libros.libros SET autorlibro_idautor=null, categorialibro_idcategoria=null WHERE idlibro=:libro";
		Query query = em.createNativeQuery(jpql);
		query.setParameter("libro", libro);
		query.executeUpdate();
	
		em.remove(leerLibros(libro));
	}
	/**
	 * Buscar un libro, pasando como parametro un atributo tipo entero 
	 * @param libro
	 * @return
	 */
	public Libro leerLibros(int libro) {
	return em.find(Libro.class, libro);
	}
	/**
	 * Lista todos los libros
	 * @return
	 */
	public List<Libro> listarLibro(){
		String jpql = "SELECT * FROM libros.libros";
		Query query = em.createNativeQuery(jpql, Libro.class);
		List<Libro> nivel = query.getResultList();
		return nivel;	
	}
	/**
	 * Listar libros por titulo 
	 * @param titulo
	 * @return
	 */
	public List<Libro> listarLibroid(String titulo){
		String jpql = "SELECT * FROM libros.libros WHERE titulolibro=:titulo";
		Query query = em.createNativeQuery(jpql, Libro.class);
		query.setParameter("titulo", titulo);
		List<Libro> nivel = query.getResultList();
		return nivel;
	}
	/**
	 * Listar libro por categoria
	 * @param categoria
	 * @return
	 */
	public List<Libro> listarLibroPC(String categoria){
		String jpql = "SELECT p.id_Libro FROM libros.libros p, libros.categoria c where c.Categoria=:categoria";
		Query query = em.createNativeQuery(jpql, Libro.class);
		query.setParameter("categoria", categoria);
		List<Libro> listc = query.getResultList();
		return listc;
	}
	public List<Libro> listarLibrosMasVendidos(){
		String jpql = "SELECT * FROM libros.factura_detalles, libros.libros Where fac_det_libro=idlibro GROUP BY fac_det_libro HAVING COUNT(*)>1;";
		Query query = em.createNativeQuery(jpql, Libro.class);
		List<Libro> listc = query.getResultList();
		return listc;
	}
	/**
	 * Devuelve el id de la tabla libro
	 * @return
	 */
	public int getid() {
		String jpql = "Select AUTO_INCREMENT from information_schema.TABLES where table_schema=\"libros\" AND table_name=\"libros\"";
		Query query = em.createNativeQuery(jpql);
		Integer v= new Integer(query.getResultList().get(0).toString());
		return v;	
	}
}
