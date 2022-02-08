/**
 * CMSC204 Assignment 1 
 * @author Yei Thek Wang (Thek)
 */
public class NoLowerAlphaException extends Exception {

	public NoLowerAlphaException() {

		super("The password must contain at least one lowercase alphabetic character");

	}
}