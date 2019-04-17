package com.bank;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Project {
	private String projectName;	
	private LocalDate targetStartDate;
	private LocalDate targetEndDate;
	private Task task;
	
	public Project(String projectName, String targetStartDate){
		this.projectName = projectName;
		this.targetStartDate = LocalDate.parse(targetStartDate);
		
	}
	
	public String getProjectName(){
		return this.projectName;
	}
	
	public long getProjectLength(){
		long noOfDaysBetween = ChronoUnit.DAYS.between(this.targetStartDate, this.targetEndDate);
		return noOfDaysBetween;
	}
	
	public LocalDate getTargetStartDate(){
		return targetStartDate;
	}
	
	public LocalDate getTargetEndDate(long [] days){
		long daysToAdd = 0L;
		for (int x = 0; x < days.length; x++)
			daysToAdd +=days[x];
		
		this.targetEndDate = targetStartDate.plusDays(daysToAdd);
		return targetEndDate;
	}
	
	
}
