package bankautomat;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FensterSchließen extends WindowAdapter {
	
	private boolean exitSystem;
	
	//Standardkonstruktor mit Anbindung einer WindowAdapter zum schließen des Fensters
	public FensterSchließen()
	{
		
		this(false);
	}
	
	
	//Konstruktur zum Schließen des Fensters durch Nutzereingabe
	public FensterSchließen (boolean exitSystem)
	{
		
		this.exitSystem = exitSystem;
	}
	

	
	//Wenn das Fenster vom Nutzer geschloßen wird, dann mache es unsichtbar
	public void windowClosing(WindowEvent event)
	{
		event.getWindow().setVisible(false);
		event.getWindow().dispose();
		System.exit(0);
		
	}
	
}
