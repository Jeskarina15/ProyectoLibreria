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
	private int idc;
	private List<Autor> listarA;
	@Inject
	private AutoresDAO autorDAO; 

	@PostConstruct
	public void init() {
	autor=new Autor();	
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
	 * metodo getid
	 * @return
	 */
	public int getIdc() {
		return idc;
	}
	/**
	 * metodo setid
	 * @param idc
	 */
	public void setIdc(int idc) {
		this.idc = idc;
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
	/**
	 * metodo clase bean, obtener id
	 * @return
	 */
	public String getId() {
		idc=autorDAO.getid();
		return null;
	}
	}
