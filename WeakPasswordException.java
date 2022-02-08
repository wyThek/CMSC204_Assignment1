/**
 * CMSC204 Assignment 1 
 * @author Yei Thek Wang (Thek)
 */
public class WeakPasswordException extends Exception {

	public WeakPasswordException() {

		super("The password is OK but weak - it contains fewer than 10 characters");

	}

}