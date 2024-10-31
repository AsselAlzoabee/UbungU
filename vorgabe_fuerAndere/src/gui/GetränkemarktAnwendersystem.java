package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;


public class GetränkemarktAnwendersystem {

	//name : 
	//von = 
	// bis= 
	//str= 
	//leistung


	  
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblArtikelnummer 					= new Label("Name:");
    private Label lblEinkaufspreis   		= new Label("GeÃ¶ffnet von:");
    private Label lblVerkaufspreis  	 		= new Label("GeÃ¶ffnet bis:");
    private Label lblMitAlkohol   			= new Label("StraÃŸe und Hausnummer:");
    private Label lblBehältnis  		= new Label("Dienstleistungen:");
    private TextField txtArtikelnummer 	 			= new TextField();
    private TextField txtEinkaufspreis		= new TextField();
    private TextField txtVerkaufspreis		= new TextField();
    private TextField txtMitAlkohol			= new TextField();
    private TextField txtBehältnis	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Getränkemarkt
    private Getränkemarkt Getränkemarkt;
    
    public GetränkemarktAnwendersystem(Stage primaryStage){
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von BÃ¼rgerÃ¤mtern");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
    }
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblArtikelnummer.setLayoutX(20);
    	lblArtikelnummer.setLayoutY(90);
    	lblEinkaufspreis.setLayoutX(20);
    	lblEinkaufspreis.setLayoutY(130);
    	lblVerkaufspreis.setLayoutX(20);
    	lblVerkaufspreis.setLayoutY(170);
    	lblMitAlkohol.setLayoutX(20);
    	lblMitAlkohol.setLayoutY(210);
    	lblBehältnis.setLayoutX(20);
    	lblBehältnis.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblArtikelnummer, lblEinkaufspreis, lblVerkaufspreis,
       		lblMitAlkohol, lblBehältnis);
    
    	// Textfelder
     	txtArtikelnummer.setLayoutX(170);
    	txtArtikelnummer.setLayoutY(90);
    	txtArtikelnummer.setPrefWidth(200);
    	txtEinkaufspreis.setLayoutX(170);
    	txtEinkaufspreis.setLayoutY(130);
    	txtEinkaufspreis.setPrefWidth(200);
    	txtVerkaufspreis.setLayoutX(170);
    	txtVerkaufspreis.setLayoutY(170);
    	txtVerkaufspreis.setPrefWidth(200);
      	txtMitAlkohol.setLayoutX(170);
    	txtMitAlkohol.setLayoutY(210);
    	txtMitAlkohol.setPrefWidth(200);
    	txtBehältnis.setLayoutX(170);
    	txtBehältnis.setLayoutY(250);
    	txtBehältnis.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtArtikelnummer, txtEinkaufspreis, txtVerkaufspreis,
     		txtMitAlkohol, txtBehältnis);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    nehmeGetraenkeauf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeGetraenkeAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				schreibeGetraenkeInCsvDatei();
			}	
	    });
    }
    
    private void nehmeGetraenkeauf(){
    	try{
    		this.Getränkemarkt = new Getränkemarkt(
    			txtArtikelnummer.getText(), 
   	            Float.parseFloat(txtEinkaufspreis.getText()),
   	            Float.parseFloat(txtVerkaufspreis.getText()),
    		    txtMitAlkohol.getText(),
    		    txtBehältnis.getText().split(";"));
    		zeigeInformationsfensterAn("Das BÃ¼rgeramt wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    private void zeigeGetraenkeAn(){
    	if(this.Getränkemarkt != null){
    		txtAnzeige.setText(
    			this.Getränkemarkt.gibGetränkemarktZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein BÃ¼rgeramt aufgenommen!");
    	}
    }    
		  
    private void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Buergeraemter.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.Getränkemarkt = new Getränkemarkt(zeile[0], 
      				Float.parseFloat(zeile[1]), 
      				Float.parseFloat(zeile[2]), 
      				zeile[3], zeile[4].split("_"));
      				ein.close();
      	  			zeigeInformationsfensterAn(
      	  	   			"Die BÃ¼rgerÃ¤mter wurden gelesen!");
      		}
       		else{
	   			zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	private void schreibeGetraenkeInCsvDatei() {
		try {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("BuergeraemterAusgabe.csv", true));
			aus.write(Getränkemarkt.gibGetränkemarktZurueck(';'));
			aus.close();
   			zeigeInformationsfensterAn(
	   			"Die BÃ¼rgerÃ¤mter wurden gespeichert!");
		}	
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

    private void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }

}
