package bankautomat;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import bank.Bank;

public class Pinbestätigung extends Frame{
	
	
	//Zuweisung der aktuellen Startbildschirm
	Startbildschirm startbildschirm;
	
	//Zuweisung der aktuellen Pinbestätigung
	Pinbestätigung pinbestätigung;
	

		
	//Konstruktor / Erstelle des Pinbestätigungsbildschirms
	public Pinbestätigung(Startbildschirm startbildschirm)
	{

		//Aufbau eines Fensters mit Pinbestätigungsbildschirm
		//Setzen des Titels des Pinbestätigungsbildschirms
		super("Pinbestätigung");
		
		//Zuweisung der aktuellen Startbildschirm
		this.startbildschirm = startbildschirm;
		
		//Zuweisung der Pinbestätigung
		this.pinbestätigung = this;
		
		
		//Setzen des Layouts
		this.setLayout(null);
				
		//Erstellen eins WindowListenerAdapters welche auf die Nutzereingaben auf dem Fenster hört
		this.addWindowListener(new FensterSchließen(true));
		
		
		//Setzen der Größe des Pinbestätigungsbildschirms
		this.setSize(800,700);
		
			
	}
	
	public void erstelleLabels()
	{
		
		
		//Erstellen eines Textfeldes / Labels
		Label pinbestätigungText = new Label("Ihr Pin wurde erfolgreich geändert!");
		
		//Hinzufügen eines Textfeldes zum Pinbestätigungsbildschirm / Fenster
		this.add(pinbestätigungText);
		
		//Platzieren des Textfeldes / Labels zum PinbestätigungTextfeld
		//pinbestätigungTextfeld.setBounds(x, y, width, height);
		pinbestätigungText.setBounds(290,310,500,40);		
		
		//Erstellen einess Buttons für den Vorgange abbrechen
		Button vorgangAbbrechen = new Button("Vorgang bestätigen");
		
		//Platzieren des Buttons auf der Pineingabe
		//pineingabeBestätigen.setBounds(x, y, width, height);
		vorgangAbbrechen.setBounds(340, 390, 120, 65);
		
		//Hinzufügen eines Buttons mit der Pineingabe bestätigen
		this.add(vorgangAbbrechen);
		
		//Hinzufügen eines Listener für den Button Vorgang abbrechen
		ButtonClickListener bcVorgangAbbrechen = new ButtonClickListener();
		
		//Hinzufügen des Listeners bcVorgangAbbrechen zum Vorgang abbrechen
		vorgangAbbrechen.addActionListener(bcVorgangAbbrechen);
		

		//Anzeigen das Fensters
		this.setVisible(true);
		
		
		
	}
	
	private class ButtonClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		
		//Speichere die Information zum Button
		String buttonInfo = e.getActionCommand().toString();		
		//Reaktion auf Vorgang bestätigen
		
		if (buttonInfo.contains("<html>Vorgang<br />bestätigen</html>"))
		{	
			//Deaktivern der Pinbestätigung
			pinbestätigung.setVisible(false);
			
			//Aktivieren des Willkommensbildschirms
			startbildschirm.setVisible(true);
			

		}
		
		
		}
		
	}
	
	

}
