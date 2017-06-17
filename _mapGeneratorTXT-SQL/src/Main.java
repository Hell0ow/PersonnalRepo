import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		PopUp start = new PopUp();
		
		TXTfile read = new TXTfile("TXTmap/newmap.txt");
		SQLfile add = new SQLfile("SQLmap/Valhala.sql");
		Database data = new Database("java", "bigouneroot");
		
		String ENTITYtable = Transform.addSQLentity();
		String MAPTable = Transform.addSQLmap(start.getMapName(), read.openFile());
		String BLOCKtable = Transform.addSQLblock(read.openFile(), data.checkIDmap());
		
		add.write(ENTITYtable, MAPTable, BLOCKtable);
		
		data.writeONdatabse(MAPTable);
		data.writeONdatabse(BLOCKtable);
		data.closeDatabase();
		

	}

}
