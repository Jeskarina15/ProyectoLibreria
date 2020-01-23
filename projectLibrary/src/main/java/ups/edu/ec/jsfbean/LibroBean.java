package ups.edu.ec.jsfbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.accesosDatos.LibroDAO;
import ups.edu.ec.modelo.Libro;

@ManagedBean
@ViewScoped
public class LibroBean {

private Integer idc;
private Libro libro;
private List<Libro> libros;
@Inject
private LibroDAO libroDAO;
@PostConstruct
public void init() {
	libro =new Libro();
	idc=libroDAO.getid();
}
/**
 * metodo getlibro
 * @return
 */
public Libro getLibro() {
	return libro;
}
/**
 * metodo setlibro
 * @param libro
 */
public void setLibro(Libro libro) {
	this.libro = libro;
}
/**
 * metodo get lista de libros
 * @return
 */
public List<Libro> getLibros() {
	return libros;
}
/**
 * metodo set libros
 * @param libros recibe una lista de tipo libro
 */
public void setLibros(List<Libro> libros) {
	this.libros = libros;
}


public Integer getIdc() {
	return idc;
}
public void setIdc(Integer idc) {
	this.idc = idc;
}
/**
 * 
 * @return
 */
public String listarLibros() {
	libros=libroDAO.listarLibro();
	return null;
}
/**
 * 
 * @param idLibro
 * @return
 */
public String EliminarLibro(int idLibro) {
	System.out.println(idLibro);
	libroDAO.eliminarLibro(idLibro);
	return "Se ha eliminado el libro ";
}
/**
 * 
 * @param idLibro
 * @param ISBN
 * @param desc
 * @param edicion
 * @param Image
 * @param Titulo
 * @param nump
 * @return
 */
public String ActualizarLibro(int idLibro, String ISBN, String desc, String edicion, String Image,String Titulo, int nump) {
	libro.setIdlibro(idLibro);
	libro.setIsbn(ISBN);
	libro.setDesclibro(desc);
	libro.setEdicion(edicion);
	libro.setImage(Image);
	libro.setTitulolibro(Titulo);
	libro.setNumeroP(nump);
	libroDAO.ActualizarLibro(libro);
	return "Se ha actualizado correctamente";
	
}
/**
 * 
 * @return
 */
public String guardarLibro() {
	libroDAO.NuevoLibro(libro);
	return "se ha guardado el libro";
}
/**
 * 
 * @return
 */
public String getId() {
	idc=libroDAO.getid();
	return null;
}
}
