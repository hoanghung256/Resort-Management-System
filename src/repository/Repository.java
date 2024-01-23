package repository;

import java.util.ArrayList;

/**
 *
 * @author hoang hung
 */
public interface Repository<T> {
    public T findById(String id);
    
    public void add(T entity);
    
    public void update(T entity);
    
    public void display(ArrayList<T> entities);
}
