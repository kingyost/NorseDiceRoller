package writer;

import model.Dice;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class DiceWriter {
    
    private boolean flag = true;
    
    Dice dice;
    
    public void SaveRoll(String file, String amount, String sides, String augment, boolean aug)
    {
	try {
	    PrintWriter output = new PrintWriter(new FileWriter(file, true));
	    output.printf("%s,%s,%b,%s", amount, sides, aug, augment);
	    output.close();
	    flag = true;
		
	}
	catch(IOException x) {
	    flag = false;
	}
	
    }
    
    public boolean GetFlag()
    {
	return flag;
    }
    

}
