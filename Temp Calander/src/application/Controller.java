package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;


public class Controller 
{
	@FXML private VBox calanderVBox;
	
	//Buttons
	@FXML private Button rightArrowBtn;
	@FXML private Button leftArrowBtn;
	@FXML private Button addBtn;
	@FXML private Button RemoveBtn;
	
	//test button methods
	@FXML private void nextMonth(ActionEvent e)
	{
		System.out.println("Next month pressed");
	}
	@FXML private void lastMonth(ActionEvent e)
	{
		System.out.println("Last month pressed");
	}
	@FXML private void assignNote(ActionEvent e)
	{
		System.out.println("Sent note");
	}
	@FXML private void deleteNote(ActionEvent e)
	{
		System.out.println("Clear Note");
	}
	    
 
}