package View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class diceController implements Initializable{
    
    @FXML private ComboBox savedRollsCmbBx;
    @FXML private ComboBox prevRollsCmbBx;
    
    @FXML private TextArea resultsBx;
    
    @FXML private CheckBox d4saveChkBx;
    @FXML private CheckBox d6saveChkBx;
    @FXML private CheckBox d8saveChkBx;
    @FXML private CheckBox d10saveChkBx;
    @FXML private CheckBox d12saveChkBx;
    @FXML private CheckBox d20saveChkBx;
    @FXML private CheckBox dSaveChkBx;
    
    @FXML private CheckBox d4minusChkBx;
    @FXML private CheckBox d6minusChkBx;
    @FXML private CheckBox d8minusChkBx;
    @FXML private CheckBox d10minusChkBx;
    @FXML private CheckBox d12minusChkBx;
    @FXML private CheckBox d20minusChkBx;
    @FXML private CheckBox dMinusChkBx;
    
    @FXML private CheckBox runicDiceChkBx;
    
    @FXML private TextField d4rolled;
    @FXML private TextField d6rolled;
    @FXML private TextField d8rolled;
    @FXML private TextField d10rolled;
    @FXML private TextField d12rolled;
    @FXML private TextField d20rolled;
    @FXML private TextField dRolled; //amount of dice to roll
    @FXML private TextField dNumber; //number of sides dice has
    
    @FXML private TextField d4Augment;
    @FXML private TextField d6Augment;
    @FXML private TextField d8Augment;
    @FXML private TextField d10Augment;
    @FXML private TextField d12Augment;
    @FXML private TextField d20Augment;
    @FXML private TextField dAugment;
    
    ImageView runeImg;
    ImageView runeDiscription;
    
    ArrayList<Image> diceImages = new ArrayList<Image>();


    
    
    @FXML public void rollButtonAction(ActionEvent event)
    {
//	resultsBx.appendText("hello");
//	System.out.println("hello");
	
	if(runicDiceChkBx.isSelected())
	{
	    
	}
	
	
    }
    
    
    
    
    
    
    
    
    

    @FXML public void loadDiceImage()
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
    
    @FXML private void clear() 
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


    public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
    }
    
}
