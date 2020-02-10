package ups.edu.ec.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.annotations.Param;

import ups.edu.ec.modelo.FacturaDetalles;
import ups.edu.ec.modelo.Libro;
import ups.edu.ec.modelo.Usuarios;
import ups.edu.ec.negocio.GestionLibroLocal;

@Path("/movil")
public class ServiciosMovil {
	@Inject
	private GestionLibroLocal gl;
	private String usuario;
	private int codigo;
	private boolean escribe;
	private boolean crearCabecera;
	private String palabra;
	private int codCabecera;
	private ArrayList<String> datos;
	
	@GET
	@Path("saludar")
	@Produces("text/plain")
	public String saludar() {
		return "Hola, este es un saludo desde el servicio rest";
	}
	
	@GET
	@Path("listar")
	@Produces("application/json")
	public List<Libro> listarLibros() {
		return(gl.listarLibro());
	}
	
	@POST
	@Path("libro")
	@Consumes("text/plain")
	@Produces("application/json")
	public Libro getLibro(String codigo) {
		System.out.println("El codigo ingresado es: "+codigo);
		return(gl.leerLibros(Integer.valueOf(codigo)));
	}
	
	@POST
	@Path("login")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces("text/plain")
	public String loguear(Usuarios usuario) {
		codigo = gl.loguear(usuario);
		if(codigo!=-1) {
			return "logueado,"+codigo;
		}
		System.out.println("Error");
		return "error";
	}
	
	@POST
	@Path("crearUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces("text/plain")
	public String crearUsuario(Usuarios usuario) {
		try {
			usuario.setUsu_rol("usuario");
			gl.NuevoUsuario(usuario);
			return "creado";
		} catch (Exception e) {
			return "error:"+e.toString();
		}
	}
	
	@POST
	@Path("comprar")
	@Consumes("text/plain")
	@Produces("text/plain")
	public String comprar(String listaDetalles) {
		crearCabecera = true;
		escribe = false;
		palabra = "";
		datos = new ArrayList<String>();
		codCabecera = 0;
		double total = 0;
		try {
			String[] jsonDetalles = listaDetalles.substring(1, listaDetalles.length()).split("},");
			System.out.println("Imprimiendo los datos: ");
			for(String detalle: jsonDetalles) {
				detalle = detalle+"}";
				System.out.println(detalle);
				for (int i = 0; i < detalle.length(); i++) {
					if(detalle.substring(i, i+1).equals(":")) {
						escribe = true;
					}
					if(detalle.substring(i, i+1).equals(",")||detalle.substring(i, i+1).equals("}")) {
						if(palabra!="") {
							System.out.println("Palabra: "+palabra);
							datos.add(palabra);
							palabra="";
							escribe = false;
						}
					}
					if(escribe && !detalle.substring(i, i+1).equals(":")) {
						palabra = palabra+detalle.substring(i, i+1);
					}
				}
				if(crearCabecera==true) {
					codCabecera=gl.crearCabecera(datos.get(3),datos.get(1), datos.get(0));
					crearCabecera=false;
				}
				total = total+Double.valueOf(datos.get(1));
				gl.crearDetalle(datos,codCabecera);
				datos.removeAll(datos);
			}
			System.out.println("El total a pagar es: "+total);
			return "Se ah ingresado la factura cabecera";
		} catch (Exception e) {
			return "Ah ocurrido un error al ingresar la factura cabecera"+e.toString();
		}
	}
	
	@POST
	@Path("like")
	@Consumes("text/plain")
	@Produces("text/plain")
	public void darMegusta(String cadena) {
		String[] datos = cadena.split(",");
		gl.darLike(datos[0], Integer.valueOf(datos[1]));
	}
}