package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Andrew on 21.12.2016.
 */
public class Backlog implements Serializable {

    private ArrayList<Task> listOfTasks;

    public Backlog() {
        listOfTasks = new ArrayList<>();
    }

    public ArrayList<Task> getListOfTasks() {
        return listOfTasks;
    }

    public void removeTask(Task task) {
        listOfTasks.remove(task);
    }

    public void addTask(Task data) {
        listOfTasks.add(data);
    }

    public Task findTask(String taskName) {
        Task task = null;
        for (Task item : listOfTasks) {
            if (Objects.equals(item.getTaskName(), taskName))
                task = item;
        }
        return task;
    }

    public Task findTask(Task task) {
        Task foundTask = null;
        for (Task item : listOfTasks) {
            if (Objects.equals(item.getTaskName(), task.getTaskName()))
                foundTask = task;
        }
        return foundTask;
    }

    // Make all task from requested user Not assigned (using when user removing from project)
    public void reassignTasksForWorker(Worker worker){
        for(Task task : listOfTasks){
            task.setAssignedWorker(null);
            task.changeStatusOfTask(StatusOfTask.ToDo);
        }
    }
}
