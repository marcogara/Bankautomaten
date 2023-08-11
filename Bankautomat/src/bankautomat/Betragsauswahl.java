package bankautomat;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bank.Bank;


public class Betragsauswahl extends Frame{
	
	//Erstellen des betragsauswahl
	Betragsauswahl betragsauswahl;
	
	//Erstellen des startbildschirm
	Startbildschirm startbildschirm;
	
	//Erstellen des Willkommensbildschirms
	Willkommensbildschirm willkommensbildschirm;
	
	//Erstellen der Bank
	Bank meineBank;
	
	//Speichern der bankkunden ID
	int bankkundenID;
	
	
	public Betragsauswahl(Startbildschirm startbildschirm, Willkommensbildschirm willkommensbildschirm, Bank meineBank, int bankkundenID)
	{
		//Aufbau eines Fensters für die Betragsauswahl
		//Setzen des Titels für die Betragsauswahl
		super("Betragsauswahl");
		
		//Zuweisung des Startbildschirm
		this.startbildschirm = startbildschirm;
		
		//Zuweisung des Willkommmensbildschirms
		this.willkommensbildschirm = willkommensbildschirm;
		
		//Zuweisung der Betragsauswahl
		this.betragsauswahl = this;
		
		//Zuweisung der Bank
		this.meineBank = meineBank;
		
		//Zuweisung der bankkunden ID
		this.bankkundenID = bankkundenID;
						
		//Setzen des Layouts
		this.setLayout(null);
				
		//Erstellen eins WindowListenerAdapters welche auf die Nutzereingaben auf dem Fenster hört
		this.addWindowListener(new FensterSchließen(true));
		
		
		//Setzen der Größe des Betragsauswahlbildschirms
		this.setSize(800,700);
				
	}
	
	
	public void erstelleButtons()
	{

		//Erstellen einess Buttons für 100 Euro
		Button Euro100 = new Button("100 Euro");
		
		//Platzieren des Buttons Euro100
		Euro100.setBounds(200, 200, 120, 60);
		
		//Hinzufügen eines Buttons für 100 Euro
		this.add(Euro100);
		
		//Hinzufügen eines Listener für 100 Euro
		ButtonClickListener bcEuro100 = new ButtonClickListener();
		
		//Hinzufügen des Listeners bcBetragsauswahl für 100 Euro
		Euro100.addActionListener(bcEuro100);
		
		
		//Erstellen einess Buttons für 50 Euro
		Button Euro50 = new Button("50 Euro");
		
		//Platzieren des Buttons Euro50
		Euro50.setBounds(470, 200, 120, 60);
		
		//Hinzufügen eines Buttons für 50 Euro
		this.add(Euro50);
		
		//Hinzufügen eines Listener für 50 Euro
		ButtonClickListener bcEuro50 = new ButtonClickListener();
		
		//Hinzufügen des Listeners bcBetragsauswahl für 50 Euro
		Euro50.addActionListener(bcEuro50);
		
		//Erstellen einess Buttons für 70 Euro
		Button Euro70 = new Button("70 Euro");
		
		//Platzieren des Buttons Euro70
		Euro70.setBounds(200, 370, 120, 60);
		
		//Hinzufügen eines Buttons für 70 Euro
		this.add(Euro70);
		
		//Hinzufügen eines Listener für 70 Euro
		ButtonClickListener bcEuro70 = new ButtonClickListener();
		
		//Hinzufügen des Listeners bcBetragsauswahl für 70 Euro
		Euro70.addActionListener(bcEuro70);
		
		
		//Erstellen einess Buttons für 20 Euro
		Button Euro20 = new Button("20 Euro");
		
		//Platzieren des Buttons Euro20
		Euro20.setBounds(470, 370, 120, 60);
		
		//Hinzufügen eines Buttons für 20 Euro
		this.add(Euro20);
		
		//Hinzufügen eines Listener für 20 Euro
		ButtonClickListener bcEuro20 = new ButtonClickListener();
		
		//Hinzufügen des Listeners bcBetragsauswahl für 20 Euro
		Euro20.addActionListener(bcEuro20);
		
		
		
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

		
		//Reaktion auf 20 Euro
		if (buttonInfo.contains("100 Euro") ||
			buttonInfo.contains("50 Euro")	||
			buttonInfo.contains("70 Euro") 	||
			buttonInfo.contains("20 Euro"))
		{	
			//drucke aktuellen Betrag
			System.out.println("Ausgezahlter Betrag: " + buttonInfo);
			
			//Aktualisiere den Kontostand
			String[] buttonInfoSplit = buttonInfo.split(" ");
			double abgebuchterBetrag = Double.parseDouble(buttonInfoSplit[0]);
			meineBank.aktualisiereKontostand(bankkundenID, abgebuchterBetrag);
		
		}
		
		
		//Reaktion für zum Startbildschirm
		
		if (buttonInfo.contains("<html>Zurück zum<br />Startbildschirm</html>"))
		{	
			//Deaktivern der Betragsauswahl
			betragsauswahl.setVisible(false);
			
			//Aktivieren des Willkommensbildschirms
			startbildschirm.setVisible(true);
		}
		
		
		//Reaktion auf Vorgang abbrechen
		
		if (buttonInfo.contains("<html>Vorgang<br />abbrechen</html>"))
		{	
			//Deaktivern der Pineingabe
			startbildschirm.setVisible(false);
			
			//Aktivieren des Willkommensbildschirms
			willkommensbildschirm.setVisible(true);
			
			//Deaktivern der Betragsauswahl
			betragsauswahl.setVisible(false);
			
			//Prüfe die Karte nach erscheinen des Willkommensbildschirms
			willkommensbildschirm.prüfeKarte(meineBank);
		}
		
		
		}

		
	}
	


}
