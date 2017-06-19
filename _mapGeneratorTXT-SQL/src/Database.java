import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private String user     = "java";
	private String password = "bigouneroot";
    private String url      = "jdbc:mysql://164.132.49.33:3306/boulderdash?useSSL=false&serverTimezone=UTC";
    private Connection connection = null;
    private Statement  statement;
	
    
	public Database(String user, String password){
		this.user = user;
		this.password = password;
		
		try{
			connection = DriverManager.getConnection(this.url, this.user, this.password);
			statement = connection.createStatement();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public int checkIDmap() throws SQLException{
		
		ResultSet result = statement.executeQuery("CALL generatorCountMap();");
		int nbrID = 0;
		
		
		while(result.next()){
			nbrID = result.getInt("COUNT(ID_map)");
			return nbrID;
		}
	
		return nbrID;		
	}
	
	
	
	public void writeONdatabase(String sqlRequest) throws SQLException{
		
		statement.executeUpdate(sqlRequest);
		
	}
	
	public void closeDatabase() throws SQLException{
		
		statement.close();
		connection.close();
	}
}
