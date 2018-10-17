package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;

public class RuneDice extends Dice{
    
    
    private int upSide;
    private int orientation = 0;
    private int totalSides = 24;
    private int amount = 1;
//    int test;
    
    public RuneDice(int side, int amount)
    {
	super(side, amount, 0);
	this.orientation = 0;
	this.totalSides = 24;
	this.amount = 1;
	
    }

    public int getSide() {
	return upSide;
//	test = upSide + orientation;
//	return test;
    }
    
    public int getOrientation(){
	return orientation;
    }

    public void resetOrientation(){
	orientation = 0;
    }
    
    public void roll() {
//	System.out.println("test");
	
//	amount = this.amount;
	for (int x=0; x<amount; x++) {
	    upSide = ((int)(Math.random() *totalSides) +1);
	}
	Pattern p = Pattern.compile("^1|2|3|4|5|6|8|14|15|22|23$");
	String tempSide = Integer.toString(upSide);
	Matcher m = p.matcher(tempSide);
	
	if(m.matches())
	{
//	    System.out.println("orientation test");
	    orientation = ((int)(Math.random() *1)+1);
	    
	}
      }


    
    
    
    

}