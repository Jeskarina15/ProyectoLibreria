package ups.edu.ec.jsfbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.accesosDatos.AutoresDAO;
import ups.edu.ec.modelo.Autor;

@ManagedBean
@ViewScoped
public class AutorBean {
	
	private Autor autor;
	
	private List<Autor> listarA;
	@Inject
	private AutoresDAO autorDAO; 

	@PostConstruct
	public void init() {
	autor=new Autor();	
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Autor> getListarA() {
		return listarA;
	}

	public void setListarA(List<Autor> listarA) {
		this.listarA = listarA;
	}
	public String nuevoAutor() {
		autorDAO.NuevoAutor(autor);
		listarAutores();
		return "Se ha creado el autor";
	}
	public String EliminarAutor(int autor) {
		autorDAO.eliminarAutor(autor);
		return "Se ha eliminado el autor";
	}
	public String ActualizarAutor(int idautor, String nombreA ) {
		autor.setIdautor(idautor);
		autor.setNombreautor(nombreA);
		autorDAO.ActualizarAutor(autor);
		return "se ha actualizado el autor";
	}
	public String listarAutores() {
		listarA=autorDAO.listarAutor();
		return null;
	}
	}
