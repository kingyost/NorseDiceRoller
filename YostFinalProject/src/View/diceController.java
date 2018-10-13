package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class diceController implements Initializable{
    
    ComboBox savedRollsCmbBx;
    ComboBox prevRollsCmbBx;
    
    TextArea resultsBx;
    
    CheckBox d4saveChkBx;
    CheckBox d6saveChkBx;
    CheckBox d8saveChkBx;
    CheckBox d10saveChkBx;
    CheckBox d12saveChkBx;
    CheckBox d20saveChkBx;
    CheckBox dSaveChkBx;
    
    CheckBox d4minusChkBx;
    CheckBox d6minusChkBx;
    CheckBox d8minusChkBx;
    CheckBox d10minusChkBx;
    CheckBox d12minusChkBx;
    CheckBox d20minusChkBx;
    CheckBox dMinusChkBx;
    
    CheckBox runicDiceChkBx;
    
    TextField d4rolled;
    TextField d6rolled;
    TextField d8rolled;
    TextField d10rolled;
    TextField d12rolled;
    TextField d20rolled;
    TextField dRolled; //amount of dice to roll
    TextField dNumber; //number of sides dice has
    
    TextField d4Augment;
    TextField d6Augment;
    TextField d8Augment;
    TextField d10Augment;
    TextField d12Augment;
    TextField d20Augment;
    TextField dAugment;
    
    ImageView runeImg;
    ImageView runeDiscription;
    
    ArrayList<Image> diceImages = new ArrayList<Image>();

    public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
    }
    
    
    public void rollButtonAction(ActionEvent event)
    {
	resultsBx.appendText("hello");
	System.out.println("hello");
    }
    
    
    
    
    
    
    
    
    

    public void loadDiceImage()
    {
	String diceImgs = "file:runes/";
	String[] side = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
	char[] orientation = {'n','r'};
	int slot = 0;
	Image dice;
	String path;
	for(int i = 1; i <= 24;i++)
	{
	    Pattern p = Pattern.compile("[1|2|3|4|5|6|8|14|15|22|23]");
	    String tempSide = Integer.toString(i);
	    Matcher m = p.matcher(tempSide);

	    if(m.matches())
	    {
		int x = ((int)(Math.random() *1)+1);
		path = diceImgs + side[i] + orientation[x] + ".jpg";

		
	    }
	    else
	    {
		path = diceImgs + side[i] + orientation[0] + ".jpg";
	    }
	    dice = new Image(path);
	    diceImages.add(dice);
	    
	}
    }
    
    private void clear() 
    {
	d4saveChkBx.setSelected(false);
	d6saveChkBx.setSelected(false);
	d8saveChkBx.setSelected(false);
	d10saveChkBx.setSelected(false);
	d12saveChkBx.setSelected(false);
	d20saveChkBx.setSelected(false);
	dSaveChkBx.setSelected(false);

	d4minusChkBx.setSelected(false);
	d6minusChkBx.setSelected(false);
	d8minusChkBx.setSelected(false);
	d10minusChkBx.setSelected(false);
	d12minusChkBx.setSelected(false);
	d20minusChkBx.setSelected(false);
	dMinusChkBx.setSelected(false);

	runicDiceChkBx.setSelected(false);

	d4rolled.setText("0");
	d6rolled.setText("0");
	d8rolled.setText("0");
	d10rolled.setText("0");
	d12rolled.setText("0");
	d20rolled.setText("0");
	dRolled.setText("0");
	dNumber.setText("0");
	d4Augment.setText("0");
	d6Augment.setText("0");
	d8Augment.setText("0");
	d10Augment.setText("0");
	d12Augment.setText("0");
	d20Augment.setText("0");
	dAugment.setText("0");
    }
    
}
