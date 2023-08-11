//Zuordnung der Klasse in das Paket
package kunde;
//Nennung weiterer Pakete


//Struktur der Klasse
//Sichtbarkeitattribut (public) Schlüsselwort (class) und Klassenname (Kunde)
public class Kunde {
//Gültigkeitsbereich der Klasse beginnt mit der geschweiften Klammer ({)

    //Struktur der Variablendefinition
    //Objektvariablen (Schlüsselwort: kein static)
    //Definition der Daten (Datentypen und Variblennamen (und) Zuweisung eines Wertes an die Variable mit den Zuweisungsopertor (=); Ansonsten wird wahrscheinlich vom 0 oder null gesetzt) mit Semikolon (;) für den Abschluss des Befehls
    String vorname = "Mathias";
    String nachname = "Mustermann";
    String geburtsname = "Mustermann";
    int kundennummer = 1;
    String IBAN = "DE41500105170123456789";
    int kontonummer = 1;
    String steuernummer = "079/123/12347";
    String straße = "Musterstraße";
    int straßennummer = 9;
    int postleitzahl = 25669;
    String stadt = "Musterstadt";
    String familienstand = "ledig";
    int kartennummer = 12598853;
    int pin = 1235;
    double kontostand = 120;

    //Erstellung einer Klassenvariable
    static int anzahlObjekt = 0;


    //Definition einer Methode (main)
    //Struktur der Methode
    //Sichtbarkeitsattribut (public) Typ der Methode z.B. Klassenmethode (Schlüsselwort: static; kann ohne ein Objekt aufgerufen werden) oder Objektmethode (Schlüsselwort: kein static)
    //Rückgabewerte (void (kein Rückgabewert) oder Datentypen (int, float, double, String, Objekt)) Methodenname (z.B. main) und in runden Klammern (Datentyp 1 Variablenname 1, Datentyp 2 Variablenname 2  ...)
    public static void main(String[] args) {
        //Gültigkeitsbereich der Methode beginnt mit der geschweiften Klammer ({)

        //Struktur zur Objekterstellung einer Klasse
        //Klassenname (Kunde) Objektname (mathiasMustermann) = Schlüsselwort (new) Klassenname () (Kunde())

        //Erstellung des Kunden Mathias Mustermann) im Bankssystem oder Bankprogramm
        Kunde mathiasMustermann = new Kunde();
        //Erhöhung der Anzahl der Objekte im Speicher
        anzahlObjekt = 1;

        //Ausgeben des Wertes einer Variable
        //System.out.println(anzahlObjekt);

        //Ausgeben des Kontostandes vor der Einzahlung
        System.out.println("Der Kontostand vor der Einzahlung ist: " + mathiasMustermann.erhalteKontostand());

        //Einzahlung von 25.00 Euro
        //Sturuktur zur Verwendung einer Objektvariablen
        //Objektvariable (mathiasMustermann) Punktoperator (.) Methodenname (betragEinzahlen) (Variablenwert (25.00))
        mathiasMustermann.betragEinzahlen(25.00);

        //Ausgeben des Kontostandes nach der Auszahlung
        System.out.println("Der Kontostand nach der Einzahlung ist: " + mathiasMustermann.erhalteKontostand());

        int breakpoint = 1;
        breakpoint  =2;


        //Gültigkeitsbereich der Methode endet mit der geschweiften Klammer (})
    }


    //Definition der Objektmethode in Konto einzahlen
    //Struktur der Methode
    //Sichtbarkeitsattribut (public) Typ der Methode z.B. Klassenmethode (Schlüsselwort: static; kann ohne ein Objekt aufgerufen werden)
    //oder Objektmethode (Schlüsselwort: kein static)
    public void betragEinzahlen(double betrag)
    {
        //der this Operator ermöglicht das Beschreiben (und das Lesen) der Variable (Objektvariable) vom aufgerufenen Objekt
        this.kontostand = this.kontostand + betrag;
    }

    public double erhalteKontostand()
    {
        //der this Operator ermöglicht das Lesen (und das Beschreiben) der Variable (Objektvariable) vom aufgerufenen Objekt
        //das Schlüsselwort return ermöglicht das Zurückgeben eines Wertes an den Aufrufenden der Methode (Objekt oder Klasse (wenn das Schlüsselwort static verwendet wird))
        return this.kontostand;
    }




//Gültigkeitsbereich der Klasse endet mit der geschweiften Klammer (})
}
