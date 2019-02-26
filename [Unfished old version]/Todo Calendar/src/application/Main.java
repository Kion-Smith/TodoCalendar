package application;
	
import java.io.IOException;
import java.util.Timer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application 
{

	public static void main(String[] args) 
	{
		
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
			
		bgTimer bgtime = new bgTimer();
		Timer t = new Timer();
		
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("/Calendar/Calendar.fxml"));
			primaryStage.setTitle("Calendar");
			primaryStage.setScene(new Scene(root,1280,768));
			primaryStage.show();
			
			//save file every 5 minutes (might change this to be a user defined time)
			// also need to check the prefrences file to see if auto save is wanted
			
			t.scheduleAtFixedRate(bgtime, 0,(60*5)*1000);
		
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			
		}
		
	

	}
	
	@Override 
	public void stop()
	{
		System.exit(0);
	}
	


}
