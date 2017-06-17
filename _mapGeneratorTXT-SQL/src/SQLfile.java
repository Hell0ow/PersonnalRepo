import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SQLfile {
	
	private String Folder = null;
	
	
	public SQLfile (String Folder){
		this.Folder = Folder;
	}
	
	
	public String write(String SQLlive, String SQLmap, String SQLcompose){
		
		Path path = Paths.get(Folder);
		String sql = SQLmap + SQLcompose; //ajouter entre map et compose SQLlive
		
		try {
			Files.write(path, sql.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sql;
		
	}
	
}
