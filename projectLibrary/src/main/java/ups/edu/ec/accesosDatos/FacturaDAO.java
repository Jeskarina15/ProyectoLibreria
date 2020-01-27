package ups.edu.ec.accesosDatos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
@Stateless
public class FacturaDAO {

	@Inject
	private EntityManager em;
	public int getidcategoria(String categoria) {
		String jpql = "SELECT idcategoria FROM libros.categoria where categoria=:categoria";
		Query query = em.createNativeQuery(jpql);
		query.setParameter("categoria", categoria);
		Integer v= new Integer(query.getResultList().get(0).toString());
		System.out.println("mi valor de v="+v);
		return v;
	}
}
