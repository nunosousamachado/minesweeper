package pt.nunosousamachado.domain;

/**
 * Created by nunomachado on 21/05/17.
 */
public class IllegalSelectionException extends Exception{

    public IllegalSelectionException(String message) {

        super(message);
    }

    public IllegalSelectionException(String message, Exception exception) {

        super(message, exception);
    }

}
