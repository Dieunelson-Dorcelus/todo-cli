package repository;

import java.util.ArrayList;
import java.util.Date;

/**
 * Task (Repository of comment)
 */
public abstract class Task implements Repository<Comment>{


    /**
     * The title
     */
    private String title;
    /**
     * Describe the task
     */
    private String description;
    /**
     * Creation date
     */
    private Date creaded;
    /**
     * Comment list
     */
    private ArrayList<Comment> comments;

    /**
     * Constructor for existing task with existing comments list
     * @param title
     * @param description
     * @param creaded
     * @param comments
     */
    public Task(String title, String description, Date creaded, ArrayList<Comment> comments){
        this.title = title;
        this.description = description;
        this.creaded = creaded;
        this.comments = comments;
    }

    /**
     * Constructor for existing task with no comment
     * @param title
     * @param description
     * @param creaded
     */
    public Task(String title, String description, Date creaded){
        this(title,description,creaded, new ArrayList<>());
    }

    /**
     * Constructor for new task
     * @param title
     * @param description
     */
    public Task(String title, String description){
        this(title,description,new Date(), new ArrayList<>());
    }

    /**
     * Get the first element which respect the filter
     * @param filter
     * @return a result
     */
    @Override
    public abstract ArrayList<Comment> readAll(Comment filter);

    @Override
    public abstract Comment read(Comment filter);

    /**
     * Create an element
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public abstract Comment create(Comment item);

    /**
     * Update an element existing element
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public abstract Comment update(Comment item);

    /**
     * Delete an existing element
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public abstract Comment delete(Comment item);

    /**
     * Get the task title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the task description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the creation date
     * @return creation date
     */
    public Date getCreaded() {
        return creaded;
    }

    /**
     * Get the comment list
     * @return comments
     */
    protected ArrayList<Comment> getComments() {
        return comments;
    }
}
