package backend.businesslogic;

/**
 * Custom exception which is thrown in Lunch if a random restaurant should be determined but the list of available restaurants is empty
 */
public class NoAvailableRestaurantException extends Exception{
    public NoAvailableRestaurantException(){}

    public NoAvailableRestaurantException(String message){
        super(message);
    }
}
