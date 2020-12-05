package repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TaskListTXT extends TaskList{

    /**
     * Constructor for existing tasklist which not empty
     *
     * @param name
     * @param created
     * @param tasks
     */
    public TaskListTXT(String name, Date created, HashMap<String, Task> tasks) {
        super(name, created, tasks);
    }

    /**
     * Constructor for existing tasklist which is empty
     *
     * @param name
     * @param created
     */
    public TaskListTXT(String name, Date created) {
        super(name, created);
    }

    /**
     * Constructor for new tasklist
     *
     * @param name
     */
    public TaskListTXT(String name) {
        super(name);
    }

    /**
     * Get all element which respect the filter
     *
     * @param filter
     * @return List of result
     */
    @Override
    public ArrayList<Task> readAll(Task filter) {
        return null;
    }

    /**
     * Get the first element which respect the filter
     *
     * @param filter
     * @return a result
     */
    @Override
    public Task read(Task filter) {
        return null;
    }

    /**
     * Create an element
     *
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public Task create(Task item) {
        return null;
    }

    /**
     * Update an element existing element
     *
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public Task update(Task item) {
        return null;
    }

    /**
     * Delete an existing element
     *
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public Task delete(Task item) {
        return null;
    }
}
