package bank;

import java.sql.*;

// TODO: Break up the class into separate entities of responsibility.
// TODO: One entity should handle communication with the database and be responsible for creating the initial database.
// TODO: Another separate class could handle the interaction with the frontend app (user). This could be a good first step towards restructuring. Open to ideas.

public class Bank
{
    //Speichern der bankkunden ID
    int bankkundenID = 0;
    //Speichern des vornamens
    String vorname = "";
    //Speichern des nachnamens
    String nachname = "";
    //Speichern des pins
    int pin = 0;

    //Speichern der bankkonten IDs
    int bankkonten_id = 0;
    //Speichern der kunden IDs
    int kunden_id = 0;
    //Speichern der kontostandes
    float kontostand = 0;


    // JDBC Treibername
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    //Datenbank URL
    static final String DB_URL = "jdbc:mysql://localhost/?useSSL=false";

    //Login für die Datenbank
    static final String USER = "root";
    static final String PASS = "";

    //Konstruktor der Bank
    public Bank()
    {

        //Definition der Verbindungsvariablen
        Connection conn = null;
        Statement stmt = null;

        try
        {

            //Registriere JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Verbinde zur Datenbank
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Löschen die Datenbank bank
            stmt = conn.createStatement();
            String sql = "DROP DATABASE IF EXISTS bank";
            stmt.execute(sql);

            //Erstelle die Datenbank bank
            stmt = conn.createStatement();
            sql = "CREATE DATABASE bank";
            stmt.executeUpdate(sql);

        }catch(SQLException se){
            //Behandlung von JDBC Fehlern
            se.printStackTrace();
        }catch(Exception e){
            //Behandlung der Fehler von Class.forName
            e.printStackTrace();
        }finally{
            //finally block wird für das schließen der Verbindung verwendet
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }


    //erstelle die Tabellen der Tabellen
    public void erstelleTabellen()

    {

        Connection conn = null;
        Statement stmt = null;

        try
        {

            //Registriere JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Öffne die Verbindung zur Datenbank
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Verbinden mit der Datenbank bank
            stmt = conn.createStatement();
            String sql = "USE bank";
            stmt.executeUpdate(sql);

            //Löschen die Tabelle bankkonten
            stmt = conn.createStatement();
            sql = "DROP TABLE IF EXISTS bankkonten";
            stmt.execute(sql);

            //Löschen die Tabelle bankkunden
            stmt = conn.createStatement();
            sql = "DROP TABLE IF EXISTS bankkunden";
            stmt.execute(sql);


            //Erstelle die Tabelle bankkkonten
            stmt = conn.createStatement();
            sql = "CREATE TABLE bankkunden (\n" +
                    "    bankkunden_id INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    vorname VARCHAR(40),\n" +
                    "    nachname VARCHAR(80),\n" +
                    "    kartennummer int,\n" +
                    "    pin int\n" +
                    ")";
            stmt.executeUpdate(sql);


            //Einfügen der Werte in die Tabelle bankkunden
            stmt = conn.createStatement();
            //Einfügen des ersten Datensatzes der Tabelle bankkunden
            sql = "INSERT INTO bankkunden "
                    + "(vorname, nachname, kartennummer, pin)"
                    + "\n" +
                    "VALUES "
                    + "(\"Mathias\", \"Mustermann\", 12598853, 1235)";
            stmt.executeUpdate(sql);

            //Einfügen des zweiten Datensatzes der Tabelle bankkunden
            sql = "INSERT INTO bankkunden "
                    + "(vorname, nachname, kartennummer, pin)"
                    + "\n" +
                    "VALUES "
                    + "(\"Markus\", \"Häuslich\", 88954243, 2355)";
            stmt.executeUpdate(sql);

            //Einfügen des dritten Datensatzes der Tabelle bankkunden
            sql = "INSERT INTO bankkunden "
                    + "(vorname, nachname, kartennummer, pin)"
                    + "\n" +
                    "VALUES "
                    + "(\"Denis\", \"Klaus\", 24585822, 1125)";
            stmt.executeUpdate(sql);

            //Einfügen des vierten Datensatzes der Tabelle bankkunden
            sql = "INSERT INTO bankkunden "
                    + "(vorname, nachname, kartennummer, pin)"
                    + "\n" +
                    "VALUES "
                    + "(\"Hakan\", \"Selman\", 66993384, 4356)";
            stmt.executeUpdate(sql);

            //Einfügen des fünften Datensatzes der Tabelle bankkunden
            sql = "INSERT INTO bankkunden "
                    + "(vorname, nachname, kartennummer, pin)"
                    + "\n" +
                    "VALUES "
                    + "(\"Nico\", \"Müller\", 44528695, 4234)";
            stmt.executeUpdate(sql);

            //Erstelle die Tabelle bankkkonten
            stmt = conn.createStatement();
            sql = "CREATE TABLE bankkonten (\n" +
                    "    bankkonten_id INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    bankkunden_id INTEGER,\n" +
                    "    FOREIGN KEY (bankkunden_id) REFERENCES bankkunden(bankkunden_id) ON DELETE CASCADE,\n" +
                    "    kontostand DECIMAL(10,2)\n" +
                    ")";
            stmt.executeUpdate(sql);

            //Einfügen der Werte in die Tabelle bankkkonten
            stmt = conn.createStatement();
            //Einfügen des ersten Datensatzes
            sql = "INSERT INTO bankkonten "
                    + "(bankkunden_id, kontostand)"
                    + "\n" +
                    "VALUES "
                    + "(1, 120.00)";
            stmt.executeUpdate(sql);

            //Einfügen des zweiten Datensatzes
            sql = "INSERT INTO bankkonten "
                    + "(bankkunden_id, kontostand)"
                    + "\n" +
                    "VALUES "
                    + "(2, 150.00)";
            stmt.executeUpdate(sql);

            //Einfügen des dritten Datensatzes
            sql = "INSERT INTO bankkonten "
                    + "(bankkunden_id, kontostand)"
                    + "\n" +
                    "VALUES "
                    + "(3, 20005.50)";
            stmt.executeUpdate(sql);

            //Einfügen des vierten Datensatzes
            sql = "INSERT INTO bankkonten "
                    + "(bankkunden_id, kontostand)"
                    + "\n" +
                    "VALUES "
                    + "(4, 124.00)";
            stmt.executeUpdate(sql);

            //Einfügen des fünften Datensatzes
            sql = "INSERT INTO bankkonten "
                    + "(bankkunden_id, kontostand)"
                    + "\n" +
                    "VALUES "
                    + "(5, 320.55)";
            stmt.executeUpdate(sql);

        }catch(SQLException se){
            //Behandlung von JDBC Fehlern
            se.printStackTrace();
        }catch(Exception e){
            //Behandlung der Fehler von Class.forName
            e.printStackTrace();
        }finally{
            //finally block wird für das schließen der Verbindung verwendet
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }

    }

    //Prüfe die Kundekarte auf Basis des Vornamen und Nachnamen
    public boolean prüfeKundenkarte(String vorname, String nachname, int kartennummer)
    {

        Connection conn = null;
        Statement stmt = null;
        boolean prüfeKundenkarte = false;

        try
        {

            //Registriere JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Öffne die Verbindung zur Datenbank
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Verbinden mit der Datenbank bank
            stmt = conn.createStatement();
            String sql = "USE bank";
            stmt.executeUpdate(sql);

            //Selektieren einen Eintrag in der die Tabelle bankkkonten
            stmt = conn.createStatement();

            sql = "SELECT * FROM bankkunden WHERE vorname = " + "\""+ vorname +"\"" + " and nachname = " + "\""+ nachname +"\"" + " and kartennummer = " + "\""+ kartennummer +"\"";
            ResultSet bankkunden = stmt.executeQuery(sql);

            //prüfe ob der Kunde vorhanden ist
            if (bankkunden.next())
            {
                prüfeKundenkarte =  true;
            }
            else
            {
                prüfeKundenkarte = false;
            }

        }catch(SQLException se){
            //Behandlung von JDBC Fehlern
            se.printStackTrace();
        }catch(Exception e){
            //Behandlung der Fehler von Class.forName
            e.printStackTrace();
        }finally{
            //finally block wird für das schließen der Verbindung verwendet
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return prüfeKundenkarte;

    }

    //Prüfe den Pin der Karte
    public boolean prüfePin(int bankkundenID, int pin)
    {
        Connection conn = null;
        Statement stmt = null;
        boolean prüfePin = false;

        try
        {

            //Registriere JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Öffne die Verbindung zur Datenbank
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Verbinden mit der Datenbank bank
            stmt = conn.createStatement();
            String sql = "USE bank";
            stmt.executeUpdate(sql);

            //Selektieren einen Eintrag in der die Tabelle bankkkonten
            stmt = conn.createStatement();

            sql = "SELECT * FROM bankkunden WHERE bankkunden_id = " + "\""+ bankkundenID +"\"" + " and pin = " + "\""+ pin +"\"";

            ResultSet bankkunden = stmt.executeQuery(sql);

            //prüfe ob der Pin korrekt ist
            if (bankkunden.next())
            {
                prüfePin =  true;
            }
            else
            {
                prüfePin = false;
            }

        }catch(SQLException se){
            //Behandlung von JDBC Fehlern
            se.printStackTrace();
        }catch(Exception e){
            //Behandlung der Fehler von Class.forName
            e.printStackTrace();
        }finally{
            //finally block wird für das schließen der Verbindung verwendet
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
//	   System.out.println("Die Verbindung wurde geschlossen");
        return prüfePin;

    }

    //Aktualisiere den Pin bei Änderunng
    public boolean aktualisierePin(int bankkundenID, int pin)
    {
        Connection conn = null;
        Statement stmt = null;
        int pinÄnderung = 0;
        boolean prüfePinÄnderung = false;

        try
        {

            //Registriere JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Öffne die Verbindung zur Datenbank
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Verbinden mit der Datenbank bank
            stmt = conn.createStatement();
            String sql = "USE bank";
            stmt.executeUpdate(sql);

            //Selektieren einen Eintrag in der die Tabelle bankkkonten
            stmt = conn.createStatement();

            sql = "UPDATE bankkunden SET "+ "pin = \""+ pin +"\" WHERE bankkunden_id = " + "\""+ bankkundenID +"\"";

            //Änderung durchführen
            pinÄnderung = stmt.executeUpdate(sql);

//	  prüfe ob die Pinänderung erfolgte
            if (pinÄnderung == 1)
            {
                prüfePinÄnderung =  true;
            }
            else
            {
                prüfePinÄnderung = false;
            }

        }catch(SQLException se){
            //Behandlung von JDBC Fehlern
            se.printStackTrace();
        }catch(Exception e){
            //Behandlung der Fehler von Class.forName
            e.printStackTrace();
        }finally{
            //finally block wird für das schließen der Verbindung verwendet
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
//	   System.out.println("Die Verbindung wurde geschlossen");
        return prüfePinÄnderung;

    }


    //Aktualisiere den Kontostand bei Abhebung
    public boolean aktualisiereKontostand(int bankkundenID, double abgebuchterBetrag)
    {
        Connection conn = null;
        Statement stmt = null;

        //Erhalte den aktuellen Kontostand
        double aktuellerKontostand = erhalteKontostand(bankkundenID);

        //Definieren des neues Kontostandes
        double neuerKontostand =	aktuellerKontostand - abgebuchterBetrag;

        int kontostandÄnderung = 0;
        boolean prüfeKontostandÄnderung = false;


        try
        {

            //Registriere JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Öffne die Verbindung zur Datenbank
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Verbinden mit der Datenbank bank
            stmt = conn.createStatement();
            String sql = "USE bank";
            stmt.executeUpdate(sql);

            //Selektieren einen Eintrag in der die Tabelle bankkkonten
            stmt = conn.createStatement();

            sql = "UPDATE bankkonten SET "+ "kontostand = \""+ neuerKontostand +"\" WHERE bankkunden_id = " + "\""+ bankkundenID +"\"";

            //Änderung durchführen
            kontostandÄnderung = stmt.executeUpdate(sql);

//	  prüfe ob die Kontostandänderung erfolgte
            if (kontostandÄnderung == 1)
            {
                prüfeKontostandÄnderung =  true;
            }
            else
            {
                prüfeKontostandÄnderung = false;
            }

        }catch(SQLException se){
            //Behandlung von JDBC Fehlern
            se.printStackTrace();
        }catch(Exception e){
            //Behandlung der Fehler von Class.forName
            e.printStackTrace();
        }finally{
            //finally block wird für das schließen der Verbindung verwendet
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return prüfeKontostandÄnderung;

    }


    //Erhalte den Bankkunden ID auf Basis den Vornamen und Nachnamen
    public int erhalteBankkundenID(String vorname, String nachname, int kartennummer)
    {
        Connection conn = null;
        Statement stmt = null;
        boolean prüfeKundenkarte = false;
        int bankkunden_id = 0;

        try
        {

            //Registriere JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Öffne die Verbindung zur Datenbank
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Verbinden mit der Datenbank bank
            stmt = conn.createStatement();
            String sql = "USE bank";
            stmt.executeUpdate(sql);

            //Selektieren einen Eintrag in der die Tabelle bankkkonten
            stmt = conn.createStatement();
            //sql = "SELECT vorname FROM bankkunden";

            sql = "SELECT * FROM bankkunden WHERE kartennummer = " + "\""+ kartennummer +"\"";


            ResultSet bankkunden = stmt.executeQuery(sql);

            //erhalten den bankkunden_id
            while (bankkunden.next())
            {
                bankkunden_id = bankkunden.getInt("bankkunden_id");

            }

        }catch(SQLException se){
            //Behandlung von JDBC Fehlern
            se.printStackTrace();
        }catch(Exception e){
            //Behandlung der Fehler von Class.forName
            e.printStackTrace();
        }finally{
            //finally block wird für das schließen der Verbindung verwendet
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return bankkunden_id;

    }


    //Erhalten den Kontostand mit den BankkundenID
    public double erhalteKontostand(int bankkundenID)
    {
        Connection conn = null;
        Statement stmt = null;
        double kontostand = 0;

        try
        {

            //Registriere JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Öffne die Verbindung zur Datenbank
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Verbinden mit der Datenbank bank
            stmt = conn.createStatement();
            String sql = "USE bank";
            stmt.executeUpdate(sql);

            //Selektieren einen Eintrag in der die Tabelle bankkkonten
            stmt = conn.createStatement();

            sql = "SELECT kontostand FROM bankkonten WHERE bankkunden_id = " + "\""+ bankkundenID +"\"";

            ResultSet bankkkonten = stmt.executeQuery(sql);

            //erhalte den aktuellen Kontostand
            while (bankkkonten.next())
            {
                kontostand = bankkkonten.getDouble("kontostand");
            }


        }catch(SQLException se){
            //Behandlung von JDBC Fehlern
            se.printStackTrace();
        }catch(Exception e){
            //Behandlung der Fehler von Class.forName
            e.printStackTrace();
        }finally{
            //finally block wird für das schließen der Verbindung verwendet
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return kontostand;

    }

}
