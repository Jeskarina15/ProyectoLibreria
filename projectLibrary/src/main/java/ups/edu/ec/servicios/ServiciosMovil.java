package ups.edu.ec.servicios;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.annotations.Param;

import ups.edu.ec.modelo.Usuarios;
import ups.edu.ec.negocio.GestionLibroLocal;

@Path("/movil")
public class ServiciosMovil {
	@Inject
	private GestionLibroLocal gl;
	private String usuario;
	private int codigo;
	
	@GET
	@Path("saludar")
	@Produces("text/plain")
	public String saludar() {
		return "Hola, este es un saludo desde el servicio rest";
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
}
