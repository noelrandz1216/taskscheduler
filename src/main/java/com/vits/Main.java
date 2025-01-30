package com.vits;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.vits.model.ProjectPlan;
import com.vits.model.Task;
import com.vits.services.ScheduleCalculator;

public class Main {

    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        try(scan) {
        int numberOfProjects = getIntInput("How many projects do you intend to create?");
        for(int i=1; i<=numberOfProjects;i++){
            ProjectPlan project = new ProjectPlan();
            String nameOfProject = getStringInput("What is the name of the project"+i+"?");
            project.setName(nameOfProject);
            int numberOfTasks = getIntInput("How many tasks are there for this project?");
            for(int j=1;j<=numberOfTasks;j++){
                String name = getStringInput("Enter task name:");
                int duration = getIntInput("Enter task duration (in days):");
                List<Task>dependencies = new ArrayList<>();
                Task task = new Task(name, dependencies, duration);
                project.addTask(task);
                int numberOfDependencies=getIntInput("How many dependencies for this task?");
                for (int k = 1; k <=numberOfDependencies; k++) {
                    Task dependency = new Task();
                    String dependencyname = getStringInput("Enter name of dependency task"+k+":");
                    dependency.setName(dependencyname);
                    int dependencyduration = getIntInput("Duration (in days):");
                    dependency.setDuration(dependencyduration);
                    task.addDependency(dependency);
                }
            }
            LocalDate projectStartDate = getDateInput("Enter project start date (YYYY-MM-DD):");
            System.out.println("Project start date:" + projectStartDate.toString());
            ScheduleCalculator calculator = new ScheduleCalculator();
            List<Task>result = calculator.calculateSchedule(project, projectStartDate);
            
            System.out.println("Schedule for Project:"+project.getName());
            for (Task task : result) {
                System.out.printf("Task %s: Start Date = %s, End Date = %s, Duration %s%n",
                        task.getName(), task.getStartDate(), task.getEndDate(), task.getDuration());
            }
        }
        }catch(Exception e){
            System.out.println("An exception occurred:" + e.getLocalizedMessage());
        }

    }

    private static int getIntInput(String prompt){
        while (true) {
            System.out.println(prompt);
            try {
                int input = scan.nextInt();
                scan.nextLine(); 
                if (input >= 0) {
                    return input;
                } else {
                    System.out.println("Invalid input. Please enter a non-negative integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scan.nextLine(); 
            }
        }
    }

    private static String getStringInput(String prompt){
        while (true) {
            System.out.println(prompt);
            String input = scan.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter a valid string.");
            }
        }
    }

    private static LocalDate getDateInput(String prompt) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            System.out.println(prompt);
            String input = scan.nextLine().trim();
            try {
                return LocalDate.parse(input, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            }
        }
    }
}