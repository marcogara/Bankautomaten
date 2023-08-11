package bankautomat;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bank.Bank;


//TODO: Startbildschirm veränden
public class Startbildschirm extends Frame{
	
	//Erstellen des Willkommensbildschirms
	Willkommensbildschirm willkommensbildschirm;
	
	//Erstellen des startbildschirm
	Startbildschirm startbildschirm;
		
	//Erstellen der Bank
	Bank meineBank;
	
	//Speichern der bankkunden ID
	int bankkundenID;
	
	//Konstruktor der Klasse Startbilschirm
	Startbildschirm(Willkommensbildschirm willkommensbildschirm, Bank meineBank, int bankkundenID)
	{
		//Aufbau eines Fensters zur Pineingabe
		//Setzen des Titels des Pineingabe
		super("Startbildschirm");
		
		//Zuweisung des Willkommmensbildschirms
		this.willkommensbildschirm = willkommensbildschirm;
		
		//Zuweisung des Startbildschirms
		startbildschirm = this;
		
		//Zuweisung der Bank
		this.meineBank = meineBank;
		
		//Zuweisung der bankkunden ID
		this.bankkundenID = bankkundenID;
				
		//Setzen des Layouts
		this.setLayout(null);
				
		//Erstellen eins WindowListenerAdapters welche auf die Nutzereingaben auf dem Fenster hört
		this.addWindowListener(new FensterSchließen(true));
		
		//Setzen des Startbildschirms
		this.setSize(800,700);
				
	}
	
	
	public void erstelleButtons()
	{

		//Erstellen einess Buttons für die Betragsauswahl
		Button betragsauswahl = new Button("Betragsauswahl");
		
		//Platzieren des Buttons für die Betragsauswahl
		betragsauswahl.setBounds(200, 200, 120, 60);
		
		//Hinzufügen eines Buttons für die Betragsauswahl
		this.add(betragsauswahl);
		
		//Hinzufügen eines Listener für die Betragsauswahl
		ButtonClickListener bcBetragsauswahl = new ButtonClickListener();
		
		//Hinzufügen des Listeners bcBetragsauswahl für die Betragsauswahl
		betragsauswahl.addActionListener(bcBetragsauswahl);
		
		//Erstellen einess Buttons für die Betragsauswahl
		Button pinÄnderung = new Button("Pin ändern");
		
		//Platzieren des Buttons für die Betragsauswahl
		pinÄnderung.setBounds(470, 200, 120, 60);
		
		//Hinzufügen eines Buttons für die Pinänderung
		this.add(pinÄnderung);
		
		//Hinzufügen eines Listener für die Betragsauswahl
		ButtonClickListener bcPinänderung = new ButtonClickListener();
		
		//Hinzufügen des Listeners bcBetragsauswahl für die Pinänderung
		pinÄnderung.addActionListener(bcPinänderung);
		
		
		//Erstellen einess Buttons für den Kontostand
		Button kontostand = new Button("Kontostand");
		
		//Platzieren des Buttons für den Kontostand
		kontostand.setBounds(200, 370, 120, 60);
		
		//Hinzufügen eines Buttons für den Kontostand
		this.add(kontostand);
		
		//Hinzufügen eines Listener für den Kontostand
		ButtonClickListener bcKontostand = new ButtonClickListener();
		
		//Hinzufügen des Listeners bcBetragsauswahl für den Kontostand
		kontostand.addActionListener(bcKontostand);
		
		//Erstellen einess Buttons für den Vorgang abbrechen
		Button vorgangAbbrechen = new Button("Vorgang abbrechen");
		
		//Platzieren des Buttons auf der Pineingabe
		vorgangAbbrechen.setBounds(470, 370, 120, 60);
		
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
		
		//Reaktion auf Betragsauswahl
		if (buttonInfo.contains("Betragsauswahl"))
		{	
			//Deaktivern des Startbildschirms
			startbildschirm.setVisible(false);
			
			//Aktivieren der Betragsauswahl
			Betragsauswahl betragsauswahl = new Betragsauswahl(startbildschirm,  willkommensbildschirm, meineBank, bankkundenID);
						
			//Erstelle die Buttons mit Listenern für die Betragsauswahl
			betragsauswahl.erstelleButtons();
		
		}
		
		
		//Reaktion auf Kontostand
		if (buttonInfo.contains("Kontostand"))
		{	
			//Deaktivern des Startbildschirms
			startbildschirm.setVisible(false);
			
			//Aktivieren des Kontostands
			Kontostand kontostand = new Kontostand(willkommensbildschirm, startbildschirm, meineBank, bankkundenID);
			
			//Erstelle die Labels für den Kontostand
			kontostand.erstelleLabels();
						
			//Erstelle die Buttons mit Listenern für den Kontostand
			kontostand.erstelleButtons();
			
			//Deaktivieren des Startbildschirms
			//kontostand.setVisible(false);
		
		}
		
		//Reaktion auf Pin ändern
		if (buttonInfo.contains("Pin ändern"))
		{	
			//Deaktivern des Startbildschirms
			startbildschirm.setVisible(false);
			
			//Aktivieren auf Pin ändern
			Pinänderung pinänderung = new Pinänderung(willkommensbildschirm, startbildschirm, meineBank, bankkundenID);
						
			//Erstelle die Labels für die Änderung der Pins
			pinänderung.erstelleLabels();
						
			//Erstelle die Buttons für die Änderung der Pins
			pinänderung.erstelleButtons();
			
		
		}
		
		
		//Reaktion auf Vorgang abbrechen
		
		if (buttonInfo.contains("Vorgang abbrechen"))
		{	
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
