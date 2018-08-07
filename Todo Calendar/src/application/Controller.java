package application;

import java.io.File;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class Controller 
{
	/* +++General Notes++++++++++++++
	*   - Might want to populate the dates before and after cur month
	*	
	*/
	
	
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
	@FXML private TextArea sendInfoTextArea;
	private TextArea InfoTextAreaList[] = new TextArea[42];
	
	@FXML private ListView<String> notesList;
	
	YearMonth curYearMonth = YearMonth.now();
	Notes monthNotes[] = new Notes[31];

	
	private int selectedDateIndex = -1;
	private int selectedDate = -1;
	
	
	@FXML private void initialize()
	{
		
		//Set Month to the current month
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
		
		
		for(int i =0;i<31;i++)
		{
			monthNotes[i] = new Notes();
		}
		
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
		
		clearMonthNotes();
		
		
	}
	
	@FXML private void lastMonth(ActionEvent e)
	{
		curYearMonth = curYearMonth.minusMonths(1);
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
		unSelectDate();
		setCalanderDates();
		
		clearMonthNotes();
	}
	
	@FXML private void assignNote(ActionEvent e)
	{
		try
		{
			monthNotes[selectedDate].addNotes(sendInfoTextArea.getText() );
			updateNotesList();
			sendInfoTextArea.setText("");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}
	

	@FXML private void deleteNote(ActionEvent e)
	{
		try
		{
			System.out.println(notesList.getSelectionModel().getSelectedIndex());
			monthNotes[selectedDate].removeNotes(notesList.getSelectionModel().getSelectedIndex());
			InfoTextAreaList[selectedDateIndex].setText("");
			notesList.getItems().clear();
			updateNotesList();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	@FXML private void openFile()
	{
		System.out.println("Opened");
		FileChooser fc = new FileChooser();
		
		FileChooser.ExtensionFilter textFileFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)","*.txt");
		FileChooser.ExtensionFilter allFilesFilter = new FileChooser.ExtensionFilter("All Files ","*.*");
		
		fc.getExtensionFilters().add(textFileFilter);
		fc.getExtensionFilters().add(allFilesFilter);
		
		File selectedFile = fc.showOpenDialog(new Stage());
	}
	
	@FXML private void exitProgram()
	{
		//save items then exit
		System.exit(0);
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
	
	private void clearMonthNotes()
	{
		try
		{
			for(int i=0;i<31;i++)
			{
				monthNotes[i].clearNotes();
			}
			
			notesList.getItems().clear();
		}
		catch(Exception e)
		{
			
		}
	}
	
	//might want to rename this
	private void setSelectedDate(int col, int row)
	{
		if(selectedDateIndex != -1)
		{
			
			borderPaneList[selectedDateIndex].setStyle("-fx-background-color: none;");
			InfoTextAreaList[selectedDateIndex].setId("cal");
		}

		notesList.getItems().clear();
		int oldSelectedIndex = selectedDateIndex;
		selectedDateIndex = row*7+col;
		
		try
		{
			selectedDate =Integer.parseInt(dateLabelsList[selectedDateIndex].getText().substring(1,dateLabelsList[selectedDateIndex].getText().length())) -1;
			updateNotesList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			selectedDate = -1;
		}
		
		if(oldSelectedIndex == row*7+col)
		{
			unSelectDate();
		}
		else
		{
			borderPaneList[selectedDateIndex].setStyle("-fx-background-color: #898989;");
			InfoTextAreaList[selectedDateIndex].setId("sel");
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
	
	//Bug fixed but not very effcient, want appened instead of constantly deleting
	private void updateNotesList()
	{
		if(!(monthNotes[selectedDate].subNoteIsEmpty()))
		{
			
			InfoTextAreaList[selectedDateIndex].setText("");
			notesList.getItems().clear();
			
			for(int i =0; i<monthNotes[selectedDate].lengthOfNotes();i++)
			{
				notesList.getItems().add(monthNotes[selectedDate].getSubNoteAt(i));
				InfoTextAreaList[selectedDateIndex].appendText( monthNotes[selectedDate].getSubNoteAt(i)+"\n" );
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


 
}