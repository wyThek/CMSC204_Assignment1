/**
 * CMSC204 Assignment 1 
 * @author Yei Thek Wang (Thek)
 */
public class InvalidSequenceException extends Exception{

	
	public InvalidSequenceException() {
		
		super("The password cannot contain more than two of the same character in sequence");
		
	}
	
}