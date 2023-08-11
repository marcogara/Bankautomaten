package bankautomat;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bank.Bank;


public class Pinänderung extends Frame{
	
	//Erstellen des Willkommensbildschirms
	Willkommensbildschirm willkommensbildschirm;
	
	//Erstellen des startbildschirm
	Startbildschirm startbildschirm;
	
	//Erstellen des Pineingabe
	Pinänderung pinänderung;
	
	//Erstellen der Bank
	Bank meineBank;
	
	//Erstellen des Labels für die Pineingabe
	Label pinfeld;
		
	//Speichern des Pins 
	String pin;
	
	//Speichern des eingegebenen Pins
	String eingegebenerPin  = "";
	
	//Speichern des verborgenen Pins
	String verborgenerPin  = "";
	
	//Speichern der bankkunden ID
	int bankkundenID;
	
	public Pinänderung(Willkommensbildschirm willkommensbildschirm, Startbildschirm startbildschirm, Bank meineBank, int bankkundenID)
	{
		//Aufbau eines Fensters zur Pineingabe
		//Setzen des Titels des Pineingabe
		super("Pinänderung");
		
		//Zuweisung der aktuellen Startbildschirm
		this.startbildschirm = startbildschirm;
		
		//Zuweisung des Willkommmensbildschirms
		this.willkommensbildschirm = willkommensbildschirm;
		
		//Zuweisung der Bank
		this.meineBank = meineBank;		
		
		//Zuweisung der aktuellen Pineingabe
		this.pinänderung = this;

		//Zuweisung der bankkunden_id
		this.bankkundenID = bankkundenID;
				
		//Setzen des Layouts
		this.setLayout(null);
				
		//Erstellen eins WindowListenerAdapters welche auf die Nutzereingaben auf dem Fenster hört
		this.addWindowListener(new FensterSchließen(true));
		
		//Setzen der Größe des Pinänderungbildschirms
		this.setSize(800,700);
				
	}
	
	public void erstelleLabels()
	{
		//Erstellen eines Textfeldes / Labels für die Pineingabe
		Label pineingabeText = new Label("Eingegebener Pin: ");
		
		//Hinzufügen eines Textfeldes zur Pineingabe
		this.add(pineingabeText);
					
		//Platzieren des Textfeldes / Labels für die Pineingabe
		pineingabeText.setBounds(270,110,120,40);
		
		//Erstellen eines Textfeldes / Labels für den eingegebenen Pin
		pinfeld = new Label("");
				
		//Platzieren des Textfeldes / Labels für den eingegebenen Pin
		pinfeld.setBounds(390,110,80,40);
		
		//Hinzufügen eines Textfeldes für den eingegebenen Pin
		this.add(pinfeld);
		
	}
		
