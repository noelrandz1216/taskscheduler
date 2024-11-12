package com.vits.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task implements Comparable<Task>{

    private String name;
    private List<Task> dependencies = new ArrayList<>();
    private int duration;
    private LocalDate startDate;
    private LocalDate endDate;


    public Task(){

    }
    
    public Task(String name, List<Task> dependencies, int duration) {
        this.name = name;
        this.dependencies = dependencies;
        this.duration = duration;
    }

    public Task(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public void addDependency(Task task){
        dependencies.add(task);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Task> dependencies) {
        this.dependencies = dependencies;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public int compareTo(Task task) {
        return getEndDate().compareTo(task.getEndDate());
    }

}
