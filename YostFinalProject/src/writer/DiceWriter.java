package writer;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class DiceWriter {
    
    private boolean flag = true;
    

    
    public void SaveRoll(String file, String amount, String sides, String augment, boolean aug) throws IOException
    {
//	System.out.println("hello");
	try {
//	    System.out.println(file);
	    PrintWriter output = new PrintWriter(new FileWriter(file, true));
	    output.printf("%s,%s,%b,%s \n", amount, sides, aug, augment);
	    output.close();
	    flag = true;
		
	}
	catch(Exception x){
	    flag = false;
	}
	
	
    }
    
    public boolean GetFlag()
    {
	return flag;
    }
    
//    public void test()
//    {
//	System.out.println("hello");
//    }

}
