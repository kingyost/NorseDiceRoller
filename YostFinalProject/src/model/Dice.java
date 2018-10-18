package model;

public class Dice implements Roller{
    

    private int upSide;
    private int amount;
    private int total;
    private int totalSides;
    private int augment;
    
    
    
    public Dice(int side, int amount, int agument)
    {
	totalSides = side;
	this.amount = amount;
	this.augment = agument;
    }
    
    public void roll()
    {
	for(int x = 0; x <amount; x++)
	{
	    upSide = ((int)(Math.random() *totalSides) +1);
	    total += upSide;
	}
	total += augment;
    }

    public void resetTotal()
    {
	total = 0;
    }

    public int getSide() {

	return upSide;
    }
    public int getTotal() {
	return total;
    }
    

    public void test()
    {
	System.out.println("Dice class test");
    }

   
    
    
}