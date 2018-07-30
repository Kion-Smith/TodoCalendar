package application;

import java.time.YearMonth;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Controller 
{
	
	YearMonth curYearMonth = YearMonth.now();
	
	@FXML private VBox calanderVBox;
	@FXML private GridPane calanderPane;
	
	//Buttons
	@FXML private Button rightArrowBtn;
	@FXML private Button leftArrowBtn;
	@FXML private Button addBtn;
	@FXML private Button RemoveBtn;
	
	//Labels
	@FXML private Label curMonth;
	
	
	private BorderPane borderPaneList[] = new BorderPane[35];
	private Label dateLabelsList[] = new Label[35];
	//Text Area
	private TextArea InfoTextAreaList[] = new TextArea[35];
	
	
	@FXML private void initialize()
	{
		
		//Set Month to the current month
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
		
		//Adding labels and Text area to the boxes using borderPane
		//this is temporary 
		int count =1;
		
		for(int r=0;r<5;r++)
		{
			for(int c = 0;c<7;c++)
			{
				borderPaneList[r+c] = new BorderPane();
				dateLabelsList[r+c] = new Label(" L "+ count );
				InfoTextAreaList[r+c] = new TextArea();
				
				//Unsure about this ->  //InfoTextAreaList[r+c].setEditable(false);
				
				InfoTextAreaList[r+c].setMaxSize(110, 83);
				
				borderPaneList[r+c].setTop(dateLabelsList[r+c]);
				borderPaneList[r+c].setCenter(InfoTextAreaList[r+c]);
				calanderPane.add(borderPaneList[r+c],c,r);

				count++;
			}
		}
		
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