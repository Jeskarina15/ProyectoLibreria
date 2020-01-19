package ups.edu.ec.jsfbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.accesosDatos.CategoriasDAO;
import ups.edu.ec.modelo.Categorias;
import ups.edu.ec.negocio.GestionLibroLocal;

@ManagedBean
@ViewScoped
public class CategoriaBean {

private Categorias c;

private List<Categorias> listarCtgs;
	
@Inject
private CategoriasDAO categoriaDAO;
	
	@PostConstruct
	public void init() {
	c=new Categorias();
	}

	public Categorias getCategoria() {
		return c;
	}

	public void setCategoria(Categorias categoria) {
		this.c = categoria;
	}

	public List<Categorias> getListarCtgs() {
		return listarCtgs;
	}

	public void setListarCtgs(List<Categorias> listarCtgs) {
		this.listarCtgs = listarCtgs;
	}

public String GuardarCategoria(Categorias categoria) {
	categoriaDAO.NuevoCategoria(categoria);
	 return "Se guardado la categoria";
}
public String ListarCategoria() {
	listarCtgs= categoriaDAO.listarCategoriaN();
	return null;
}
public String EliminarCategoria(int categoria) {
	categoriaDAO.eliminarCategoria(categoria);
	return "se ha eliminado la categoria";
}
public String ActualizarCategoria(int idc, String categoria) {
	c.setIdcategoria(idc);
	c.setCategoria(categoria);
	categoriaDAO.ActualizarCategoria(c);
	return "Se ha actualizado la categoria";
}	
}
