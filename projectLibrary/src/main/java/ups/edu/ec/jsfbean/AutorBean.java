package ups.edu.ec.jsfbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.accesosDatos.AutoresDAO;
import ups.edu.ec.modelo.Autor;

@ManagedBean
@RequestScoped
public class AutorBean {
	
	private Autor autor;
	private List<Autor> listarA;
	private List<String> listNA;
	@Inject
	private AutoresDAO autorDAO; 

	@PostConstruct
	public void init() {
	autor=new Autor();	
	listNA=autorDAO.listarNAutor();
	listarAutores();

	}
	public List<String> getListNA() {
		return listNA;
	}

	public void setListNA(List<String> listNA) {
		this.listNA = listNA;
	}

	/**
	 * metodo get autor
	 * @return
	 */
	public Autor getAutor() {
		return autor;
	}
	/**
	 * metodo set autor
	 * @param autor
	 */
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	/**
	 * metodo getlista
	 * @return
	 */
	public List<Autor> getListarA() {
		return listarA;
	}
	/**
	 * metodo setlista
	 * @param listarA
	 */
	public void setListarA(List<Autor> listarA) {
		this.listarA = listarA;
	}
	/**
	 * metodo clase bean, crear nuevo autor 
	 * @return
	 */
	public String nuevoAutor() {
		autorDAO.NuevoAutor(autor);
		listarAutores();
		return "Se ha creado el autor";
	}
	/**
	 * metodo clase bean, eliminar autor
	 * @param autor
	 * @return
	 */
	public String EliminarAutor(int autor) {
		autorDAO.eliminarAutor(autor);
		return "Se ha eliminado el autor";
	}
	/**
	 * metodo clase bean, actualizar autor
	 * @param idautor
	 * @param nombreA
	 * @return
	 */
	public String ActualizarAutor(int idautor, String nombreA ) {
		autor.setIdautor(idautor);
		autor.setNombreautor(nombreA);
		autorDAO.ActualizarAutor(autor);
		return "se ha actualizado el autor";
	}
	/**
	 * metodo clase bean, listar autores
	 * @return
	 */
	public String listarAutores() {
		listarA=autorDAO.listarAutor();
		return null;
	}
	}
