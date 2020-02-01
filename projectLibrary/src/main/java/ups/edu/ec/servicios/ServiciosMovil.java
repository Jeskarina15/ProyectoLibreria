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
	
	@GET
	@Path("saludar")
	@Produces("text/plain")
	public String saludar() {
		return "Hola, este es un saludo desde el servicio rest";
	}
	
	@POST
	@Path("login")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Usuarios loguear(Usuarios usuario) {
		System.out.println(usuario.toString());
		//return "Usuario: "+usuario.getNombreu()+", Contraseña: "+usuario.getPassword();
		return usuario;
	}
}
