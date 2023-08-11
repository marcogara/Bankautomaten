package bankautomat;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bank.Bank;


public class Kontostand extends Frame{
	
	//Erstellen des kontostand
	Kontostand kontostand;
	
	//Erstellen des Willkommensbildschirms
	Willkommensbildschirm willkommensbildschirm;
	
	//Erstellen des startbildschirm
	Startbildschirm startbildschirm;
	
	//Erstellen der Bank
	Bank meineBank;
	
	//Speichern der bankkunden ID
	int bankkundenID;
	
	
	public Kontostand(Willkommensbildschirm willkommensbildschirm, Startbildschirm startbildschirm, Bank meineBank, int bankkundenID)
	{
		//Aufbau eines Fensters für die Kontostand
		//Setzen des Titels für die Kontostand
		super("Kontostand");
		
		//Zuweisung des Startbildschirm
		this.startbildschirm = startbildschirm;
		
		//Zuweisung des Willkommmensbildschirms
		this.willkommensbildschirm = willkommensbildschirm;
		
		//Zuweisung der Kontostand
		this.kontostand = this;
		
		//Zuweisung der Bank
		this.meineBank = meineBank;
		
		//Zuweisung der bankkunden_id
		this.bankkundenID = bankkundenID;
				
		//Setzen des Layouts
		this.setLayout(null);
				
		//Erstellen eins WindowListenerAdapters welche auf die Nutzereingaben auf dem Fenster hört
		this.addWindowListener(new FensterSchließen(true));
				
		//Setzen des Kontostandbildschirms
		this.setSize(800,700);
				
	}
	
	public void erstelleLabels()
	{
		//Erstellen eines Textfeldes / Labels für den aktuellen Kontostand
		Label kontostandText = new Label("Ihr aktueller Kontostand ist: ");
		
		//Hinzufügen eines Textfeldes für den aktuellen Kontostand
		this.add(kontostandText);
			
		//Platzieren des Textfeldes / Labels für den aktuellen Kontostand
		kontostandText.setBounds(270,240,180,40);
		
		//Erhalte aktuellen Kontostand
		double kontostand = meineBank.erhalteKontostand(bankkundenID);
		
		//Erstellen eines Textfeldes / Labels für den aktuellen Kontostand
		Label aktuellerKontostand = new Label(kontostand + " Euro");
				
		//Platzieren des Textfeldes / Labels für den aktuellen Kontostand
		aktuellerKontostand.setBounds(450,240,120,40);
		
		//Hinzufügen eines Textfeldes für den aktuellen Kontostand
		this.add(aktuellerKontostand);
		
	}
	
	
	public void erstelleButtons()
	{
		
		//Erstellen einess Buttons für Zurück zum Startbildschirm
		Button zurückStartbildschirm = new Button("<html>Zurück zum<br />Startbildschirm</html>");
		
		//Platzieren des Buttons für Zurück zum Startbildschirm
		zurückStartbildschirm.setBounds(220, 470, 140, 60);
		
		//Hinzufügen eines Buttons für Zurück zum Startbildschirm
		this.add(zurückStartbildschirm);
		
		//Hinzufügen eines Listener für Zurück zum Startbildschirm
		ButtonClickListener bcZurückStartbildschirm = new ButtonClickListener();
		
		//Hinzufügen des Listeners bcVorgangAbbrechen für Zurück zum Startbildschirm
		zurückStartbildschirm.addActionListener(bcZurückStartbildschirm);
		
		//Erstellen einess Buttons für den Vorgang abbrechen
		Button vorgangAbbrechen = new Button("<html>Vorgang<br />abbrechen</html>");
		
		//Platzieren des Buttons auf der Pineingabe
		vorgangAbbrechen.setBounds(430, 470, 140, 60);
		
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

		//Reaktion für zum Startbildschirm
		if (buttonInfo.contains("<html>Zurück zum<br />Startbildschirm</html>"))
		{	
			//Deaktivern der Kontostand
			kontostand.setVisible(false);
			
			//Aktivieren des Startbildschirms
			startbildschirm.setVisible(true);
		}
		
		
		//Reaktion auf Vorgang abbrechen
		
		if (buttonInfo.contains("<html>Vorgang<br />abbrechen</html>"))
		{	
			
			//Deaktivern der Kontostand
			kontostand.setVisible(false);
			
			//Deaktivern der Pineingabe
			startbildschirm.setVisible(false);
			
			//Aktivieren des Willkommensbildschirms
			willkommensbildschirm.setVisible(true);
			
			//Prüfe die Karte nach erscheinen des Willkommensbildschirms
			willkommensbildschirm.prüfeKarte(meineBank);
		}
		
		
		}

		
	}
	
	
}
