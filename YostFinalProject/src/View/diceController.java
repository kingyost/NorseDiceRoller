package View;

import model.Dice;
import model.RuneDice;
import writer.DiceWriter;
import Reader.DiceReader;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class diceController implements Initializable{

//    RuneDice rDice;  // it kept erroring out when this was empty
//    Dice dice;       // it kept erroring out when this was empty
    
    RuneDice rDice= new RuneDice(0,0);
    Dice dice = new Dice(0,0,0);  
    DiceWriter write= new DiceWriter();
    DiceReader read= new DiceReader();

    @FXML private ComboBox<String> savedRollsCmbBx;

    @FXML private TextArea resultsBx;

    @FXML private RadioButton d4saveRB;
    @FXML private RadioButton d6saveRB;
    @FXML private RadioButton d8saveRB;
    @FXML private RadioButton d10saveRB;
    @FXML private RadioButton d12saveRB;
    @FXML private RadioButton d20saveRB;
    @FXML private RadioButton d100saveRB;
    @FXML private RadioButton dSaveRB;

    @FXML private TextField d4rolled;
    @FXML private TextField d6rolled;
    @FXML private TextField d8rolled;
    @FXML private TextField d10rolled;
    @FXML private TextField d12rolled;
    @FXML private TextField d20rolled;
    @FXML private TextField d100rolled;
    @FXML private TextField dRolled; //amount of dice to roll
    @FXML private TextField dNumber; //number of sides dice has


    @FXML private CheckBox d4minusChkBx;
    @FXML private CheckBox d6minusChkBx;
    @FXML private CheckBox d8minusChkBx;
    @FXML private CheckBox d10minusChkBx;
    @FXML private CheckBox d12minusChkBx;
    @FXML private CheckBox d20minusChkBx;
    @FXML private CheckBox d100minusChkBx;
    @FXML private CheckBox dMinusChkBx;

    @FXML private TextField d4Augment;
    @FXML private TextField d6Augment;
    @FXML private TextField d8Augment;
    @FXML private TextField d10Augment;
    @FXML private TextField d12Augment;
    @FXML private TextField d20Augment;
    @FXML private TextField d100Augment;
    @FXML private TextField dAugment;

    @FXML private RadioButton RuneToggle;
    @FXML private RadioButton DiceToggle;
    @FXML private RadioButton SavedToggle;

    

    @FXML private CheckBox runicDiceChkBx;

    @FXML private ImageView runeImg;
    @FXML private ImageView runeDiscription;

    ArrayList<String> diceString = new ArrayList<String>();

    ArrayList<Image> diceImages = new ArrayList<Image>();
    ArrayList<Image> imgMeaning = new ArrayList<Image>();

    String file = "SavedRolls.txt";



    @FXML public void rollButtonAction(ActionEvent event)
    {

	String d4roll = d4rolled.getText();
	String d6roll = d6rolled.getText();
	String d8roll = d8rolled.getText();
	String d10roll = d10rolled.getText();
	String d12roll = d12rolled.getText();
	String d20roll = d20rolled.getText();
	String d100roll = d100rolled.getText();
	String dRoll = dRolled.getText();
	String dSide = dNumber.getText();

	String d4Plus = d4Augment.getText();
	String d6Plus = d6Augment.getText();
	String d8Plus = d8Augment.getText();
	String d10Plus = d10Augment.getText();
	String d12Plus = d12Augment.getText();
	String d20Plus = d20Augment.getText();
	String d100Plus = d100Augment.getText();
	String dPlus = dAugment.getText();


	if(RuneToggle.isSelected())
	{
	    if(runicDiceChkBx.isSelected())
	    {

		rDice.roll();
		rDice.getSide();


		int index = (rDice.getOrientation() == 1)
			? rDice.getSide() + 24
				: rDice.getSide();

		runeImg.setImage(diceImages.get(index));
		runeDiscription.setImage(imgMeaning.get(index));
		rDice.resetOrientation();
	    }
	}
	
	else if (DiceToggle.isSelected()){
	    try {
		if(!d4roll.equals("") && !d4roll.equals("0"))	    
		{
		    RollCall(4, Integer.parseInt(d4roll), Integer.parseInt(d4Plus), d4minusChkBx.isSelected());
		}
		if(!d6roll.equals("") && !d6roll.equals("0"))		   
		{
		    RollCall(6, Integer.parseInt(d6roll), Integer.parseInt(d6Plus), d6minusChkBx.isSelected());
		}
		if(!d8roll.equals("") && !d8roll.equals("0"))	    
		{
		    RollCall(8, Integer.parseInt(d8roll), Integer.parseInt(d8Plus), d8minusChkBx.isSelected());
		}
		if(!d10roll.equals("") && !d10roll.equals("0"))		   
		{
		    RollCall(10, Integer.parseInt(d10roll), Integer.parseInt(d10Plus), d10minusChkBx.isSelected());
		}
		if(!d12roll.equals("") && !d12roll.equals("0"))	    
		{
		    RollCall(12, Integer.parseInt(d12roll), Integer.parseInt(d12Plus), d12minusChkBx.isSelected());
		}
		if(!d20roll.equals("") && !d20roll.equals("0"))		   
		{
		    RollCall(20, Integer.parseInt(d20roll), Integer.parseInt(d20Plus), d20minusChkBx.isSelected());
		}
		if(!d100roll.equals("") && !d100roll.equals("0"))	    
		{
		    RollCall(100, Integer.parseInt(d100roll), Integer.parseInt(d100Plus), d100minusChkBx.isSelected());
		}
		if(!dRoll.equals("") && !dRoll.equals("0"))	    
		{
		    RollCall(Integer.parseInt(dSide), Integer.parseInt(dRoll), Integer.parseInt(dPlus), dMinusChkBx.isSelected());
		}

//		System.out.println(d4saveRB.isSelected());
		
		if(d4saveRB.isSelected()){ 
		    write.SaveRoll(file, d4roll, "4", d4Plus, d4minusChkBx.isSelected());
		    RollBox(4, Integer.parseInt(d4roll), Integer.parseInt(d4Plus), d4minusChkBx.isSelected());
		} else if(d6saveRB.isSelected()) {
		    write.SaveRoll(file, d6roll, "6", d6Plus, d6minusChkBx.isSelected());
		} else if(d8saveRB.isSelected()) {
		    write.SaveRoll(file, d8roll, "8", d6Plus, d8minusChkBx.isSelected());
		} else if(d10saveRB.isSelected()) {
		    write.SaveRoll(file, d10roll, "10", d10Plus, d10minusChkBx.isSelected());
		} else if(d12saveRB.isSelected()) {
		    write.SaveRoll(file, d12roll, "12", d12Plus, d12minusChkBx.isSelected());
		}  else if(d20saveRB.isSelected()) {
		    write.SaveRoll(file, d20roll, "20", d20Plus, d20minusChkBx.isSelected());
		}  else if(d100saveRB.isSelected()) {
		    write.SaveRoll(file, d100roll, "100", d100Plus, d100minusChkBx.isSelected());
		} else if(dSaveRB.isSelected()){
		    write.SaveRoll(file, dRoll, dSide, d4Plus, dMinusChkBx.isSelected());
		}


	    }
	    catch(NumberFormatException e) {
		Alert alert = new Alert(AlertType.ERROR, "Only enter numbers in the text boxes.");
		alert.showAndWait();
	    } 
	    catch (IOException e) {
		Alert alert = new Alert(AlertType.ERROR, "Unable to write to " + file + ".");
		alert.showAndWait();
	    }
	    
	} 
//	
	else if (SavedToggle.isSelected()){
//	    if(savedRollsCmbBx.getSelectionModel() != null)
//	    {
//		clickCombo(savedRollsCmbBx.getSelectionModel().getSelectedIndex());
//	    }
//	    else {
//		Alert alert = new Alert(AlertType.ERROR, "Make sure you select a roll");
//		alert.showAndWait();
//	    }
	    
	    Alert alert = new Alert(AlertType.ERROR, "Functionality Comming Soon!\n For now you can only see saved rolls.");
	    alert.showAndWait();
	} 
	
	else {
	    Alert alert = new Alert(AlertType.ERROR, "please select a radio button.");
	    alert.showAndWait();
	}

//	System.out.println(diceString.get(savedRollsCmbBx.getSelectionModel().getSelectedIndex()));

	clear();
	
//	initialize(null, null);
    }

    @FXML public void clickCombo(int index)
    {
	boolean plus;
//	System.out.println(diceString.get(savedRollsCmbBx.getSelectionModel().getSelectedIndex()));
	String diceStr = diceString.get(index);
	System.out.println(diceStr);
	String[] fields = diceStr.split(",");
	int amount = Integer.parseInt(fields[0]);
	int sides = Integer.parseInt(fields[1]);
	if(fields[2].equals("true"))
	{
	   plus = true;
	} else {
	    plus = false;
	}
	int augment = Integer.parseInt(fields[3]);
	RollCall(sides,amount,augment,plus);
    }



    public void RollCall(int side, int amount, int agument, boolean Agu)
    {
	int modAgument=agument;
	String plus = "+";

	if(Agu)
	{
	    modAgument = -agument;
	    plus = "-";
	}
	
	Dice dice = new Dice(side, amount, modAgument);

	dice.roll();

	String printout = amount+ "d"+ side + plus + agument +" = "+dice.getTotal();
//	String printout = Rolls(side, amount, agument, Agu);
	resultsBx.appendText(printout+"\n");
	dice.resetTotal();
    }
    
    public void RollBox(int side, int amount, int agument, boolean Agu)
    {
	String plus = "+";

	if(Agu)
	{
	    plus = "-";
	}
	
	String printout = amount+ "d"+ side + plus + agument;
	savedRollsCmbBx.getItems().add(printout);
    }

    @FXML public void loadDiceImage()
    {
	String diceImgs = "file:runes/";
	String[] side = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
	char[] orientation = {'n','r'};
	Image dice;
	Image img;
	String path;
	String meaning;

	for(int i=0; i<55;i++)
	{
	    diceImages.add(null);
	    imgMeaning.add(null);
	}
	for(int i = 1; i < 25;i++)
	{
	    Pattern p = Pattern.compile("^1|2|3|4|5|6|8|14|15|22|23$");
	    String tempSide = Integer.toString(i);
	    Matcher m = p.matcher(tempSide);

	    if(m.matches())
	    {
		//		    int x = ((int)(Math.random() *1)+1);
		path = diceImgs + side[i-1] + orientation[1] + ".jpg";
		meaning = diceImgs + side[i-1] + orientation[1] + "-meaning.jpg";
		//	    System.out.println(path);
		//	    System.out.println(meaning);
		//	    System.out.println(i+24);
		dice = new Image(path);
		img = new Image(meaning);
		diceImages.set(i+24,dice);
		imgMeaning.set(i+24,img);
	    }

	    path = diceImgs + side[i-1] + orientation[0] + ".jpg";
	    meaning = diceImgs + side[i-1] + orientation[0] + "-meaning.jpg";
	    //	System.out.println(path);
	    //	System.out.println(meaning);
	    //	System.out.println(i);
	    dice = new Image(path);
	    img = new Image(meaning);
	    diceImages.set(i,dice);
	    imgMeaning.set(i,img);

	}
    }

    @FXML private void clear() 
    {
	d4saveRB.setSelected(false);
	d6saveRB.setSelected(false);
	d8saveRB.setSelected(false);
	d10saveRB.setSelected(false);
	d12saveRB.setSelected(false);
	d20saveRB.setSelected(false);
	dSaveRB.setSelected(false);

	d4minusChkBx.setSelected(false);
	d6minusChkBx.setSelected(false);
	d8minusChkBx.setSelected(false);
	d10minusChkBx.setSelected(false);
	d12minusChkBx.setSelected(false);
	d20minusChkBx.setSelected(false);
	dMinusChkBx.setSelected(false);

	runicDiceChkBx.setSelected(false);

	d4rolled.setText("");
	d6rolled.setText("");
	d8rolled.setText("");
	d10rolled.setText("");
	d12rolled.setText("");
	d20rolled.setText("");
	d100rolled.setText("");
	dRolled.setText("");
	dNumber.setText("");
	
	d4Augment.setText("");
	d6Augment.setText("");
	d8Augment.setText("");
	d10Augment.setText("");
	d12Augment.setText("");
	d20Augment.setText("");
	d100Augment.setText("");
	dAugment.setText("");
	
//	diceString.removeAll(read.getDiceStr());
//	savedRollsCmbBx.getItems().setAll(read.getDiceStr());
//	savedRollsCmbBx.ite
    }


    public void initialize(URL arg0, ResourceBundle arg1)  {
	// TODO Auto-generated method stub
	loadDiceImage();

//	read.loadDice(file);
	

	read.loadDice(file);
	savedRollsCmbBx.getItems().setAll(read.getDiceStr());
//	diceString.addAll(read.getDice());
	
	
    }
    

}
