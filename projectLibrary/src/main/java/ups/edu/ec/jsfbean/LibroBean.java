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
import ups.edu.ec.modelo.Autor;
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
private Categorias c;
private Autor a;
@PostConstruct
public void init() {
	libro =new Libro();
	c=new Categorias();
	 a=new Autor();
	listarLibros();
}

public Categorias getC() {
	return c;
}

public void setC(Categorias c) {
	this.c = c;
}

public Autor getA() {
	return a;
}

public void setA(Autor a) {
	this.a = a;
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
public String guardarLibro( String ISBN, String desc, String edicion, String Image,String Titulo, int nump,String cat, String autor) {
	System.out.println("Datos"+ISBN+"+"+desc+"+"+edicion+"+"+Image+"+"+ Titulo+"+"+ nump+"+"+ cat+"+"+ autor);
	int aut= autoresDAO.getidautor(autor);
	int cate=categoriasDAO.getidcategoria(cat);
	libro.setDesclibro(desc);
	libro.setIsbn(ISBN);
	libro.setEdicion(edicion);
	libro.setImage(Image);
	libro.setTitulolibro(Titulo);
	libro.setNumeroP(nump);
	libroDAO.NuevoLibro(libro, aut,cate);
	return "se ha guardado el libro";
}
}
