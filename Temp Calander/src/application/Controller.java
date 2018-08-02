package application;

import java.time.LocalDate;
import java.time.YearMonth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
	
	private BorderPane borderPaneList[] = new BorderPane[42];
	
	//Labels
	@FXML private Label curMonth;
	private Label dateLabelsList[] = new Label[42];
	
	//Text Area
	private TextArea InfoTextAreaList[] = new TextArea[42];
	
	@FXML private ListView<String> notesList;
	
	@FXML private TextArea sendInfoTextArea;
	
	private Group calanderTextAreas = new Group();
	
	private int selectedDate = -1;
	
	
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
				
				//InfoTextAreaList[curLoc].setEditable(false);
				
				InfoTextAreaList[curLoc].setMaxSize(110, 83);	
				
				InfoTextAreaList[curLoc].setText("a");
				borderPaneList[curLoc].setTop(dateLabelsList[curLoc]);
				borderPaneList[curLoc].setCenter(InfoTextAreaList[curLoc]);
				
			//causes program to not work idk why	//calanderTextAreas.getChildren().add(InfoTextAreaList[curLoc]);
				
				calanderPane.add(borderPaneList[curLoc],c,r);
				
				curCell(c,r);
				
			}
		}
		
		
		setCalanderDates();
	}
	
	//Still unsure about this method
	private void curCell(int col, int row)
	{
        Pane pane = new Pane();
        pane.setOnMouseClicked(e -> { setSelectedDate(col,row);
            
        });
       calanderPane.add(pane, col, row);
    }
	
	private void setSelectedDate(int col, int row)
	{
		selectedDate = row*7+col;
		System.out.println(selectedDate);
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
		curYearMonth = curYearMonth.plusMonths(1);
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
		
		setCalanderDates();
	}
	
	@FXML private void lastMonth(ActionEvent e)
	{
		curYearMonth = curYearMonth.minusMonths(1);
		curMonth.setText(curYearMonth.getMonth().toString()+" "+curYearMonth.getYear());
		
		setCalanderDates();
	}
	
	@FXML private void assignNote(ActionEvent e)
	{
		notesList.getItems().add(sendInfoTextArea.getText() );
		
		System.out.println(selectedDate);
		if(selectedDate != -1)
		{
			System.out.println(InfoTextAreaList[selectedDate].getText()+"ran");
			InfoTextAreaList[selectedDate].setText(sendInfoTextArea.getText());
		}
		
		sendInfoTextArea.setText("");
	}
	
	@FXML private void deleteNote(ActionEvent e)
	{
		notesList.getItems().remove(notesList.getSelectionModel().getSelectedItem());
	}
 
}