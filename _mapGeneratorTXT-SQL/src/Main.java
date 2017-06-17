
public class Main {

	public static void main(String[] args) {
		
		PopUp start = new PopUp();
		
		TXTfile read = new TXTfile("TXTmap/newmap.txt");
		SQLfile add = new SQLfile("SQLmap/Valhala.sql");
		
		String liveTable = Transform.addSQLlive();
		String mapTable = Transform.addSQLmap(start.getMapID(), start.getMapName());
		String composeTable = Transform.addSQLcompose(read.openFile(), start.getMapID());

		add.write(liveTable, mapTable, composeTable);
	}

}
