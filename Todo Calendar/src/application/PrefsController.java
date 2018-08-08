package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
		
		if(SettingsList.getSelectionModel().getSelectedIndex() ==0)
		{
			GeneralSettings gs = new  GeneralSettings();
			sP.getChildren().add(gs);
			
			//SettingsPane.setCenter(gs);
			//SettingsPane;
			
		}
		
		
		//System.out.println(SettingsList.getSelectionModel().getSelectedIndex());
		
	}
}
