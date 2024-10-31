package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import gui.GetraenkeView;

public class GetraenkeModel {

	private Getraenke getraenke;

	public Getraenke getGetraenke() {
		return getraenke;
	}

	public void setGetraenke(Getraenke getraenke) {
		this.getraenke = getraenke;
	}
	
	
	public void schreibeGetraenkeInCsvDatei() throws IOException {
		
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("BuergeraemterAusgabe.csv", true));
			aus.write(getGetraenke().gibGetraenkezurueck(';'));
			aus.close();
   			
	}
	

}
