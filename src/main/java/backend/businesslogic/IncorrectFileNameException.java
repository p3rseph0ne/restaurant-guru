package backend.businesslogic;

/**
 * custom Exception thats thrown in restaurant reader if the filename for the restaurant data is incorrect
 */
public class IncorrectFileNameException extends Exception{
    public IncorrectFileNameException(String errorMessage){
        super(errorMessage);
    }
}
