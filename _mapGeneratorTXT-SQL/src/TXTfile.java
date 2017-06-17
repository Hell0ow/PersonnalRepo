import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class TXTfile{
	
	private String Folder = null;
	
	
	public TXTfile(String Folder){
		this.Folder = Folder;
	}
	
	
	
	public String getFolder(){
		return Folder;
	}
		
	
	public List<String> openFile(){
		
		Path path = Paths.get(Folder);
		List <String> resultRead = new ArrayList<>();
		
		try {		
 			resultRead = Files.readAllLines(path);	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultRead;
	}
}
