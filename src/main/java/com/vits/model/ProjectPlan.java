package com.vits.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectPlan {

    private String name;

    private List<Task> listOfTasks;

    public ProjectPlan(){
        this.listOfTasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getListOfTasks() {
        return listOfTasks;
    }

    public void setListOfTasks(List<Task> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    public void addTask(Task task) {
        listOfTasks.add(task);
    }
}
