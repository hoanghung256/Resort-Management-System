package repository;

import java.util.ArrayList;

/**
 *
 * @author hoang hung
 */
public interface Repository<T> {
    ArrayList<T> readFile();

    void writeFile(ArrayList<T> entities);
}
