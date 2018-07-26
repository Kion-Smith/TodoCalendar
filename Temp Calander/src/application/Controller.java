package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller 
{
	@FXML
	private TableView<Day> calander;
	
	@FXML
	private TableColumn<Day,Integer> sunday;
	
	@FXML
	private TableColumn<Day,Integer> monday;
	
	@FXML
	private TableColumn<Day,Integer> tuesday;
	
	@FXML
	private TableColumn<Day,Integer> wensday;
	
	@FXML
	private TableColumn<Day,Integer> thursday;
	
	@FXML
	private TableColumn<Day,Integer> friday;
	
	@FXML
	private TableColumn<Day,Integer> saturday;
	
	 public Controller() 
	 {
	    	
	 }
	    
 
}