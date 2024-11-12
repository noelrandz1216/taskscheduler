package com.vits.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.vits.model.ProjectPlan;
import com.vits.model.Task;

public class ScheduleCalculator {

    public List<Task> calculateSchedule(ProjectPlan projectPlan, LocalDate projectStartDate) {
        HashMap<Task, Integer>inDegree = new HashMap<>();
        int i=0;
        for (Task task : projectPlan.getListOfTasks()) {
            for (Task dependency : task.getDependencies()) {
                inDegree.put(dependency,i);
                i++;
            }
            inDegree.put(task,i);
            i++;
        }
        Map<Task,Integer> sortedMap = sortByValue(inDegree);

        Queue<Task> queue = new LinkedList<>();
        for (Task task : sortedMap.keySet()) {
            queue.add(task);
        }

        List<Task>listToReturn = new ArrayList<>();
        LocalDate taskStartDate = projectStartDate;
        LocalDate taskEndDate;
        while (!queue.isEmpty()) {
            Task currentTask = queue.poll();
            currentTask.setStartDate(taskStartDate);
            taskEndDate = taskStartDate.plusDays(currentTask.getDuration());
            currentTask.setEndDate(taskEndDate);
            taskStartDate = taskEndDate.plusDays(1);
            listToReturn.add(currentTask);
        }
        return listToReturn;
    }

    public static HashMap<Task, Integer> sortByValue(HashMap<Task, Integer> hm)
    {
        List<Map.Entry<Task, Integer> > list =
               new LinkedList<>(hm.entrySet());

        Collections.sort(list, (Map.Entry<Task, Integer> o1, Map.Entry<Task, Integer> o2) -> (o1.getValue()).compareTo(o2.getValue()));
         
        HashMap<Task, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Task, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
