import java.util.ArrayList;
import java.util.List;

public abstract class Transform {
	
	
	public static String addSQLblock(List<String> read, int mapId){
		
		String sqlCompose = "\n\n\nINSERT INTO BLOCK (X_block, Y_block, ID_map, ID_typeBlock) VALUES\n";
		
		mapId++;
		
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
	
	
	
	public static String addSQLmap(String mapName, List <String> readTXT){
			
		int Xmax = 0, Ymax = 0, nbDiamond = 0, mapTime = 160;
		String actualStg = new String();
			
		for(int i = 0; i < readTXT.size(); i++){
					
			actualStg = readTXT.get(i);
			
			for(int j =0; j <actualStg.length(); j++){
				
				if(actualStg.charAt(j) == '1'){
					nbDiamond++;
				}
			}
		}	
		
		
		Xmax = readTXT.get(0).length() -1;
		Ymax = readTXT.size() -1;		
		
		
		String sqlMap = "INSERT INTO MAP (Name_map, Xmin_map, Xmax_map, Ymax_map, Ymin_map, nbDiamond, mapTime) VALUES \n";
		sqlMap += "('" + mapName + "', '0', '" + Xmax + "', '0', '" + Ymax + "', '" + nbDiamond + "', '" + mapTime + "');\n";
		return sqlMap;
	}
	
	
	public static String addSQLentity(){
		
		String sqlLive = "\n\n\nINSERT INTO ENTITY (X_entity, Y_entity, ID_map, ID_ntity) VALUES\n";
		return sqlLive;
	}
	
}