	public void erstelleButtons()
	{
		
		//Erstellen eines Buttons mit der Pinnnummer 7
		Button pinnummerSieben = new Button("7");
		
		//Platzieren des Buttons auf der Pineingabe
		//pinnummer_7.setBounds(x, y, width, height);
		pinnummerSieben.setBounds(260, 170, 60, 60);
		
		//Hinzufügen eines Buttons mit der Pinnnummer 7 zur Pineingabe
		this.add(pinnummerSieben);	
		
		//Erstellen einess Buttons mit der Pinnnummer  8
		Button pinnummerAcht = new Button("8");
		
		//Platzieren des Buttons auf der Pineingabe
		//pinnummer_8.setBounds(x, y, width, height);
		pinnummerAcht.setBounds(340, 170, 60, 60);
		
		//Hinzufügen eines Buttons mit der Pinnnummer 8 zur Pineingabe
		this.add(pinnummerAcht);
					
		//Erstellen einess Buttons mit der Pinnnummer  9
		Button pinnummerNeun = new Button("9");
				
		//Platzieren des Buttons auf der Pineingabe
		//pinnummer_9.setBounds(x, y, width, height);
		pinnummerNeun.setBounds(420, 170, 60, 60);
		
		//Hinzufügen eines Buttons mit der Pinnnummer 9 zur Pineingabe
		this.add(pinnummerNeun);
		
		//Erstellen einess Buttons mit der Pinnnummer  4
		Button pinnummerVier = new Button("4");
		
		//Platzieren des Buttons auf der Pineingabe
		//pinnummer_4.setBounds(x, y, width, height);
		pinnummerVier.setBounds(260, 250, 60, 60);
		
		//Hinzufügen eines Buttons mit der Pinnnummer 4 zur Pineingabe
		this.add(pinnummerVier);
			
		
		//Erstellen einess Buttons mit der Pinnnummer  5
		Button pinnummerFünf = new Button("5");
		
		//Platzieren des Buttons auf der Pineingabe
		//pinnummer_5.setBounds(x, y, width, height);
		pinnummerFünf.setBounds(340, 250, 60, 60);
		
		//Hinzufügen eines Buttons mit der Pinnnummer 5 zur Pineingabe
		this.add(pinnummerFünf);
		
		
		//Erstellen einess Buttons mit der Pinnnummer  6
		Button pinnummerSechs = new Button("6");
		
		
		//Platzieren des Buttons auf der Pineingabe
		//pinnummer_5.setBounds(x, y, width, height);
		pinnummerSechs.setBounds(420, 250, 60, 60);
		
		//Hinzufügen eines Buttons mit der Pinnnummer 6 zur Pineingabe
		this.add(pinnummerSechs);
		
		
		//Erstellen einess Buttons mit der Pinnnummer  1
		Button pinnummerEins = new Button("1");
		
		//Platzieren des Buttons auf der Pineingabe
		//pinnummer_1.setBounds(x, y, width, height);
		pinnummerEins.setBounds(260, 330, 60, 60);
		
		//Hinzufügen eines Buttons mit der Pinnnummer 1 zur Pineingabe
		this.add(pinnummerEins);
		
		
		//Erstellen einess Buttons mit der Pinnnummer  2
		Button pinnummerZwei = new Button("2");
	
		//Platzieren des Buttons auf der Pineingabe
		//pinnummer_2.setBounds(x, y, width, height);
		pinnummerZwei.setBounds(340, 330, 60, 60);
		
		//Hinzufügen eines Buttons mit der Pinnnummer 2 zur Pineingabe
		this.add(pinnummerZwei);
		
		
		//Erstellen einess Buttons für die Pinnnummer  3
		Button pinnummerDrei = new Button("3");
		
		//Platzieren des Buttons auf der Pineingabe
		//pinnummer_2.setBounds(x, y, width, height);
		pinnummerDrei.setBounds(420, 330, 60, 60);
		
		//Hinzufügen eines Buttons mit der Pinnnummer 3 zur Pineingabe
		this.add(pinnummerDrei);
		
		//Erstellen einess Buttons für Zurück zum Startbildschirm
		Button zurückStartbildschirm = new Button("Korrektur");
		
		//Platzieren des Buttons für Zurück zum Startbildschirm
		//zurückStartbildschirm.setBounds(x, y, width, height);
		zurückStartbildschirm.setBounds(160, 430, 120, 65);
		
		//Hinzufügen eines Buttons für Zurück zum Startbildschirm
		this.add(zurückStartbildschirm);
		
				
		//Erstellen einess Buttons für die Pinänderung bestätigen
		Button pineingabeBestätigen = new Button("<html>Pinänderung<br />bestätigen</html>");
		
		//Platzieren des Buttons auf der Pineingabe
		//pineingabeBestätigen.setBounds(x, y, width, height);
		pineingabeBestätigen.setBounds(305, 430, 120, 65);
		
		//Hinzufügen eines Buttons mit der Pineingabe bestätigen
		this.add(pineingabeBestätigen);
		
		
		//Erstellen einess Buttons für den Vorgange abbrechen
		Button vorgangAbbrechen = new Button("<html>Vorgang<br />abbrechen</html>");
		
		//Platzieren des Buttons auf der Pineingabe
		//pineingabeBestätigen.setBounds(x, y, width, height);
		vorgangAbbrechen.setBounds(450, 430, 120, 65);
		
		//Hinzufügen eines Buttons mit der Pineingabe bestätigen
		this.add(vorgangAbbrechen);
		
		//Hinzufügen eines Listener für Zurück zum Startbildschirm
		ButtonClickListener bcZurückStartbildschirm = new ButtonClickListener();
		
		//Hinzufügen des Listeners bcVorgangAbbrechen für Zurück zum Startbildschirm
		zurückStartbildschirm.addActionListener(bcZurückStartbildschirm);
		
		
		//Hinzufügen eines Listener für den Button Pineingabe bestätigen
		ButtonClickListener bcPinBestätigen = new ButtonClickListener();
		
		//Hinzufügen des Listeners bc_7 zum ButtonPineingabe bestätigen
		pineingabeBestätigen.addActionListener(bcPinBestätigen);
		
		//Hinzufügen eines Listener für den Button Vorgang abbrechen
		ButtonClickListener bcVorgangAbbrechen = new ButtonClickListener();
		
		//Hinzufügen des Listeners bcVorgangAbbrechen zum Vorgang abbrechen
		vorgangAbbrechen.addActionListener(bcVorgangAbbrechen);
		
		
		//Hinzufügen eines Listener für den Button mit der Pinnnummer 7
		ButtonClickListener buttonListenerSieben = new ButtonClickListener();
		
		//Hinzufügen des Listeners bc_7 zum Button mit der Pinnummer 7
		pinnummerSieben.addActionListener(buttonListenerSieben);
		
		
		//Hinzufügen eines Listener für den Button mit der Pinnnummer 8
		ButtonClickListener buttonListenerAcht = new ButtonClickListener();
		
		//Hinzufügen des Listeners bc_8 zum Button mit der Pinnummer 8
		pinnummerAcht.addActionListener(buttonListenerAcht);
		
		
		//Hinzufügen eines Listener für den Button mit der Pinnnummer 9
		ButtonClickListener buttonListenerNeun = new ButtonClickListener();
		
		//Hinzufügen des Listeners bc_9 zum Button mit der Pinnummer 9
		pinnummerNeun.addActionListener(buttonListenerNeun);
		
		
		//Hinzufügen eines Listener für den Button mit der Pinnnummer 4
		ButtonClickListener buttonListenerVier = new ButtonClickListener();
		
		//Hinzufügen des Listeners bc_4 zum Button mit der Pinnummer 4
		pinnummerVier.addActionListener(buttonListenerVier);
		
		
		//Hinzufügen eines Listener für den Button mit der Pinnnummer 5
		ButtonClickListener buttonListenerFünf = new ButtonClickListener();
		
		//Hinzufügen des Listeners bc_5 zum Button mit der Pinnummer 5
		pinnummerFünf.addActionListener(buttonListenerFünf);
		
		
		//Hinzufügen eines Listener für den Button mit der Pinnnummer 6
		ButtonClickListener buttonListenerSechs = new ButtonClickListener();
		
		//Hinzufügen des Listeners bc_6 zum Button mit der Pinnummer 6
		pinnummerSechs.addActionListener(buttonListenerSechs);
		
		//Hinzufügen eines Listener für den Button mit der Pinnnummer 1
		ButtonClickListener buttonListenerEins = new ButtonClickListener();
		
		//Hinzufügen des Listeners bc_1 zum Button mit der Pinnummer 1
		pinnummerEins.addActionListener(buttonListenerEins);
		
		//Hinzufügen eines Listener für den Button mit der Pinnnummer 2
		ButtonClickListener buttonListenerZwei = new ButtonClickListener();
		
		//Hinzufügen des Listeners bc_2 zum Button mit der Pinnummer 2
		pinnummerZwei.addActionListener(buttonListenerZwei);
		
		//Hinzufügen eines Listener für den Button mit der Pinnnummer 3
		ButtonClickListener buttonListenerDrei = new ButtonClickListener();
		
		//Hinzufügen des Listeners bc_3 zum Button mit der Pinnummer 3
		pinnummerDrei.addActionListener(buttonListenerDrei);
				
		//Anzeigen das Fensters
		this.setVisible(true);

		
	}
	
	
	private class ButtonClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
		//Speichere die Information zum Button
		String buttonInfo = e.getActionCommand().toString();
			
