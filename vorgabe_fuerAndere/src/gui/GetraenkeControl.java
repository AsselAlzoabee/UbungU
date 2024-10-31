package gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Getraenke;
import business.GetraenkeModel;
import javafx.stage.Stage;


public class GetraenkeControl {

	private GetraenkeView getraenkeView;
	private GetraenkeModel getraenkeModel;
	
	
	public GetraenkeControl( Stage primaryStage) {
		
		this.getraenkeModel = new GetraenkeModel();
		this.getraenkeView = new GetraenkeView(this, primaryStage, getraenkeModel);
	}
	
	public void schreibeInCsvDatei(String meldung) throws IOException {
		getraenkeModel.schreibeGetraenkeInCsvDatei();
		getraenkeView.zeigeInformationsfensterAn(meldung);
	}
	
	
	 void nehmeGetraenkeauf(){
	    	try{
	    		getraenkeModel.setGetraenke(new Getraenke(
		    			getraenkeView.getTxtArtikelnummer().getText(), 
		   	            Float.parseFloat(getraenkeView.getTxtEinkaufspreis().getText()),
		   	            Float.parseFloat(getraenkeView.getTxtVerkaufspreis().getText()),
		   	         getraenkeView.getTxtMitAlkohol().getText(),
		   	      getraenkeView.getTxtBehältnis().getText().split(";")));
	    		getraenkeView.zeigeInformationsfensterAn("Das BÃ¼rgeramt wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		getraenkeView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	    }
	 
	 void leseAusDatei(String typ){
	    	try {
	      		if("csv".equals(typ)){
	      			BufferedReader ein = new BufferedReader(new FileReader("Buergeraemter.csv"));
	      			String[] zeile = ein.readLine().split(";");
	      			getraenkeModel.setGetraenke(new Getraenke(zeile[0], 
		      				Float.parseFloat(zeile[1]), 
		      				Float.parseFloat(zeile[2]), 
		      				zeile[3], zeile[4].split("_")));
	      				ein.close();
	      	  			getraenkeView.zeigeInformationsfensterAn(
	      	  	   			"Die BÃ¼rgerÃ¤mter wurden gelesen!");
	      		}
	       		else{
		   			getraenkeView.zeigeInformationsfensterAn(
		   				"Noch nicht implementiert!");
		   		}
			}
			catch(IOException exc){
				getraenkeView.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				getraenkeView.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
				
			}
		}
	 
	 
	 
	 
	 
	 
}	
//catch(IOException exc){
//GetraenkeView.zeigeFehlermeldungsfensterAn(
//		"IOException beim Speichern!");
//}
//catch(Exception exc){
//GetraenkeView.zeigeFehlermeldungsfensterAn(
//		"Unbekannter Fehler beim Speichern!");
//}
//GetraenkeView.zeigeInformationsfensterAn(
//			"Die BÃ¼rgerÃ¤mter wurden gespeichert!");
	 
	 
