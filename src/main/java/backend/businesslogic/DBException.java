package backend.businesslogic;

/**
 * Custom exception thats thrown if any problem with the db occurs
 */
public class DBException extends Exception{

    public DBException(String message) {
        super(message);
        System.out.println(message);
    }

}
