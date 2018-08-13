package MenuItems;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class GeneralSettings extends AnchorPane 
{
	public GeneralSettings()
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
}
