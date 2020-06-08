package PrjRS;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AlunoRepo {
	

	
	Connection con = null;
	
	public AlunoRepo() {
		String  url = "jdbc:mysql://localhost:3306/restdb?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String pass = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("conexão feita");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	
	
	public List<Aluno> getAluno(){
		List<Aluno> alunos = new ArrayList<Aluno>();
		String sql = "select * from aluno";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Aluno a = new Aluno();
				a.setId(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setCurso(rs.getString(3));
				
				alunos.add(a);
			}
		} catch (SQLException e) {
			System.out.println(e);;
		}
		return alunos;
	}
	

	public Aluno getAluno(int id) throws SQLException {
		 PreparedStatement pstmt = con.prepareStatement("select * from aluno where id = ?");
		 pstmt.setInt(1, id);
		Aluno a = new Aluno();
		try {
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
				a.setId(rs.getInt(1));
				a.setNome(rs.getString(2));
				a.setCurso(rs.getString(3));
				
			}
		} catch (SQLException e) {
			System.out.println(e);;
		}
		return a;
	}



	public void create(Aluno a1) {
		String sql = "insert into aluno values(?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getNome());
			st.setString(3, a1.getCurso());
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);;
		}
	}

}