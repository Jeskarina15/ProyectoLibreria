package ups.edu.ec.jsfbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.accesosDatos.CategoriasDAO;
import ups.edu.ec.modelo.Categorias;


@ManagedBean
@ViewScoped
public class CategoriaBean {

private Categorias c;

private List<Categorias> listarCtgs;
private int idc;
@Inject
private CategoriasDAO categoriaDAO;
	

	@PostConstruct
	public void init() {
	c=new Categorias();
	}
	/**
	 * 
	 * @return
	 */
	public Categorias getCategoria() {
		return c;
	}
	/**
	 * 
	 * @param categoria
	 */
	public void setCategoria(Categorias categoria) {
		this.c = categoria;
	}
	/**
	 * 
	 * @return
	 */
	public List<Categorias> getListarCtgs() {
		return listarCtgs;
	}
	/**
	 * 
	 * @param listarCtgs
	 */
	public void setListarCtgs(List<Categorias> listarCtgs) {
		this.listarCtgs = listarCtgs;
	}
/**
 * 
 * @return
 */
public String NuevaCategoria() {
	categoriaDAO.NuevoCategoria(c);
	ListarCategoria();
	 return "Se ha guardado la categoria";
}
/**
 * 
 * @return
 */
public String ListarCategoria() {
	listarCtgs= categoriaDAO.listarCategorias();
	return null;
}
/**
 * 
 * @param categoria
 * @return
 */
public String EliminarCategoria(int categoria) {
	categoriaDAO.eliminarCategoria(categoria);
	return "se ha eliminado la categoria";
}
/**
 * 
 * @param idc
 * @param categoria
 * @return
 */
public String ActualizarCategoria(int idc, String categoria) {
	c.setIdcategoria(idc);
	c.setCategoria(categoria);
	categoriaDAO.ActualizarCategoria(c);
	return "Se ha actualizado la categoria";
}
/**
 * 
 * @return
 */
public int getIdc() {
	return idc;
}
/**
 * 
 * @param idc
 */
public void setIdc(int idc) {
	this.idc = idc;
}
/**
 * 
 * @return
 */
public String getId() {
	idc=categoriaDAO.getid();
	return null;
}
}
