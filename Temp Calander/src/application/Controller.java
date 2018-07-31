package application;

import java.time.LocalDate;
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
	
	
	private BorderPane borderPaneList[] = new BorderPane[42];
	private Label dateLabelsList[] = new Label[42];
	//Text Area
	private TextArea InfoTextAreaList[] = new TextArea[42];
	
	
	@FXML private void initialize()
	{
		
		//Set Month to the current month
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
		
		//Adding labels and Text area to the boxes using borderPane
		for(int r=0;r<6;r++)
		{
			for(int c = 0;c<7;c++)
			{
				int curLoc = r*7+c;
				
				
				borderPaneList[curLoc] = new BorderPane();
				dateLabelsList[curLoc] = new Label("");
				InfoTextAreaList[curLoc] = new TextArea();
				
				//Unsure about this ->  //InfoTextAreaList[r+c].setEditable(false);
				
				InfoTextAreaList[r*7+c].setMaxSize(110, 83);			
				borderPaneList[r*7+c].setTop(dateLabelsList[curLoc]);
				borderPaneList[r*7+c].setCenter(InfoTextAreaList[curLoc]);
				calanderPane.add(borderPaneList[curLoc],c,r);
				
			}
		}
		
		
		setCalanderDates();
	}
	
	//test button methods
	
	private void setCalanderDates()
	{
		LocalDate startDate = LocalDate.of(curYearMonth.getYear(),curYearMonth.getMonth(),1);
		
		int start = DayStringToNums(startDate.getDayOfWeek().toString());
		int end=startDate.withDayOfMonth(startDate.lengthOfMonth()).getDayOfMonth();
		
		int count = 1;
		for(int r=0;r<6;r++)
		{
			for(int c = 0;c<7;c++)
			{	
				int curLoc = r*7+c;
				
				if(curLoc >= start && count <= end)
				{
					dateLabelsList[curLoc].setText(" "+ (count) );
					InfoTextAreaList[curLoc].setText("");
					count++;
				}
				else
				{
					dateLabelsList[curLoc].setText("");
					InfoTextAreaList[curLoc].setText("");
				}
				
				
			}
		}
	}
	
	private int DayStringToNums(String day)
	{
		int numvalue = -1;
		
		switch(day)
		{
			case "SUNDAY":
				numvalue = 0;
				break;
			case "MONDAY":
				numvalue = 1;
				break;
			case "TUESDAY":
				numvalue = 2;
				break;
			case "WEDNESDAY":
				numvalue = 3;
				break;
			case "THURSDAY":
				numvalue = 4;
				break;
			case "FRIDAY":
				numvalue = 5;
				break;
			case "SATURDAY":
				numvalue = 6;
				break;
		}
		return numvalue;
	}
	
	@FXML private void nextMonth(ActionEvent e)
	{
		
		System.out.println("Next month pressed");
		curYearMonth = curYearMonth.plusMonths(1);
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
		
		setCalanderDates();
	}
	
	@FXML private void lastMonth(ActionEvent e)
	{
		
		System.out.println("Last month pressed");
		curYearMonth = curYearMonth.minusMonths(1);
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
		
		setCalanderDates();
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