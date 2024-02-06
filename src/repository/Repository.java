package repository;

import java.io.File;

/**
 *
 * @author hoang hung
 */
public interface Repository<T, C> {
    final String path = new File("src").getAbsolutePath();
    
    C readFile();

    void writeFile(C entities);
}
