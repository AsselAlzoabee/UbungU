package main;
// 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
import gui.MoebelhausControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new MoebelhausControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
