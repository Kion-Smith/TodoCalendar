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
				int curLoc = r*7+c;
				borderPaneList[curLoc] = new BorderPane();
				dateLabelsList[curLoc] = new Label(" L "+ count );
				InfoTextAreaList[curLoc] = new TextArea();
				
				//Unsure about this ->  //InfoTextAreaList[r+c].setEditable(false);
				
				InfoTextAreaList[r*7+c].setMaxSize(110, 83);			
				borderPaneList[r*7+c].setTop(dateLabelsList[curLoc]);
				borderPaneList[r*7+c].setCenter(InfoTextAreaList[curLoc]);
				calanderPane.add(borderPaneList[curLoc],c,r);

				count++;
			}
		}
		
		
		setCalanderDates();
	}
	
	//test button methods
	
	@FXML private void setCalanderDates()
	{
		LocalDate startDate = LocalDate.of(curYearMonth.getYear(),curYearMonth.getMonth(),1);
		LocalDate endDate = LocalDate.of(curYearMonth.getYear(),curYearMonth.getMonth(), startDate.withDayOfMonth(startDate.lengthOfMonth()).getDayOfMonth() );
		/*
	     while (!curDay.getDayOfWeek().toString().equals("SUNDAY") ) {
	    	 curDay = curDay.minusDays(1);
	        }
		*/
		System.out.println("START :"+startDate+" AKA: "+startDate.getDayOfWeek().toString());
		System.out.println("END :"+endDate+" AKA: "+endDate.getDayOfWeek().toString());
		
		
		for(int r=0;r<5;r++)
		{
			for(int c = 0;c<7;c++)
			{	
				int curLoc = r*7+c;
				//dateLabelsList[curLoc].setText("MEME");

				
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