package Reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class DiceReader {
    

    
    private ArrayList<String> dice = new ArrayList<String>();
    private ArrayList<String> diceStr = new ArrayList<String>();
    
    public void loadDice(String file) /*throws FileNotFoundException*/
    {
	try {
	Scanner input;
	String amount;
	String sides;
	boolean plus;
	String plusStr;
	String augment;
	
	input = new Scanner(new File(file));
	
	while(input.hasNext()) 
	{
	    String line = input.nextLine();
	    dice.add(line);
	    String[] fields = line.split(",");
	    
	    amount = fields[0];
	    sides = fields[1];
	    if(fields[2].equals("true"))
	    {
		plus = true;
		plusStr = "-";
	    } else {
		plus = false;
		plusStr = "+";
	    }
	    augment = fields[3];
	    
	    
	    diceStr.add(amount +"d"+sides+plusStr+augment);
	    
	}
	input.close();
	}
	catch(IOException x)
	{
	    Alert alert = new Alert(AlertType.ERROR, "File not found");
	    alert.showAndWait(); 
	}
    }
    

//    public List<String> getAllDice()
//    {
//	ArrayList<String> tempDice = new ArrayList<String>();
//	diceStr.stream().forEach(e -> tempDice.add(e.getDice()));
//	
//	return tempDice;
//    }
    
    public ArrayList<String> getDiceStr()
    {
	return diceStr;
    }
    
    public ArrayList<String> getDice()
    {
	return dice;
    }
}
