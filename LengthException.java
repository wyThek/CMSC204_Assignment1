/**
 * CMSC204 Assignment 1 
 * @author Yei Thek Wang (Thek)
 */
public class LengthException extends Exception {

	public LengthException() {

		super("The password must be at least 6 characters long");

	}

}