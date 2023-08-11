package bankautomat;


import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.util.Scanner;

import bank.Bank;

public class Willkommensbildschirm extends Frame{
	
	//Konstruktor / Erstelle des Willkommensbildschirms
	Willkommensbildschirm()
	{

		//Aufbau eines Fensters mit Willkommenbildschirm
		//Frame willkommensbildschirm = new Frame();
		//Setzen des Titels des Willkommensbildschirms
		super("Willkommensbildschirm");
		
		//Setzen des Layouts
		this.setLayout(null);
				
		//Erstellen eins WindowListenerAdapters welche auf die Nutzereingaben auf dem Fenster hört
		this.addWindowListener(new FensterSchließen(true));
		
		
		//Setzen des Willkommensbildschirms
		this.setSize(800,700);
			
	}
	
	
	public void erstelleLabels()
	{
		//Erstellen eines Textfeldes / Labels
		Label willkommensText = new Label("Willkommen bei der MUSTER BANK - Bitte schieben Sie Ihre Karten ein.");
		
		
		//Platzieren des Textfeldes / Labels zum Willkommenfeld
		//willkommenstextfeld.setBounds(x, y, width, height); 
		willkommensText.setBounds(170,310,500,40);	
		
		//Hinzufügen eines Textfeldes zum Willkommensbildschirm / Fenster
		this.add(willkommensText);
		
		//Anzeigen das Fensters
		this.setVisible(true);
		
	}
	

	public void prüfeKarte(Bank meineBank)
	{
		
		
		//Initialisieren des Scanners zur Eingabe der Vornamen ein        
        Scanner eingabewert = new Scanner(System.in);
        
        //Aufruf zur Konsolenansweisung für die Vorname 
        System.out.print("Geben Sie Ihre Vornamen ein: ");
        
        //Speichern des Eingabewertes Vorname
        String vorname = eingabewert.nextLine();
        
		//Initialisieren des Scanners zur Eingabe des Vornamen        
        eingabewert = new Scanner(System.in);
        
        //Aufruf zur Konsolenansweisung für die Nachnamen 
        System.out.print("Geben Sie Ihre Nachnamem ein: ");
        
        //Speichern des Eingabewertes Nachname
        String nachname = eingabewert.nextLine();
        
		//Initialisieren des Scanners zur Eingabe der Kartennummer ein        
        eingabewert = new Scanner(System.in);

        //Aufruf zur Konsolenansweisung für die Kartennummer 
        System.out.print("Geben Sie Ihre Kartennummer ein: ");
        
        //Speichern des Eingabewertes
        int kartennummer = eingabewert.nextInt();
        
        //test mit vorname: Mathias
        //test mit nachname: Mustermann
        //test mit kartennummer: 12598853
        //test mit pin: 1235
        
        //Prüfe vorname, nachname und pin
        boolean kundenKartePrüfung = meineBank.prüfeKundenkarte(vorname, nachname, kartennummer);
        
       	//Prüfen ob der Vorname, Nachname und die Kartennummer korrekt ist
        if (kundenKartePrüfung == true)
        {
        	//Deaktivieren des Fensters
    		this.setVisible(false);
    		
    		//Laden des bankkunden IDs     		
    		int bankkundenID = meineBank.erhalteBankkundenID(vorname, nachname, kartennummer);
    		    		
    		//Erstelle eine Objekt pineingabe
    		Pineingabe pineingabe = new Pineingabe(this, meineBank, bankkundenID);
    		
    		//Erstelle die Labels
    		pineingabe.erstelleLabels();
    		
    		//Erstelle die Buttons mit Listenern für die Pineingabe
    		pineingabe.erstelleButtons();

        }
	}

	//Aufbau des Willkommensbilschirms
	public static void main(String[] args)
	{
		//Erstelle eine Bank
		Bank meineBank = new Bank();
				
		//Erstelle die Tabellen
		meineBank.erstelleTabellen();
			
		
		//Erstelle eine Objekt willkommensbildschirm
		Willkommensbildschirm willkommensbildschirm = new Willkommensbildschirm();
		
		//Setze die Labels
		willkommensbildschirm.erstelleLabels();
		
		//prüfen der Karte
		//Kartennummer: 1256945
		willkommensbildschirm.prüfeKarte(meineBank);
	}
	
	
}
