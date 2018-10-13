package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;

public class RuneDice implements Roller{
    
    
    private int upSide = 1;
    private int orientation = 1;
    private int totalSides =24;
//    int test;

    public int getSide() {
	return upSide + orientation;
//	test = upSide + orientation;
//	return test;
    }
    
    public int getOrientation(){
	return orientation;
    }

    public void roll(int side) {
	
	side = totalSides;
	upSide = ((int)(Math.random() *side) +1);
	
	Pattern p = Pattern.compile("[1|2|3|4|5|6|8|14|15|22|23]");
	String tempSide = Integer.toString(upSide);
	Matcher m = p.matcher(tempSide);
	
	if(m.matches())
	{
	    orientation = ((int)(Math.random() *1)+1);
	}
	else
	{
	    orientation = 0;
	}
    }
    
    
    
    

}
