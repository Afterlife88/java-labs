package excpetions;

/**
 * Created by Andrew on 13.12.2016.
 */
public class ServiceException extends Exception{
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException (String message, Throwable cause) {
        super (message, cause);
    }
}