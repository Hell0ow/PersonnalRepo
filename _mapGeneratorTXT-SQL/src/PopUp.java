import javax.swing.*;

public class PopUp {
	
	private String mapName = new String();
	private String mapID = new String();
	
    public PopUp(){

        this.mapName = JOptionPane.showInputDialog("Enter the name of your new map:");
        this.mapID = JOptionPane.showInputDialog("Specify the ID of the map:");
        JOptionPane.showMessageDialog(null, "Map generation success!");
 
    }

	public String getMapName() {
		return mapName;
	}

	public String getMapID() {
		return mapID;
	}
}