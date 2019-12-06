package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.swing.text.DateFormatter;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import datamodel.TodoItem;




public class EventController {

	@FXML
	private ListView<TodoItem> todoListView;
	
	@FXML
	private TextArea todoDetails;
	
	@FXML
	private Label deadlineField;
	
	
	private List<TodoItem> todoList;
	
	@FXML
	
	private BorderPane mainBorderPane;
	
	
	@FXML
	public void initialize() {
		
		deadlineField.setFont(Font.font(20));
		
	
		

		
		todoListView.getItems().setAll(TodoData.getInstance().getTodoItemsList());
		
		todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		todoListView.getSelectionModel().selectFirst();
		
		handleClickListView();
		
		
		
	}
	
	
	
	@FXML
	
	public void showNewItemDialog() {
		
		
		Dialog<ButtonType> dialog = new Dialog<>();
		
		dialog.initOwner(mainBorderPane.getScene().getWindow());
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("todoItemDialog.fxml"));
			
			dialog.getDialogPane().setContent(root);
			
		} catch (IOException e) {
			
			System.out.println(e);
			
			
		}
		
		dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
		
		dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
		
		Optional<ButtonType> result = dialog.showAndWait();
		
		if (result.isPresent() && result.get() == ButtonType.OK) {
			
			System.out.println("OK");
			
			
		} else {

			System.out.println("Cancel");
			
		}
		
		
	}
	
	
	
	
	
	@FXML
	public void handleClickListView() {
		
		TodoItem item = todoListView.getSelectionModel().getSelectedItem();
		
		todoDetails.setText(item.getDatails());
		
	
		DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		
		deadlineField.setText(df.format(item.getDeadline()));
		
		
		
	}
	
	
	
}
