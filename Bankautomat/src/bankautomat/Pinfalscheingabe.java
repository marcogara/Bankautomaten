package bankautomat;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bank.Bank;


public class Pinfalscheingabe extends Frame{
	
	//Erstellen des Willkommensbildschirms
	Willkommensbildschirm willkommensbildschirm;
	
	//Erstellen des Pinfalscheingabe
	Pinfalscheingabe pinfalscheingabe;
	
	//Erstellen des Pineingabe
	Pineingabe pineingabe;
	
	//Erstellen der Bank
	Bank meineBank;
		
	//Speichern des Versuchs
	int eingabeversuch;
	
	
	public Pinfalscheingabe(Willkommensbildschirm willkommensbildschirm, Bank meineBank, Pineingabe pineingabe, int eingabeversuch)
	{
		//Aufbau eines Fensters für die Kontostand
		//Setzen des Titels für die Kontostand
		super("Kontostand");
		
		//Zuweisung des Pineingabe
		this.pineingabe = pineingabe;
		
		//Zuweisung des Willkommmensbildschirms
		this.willkommensbildschirm = willkommensbildschirm;
		
		//Zuweisung der Pinfalscheingabe
		this.pinfalscheingabe = this;
		
		//Zuweisung der Bank
		this.meineBank = meineBank;
		
		//Zuweisung der versuch
		this.eingabeversuch = eingabeversuch;
		
				
		//Setzen des Layouts
		this.setLayout(null);
				
		//Erstellen eins WindowListenerAdapters welche auf die Nutzereingaben auf dem Fenster hört
		this.addWindowListener(new FensterSchließen(true));
		
		
		//Setzen des Kontostandbilschirms
		this.setSize(800,700);
				
	}
	
	public void erstelleLabels()
	{
		if ((3 - eingabeversuch) > 0)
		{
		
		//Erstellen eines Textfeldes / Labels für die Pinfalscheingabe
		Label pinfalscheingabeText = new Label("Ihr Pin wurde falsch eingegeben. Sie haben noch " + (3 - eingabeversuch) + " Versuche.");
		
		//Hinzufügen eines Textfeldes für die Pinfalscheingabe
		this.add(pinfalscheingabeText);
			
		//Platzieren des Textfeldes / Labels für die Pinfalscheingabe
		pinfalscheingabeText.setBounds(230,240,380,40);
				
		//Hinzufügen eines Textfeldes für die Pinfalscheingabe
		this.add(pinfalscheingabeText);
		}
		
		else
		{
			
			//Erstellen eines Textfeldes / Labels für die Pinfalscheingabe
			Label pinfalscheingabeText = new Label("Ihr Pin wurde 3 mal falsch eingegeben. Ihre Karte wird zurückgegeben");
			
			//Hinzufügen eines Textfeldes für die Pinfalscheingabe
			this.add(pinfalscheingabeText);
				
			//Platzieren des Textfeldes / Labels für die Pinfalscheingabe
			pinfalscheingabeText.setBounds(200,240,480,40);	
			
		}
		
	}
	
	
	public void erstelleButtons()
	{
		
		if ((3 - eingabeversuch) > 0)
		{
		//Erstellen einess Buttons für Zurück zum Startbildschirm
		Button zurückStartbildschirm = new Button("<html>Zurück zur<br />Pineingabe</html>");
		
		//Platzieren des Buttons für Zurück zum Startbildschirm
		//zurückStartbildschirm.setBounds(x, y, width, height);
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
		
		else
		{
						
			//Erstellen einess Buttons für den Vorgang abbrechen
			Button vorgangAbbrechen = new Button("<html>Rückgabe<br />bestätigen</html>");
			
			//Platzieren des Buttons auf der Pineingabe
			vorgangAbbrechen.setBounds(350, 330, 140, 60);
			
			//Hinzufügen eines Buttons mit der Pineingabe bestätigen
			this.add(vorgangAbbrechen);
			
			//Hinzufügen eines Listener für den Button Vorgang abbrechen
			ButtonClickListener bcVorgangAbbrechen = new ButtonClickListener();
			
			//Hinzufügen des Listeners bcVorgangAbbrechen zum Vorgang abbrechen
			vorgangAbbrechen.addActionListener(bcVorgangAbbrechen);
			
			//Anzeigen das Fensters
			this.setVisible(true);
			
		}
		
	}
	
	private class ButtonClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		
		//Speichere die Information zum Button
		String buttonInfo = e.getActionCommand().toString();

		//Reaktion für zum Startbildschirm
		if (buttonInfo.contains("<html>Zurück zur<br />Pineingabe</html>"))
		{	
			//Deaktivern der Pinfalscheingabe
			pinfalscheingabe.setVisible(false);
			
			//Aktivieren des Pineingabe
			pineingabe.setVisible(true);
		}
		
		
		//Reaktion auf Vorgang abbrechen
		
		if (buttonInfo.contains("<html>Vorgang<br />abbrechen</html>"))
		{	
			//Deaktivern der Pinfalscheingabe
			pinfalscheingabe.setVisible(false);
			
			//Aktivieren des Willkommensbildschirms
			willkommensbildschirm.setVisible(true);
			
			//Prüfe die Karte nach erscheinen des Willkommensbildschirms
			willkommensbildschirm.prüfeKarte(meineBank);
		}
		
		//Reaktion auf Rückgabe bestätigen
		
		if (buttonInfo.contains("<html>Rückgabe<br />bestätigen</html>"))
		{	
	        //Aufruf zur Konsolenansweisung für die Rückgabe der Karte 
	        System.out.print("Ihre Karte wird zurückgegeben! \n");
			
			//Deaktivern der Pinfalscheingabe
			pinfalscheingabe.setVisible(false);
			
			//Aktivieren des Willkommensbildschirms
			willkommensbildschirm.setVisible(true);
						
			//Prüfe die Karte nach erscheinen des Willkommensbildschirms
			willkommensbildschirm.prüfeKarte(meineBank);
			

		}
		
		
		}

		
	}
	
	
}
