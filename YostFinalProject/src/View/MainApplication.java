package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApplication extends Application{

    public void start(Stage stage) throws Exception {
	diceController controller;
	
	FXMLLoader loader = new FXMLLoader(getClass().getResource("diceRollerFXML.fxml"));
	
	Parent root = loader.load();

	Scene scene = new Scene(root);
	controller = (diceController)loader.getController();
	
	stage.setTitle("Norse Dice Roller");
	stage.setScene(scene);
	stage.show();
	
    }
    
    public static void main(String[] args)
	{
		Application.launch(args);
	}

}
