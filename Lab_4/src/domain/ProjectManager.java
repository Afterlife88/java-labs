package domain;

import exceptions.TaskNotFoundExcpetion;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Andrew on 21.12.2016.
 */
public class ProjectManager extends Worker  implements Serializable {

    private Project workingProject;

    public ProjectManager(String firstName, String secondName, Project project) {
        super(firstName, secondName);
        this.workingProject = project;
    }

    public void addTaskToBackLog(Task task) {
        workingProject.getBacklog().addTask(task);
    }

    public void assignTaskToWorker (Worker worker, Task task){
        task.setAssignedWorker(worker);
    }

    public void removeTaskFromBacklog(String taskName) throws TaskNotFoundExcpetion {
        Task foundTask = workingProject.getBacklog().findTask(taskName);
        if (foundTask == null)
            throw new TaskNotFoundExcpetion("Requested task not found in backlog");
        workingProject.getBacklog().removeTask(foundTask);
    }
    public Sprint startSprint (LocalDate beginDate, LocalDate endDate){
        return new Sprint(beginDate, endDate, workingProject.getBacklog());
    }

    public void removeWorkerFromProject (Worker worker) {
        workingProject.removeFromProject(worker);
        workingProject.getBacklog().reassignTasksForWorker(worker);

    }

}
