package application;

import java.io.File;
import java.util.prefs.Preferences;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GeneralSettingsController extends AnchorPane 
{
	
	@FXML private Button savingLocation;
	@FXML private Button SelectFileButton;
	
	///cant seem to set this in scene builder
	@FXML private ToggleGroup OnOffGroup;
	
	@FXML private TextField curDefaultFileLocation;
	
	@FXML private RadioButton OnRadioBtn;
	@FXML private RadioButton OffRadioBtn;
	
	
	Preferences userPref = Preferences.userRoot();
	Preferences sysPref = Preferences.systemRoot();
	
	
	public GeneralSettingsController()
	{
		System.out.println("ran");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GeneralSettings.fxml"));
		
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		

        try {
            fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML private void initialize()
	{
		curDefaultFileLocation.setText( userPref.get("File_Loc", "null"));
		curDefaultFileLocation.setEditable(false);
	}
	
	@FXML private void changeFileLocation()
	{
		FileChooser fc = new FileChooser();
		
		FileChooser.ExtensionFilter textFileFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)","*.txt");
		FileChooser.ExtensionFilter allFilesFilter = new FileChooser.ExtensionFilter("All Files ","*.*");
		
		fc.getExtensionFilters().add(textFileFilter);
		fc.getExtensionFilters().add(allFilesFilter);
		
		File selectedFile = fc.showOpenDialog(new Stage());
	
		userPref.put("File_Loc", selectedFile.getAbsolutePath());
		curDefaultFileLocation.setText(selectedFile.getAbsolutePath());
		
	}
	
}
