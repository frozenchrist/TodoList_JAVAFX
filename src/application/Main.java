package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		
		
		
		
		try {
			
			BorderPane root = new BorderPane();
			
			root = FXMLLoader.load(getClass().getResource("MainWindowUI.fxml"));
			
			Scene scene = new Scene(root,800,600);
			
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setTitle("Todo List");
			
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	
	
	@Override
	public void stop() throws Exception {
		

		
		try {
			
			TodoData.getInstance().storeTodoItems();
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			
			System.out.println(e);
		};
		
		
	}
	
	
	@Override
	public void init() throws Exception {

		try {
			
			TodoData.getInstance().loadTodoItems();
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		
		
		
	}
	
}
