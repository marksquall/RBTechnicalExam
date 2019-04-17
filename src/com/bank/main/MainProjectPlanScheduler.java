package com.bank.main;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.bank.Project;
import com.bank.Task;

import java.io.BufferedReader;
import java.io.IOException;


public class MainProjectPlanScheduler {
	
	private static String projectName;
	private static String targetStartDate;
	//private static String targetEndDate;
	private static Project proj;
	
	private static List<Integer> ids = new ArrayList<>();
	

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Enter project Name: ");
		projectName = br.readLine();
		System.out.print("Enter project target start date (YYYY-MM-DD): ");
		targetStartDate = br.readLine();
		//System.out.print("Enter project target end date (YYYY-MM-DD): ");
		//targetEndDate = br.readLine();
		
		generateTaskID();
		//System.out.println(getGeneratedID(ids, 9));
		displayResultProjectPlan();
	}
	
	public static void displayResultProjectPlan(){
		String [] taskName = {"Project Initiation", "Analysis & Requirements", "Prepare & Test Scripts", "Design", "Infra Setup", "Programming", "Integration and Testing", "Users Training & Testing", "Product Deployment"};
		
		long [] daysDuration = { ThreadLocalRandom.current().nextInt(5, 11), 
								 ThreadLocalRandom.current().nextInt(10, 16), 
								 ThreadLocalRandom.current().nextInt(5, 11), 
								 ThreadLocalRandom.current().nextInt(10, 16), 
								 ThreadLocalRandom.current().nextInt(4, 11), 
								 ThreadLocalRandom.current().nextInt(30, 61), 
								 ThreadLocalRandom.current().nextInt(8, 11), 
								 ThreadLocalRandom.current().nextInt(6, 11), 
								 ThreadLocalRandom.current().nextInt(3, 6) };
		List<Integer> newID = new ArrayList<>(); 
		Task [] task;
		task = new Task [taskName.length];	
		
		proj = new Project(projectName, targetStartDate);		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, YYYY");
	    System.out.println("\n------------------------------------------------------------------");
	    System.out.println("# Project plan for 		: " 	+ proj.getProjectName());
		System.out.println("# Target Start Date		: " 	+ formatter.format(proj.getTargetStartDate()));
		System.out.println("# Target Completion Date	: " + formatter.format(proj.getTargetEndDate(daysDuration)));
		System.out.println("\n");
		System.out.println("# Project Tasks");
		System.out.println("Task-ID \t\t Start-Date \t\t End-Date \t\t Duration(Days) \t\t Task \t\t\t    Dependencies (Task-ID) ");
		System.out.println("------- \t\t ---------- \t\t -------- \t\t -------------- \t\t -------------------------- ---------------------- ");
		newID = getGeneratedID(ids, 9);
		LocalDate sd = LocalDate.parse(targetStartDate);
				
		LocalDate ed;
		
		for (int x= 0; x < taskName.length; x++) {
			ed = sd.plusDays(daysDuration[x]);
			task[x] = new Task (newID.get(x),
								sd,
								ed,
								taskName[x]);
			task[x].checkDependencies(task[x].getTaskName(), task);
			System.out.println(task[x]);
			sd = ed;
		}
		
		
		
		/*
		do {
			daysDuration = rand.nextInt((maxDurationDays - minDurationDays) + 1) + minDurationDays;
			if (daysRemaining >= daysDuration) daysRemaining -= daysDuration;
			else {
				daysDuration = (int)daysRemaining;
				daysRemaining -= daysDuration;
			}
			//else daysRemaining = 0;
			System.out.println("Duration: " + daysDuration +", days remaining: "+ daysRemaining);
		} while (daysRemaining > 0);
		*/
		
		
	}

	public static void generateTaskID() {
		for (int x = 100; x < 121; x++) {
			ids.add(x);
		}		
		//System.out.println(ids);
	}
	
	public static List <Integer> getGeneratedID(List<Integer> list, int totalItems){
		Random rand = new Random();
		List<Integer> newIdList = new ArrayList<>(); 
		for (int i = 0; i < totalItems; i++) {
			int randomIndex = rand.nextInt(list.size()); 
	        newIdList.add(list.get(randomIndex)); 
	        list.remove(randomIndex); 
	    } 
	    return newIdList; 
	}
}
