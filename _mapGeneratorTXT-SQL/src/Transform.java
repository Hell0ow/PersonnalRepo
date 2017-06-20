import java.util.ArrayList;
import java.util.List;

public abstract class Transform {
	
	
	public static String addSQLblock(List<String> readTXT, int mapId){
		
		String sqltransform = new String();
		String returnSql = "\n\n\nINSERT INTO BLOCK (X_block, Y_block, ID_map, ID_typeBlock) VALUES\n";
		
		mapId++;
		
		List <String> result = new ArrayList<>();
		String actualStg = new String();
		String change = new String();
		int y = 0;
		
		
		
		
		
		
		for(int i = 0; i < readTXT.size(); i++){
			
			actualStg = readTXT.get(i);
			
			for(int j =0; j <actualStg.length(); j++){
				
				change = "\n('" + j + "', '" + y + "', '" + mapId + "', '" + actualStg.charAt(j) +"')";
				result.add(change);
			}
			y++;
		}		
		sqltransform = result.toString() + ";";
		
		
		
		
		
		
		
		// Here, we modify the unwanted characters in the sql file.
		// These characters can be the remainder of the List/String conversion or they are the entity that are not taken into account in the BLOCK table.
		String delete[] = {"H", "B", "F", "G", "P", "T", "A"}; //For example, H correspond to a human, what's why we replace H by 5(void block).
		String place = "5";
	
		sqltransform = sqltransform.replace("[", "");
		sqltransform = sqltransform.replace("]", "");
		
		for(int t = 0; t < delete.length; t++){
	
			sqltransform = sqltransform.replace(delete[t], place);
		}		
		
		
		
		returnSql += sqltransform;
		
		return returnSql;
	}
	
	
	
	
	
	
	
	public static String addSQLmap(List <String> readTXT, String mapName){
			
		int Xmax = 0, Ymax = 0, nbDiamond = 0, mapTime = 160;
		String actualStg = new String();
			
		for(int i = 0; i < readTXT.size(); i++){
					
			actualStg = readTXT.get(i);
			
			for(int j =0; j <actualStg.length(); j++){
				
				if(actualStg.charAt(j) == '1' || actualStg.charAt(j) == 'P' || actualStg.charAt(j) == 'T' || actualStg.charAt(j) == 'A'){
					nbDiamond++;
				}
			}
		}	
		
		
		Xmax = readTXT.get(0).length() -1;
		Ymax = readTXT.size() -1;		
		
		
		String sqlMap = "INSERT INTO MAP (Name_map, Xmin_map, Xmax_map, Ymin_map, Ymax_map, nbDiamond, mapTime) VALUES \n";
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
					
				switch(actualStg.charAt(j)){
				case 'H': //Human
					ID_entity = 1;
					break;
				case 'B': // BuzzBuzz (drop points)
					ID_entity = 2;
					break;
				case 'F': // FlapFlap (drop points)
					ID_entity = 3;
					break;
				case 'G': //GuriGuri (drop points)
					ID_entity = 4;
					break;
				case 'P': // PiroPiro (drop Diamond)
					ID_entity = 5;
					break;
				case 'T': // TackyTacky (drop diamond)
					ID_entity = 6;
					break;
				case 'A': // Amoeba (drop diamond)
					ID_entity = 7;
					break;
				}
				
				if(ID_entity != 0){
					change = "\n('" + j + "', '" + i + "', '" + mapId + "', '" + ID_entity +"')";
					result.add(change);
				}
				ID_entity = 0;
					
			}
		}
		
		
		
		
		
		sqlEntity += result.toString() + ";";
		sqlEntity = sqlEntity.replace("[", "");
		sqlEntity = sqlEntity.replace("]", "");
		
		return sqlEntity;
	}
	
}
