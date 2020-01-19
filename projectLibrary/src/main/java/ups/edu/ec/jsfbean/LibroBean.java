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
private int idc;
private Libro libro;
//lista para los libros
private List<Libro> libros;

@Inject
private LibroDAO libroDAO;
//private GestionLibroLocal gestioL;

//inicializamos libro para evitar el nullpointerexception
@PostConstruct
public void init() {
	libro =new Libro();
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
public int getIdc() {
	return idc;
}
public void setIdc(int idc) {
	this.idc = idc;
}
//listar los libros
public String listarLibros() {
	libros=libroDAO.listarLibro();
	return null;
}
//eliminar libro
public String EliminarLibro(int idLibro) {
	System.out.println(idLibro);
	libroDAO.eliminarLibro(idLibro);
	return "Se ha eliminado el libro ";
}
//actualizar libro
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

public String guardarLibro(Libro libro) {
	libroDAO.NuevoLibro(libro);
	return "se ha guardado el libro";
}
public String getId() {
	idc=libroDAO.getid();
	return null;
}
}
