package application;
	
import java.io.IOException;


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
			
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("/Calendar/Calendar.fxml"));
			primaryStage.setTitle("Calendar");
			primaryStage.setScene(new Scene(root,1280,768));
			primaryStage.show();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			
		}

	}

}
