package MenuItems;

import java.io.File;
import java.io.IOException;
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
	
	@FXML private TextField curDefaultFileLocation;
	
	@FXML private RadioButton OnRadioBtn;
	@FXML private RadioButton OffRadioBtn;
	
	private File selectedFile;

	Preferences userPref = Preferences.userRoot();
	
	public GeneralSettingsController()
	{
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
		
		if(userPref.get("radioBtnState", "on").equals("on") )
		{
			OnRadioBtn.setSelected(true);
		}
		else if(userPref.get("radioBtnState", "off").equals("off") )
		{
			OffRadioBtn.setSelected(true);
		}
		
	}
	
	@FXML private void changeFileLocation()
	{
		FileChooser fc = new FileChooser();
		
		FileChooser.ExtensionFilter textFileFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)","*.txt");
		FileChooser.ExtensionFilter allFilesFilter = new FileChooser.ExtensionFilter("All Files ","*.*");
		
		fc.getExtensionFilters().add(textFileFilter);
		fc.getExtensionFilters().add(allFilesFilter);
		
		selectedFile = fc.showOpenDialog(new Stage());
		curDefaultFileLocation.setText(selectedFile.getAbsolutePath());
		
	}

	/*
	@FXML private void settingOn()
	{
		OnButtonState = true;
		OffButtonState = false;
	}
	
	@FXML private void settingOff()
	{
		OffButtonState = true;
		OnButtonState = false;
	}
	*/
	

	public void resetSettings()
	{
		userPref.remove("File_Loc");
		File calanderDataFile = new File("CalanderInfo.txt");
		try {
			calanderDataFile.createNewFile();
			userPref.put("File_Loc", calanderDataFile.getAbsolutePath());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		curDefaultFileLocation.setText(calanderDataFile.getAbsolutePath());
		
		OnRadioBtn.setSelected(true);
		userPref.put("radioBtnState", "on");
	}
	
	public void applySettings()
	{
		if(OnRadioBtn.isSelected())
		{
			userPref.put("radioBtnState", "on");
		}
		else if(OffRadioBtn.isSelected())
		{
			userPref.put("radioBtnState","off");
		}

		
		try
		{
			userPref.put("File_Loc", selectedFile.getAbsolutePath());
			curDefaultFileLocation.setText(selectedFile.getAbsolutePath());
		}
		catch(Exception e)
		{
			userPref.put("File_Loc", curDefaultFileLocation.getText());
		}
	
	
				
	}
	
}
