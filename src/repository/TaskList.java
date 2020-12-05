package repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


/**
 * Task list repository
 */
public abstract class TaskList implements Repository<Task>{


    /**
     * Name of the tasklist
     */
    private String name;
    /**
     * Creation date
     */
    private Date created;
    /**
     * Task dictionary
     */
    private HashMap<String,Task> tasks;

    /**
     * Constructor for existing tasklist which not empty
     * @param name
     * @param created
     * @param tasks
     */
    public TaskList(String name, Date created, HashMap<String, Task> tasks){
        this.name = name;
        this.created = created;
        this.tasks = tasks;
    }

    /**
     * Constructor for existing tasklist which is empty
     * @param name
     * @param created
     */
    public TaskList(String name, Date created){
        this(name, created, new HashMap<>());
    }

    /**
     * Constructor for new tasklist
     * @param name
     */
    public TaskList(String name){
        this(name, new Date(), new HashMap<>());
    }

    /**
     * Get all element which respect the filter
     * @param filter
     * @return List of result
     */
    @Override
    public abstract ArrayList<Task> readAll(Task filter);

    /**
     * Get the first element which respect the filter
     * @param filter
     * @return a result
     */
    @Override
    public abstract  Task read(Task filter);

    /**
     * Create an element
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public abstract  Task create(Task item);

    /**
     * Update an element existing element
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public abstract  Task update(Task item);

    /**
     * Delete an existing element
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public abstract  Task delete(Task item);

    /**
     * Get the name of the list
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the creation date
     * @return creation date
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Get the task list
     * @return tasks
     */
    protected HashMap<String, Task> getTasks() {
        return tasks;
    }
}
