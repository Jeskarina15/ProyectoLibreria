package ups.edu.ec.jsfbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.modelo.Categorias;
import ups.edu.ec.negocio.GestionLibroLocal;

@ManagedBean
@ViewScoped
public class CategoriaBean {

private Categorias categoria;

private List<Categorias> listarCtgs;
	
@Inject
private GestionLibroLocal gestioL;
	
	@PostConstruct
	public void init() {
	categoria=new Categorias();
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public List<Categorias> getListarCtgs() {
		return listarCtgs;
	}

	public void setListarCtgs(List<Categorias> listarCtgs) {
		this.listarCtgs = listarCtgs;
	}

	public GestionLibroLocal getGestioL() {
		return gestioL;
	}

	public void setGestioL(GestionLibroLocal gestioL) {
		this.gestioL = gestioL;
	}
public String GuardarCategoria(Categorias categoria) {
	 gestioL.NuevoCategoria(categoria);
	 
	 return "Listado-Categorias";
}
	
}
