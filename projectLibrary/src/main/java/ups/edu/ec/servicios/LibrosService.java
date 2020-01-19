package ups.edu.ec.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ups.edu.ec.accesosDatos.LibroDAO;
import ups.edu.ec.modelo.Autor;
import ups.edu.ec.modelo.Categorias;
import ups.edu.ec.modelo.Libro;
import ups.edu.ec.modelo.Usuarios;
import ups.edu.ec.negocio.GestionLibroLocal;

//@Path("libros")
@WebService
public class LibrosService {
	
	@Inject
	private GestionLibroLocal gl;
	
	//@GET
	//@Path("ListarCategorias")
	//@Produces("application/json")
	@WebMethod
	public List<Categorias> getCategorias(){
		return gl.listarCategorias();
	}
	
	//@GET
	//@Path("ListarAutores")
	//@Produces("application/json")
	@WebMethod
	public List<Autor> getAutores(){
		return gl.listarAutor();
	}
	
	//@GET
	//@Path("consultar")
	//@Produces("application/json")
	@WebMethod
	public List<Libro> getLibros(){
		return gl.listarLibro();
	}
	//@POST
	//@Path("crearLibro")
	//@Produces("application/json")
	//@Consumes("application/json")
	@WebMethod
	public Respuesta crearLibro(Libro libro) {
		Respuesta r=new Respuesta();
	try {
		
		gl.NuevoLibro(libro);
		r.setCodigo(0);
		r.setMensaje("OK");
	} catch (Exception e) {
		r.setCodigo(99);
		r.setMensaje("error al insertar el libro");
	}
	return r;
	}
	
	//@POST
	//@Path("leerLibro")
	//@Produces("application/json")
	//@Consumes("application/json")
	@WebMethod
	public Libro leerLibro(Libro libro) {
	
		return gl.leerLibros(libro.getIdlibro());
	}

	//@POST
	//@Path("CrearUsuario")
	//@Produces("application/json")
	//@Consumes("application/json")
	@WebMethod
	public Respuesta crearUsuario(Usuarios usuario) {
		Respuesta r=new Respuesta();
		try {
			gl.NuevoUsuario(usuario);
			r.setCodigo(0);
			r.setMensaje("Se ha creado el usuario correctamente");
		} catch (Exception e) {
			r.setCodigo(99);
			r.setMensaje("No se ha podido crear el usuario");
		}
		return r;
	}
}
