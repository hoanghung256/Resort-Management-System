package service;

/**
 *
 * @author hoang hung
 */
public interface Service<T> {
    T findById(String id);

    void display();

    void add(T entity);
    
    void save();
}
