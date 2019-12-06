package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import datamodel.TodoItem;
import javafx.collections.FXCollections;

public class TodoData {

	private static TodoData instance = new TodoData();
	
	private static String filename = "TodolistItems.txt";
	
	private List<TodoItem> todoItemsList;
	
	private DateTimeFormatter df;
	
	
	
	public static TodoData getInstance() {
		
		return instance;
		
	}
	
	
	
	private TodoData () {
		
		
		df = DateTimeFormatter.ofPattern("yyyy-MM-d");
		
		
	}

	
	

	public List<TodoItem> getTodoItemsList() {
		return todoItemsList;
	}

	
	

	public void setTodoItemsList(List<TodoItem> todoItemsList) {
		this.todoItemsList = todoItemsList;
	}
	
	
	
	
	public void loadTodoItems() throws IOException{

		todoItemsList = FXCollections.observableArrayList();
		
	
		Path path = Paths.get(filename);
		
		BufferedReader br = Files.newBufferedReader(path);
	
		String input;
		
		try {
			
			while((input = br.readLine()) != null) {
				
				String[] itemPieces = input.split("\t");
				
				String shortDes = itemPieces[0];
				
				String details = itemPieces[1];
				
				String deadline = itemPieces[2];
				
				CharSequence text;
				
				LocalDate date = LocalDate.parse(deadline, df);
				
				TodoItem todoItem = new TodoItem(shortDes, details, date);
				
				todoItemsList.add(todoItem);
				
			}
			
		} finally {
			
			if(br != null) {
				
				br.close();
				
			}
			
		}

	
	}
	
	
	public void storeTodoItems() throws IOException{
		
		Path path = Paths.get(filename);
		
		BufferedWriter bw = Files.newBufferedWriter(path);

		try {
			
			Iterator<TodoItem> iter = todoItemsList.iterator();
			while(iter.hasNext()) {
				
				TodoItem item = iter.next();
				
				bw.write(String.format("%s\t%s\t%s", item.getShortDes(), item.getDatails(),item.getDeadline()));
				
				bw.newLine();
			}
			
		} finally {

			if(bw != null) {
				
				bw.close();
				
			}
			}
			
		}
	
	
	
}
