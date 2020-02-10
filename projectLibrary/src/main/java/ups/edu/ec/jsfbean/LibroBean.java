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
private List<Libro> librosm;
private List<Libro> librost;
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

public List<Libro> getLibrosm() {
	return librosm;
}

public void setLibrosm(List<Libro> librosm) {
	this.librosm = librosm;
}

public List<Libro> getLibrost() {
	return librost;
}

public void setLibrost(List<Libro> librost) {
	this.librost = librost;
}

/**
 * Metodo para listar todos los libros
 * @return
 */
public String listarLibros() {
	libros=libroDAO.listarLibro();
	return null;
}
/**
 * metodo para listar todos los libros o los libros mas vendidos
 * @param tipo
 * @return
 */
public String listarLibrosT(String tipo) {
	System.out.println("........................"+tipo);
	if (tipo.equals("Libros")) {
	libros=libroDAO.listarLibro();
		
	}else if(tipo.equals("MasVendidos")) {
	libros=libroDAO.listarLibrosMasVendidos();
	}
	
	return null;
	}
/**
 * 
 * @param idLibro
 * @return
 */
public String EliminarLibro(int idLibro) {
	System.out.println("..........................................................."+idLibro);
	libroDAO.eliminarLibro(idLibro);
	return null;
}
/**
 * Parametros requeridos para actualizar un libro
 * @param idLibro
 * @param ISBN
 * @param desc
 * @param edicion
 * @param Image
 * @param Titulo
 * @param nump
 * @return
 */
public String ActualizarLibro(int idLibro, String ISBN, String desc, String edicion, String Image,String Titulo, int nump,int stock, double precio) {
	libro.setIdlibro(idLibro);
	libro.setIsbn(ISBN);
	libro.setDesclibro(desc);
	libro.setEdicion(edicion);
	libro.setImage(Image);
	libro.setTitulolibro(Titulo);
	libro.setNumeropag(nump);
	libro.setStock(stock);
	libro.setLib_precio(precio);
	System.out.println(libro);
	libroDAO.ActualizarLibro(libro);
	
	return "Se ha actualizado correctamente";
	
}
/**
 * Insertar un libro determinando el id de las tablas categoria y autores
 * @param ISBN
 * @param desc
 * @param edicion
 * @param Image
 * @param Titulo
 * @param nump
 * @param cat
 * @param autor
 * @param stock
 * @param precio
 * @return
 */
public String guardarLibro( String ISBN, String desc, String edicion, String Image,String Titulo,int nump,String cat, String autor, int stock, double precio) {
	
	int aut= autoresDAO.getidautor(autor);
	int cate=categoriasDAO.getidcategoria(cat);
	libro.setDesclibro(desc);
	libro.setIsbn(ISBN);
	libro.setEdicion(edicion);
	libro.setImage(Image);
	libro.setTitulolibro(Titulo);
	libro.setNumeropag(nump);
	libro.setMegusta(0);
	libro.setStock(stock);
	libro.setLib_precio(precio);
	libroDAO.NuevoLibro(libro, cate, aut);
	return "se ha guardado el libro";
}
}
