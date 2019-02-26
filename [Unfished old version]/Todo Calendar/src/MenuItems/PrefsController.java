package MenuItems;

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
	
	GeneralSettingsController gs;
	
	@FXML private void initialize()
	{
		gs = new GeneralSettingsController();
	}
	
	@FXML private void displayMenu()
	{
		switch(SettingsList.getSelectionModel().getSelectedIndex())
		{
			case 0:
				sP.getChildren().add(gs);
				break;
			default:
				break;	
		}
	}
	
	@FXML void resetingToDefault()
	{
		switch(SettingsList.getSelectionModel().getSelectedIndex())
		{
			case 0:
				gs.resetSettings();
				break;
			default:
				break;
		}
	}
	
	@FXML void applyChanges()
	{
		switch(SettingsList.getSelectionModel().getSelectedIndex())
		{
			case 0:
				gs.applySettings();
				break;
			default:
				break;
		}
	}
}
