package PrjRS;


import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alunos")	
public class AlunoResource {
	
	AlunoRepo repo = new AlunoRepo();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aluno> ListaAlunos() {
		return repo.getAluno();
	}
	
	@GET
	@Path("/aluno/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Aluno getAluno(@PathParam("id") int id) throws SQLException {
			return repo.getAluno(id);
	}
	
	@Path("/aluno")
	@POST
	public Aluno CriarAluno(Aluno a1) {
		System.out.println(a1);
		repo.create(a1);
		
		return a1;
	}
}
