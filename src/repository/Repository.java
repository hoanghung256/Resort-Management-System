package repository;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author hoang hung
 */
public interface Repository<T> {
    final String path = new File("src").getAbsolutePath();
    
    ArrayList<T> readFile();

    void writeFile(ArrayList<T> entities);
}
