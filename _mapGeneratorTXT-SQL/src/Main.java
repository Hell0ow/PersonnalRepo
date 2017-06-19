import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		Controller start = new Controller();
		
		try {
			start.run();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
