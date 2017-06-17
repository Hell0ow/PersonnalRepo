import javax.swing.*;

public class PopUp {
	
	private String mapName = new String();
	
    public PopUp(){

        this.mapName = JOptionPane.showInputDialog("Enter the name of your new map:");
        JOptionPane.showMessageDialog(null, "Map generation success!");
 
    }

	public String getMapName() {
		return mapName;
	}
}