package com.vits.model;

import java.util.List;

public class ProjectPlan {

    private String name;

    private List<Task> listOfTasks;

    public ProjectPlan(List<Task> tasklist){
        this.listOfTasks = tasklist;
    }

    public ProjectPlan(List<Task> tasklist, String name){
        this.listOfTasks = tasklist;
        this.name = name;
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
