/**
 * CMSC204 Assignment 1 
 * @author Yei Thek Wang (Thek)
 */
public class NoUpperAlphaException extends Exception {

	public NoUpperAlphaException() {

		super("The password must contain at least one uppercase alphabetic character");

	}
}