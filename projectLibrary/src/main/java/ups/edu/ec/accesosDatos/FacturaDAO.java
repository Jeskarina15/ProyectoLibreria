package ups.edu.ec.accesosDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ups.edu.ec.modelo.Libro;
import ups.edu.ec.modelo.Usuarios;
@Stateless
public class FacturaDAO {

	@Inject
	private EntityManager em;
	public List<Libro> desclibrosMeG() {
		String jpql = "SELECT * FROM libros.libros order by megusta desc";
		Query query = em.createNativeQuery(jpql,Libro.class);
		List<Libro>  lista=query.getResultList();
		return lista;
	}
	public List<Libro> repetidoscomprados() {
		String jpql = "SELECT * FROM libros.factura_detalles, libros.libros Where fac_det_libro=idlibro GROUP BY fac_det_libro HAVING COUNT(*)>1";
		Query query = em.createNativeQuery(jpql, Libro.class);
		List<Libro> lista=query.getResultList();
		return lista;
	}
	public List<Integer> cantidadrepetidos(){
		String jpql = "SELECT COUNT(fac_det_libro) FROM libros.factura_detalles, libros.libros Where fac_det_libro=idlibro GROUP BY fac_det_libro HAVING COUNT(*)>1";
		Query query = em.createNativeQuery(jpql);
		List<Integer> lista=query.getResultList();
		return lista;
	}
	public List<Integer> usuariosrepetidos(){
		String jpql = "SELECT COUNT(fac_cab_usuario_usu_id) FROM libros.facturas_cabecera, libros.usuarios Where fac_cab_usuario_usu_id=usu_id GROUP BY fac_cab_usuario_usu_id HAVING COUNT(*)>1";
		Query query = em.createNativeQuery(jpql);
		List<Integer> lista=query.getResultList();
		return lista;
	}
	public List<Usuarios> usuariosmascomprados() {
		String jpql = "SELECT * FROM libros.facturas_cabecera, libros.usuarios Where fac_cab_usuario_usu_id=usu_id GROUP BY fac_cab_usuario_usu_id HAVING COUNT(*)>1";
		Query query = em.createNativeQuery(jpql,Usuarios.class);
		List<Usuarios> lista=query.getResultList();
		return lista;
	}
}