		//Prüfe ob der Button ein Button für die Eingabe eines Pins ist
		String textPinfeld = pinfeld.getText();	
		
		//Aktualisieren des Pinfeldes
		if (istGanzzahl(buttonInfo))
		{				
			
			//Überprüfung ob die aktuellen Pineingabe maximal 4 Pinzahlen entspricht
			if (verborgenerPin.length() < 4)
			{
				//Berechne des eingegebenen Pins im Pinfeld
				eingegebenerPin  = eingegebenerPin + buttonInfo;	
				
				//Erhalte und erstelle den verborgenen Pin im Pinfeld mit Sternen ****
				verborgenerPin = verborgenerPin + "*";
				
				//Pin nicht anzeigen sondern stattdessen Sterne: ****
				pinfeld.setText(verborgenerPin);
			}
	
		}
		
		//Reaktion für zum Startbildschirm
		if (buttonInfo.contains("<html>Zurück zum<br />Startbildschirm</html>"))
		{	
			//Deaktivern der Kontostand
			pinänderung.setVisible(false);
			
			//Aktivieren des Willkommensbildschirms
			startbildschirm.setVisible(true);
		}
		
		//Reaktion auf Pin bestätigen
		//Überprüfe ob der Button Pinänderung gedrückt wurde
		if (buttonInfo.contains("<html>Pinänderung<br />bestätigen</html>"))
		{	
						
			//Überprüfen des Pins bei 4 Pinziffern
			if (eingegebenerPin.length() == 4)
			{
				//Aktualisiere Pin
				boolean pinAktualisierung = meineBank.aktualisierePin(bankkundenID, Integer.parseInt(eingegebenerPin));
				
				//Deaktivern der Pineingabe
				pinänderung.setVisible(false);
				
				if (pinAktualisierung == true)
				{
					//Erstellen des Pinbestätigung
					Pinbestätigung pinbestätigung = new Pinbestätigung(startbildschirm);
					
					//Aktivieren des Pinbestätigung
					pinbestätigung.setVisible(true);
					
					//Prüfe die Karte nach erscheinen des Pinbestätigung
					pinbestätigung.erstelleLabels();
					
				}
				else 
				{
					//TODO: Pinänerung konnte nicht durchgeführt werden
					//Erstellen des Pinbestätigung
					Pinbestätigung pinbestätigung = new Pinbestätigung(startbildschirm);
					
					//Aktivieren des Pinbestätigung
					pinbestätigung.setVisible(true);
					
					//Prüfe die Karte nach erscheinen des Pinbestätigung
					pinbestätigung.erstelleLabels();
	
				}
					
				

			}
			
		}
		
		//Reaktion auf Vorgang abbrechen
		
		if (buttonInfo.contains("<html>Vorgang<br />abbrechen</html>"))
		{	
			//Deaktivern der Pineingabe
			pinänderung.setVisible(false);
			
			//Aktivieren des Willkommensbildschirms
			willkommensbildschirm.setVisible(true);
			
			//Prüfe die Karte nach erscheinen des Willkommensbildschirms
			willkommensbildschirm.prüfeKarte(meineBank);
		}
						
		}
		
	}
	
	//Prüfe ob die Zahl eine Ganzzahl ist 
	public static boolean istGanzzahl(String zeichenkette) {
	    try { 
	        Integer.parseInt(zeichenkette); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // gib ein Wahr zurück falls der Button ein Integer ist
	    return true;
	}
	
	
}
