package View;

import Reader.DiceReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application{
    
    DiceReader read = new DiceReader();

    public void start(Stage stage) throws Exception {
//	FXMLLoader loader = new FXMLLoader(getClass().getResource("diceRollerFXML.fxml"));
	FXMLLoader loader = new FXMLLoader(getClass().getResource("diceRollerFXML2.fxml"));
	Parent root = loader.load();

	Scene scene = new Scene(root);
	

	
	read.loadDice("SavedRolls.txt");
	
	stage.setTitle("Norse Dice Roller");
	stage.setScene(scene);
	stage.show();
	
    }
    
    public static void main(String[] args)
	{
		Application.launch(args);
	}

}