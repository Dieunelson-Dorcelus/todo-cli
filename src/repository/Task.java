package repository;

import java.util.ArrayList;
import java.util.Date;

/**
 * Task (Repository of comment)
 */
public class Task implements Repository<Comment>{


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
    private Date created;
    /**
     * It is done ?
     */
    private boolean done;
    /**
     * Comment list
     */
    private ArrayList<Comment> comments;

    /**
     * Constructor for existing task with existing comments list
     * @param title
     * @param description
     * @param created
     * @param comments
     */
    public Task(String title, String description, Date created, ArrayList<Comment> comments, boolean done){
        this.title = title;
        this.description = description;
        this.created = created;
        this.comments = comments;
        this.done = done;
    }

    /**
     * Constructor for existing task with no comment
     * @param title
     * @param description
     * @param created
     */
    public Task(String title, String description, Date created, boolean done){
        this(title,description,created, new ArrayList<>(), done);
    }

    /**
     * Constructor for new task
     * @param title
     * @param description
     */
    public Task(String title, String description){
        this(title,description,new Date(), new ArrayList<>(), false);
    }

    /**
     * Get the first element which respect the filter
     * @param filter
     * @return a result
     */
    @Override
    public ArrayList<Comment> readAll(Comment filter){
        return null;
    }

    @Override
    public Comment read(Comment filter) {
        return null;
    }

    /**
     * Create an element
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public Comment create(Comment item) {
        return null;
    }

    /**
     * Update an element existing element
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public Comment update(Comment item) {
        return null;
    }

    /**
     * Delete an existing element
     * @param item
     * @return the element form the DataBase
     */
    @Override
    public Comment delete(Comment item) {
        return null;
    }

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
    public Date getCreated() {
        return created;
    }

    /**
     * Get the comment list
     * @return comments
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", done=" + done +
                ", comments=" + comments +
                '}';
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
