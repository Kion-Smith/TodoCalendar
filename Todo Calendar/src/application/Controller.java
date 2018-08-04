package application;

import java.time.LocalDate;
import java.time.YearMonth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;



public class Controller 
{
	
	YearMonth curYearMonth = YearMonth.now();
	
	
	@FXML private VBox calendarVBox;
	@FXML private GridPane calendarPane;
	
	//Buttons
	@FXML private Button rightArrowBtn;
	@FXML private Button leftArrowBtn;
	@FXML private Button addBtn;
	@FXML private Button RemoveBtn;
	
	private BorderPane borderPaneList[] = new BorderPane[42];
	
	//Labels
	@FXML private Label curMonth;
	private Label dateLabelsList[] = new Label[42];
	
	//Text Area
	private TextArea InfoTextAreaList[] = new TextArea[42];
	
	@FXML private ListView<String> notesList;
	
	@FXML private TextArea sendInfoTextArea;

	
	private int selectedDateIndex = -1;
	
	
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
				InfoTextAreaList[curLoc] = new TextArea("");
				
				InfoTextAreaList[curLoc].setEditable(false);
				
				InfoTextAreaList[curLoc].setMaxSize(110, 83);	
				InfoTextAreaList[curLoc].setId("cal");
				borderPaneList[curLoc].setTop(dateLabelsList[curLoc]);
				borderPaneList[curLoc].setCenter(InfoTextAreaList[curLoc]);
				
				
				calendarPane.add(borderPaneList[curLoc],c,r);
				
				curCell(c,r);
				
			}
		}
		
		setCalanderDates();
	}
	@FXML private void nextMonth(ActionEvent e)
	{
		curYearMonth = curYearMonth.plusMonths(1);
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
		unSelectDate();
		setCalanderDates();
		
	}
	
	@FXML private void lastMonth(ActionEvent e)
	{
		curYearMonth = curYearMonth.minusMonths(1);
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
		unSelectDate();
		setCalanderDates();
		
	}
	
	@FXML private void assignNote(ActionEvent e)
	{
		notesList.getItems().add(sendInfoTextArea.getText() );
		
		System.out.println(selectedDateIndex);
		if(selectedDateIndex != -1)
		{
			InfoTextAreaList[selectedDateIndex].setText(sendInfoTextArea.getText());
		}
		
		sendInfoTextArea.setText("");
	}
	
	@FXML private void deleteNote(ActionEvent e)
	{
		notesList.getItems().remove(notesList.getSelectionModel().getSelectedItem());
	}
	
	
	private void curCell(int col, int row)
	{
		
		Pane pane = new Pane();
	    pane.setOnMouseClicked(e ->  { 
	    	
	    	if(!dateLabelsList[row*7+col].getText().equals("") )
	    		setSelectedDate(col,row); 
	    });
	    
	   calendarPane.add(pane, col, row);
	   
		
    }
	
	//might want to rename this
	private void setSelectedDate(int col, int row)
	{
		if(selectedDateIndex != -1)
		{
			borderPaneList[selectedDateIndex].setStyle("-fx-background-color: none;");
			InfoTextAreaList[selectedDateIndex].setId("cal");
		}
		
		selectedDateIndex = row*7+col;
		borderPaneList[selectedDateIndex].setStyle("-fx-background-color: #898989;");
		InfoTextAreaList[selectedDateIndex].setId("sel");
		
		if(!InfoTextAreaList[selectedDateIndex].getText().equals(""))
		{
			populateNotesList();
		}
	}
	
	//want to name this somthing better
	private void unSelectDate()
	{

		if(selectedDateIndex>-1)
		{
			borderPaneList[selectedDateIndex].setStyle("-fx-background-color: none;");
			InfoTextAreaList[selectedDateIndex].setId("cal");
			selectedDateIndex = -1;
		}

	}
	
	
	
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
					borderPaneList[curLoc].setStyle("-fx-background-color: none");
					dateLabelsList[curLoc].setText(" "+ (count) );
					InfoTextAreaList[curLoc].setText("");
					
					count++;
				}
				else
				{
					dateLabelsList[curLoc].setText("");
					InfoTextAreaList[curLoc].setText("");
					borderPaneList[curLoc].setStyle("-fx-background-color: #F3F3F3");
					
					
				}
				
				
			}
		}
		
	}
	//Need to think of a way to populate existing notes
	private void populateNotesList()
	{
		
	
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


 
}