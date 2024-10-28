package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import gui.MoebelhausControl;
import gui.MoebelhausView;

public class MoebelhausModel {
	private MoebelhausView view;
	private MoebelhausControl control;
    private Moebelstueck moebelstueck;
    
    public MoebelhausModel(MoebelhausControl control) {
    	this.setControl(control);
	}


	public void schreibeMoebelstueckInCsvDatei() throws IOException{
		BufferedWriter aus 
			= new BufferedWriter(new FileWriter("MoebelstueckeAusgabe.csv", false));
		aus.write(moebelstueck.gibMoebelstueckZurueck(';'));
		aus.close();
		view.zeigeInformationsfensterAn(
   			"Das Moebelhaus wurden gespeichert!");
		System.out.println(moebelstueck.gibMoebelstueckZurueck(';'));
	}
	
	public void leseAusDatei(String typ) throws IOException{
  		if("csv".equals(typ)){
  			BufferedReader ein = new BufferedReader(new FileReader("Moebelstueck.csv"));
  			String[] zeile = ein.readLine().split(";");
  			this.moebelstueck = new Moebelstueck(zeile[0], 
  				Float.parseFloat(zeile[1]), 
  				Float.parseFloat(zeile[2]), 
  				zeile[3], zeile[4].split("_"));
  				ein.close();
  	  			view.zeigeInformationsfensterAn(
  	  	   			"Die Bürgerämter wurden gelesen!");
  		}
   		else{
   			view.zeigeInformationsfensterAn(
   				"Noch nicht implementiert!");
   		}
	}
		
	
    
	public Moebelstueck getMoebelstueck() {
		return this.moebelstueck;
	}

	public void setMoebelstueck(Moebelstueck moebelstueck) {
		this.moebelstueck = moebelstueck;
	}


	public MoebelhausControl getControl() {
		return control;
	}


	public void setControl(MoebelhausControl control) {
		this.control = control;
	}
    
    
}
