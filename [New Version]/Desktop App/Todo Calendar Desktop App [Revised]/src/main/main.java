package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application 
{
	
	public  static void main(String args[])
	{
		launch(args);
	}
	
	@Override
	public void start(Stage s) throws Exception 
	{
		Parent root = FXMLLoader.load(getClass().getResource("../fxml Items/mainScreen.fxml"));
		
		s.setTitle("TODO Calendar by Kion Smith");
		s.setScene(new Scene(root,1280,720));
		s.show();
	}
	
	@Override 
	public void stop()
	{
		System.exit(0);
	}

}
