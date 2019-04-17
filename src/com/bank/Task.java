package com.bank;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Task {
	
	private String taskName;
	private int taskId;
	private LocalDate startDate;
	private LocalDate endDate;
	private long daysDuration;
	private List<Integer> dependencies;
	public Task(int taskId, LocalDate startDate, LocalDate endDate, String taskName){
		this.taskId 	= taskId;
		this.startDate 	= startDate;
		this.endDate	= endDate;
		this.taskName	= taskName;
		
	}
	
	public Task(){		
	}
	
	public int getTaskId(){
		return taskId;
	}
	
	
	public String getTaskName(){
		return taskName;
	}
	
	public long getDaysDuration(){
		daysDuration = 	ChronoUnit.DAYS.between(startDate, endDate);
		return daysDuration;
	}
	
	public LocalDate getTaskStartDate(){
		return startDate;
	}
	
	public LocalDate getTaskEndDate(){
		return endDate;
	
	}
	
	public void checkDependencies(String taskName, Task [] t){
		try {
			int x = 0;
			int y = t.length;
			dependencies = new ArrayList <Integer>();
			
			for(x=0; x < (y-1); x++){
				dependencies.add(t[x].getTaskId());
			}
			//dependencies.remove( dependencies.size() - 1 );
		} catch (Exception ex){
			//do nothing
		}
		
		
	}
	
	@Override
	public String toString() {
		return getTaskId() 			+ "\t\t\t" +
			   getTaskStartDate() 	+ "\t\t" +
			   getTaskEndDate()		+ "\t\t\t" +
			   getDaysDuration()	+ "\t\t\t " +
			   getTaskName()		+ "\t\t" +
			   dependencies;
	}
	
}
