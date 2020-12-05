package repository;

import java.util.ArrayList;

public interface Repository<T> {

    /**
     * Get all element which respect the filter
     * @param filter
     * @return List of result
     */
    public ArrayList<T> readAll(T filter);

    /**
     * Get the first element which respect the filter
     * @param filter
     * @return a result
     */
    public T read(T filter);

    /**
     * Create an element
     * @param item
     * @return the element form the DataBase
     */
    public T create(T item);

    /**
     * Update an element existing element
     * @param item
     * @return the element form the DataBase
     */
    public T update(T item);

    /**
     * Delete an existing element
     * @param item
     * @return the element form the DataBase
     */
    public T delete(T item);

}
