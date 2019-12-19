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
import ups.edu.ec.negocio.GestionLibroLocal;

@ManagedBean
@ViewScoped
public class LibroBean {

	//atributo tipo libro 
private Libro libro;
//lista para los libros
private List<Libro> libros;

@Inject
private GestionLibroLocal gestioL;

//inicializamos libro para evitar el nullpointerexception
@PostConstruct
public void init() {
	libro =new Libro();
	libro.addAutor(new Autor());
	libro.addCategorias(new Categorias());
}
//gets y sets de los atributos
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
//crear libro
public String crearLibro() {
	System.out.println(libro);
	//libroDAO.NuevoLibro(libro);
	//listarLibros();
	
	return null;
}
//agregAr un nuevo autor
public String addAutores() {
	libro.addAutor(new Autor());
	return null;
}
//agregar una categoria
public String addCategoria() {
	libro.addCategorias(new Categorias());
	return null;
}


//listar los libros
/*public String listarLibros() {
	libros=libroDAO.listarLibro();
	return null;
}*/
//eliminar libro
/*public String EliminarLibro(int idLibro) {
	System.out.println(idLibro);
	libroDAO.eliminarLibro(idLibro);
	return null;
}*/
//actualizar libro
/*public String ActualizarLibro(int idLibro, String ISBN, String desc, String edicion, String Image,String Titulo, int nump) {
	libro.setIdLibro(idLibro);
	libro.setISBN(ISBN);
	libro.setDescLibro(desc);
	libro.setEdicion(edicion);
	libro.setImageURL(Image);
	libro.setNombreLibro(Titulo);
	libro.setNumeroP(nump);
	libroDAO.ActualizarLibro(libro);
	return null;
	
}*/

public String guardarLibro(Libro libro) {
	
	gestioL.NuevoLibro(libro);
	libros=gestioL.listarLibro();
	
	return "listado-libros";
}
}
