package gui;

import java.io.IOException;

import business.MoebelhausModel;
import business.Moebelstueck;
import javafx.stage.Stage;

public class MoebelhausControl {
	
	private MoebelhausView view;
	private MoebelhausModel model;
	
    public MoebelhausControl(Stage stage) {
		super();
		this.model = new MoebelhausModel(this);
		this.view = new MoebelhausView(stage, this, model);
	
	}
    
	public void nehmeMoebelstueckAuf(){
    	try{
    		model.setMoebelstueck(new Moebelstueck(
    			view.getTxtName().getText(), 
   	            Float.parseFloat(view.getTxtGeoeffnetVon().getText()),
   	            Float.parseFloat(view.getTxtGeoeffnetBis().getText()),
    		    view.getTxtStrasseHNr().getText(),
    		    view.getTxtDienstleistungen().getText().split(";")));
    		view.zeigeInformationsfensterAn("Das Moebelhaus wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
    public void schreibeMoebelstueckInDatei(){
    	try {
			model.schreibeMoebelstueckInCsvDatei();
		} catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
					"IOException beim Speichern!");
		}
		catch(Exception exc){
			System.out.println(exc);
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
    }
    
    public void leseAusDateien(String typ) {
    	try {
			model.leseAusDatei(typ);
		} catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		} catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
    }
    
    
    
    
}
