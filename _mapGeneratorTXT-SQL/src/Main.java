import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		PopUp start = new PopUp();
		
		TXTfile reader = new TXTfile("newmap.txt");
		SQLfile writer = new SQLfile("SQLrequest.sql");
		Database data = new Database("java", "bigouneroot");
		
		String ENTITYtable = Transform.addSQLentity(reader.openFile(), data.checkIDmap());
		String MAPTable = Transform.addSQLmap(start.getMapName(), reader.openFile());
		String BLOCKtable = Transform.addSQLblock(reader.openFile(), data.checkIDmap());
		
		writer.write(ENTITYtable, MAPTable, BLOCKtable);
		
		/*data.writeONdatabse(MAPTable);
		data.writeONdatabse(BLOCKtable);
		data.writeONdatabse(ENTITYtable);
		data.closeDatabase();*/
		

	}

}
