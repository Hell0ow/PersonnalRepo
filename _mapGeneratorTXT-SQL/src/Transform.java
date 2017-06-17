import java.util.ArrayList;
import java.util.List;

public abstract class Transform {
	
	
	public static String addSQLcompose(List<String> read, String mapId){
		
		String sqlCompose = "\n\n\nINSERT INTO compose (X_comp, Y_comp, ID_Map, ID_Block) VALUES\n";
		
		List <String> result = new ArrayList<>();
		String actualStg = new String();
		int y = 0;
		
		for(int i = 0; i < read.size(); i++){
			
			actualStg = read.get(i);
			
			for(int j =0; j <actualStg.length(); j++){
				
				//if()
				String change = "\n('" + j + "', '" + y + "', '" + mapId + "', '" + actualStg.charAt(j) +"')";
				result.add(change);
			}
			y++;
		}		
		
		String div = new String();
		
		for(int i=0; i < result.size(); i++){
			
			div += result.get(i).toString();
		}
		
		sqlCompose += result.toString() + ";";
		sqlCompose = sqlCompose.replace("[", "");
		sqlCompose = sqlCompose.replace("]", "");
		
		
		return sqlCompose;
	}
	
	
	
	public static String addSQLmap(String mapId, String mapName){
			
		int Xmax = 0, Ymax = 0, nbDiamond = 0;
		
		String sqlMap = "INSERT INTO MAP(ID_Map, Name_map, Xmin_map, Xmax_map, Ymax_map, Ymin_map, mapTime) VALUES\n";
		sqlMap += "('" + mapId + "', '" + mapName + "', '0', '" + Xmax + "', '" + Ymax + "', '0', '" + nbDiamond + "');\n";
		return sqlMap;
	}
	
	
	public static String addSQLlive(){
		
		String sqlLive = "\n\n\nINSERT INTO live (X_live, Y_live, ID_map, ID_Entity) VALUES\n";
		return sqlLive;
	}
	
}
