package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class MainSceneController {

	String namear[] = new String[9];
	int studentStrength = 0;
	String colorar[] = new String[9];
	
	@FXML
	private Label msg;
	
	@FXML
	private ArrayList<Label> labellist;
	
	@FXML
	private ArrayList<Rectangle> reclist;
	
	@FXML
	private TextField sname;
	
	@FXML
	private ComboBox cmb;
	
	@FXML
	public void btnOKClicked(ActionEvent event) {
		msg.setText("");
		boolean flag = true;
		Random rdm = new Random();
		if(studentStrength == 9) {
			msg.setText("Error!! Seats are Full");
		}
		
		if(sname.getText() == null || sname.getText().isBlank()) {
			msg.setText("Enter Valid Name!!");
			msg.setTextFill(Color.valueOf("Red"));
			return;
		}
		while(flag && studentStrength != 9) {
			int temp = rdm.nextInt(9);
			if(namear[temp] == null) {
				
				String chosenclr = (String) cmb.getValue();
				boolean colormatch = false;
				for(String i:colorar) {
					if(i==chosenclr) {
						colormatch=true;
						msg.setTextFill(Color.valueOf("Red"));
						msg.setText("Color is Already Chosen");
					}
				}
				if(colormatch) break;
				
				colorar[temp] = chosenclr;
				reclist.get(temp).setFill(Color.valueOf(chosenclr));
				namear[temp] = sname.getText();
				labellist.get(temp).setText(sname.getText());
				studentStrength++;
				flag = false;
			}
		}
		
		
	}
}
