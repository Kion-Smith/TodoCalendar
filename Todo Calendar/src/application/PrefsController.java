package application;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PrefsController
{
	@FXML BorderPane SettingsPane;
	@FXML Pane sP;
	
	@FXML Button applyChangesBtn;
	@FXML Button resetDefaultBtn;
	
	
	@FXML private ListView<String> SettingsList;
	

	
	@FXML private void initialize()
	{
	
	}
	@FXML private void displayMenu()
	{
		switch(SettingsList.getSelectionModel().getSelectedIndex())
		{
			case 0:
				GeneralSettingsController gs = new  GeneralSettingsController();
				sP.getChildren().add(gs);
				break;
			default:
				break;	
		}
		
		/*
		if(SettingsList.getSelectionModel().getSelectedIndex() ==0)
		{
			GeneralSettingsController gs = new  GeneralSettingsController();
			sP.getChildren().add(gs);
			
			
		}*/
		
		
	}
}
