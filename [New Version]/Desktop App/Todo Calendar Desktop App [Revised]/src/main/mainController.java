package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;

public class mainController 
{

    @FXML
    private MenuBar menuBar;

    @FXML
    private GridPane calendarGrid;

    @FXML
    private Label monthYearLabel;

    @FXML
    private Button leftArrowButton;

    @FXML
    private Button rightArrowButton;
    
    /*
    @FXML
    void handleButtonClick(ActionEvent event) 
    {
    	System.out.println("ERA");
    }*/

}