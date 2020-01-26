package ups.edu.ec.jsfbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.accesosDatos.AutoresDAO;
import ups.edu.ec.accesosDatos.CategoriasDAO;
import ups.edu.ec.accesosDatos.LibroDAO;
import ups.edu.ec.modelo.Categorias;
import ups.edu.ec.modelo.Libro;

@ManagedBean
@RequestScoped
public class LibroBean {

private Libro libro;
private List<Libro> libros;
@Inject
private LibroDAO libroDAO;
@Inject
private CategoriasDAO categoriasDAO;
@Inject 
private AutoresDAO autoresDAO;
@PostConstruct
public void init() {
	libro =new Libro();
	listarLibros();
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
public String guardarLibro(String cat, String autor) {
	int aut= autoresDAO.getidautor(autor);
	int cate=categoriasDAO.getidcategoria(cat);
	libro.getCategorialibro().setIdcategoria(cate);
	libro.getAutorlibro().setIdautor(aut);
	libroDAO.NuevoLibro(libro);
	return "se ha guardado el libro";
}
}
