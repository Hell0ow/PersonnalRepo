import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SQLfile {
	
	private String Folder = null;
	
	
	public SQLfile (String Folder){
		this.Folder = Folder;
	}
	
	
	public void write(String SQLlive, String SQLmap, String SQLcompose){
		
		Path path = Paths.get(Folder);
		String sql = SQLmap + SQLlive + SQLcompose;
		
		try {
			Files.write(path, sql.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
