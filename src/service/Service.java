package service;

/**
 *
 * @author hoang hung
 */
public interface Service<T> {
    public void findById(String id);
    
    public void display();
    
    public void add(T entity);
    
    public void update(T entity);
}
