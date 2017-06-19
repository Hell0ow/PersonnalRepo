import java.sql.SQLException;

public class Controller{
	
	private PopUp start;
	private TXTfile reader;
	private SQLfile writer;
	private Database data;
	
	
	public Controller(){
		
		start = new PopUp();
		reader = new TXTfile("MAP/newmap.txt");
		writer = new SQLfile("MAP/SQLrequest.sql");
		data = new Database("java", "bigouneroot");
	}

	
	public void run() throws SQLException {
		
		String ENTITYtable = Transform.addSQLentity(reader.openFile(), data.checkIDmap());
		String MAPTable = Transform.addSQLmap(reader.openFile(),start.getMapName());
		String BLOCKtable = Transform.addSQLblock(reader.openFile(), data.checkIDmap());
		
		writer.write(ENTITYtable, MAPTable, BLOCKtable);
		
		data.writeONdatabase(MAPTable);
		data.writeONdatabase(BLOCKtable);
		data.writeONdatabase(ENTITYtable);
		data.closeDatabase();
		

	}

}
