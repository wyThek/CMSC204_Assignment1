/**
 * CMSC204 Assignment 1 
 * @author Yei Thek Wang (Thek)
 */
public class NoDigitException extends Exception {

	public NoDigitException() {

		super("The password must contain at least one digit");

	}
}