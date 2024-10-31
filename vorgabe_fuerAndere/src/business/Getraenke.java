package business;

public class Getraenke {



	
	// Artikelnummer des Buergeramtes
    private String Artikelnummer;
    // Oeffnungszeiten
    private float Einkaufspreis;
    private float Verkaufspreis;
    // Strasse und Hausnummer des Buergeramtes
    private String mitAlkohol;
    // Behältnis des Buergeramtes
    private String[] Behältnis;

    public Getraenke(String Artikelnummer, float Einkaufspreis, float Verkaufspreis,
    	String mitAlkohol, String[] Behältnis){
   		this.Artikelnummer = Artikelnummer;
  	    this.Einkaufspreis = Einkaufspreis;
   	    this.Verkaufspreis = Verkaufspreis;
   	    this.mitAlkohol = mitAlkohol;
   	    this.Behältnis = Behältnis;
    }
    
	public String getArtikelnummer() {
		return Artikelnummer;
	}

	public void setArtikelnummer(String Artikelnummer) {
		this.Artikelnummer = Artikelnummer;
	}

	public float getEinkaufspreis() {
		return Einkaufspreis;
	}

	public void setEinkaufspreis(float Einkaufspreis) {
		this.Einkaufspreis = Einkaufspreis;
	}

	public float getVerkaufspreis() {
		return Verkaufspreis;
	}

	public void setVerkaufspreis(float Verkaufspreis) {
		this.Verkaufspreis = Verkaufspreis;
	}

	public String getmitAlkohol() {
		return mitAlkohol;
	}

	public void setmitAlkohol(String mitAlkohol) {
		this.mitAlkohol = mitAlkohol;
	}

	public String[] getBehältnis() {
		return Behältnis;
	}

	public void setBehältnis(String[] Behältnis) {
		this.Behältnis = Behältnis;
	}
	
	public String getBehältnisAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getBehältnis().length - 1; i++) {
			ergebnis = ergebnis + this.getBehältnis()[i] + trenner; 
		}
		return ergebnis	+ this.getBehältnis()[i];
	}
	
	public String gibGetraenkezurueck(char trenner){
  		return this.getArtikelnummer() + trenner 
  			+ this.getEinkaufspreis() + trenner
  		    + this.getVerkaufspreis() + trenner
  		    + this.getmitAlkohol() + trenner + "\n"
  		    + this.getBehältnisAlsString(trenner) + "\n";
	}
}