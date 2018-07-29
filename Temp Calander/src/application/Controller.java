package application;

import java.time.YearMonth;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;


public class Controller 
{
	
	YearMonth curYearMonth = YearMonth.now();
	
	@FXML private VBox calanderVBox;
	
	//Buttons
	@FXML private Button rightArrowBtn;
	@FXML private Button leftArrowBtn;
	@FXML private Button addBtn;
	@FXML private Button RemoveBtn;
	
	//Labels
	@FXML private Label curMonth;
	@FXML private Label dateLabelsList[] = new Label[35];
	
	//Text Area
	@FXML private TextArea InfoTextAreaList[] = new TextArea[35];
	int temp =0;
	
	
	
	@FXML private void initialize()
	{
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
	}
	
	//test button methods
	
	@FXML private void nextMonth(ActionEvent e)
	{
		
		System.out.println("Next month pressed");
		curYearMonth = curYearMonth.plusMonths(1);
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
		
		
	}
	
	@FXML private void lastMonth(ActionEvent e)
	{
		
		System.out.println("Last month pressed");
		curYearMonth = curYearMonth.minusMonths(1);
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
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