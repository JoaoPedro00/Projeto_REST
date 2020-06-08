package PrjRS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ola")
public class HelloResource {
	
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "Ola Mundo ! ";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String HTMLHello() {
		return "<html>"
				+ "<title>Hello REST</title>"
				+ "<body><h1>Ola mundo!</h1>"
				+ "<h2>feito em HTML</h2></body>"
				+ "</html>";
	}
}