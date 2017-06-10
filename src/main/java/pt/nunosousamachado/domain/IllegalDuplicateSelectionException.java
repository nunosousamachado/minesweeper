package pt.nunosousamachado.domain;

/**
 * Created by nunomachado on 10/06/17.
 */
public class IllegalDuplicateSelectionException extends Exception {

    public IllegalDuplicateSelectionException(String message) {

        super(message);
    }

    public IllegalDuplicateSelectionException(String message, Exception exception) {

        super(message, exception);
    }


}
