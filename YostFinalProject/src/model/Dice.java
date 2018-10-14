package model;

public class Dice implements Roller{
    
//    private int diceSides;
    private int upSide;
    private int total;
    Dice dice;
    
    
    public void roll(int side, int amount)
    {
	for(int x = 0; x <amount; x++)
	{
	    upSide = ((int)(Math.random() *side) +1);
	    total += upSide;
	}
    }


    public int getSide() {

	return upSide;
    }
    public int getTotal() {
	return total;
    }

}
