package Calendar;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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



public class CalendarController 
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

	private final int CURMONTH = LocalDate.now().getMonthValue();
	private final int CURDAY = LocalDate.now().getDayOfMonth();
	private final int CURYEAR = LocalDate.now().getYear();
	
	private int selectedDateIndex = -1;
	private int selectedDate = -1;
	
	FileData pastFileData;
	FileData curFileData;
	
	ArrayList<CalendarData> currentCalendar;
	ArrayList<CalendarData> pastCalendar;// only for loading data from a file
	
	Preferences userPref = Preferences.userRoot();
	
	
	// JAVA FX  functions
	@FXML private void initialize()
	{
		//add background task here
		
		currentCalendar =new ArrayList();
		pastCalendar=new ArrayList();
		
		loadData();
		
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
		try
		{
			
			int index = checkForDate(currentCalendar, selectedDate);
			if(index != -1)
			{
				currentCalendar.get(index).addToNotesList(sendInfoTextArea.getText());
			}
			else if(index == -1)
			{
				CalendarData tempData = new CalendarData(curYearMonth.getYear(), curYearMonth.getMonthValue(), selectedDate);
				currentCalendar.add(tempData);
				tempData.addToNotesList(sendInfoTextArea.getText());
			}
			
			updateNotesList();
			sendInfoTextArea.setText("");
			System.out.println(selectedDateIndex);
		}
		catch(Exception ex)
		{
			//
			ex.printStackTrace();
		}
		
		
	}
	

	@FXML private void deleteNote(ActionEvent e)
	{
		try
		{
			
			int index = checkForDate(currentCalendar,selectedDate);
			System.out.println("BEfore"+index);
			if(index != -1 )
			{
				
				currentCalendar.get(index).removeFromNotesList(notesList.getSelectionModel().getSelectedIndex());
				updateNotesList();
				
				if(currentCalendar.get(index).isNotesListEmpty())
				{
					currentCalendar.remove(index);
				}
			}
			

		}
		catch(Exception ex)
		{
			//this will throw a error if notes list is empty
			ex.printStackTrace();
		}
		
	}
	

	@FXML private void openFile()
	{
		saveCalendarData();
		FileChooser fc = new FileChooser();
		
		FileChooser.ExtensionFilter kscFileFilter = new FileChooser.ExtensionFilter("Kion Calendar Files (*.ksc)","*.ksc");
		FileChooser.ExtensionFilter textFileFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)","*.txt");
		FileChooser.ExtensionFilter allFilesFilter = new FileChooser.ExtensionFilter("All Files ","*.*");
		
		fc.getExtensionFilters().add(kscFileFilter);
		fc.getExtensionFilters().add(textFileFilter);
		fc.getExtensionFilters().add(allFilesFilter);
		
		try
		{
			File selectedFile = fc.showOpenDialog(new Stage());
			
			if(selectedFile.exists())
			{
				userPref.put("File_Loc", selectedFile.getAbsolutePath());
				loadData();
			}
		}
		catch(Exception e)
		{
			System.out.println("~~~ Error: File does not exist or was not selected");
		}
		
		
	}
	
	@FXML private void exitProgram()
	{
		//save items then exit (pop up window that asks this)
		System.exit(0);
	}
	

	
	@FXML private void openAboutWindow()
	{
		Parent root;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("/MenuItems/About.fxml"));
			Stage aboutStage = new Stage();
			aboutStage.setTitle("About the Calendar app");
			aboutStage.setScene(new Scene(root,600,400));
			aboutStage.show();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			
		}
	}
	
	@FXML private void openPrefsWindow()
	{
		Parent root;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("/MenuItems/Preferences.fxml"));
			Stage aboutStage = new Stage();
			aboutStage.setTitle("Preferences");
			aboutStage.setScene(new Scene(root,600,400));
			aboutStage.show();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			
		}
	}
	// END OF FX FUNCTIONS
	
	
	
	
	//FILE DATA
	//Loading data from file
	private void loadData()
	{
		//have some way to parse data from xml file here
		
		
		if(userPref.get("File_Loc", "null").equals("null"))
		{
			File calanderDataFile = new File("curCalendar.ksc");
			try {
				calanderDataFile.createNewFile();
				userPref.put("File_Loc", calanderDataFile.getAbsolutePath());
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			//read data
			
			System.out.println(userPref.get("File_Loc", "null"));
			File curFile = new File(userPref.get("File_Loc", "null"));
			FileData curFileData= new FileData(curFile);
			curFileData.initializeData();
			
			for(int i =0;i<curFileData.getFileDataListSize();i++)
			{
				currentCalendar.add(curFileData.getCalendarDataAt(i));
			}
			
			
		}
		
	}
	
	//Used for getting mouse event for calendar dates and populating dates
	private void curCell(int col, int row)
	{
		
		Pane pane = new Pane();
	    pane.setOnMouseClicked(e ->  { 
	    	
	    	if(!dateLabelsList[row*7+col].getText().equals("") )
	    		setSelectedDate(col,row); 
	    });
	    
	   calendarPane.add(pane, col, row);
	   	
    }
	
	//Setting all the calendar dates( from file or from past data)
	private void setCalanderDates()
	{
		//in here load data from file
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
					InfoTextAreaList[curLoc].setId("cal");
					
					if(count == CURDAY && CURMONTH == curYearMonth.getMonthValue() && CURYEAR == curYearMonth.getYear())
					{
						borderPaneList[curLoc].setStyle("-fx-background-color: #6d6d6d");
						InfoTextAreaList[curLoc].setId("cur");
						

					}
					
					int index = checkForDate(currentCalendar,count-1);
					
					if(index != -1)
					{
						InfoTextAreaList[curLoc].setText("");
						for(int i =0;i<currentCalendar.get(index).Notes.size();i++)
						{
							InfoTextAreaList[curLoc].appendText("-"+currentCalendar.get(index).Notes.get(i)+"\n");
						}
					}
					

					
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
	
	//Check to see if current date equals the calendar date
	private int checkForDate(ArrayList<CalendarData> list, int date)
	{
		if(!list.isEmpty())
		{
			for(int i =0;i<currentCalendar.size();i++)
			{
				if(currentCalendar.get(i).isIdenticalDate(curYearMonth.getYear(), curYearMonth.getMonthValue(), date))
				{
					return i;
				}
			}
			
		}
		
		return -1;
	}
	
	//CALENDAR INTERACTION
	//Selecting date
	private void setSelectedDate(int col, int row)
	{
		if(selectedDateIndex != -1)
		{
			if(CURDAY-1 == selectedDate && CURMONTH == curYearMonth.getMonthValue() && CURYEAR == curYearMonth.getYear())
			{
				borderPaneList[selectedDateIndex].setStyle("-fx-background-color: #6d6d6d;");
				InfoTextAreaList[selectedDateIndex].setId("cur");
				
			}
			else
			{
				borderPaneList[selectedDateIndex].setStyle("-fx-background-color: none;");
				InfoTextAreaList[selectedDateIndex].setId("cal");
			}
		}

		notesList.getItems().clear();
		int oldSelectedIndex = selectedDateIndex;
		selectedDateIndex = row*7+col;
		
		try
		{
			selectedDate =Integer.parseInt(dateLabelsList[selectedDateIndex].getText().substring(1,dateLabelsList[selectedDateIndex].getText().length())) -1;
			//cause of error
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
	

	//unselect current day
	private void unSelectDate()
	{
		
		if(selectedDateIndex>-1)
		{
			
			if(CURDAY-1 == selectedDate && CURMONTH == curYearMonth.getMonthValue() && CURYEAR == curYearMonth.getYear())
			{
				borderPaneList[selectedDateIndex].setStyle("-fx-background-color: #6d6d6d;");
				InfoTextAreaList[selectedDateIndex].setId("cur");
			}
			else
			{
				borderPaneList[selectedDateIndex].setStyle("-fx-background-color: none;");
				InfoTextAreaList[selectedDateIndex].setId("cal");
				selectedDateIndex = -1;
			}
		}

	}
	
	
	
	//Bug fixed but not very effcient, want appened instead of constantly deleting
	private void updateNotesList()
	{
		int index = checkForDate(currentCalendar,selectedDate);
		if(index != -1)
		{
			notesList.getItems().clear();
			InfoTextAreaList[selectedDateIndex].setText("");
			for(int i =0; i<currentCalendar.get(index).Notes.size();i++)
			{
				notesList.getItems().add(currentCalendar.get(index).Notes.get(i));
				InfoTextAreaList[selectedDateIndex].appendText("-"+currentCalendar.get(index).Notes.get(i)+"\n" );
			}
		}
		
		
	
	}
	
	
	public void saveCalendarData()
	{
		System.out.println(currentCalendar.toString());
		chronoOrder(currentCalendar);
		System.out.println(chronoOrder(currentCalendar).toString());
		//also add for the previous dates calendar
	}
	
	//implmentation of mergesort !!!(does not work currently)
	public ArrayList<CalendarData> chronoOrder(ArrayList<CalendarData> obj)
	{
		//neeed to look at what stort alg would be best
		ArrayList<CalendarData> firstHalf = new ArrayList<CalendarData>();
		ArrayList<CalendarData> secondHalf = new ArrayList<CalendarData>();
		int mid = obj.size()/2;
		
		if(obj.size()>1)
		{
			
			for(int i=0;i<mid;i++)
			{
				firstHalf.add(obj.get(i));
			}
			
			for(int i=mid;i<obj.size();i++)
			{
				secondHalf.add(obj.get(i));
			}
			
			merge(firstHalf,secondHalf,obj);
			
			
		}
		
		return obj;
	}
	
	public void merge(ArrayList<CalendarData> list1,ArrayList<CalendarData> list2,ArrayList<CalendarData> og)
	{
		int indexList1 =0;
		int indexList2 =0;
		int indexOG=0;
		
		while(indexList1<list1.size() && indexList2 < list2.size())
		{
			if(list1.get(indexList1).getDateCombined() < list2.get(indexList2).getDateCombined())
			{
				og.set(indexOG, list1.get(indexList1));
				indexList1++;
			}
			else
			{
				og.set(indexOG, list2.get(indexList2));
				indexList2++;
			}
			indexOG++;	
		}
		
		ArrayList<CalendarData> temp = null;
		int tempIndex;
		
		if(indexList1 >= list1.size())
		{
			System.out.println("ZZ"+temp.toString());
			temp = list2;
			tempIndex = indexList2;
			System.out.println("xx"+temp.toString());
		}
		else
		{
			temp = list1;
			tempIndex = indexList1;
		}
		
		
		for(int i=tempIndex;i<temp.size();i++)
		{
			og.set(indexOG, temp.get(i));
			indexOG++;
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