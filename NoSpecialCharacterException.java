/**
 * CMSC204 Assignment 1 
 * @author Yei Thek Wang (Thek)
 */
public class NoSpecialCharacterException extends Exception {

	public NoSpecialCharacterException() {

		super("The password must contain at least one special character");

	}
}