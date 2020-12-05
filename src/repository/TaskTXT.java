package repository;

import java.util.ArrayList;
import java.util.Date;

public class TaskTXT extends Task{

    /**
     * Constructor for existing task with existing comments list
     *
     * @param title
     * @param description
     * @param creaded
     * @param comments
     */
    public TaskTXT(String title, String description, Date creaded, ArrayList<Comment> comments) {
        super(title, description, creaded, comments);
    }

    /**
     * Constructor for existing task with no comment
     *
     * @param title
     * @param description
     * @param creaded
     */
    public TaskTXT(String title, String description, Date creaded) {
        super(title, description, creaded);
    }

    /**
     * Constructor for new task
     *
     * @param title
     * @param description
     */
    public TaskTXT(String title, String description) {
        super(title, description);
    }

    /**
     * Get the first element which respect the filter
     *
     * @param filter
     * @return a result
     */
    @Override
    public ArrayList<Comment> readAll(Comment filter) {
        return null;
    }

    @Override
    public Comment read(Comment filter) {
        return null;
    }

    /**
     * Create an element
     *
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public Comment create(Comment item) {
        return null;
    }

    /**
     * Update an element existing element
     *
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public Comment update(Comment item) {
        return null;
    }

    /**
     * Delete an existing element
     *
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public Comment delete(Comment item) {
        return null;
    }
}
