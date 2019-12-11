package ups.edu.ec.jsfbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.accesosDatos.LibroDAO;
import ups.edu.ec.modelo.Autor;
import ups.edu.ec.modelo.Categorias;
import ups.edu.ec.modelo.Libro;

@ManagedBean
@ViewScoped
public class LibroBean {

private Libro libro;

private List<Libro> libros;

@Inject
private LibroDAO libroDAO;

@PostConstruct
public void init() {
	libro =new Libro();
	libro.addAutor(new Autor());
	libro.addCategorias(new Categorias());
}

public Libro getLibro() {
	return libro;
}

public void setLibro(Libro libro) {
	this.libro = libro;
}

public List<Libro> getLibros() {
	return libros;
}

public void setLibros(List<Libro> libros) {
	this.libros = libros;
}

public String crearLibro() {
	System.out.println(libro);
	libroDAO.NuevoLibro(libro);
	listarLibros();
	
	return null;
}
public String addAutores() {
	libro.addAutor(new Autor());
	return null;
}
public String addCategoria() {
	libro.addCategorias(new Categorias());
	return null;
}

public String listarLibros() {
	libros=libroDAO.listarLibro();
	return null;
}
public String EliminarLibro(int idLibro) {
	System.out.println(idLibro);
	libroDAO.eliminarLibro(idLibro);
	return null;
}
public String ActualizarLibro(int idLibro, String ISBN, String desc, String edicion, String Image,String Titulo, int nump) {
	libro.setIdLibro(idLibro);
	libro.setISBN(ISBN);
	libro.setDescLibro(desc);
	libro.setEdicion(edicion);
	libro.setImageURL(Image);
	libro.setNombreLibro(Titulo);
	libro.setNumeroP(nump);
	libroDAO.ActualizarLibro(libro);
	return null;
	
}
}
