package datamodel;

import java.time.LocalDate;

public class TodoItem {
	
	private String shortDes;
	
	private String datails;
	
	private LocalDate deadline;

	
	public TodoItem(String shortDes, String datails, LocalDate deadline) {
		super();
		this.shortDes = shortDes;
		this.datails = datails;
		this.deadline = deadline;
	}
	

	public String getShortDes() {
		return shortDes;
	}

	public void setShortDes(String shortDes) {
		this.shortDes = shortDes;
	}

	public String getDatails() {
		return datails;
	}

	public void setDatails(String datails) {
		this.datails = datails;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	
	
	public String toString() {
		
		return shortDes;
		
		
	}
	
	

	public String getDeadlineString() {
		
		return "Deadline: "+ deadline.getYear() + "-" + deadline.getMonth() + "-" + deadline.getDayOfMonth();
		
	}
	

}
