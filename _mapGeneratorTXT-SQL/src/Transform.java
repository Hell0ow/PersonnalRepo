import java.util.ArrayList;
import java.util.List;

public abstract class Transform {
	
	
	public static String addSQLblock(List<String> read, int mapId){
		
		String sqlCompose = "\n\n\nINSERT INTO BLOCK (X_block, Y_block, ID_map, ID_typeBlock) VALUES\n";
		
		mapId++;
		
		List <String> result = new ArrayList<>();
		String actualStg = new String();
		String change = new String();
		int y = 0;
		
		
		
		
		
		
		for(int i = 0; i < read.size(); i++){
			
			actualStg = read.get(i);
			
			for(int j =0; j <actualStg.length(); j++){
				
				change = "\n('" + j + "', '" + y + "', '" + mapId + "', '" + actualStg.charAt(j) +"')";
				result.add(change);
			}
			y++;
		}		
		sqlCompose += result.toString() + ";";
		
		
		
		
		
		
		
		// Here, we modify the unwanted characters in the sql file.
		// These characters can be the remainder of the List/String conversion or they are the entity that are not taken into account in the BLOCK table.
		String delete[] = {"[", "]", "H"}; //For example, H correspond to a human, what's why we replace H by 5(void block).
		String place[] = {"", "", "5"};
	
		for(int t = 0; t < delete.length; t++){
	
			sqlCompose = sqlCompose.replace(delete[t], place[t]);
		}		
		
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
		sqlMap += "('" + mapName + "', '0', '" + Xmax + "', '0', '" + Ymax + "', '" + nbDiamond + "', '" + mapTime + "');";
		return sqlMap;
	}
	
	
	
	
	
	
	
	public static String addSQLentity(List<String> readTXT, int mapId){
		
		String sqlEntity = "\n\n\nINSERT INTO ENTITY (X_entity, Y_entity, ID_map, ID_typeEntity) VALUES\n";
		String actualStg = new String();
		String change = new String();
		int ID_entity = 0;
		List <String> result = new ArrayList <String>();
		
		mapId++;
		
		
		
		
		
		for(int i = 0; i < readTXT.size(); i++){
			
			actualStg = readTXT.get(i);
			
			for(int j = 0; j < actualStg.length(); j++){
				
				if(actualStg.charAt(j) == 'H'){
					
					switch(actualStg.charAt(j)){
					case 'H':
						ID_entity = 1;
						break;
					}
					
					change = "\n('" + j + "', '" + i + "', '" + mapId + "', '" + ID_entity +"')";
					result.add(change);
				}
			}
		}
		
		
		
		
		
		sqlEntity += result.toString() + ";";
		sqlEntity = sqlEntity.replace("[", "");
		sqlEntity = sqlEntity.replace("]", "");
		
		return sqlEntity;
	}
	
}
