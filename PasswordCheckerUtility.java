
/**
 * CMSC204 Assignment 1 
 * @author Yei Thek Wang (Thek)
 */

import java.util.ArrayList;

public class PasswordCheckerUtility {

	/**
	 * Constructor
	 */
	public PasswordCheckerUtility() {
	}

	/**
	 * Compare equality of two passwords, the method will throw an exception
	 * 
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {

		if (!password.equals(passwordConfirm)) { 	// Checks if the passwords are not the same
			throw new UnmatchedException(); 		// Passwords inputs do not match
		}

	}

	/**
	 * Compare equality of two passwords. This method
	 * does not throws an exception, but returns false if the two passwords do not
	 * match. Else, the method returns false
	 * 
	 * @param password
	 * @param passwordConfirm
	 * @return true, false
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {

		if (password.equals(passwordConfirm)) { 		// Checks if passwords are the same
			return true; 								// Passwords are the same
		}
		return false; 									// Passwords not the same

	}

	/**
	 * This method passes an list of passwords and find the invalid passwords The
	 * 
	 * @param passwords
	 * @return invalidPasswordList
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

		int i = 0; // Count array index
		ArrayList<String> invalidPasswordList = new ArrayList<String>(); 		// New list
		while (i < passwords.size()) {
			try {
				if (isValidPassword(passwords.get(i))) { 						// Does not add list if valid password

				}
			} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
					| NoSpecialCharacterException | InvalidSequenceException e) {
				invalidPasswordList.add(passwords.get(i) + " -> " + e.getMessage()); // Add to invalid password list
				System.out.println(passwords.get(i) + " -> " + e.getMessage());
			}
			i++;
		}
		return invalidPasswordList; 											// Passes invalid list
	}

	/**
	 * This method checks if the password is between six to nine characters long
	 * 
	 * @param password
	 * @return true, false
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {

		if (password.length() <= 9 || password.length() >= 6) { 				// Password is 6 to 9 characters long
			return true;
		} else {
			return false; 														// Password is not between 6 to 9 characters long
		}
	}

	/**
	 * This method checks if the password has a number If the password does not have
	 * a number, the method will call error text
	 * 
	 * @param password
	 * @return true
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException {

		for (int i = 0; i < password.length(); i++) { 					// Goes through each character
			if (password.charAt(i) >= 48 && password.charAt(i) <= 57) { // Numbers of ASCII values that are digits
				return true; 											// Password has digit
			}
		}

		throw new NoDigitException(); 									// Password has no digit
	}

	/**
	 * This method checks if the password has a lower case letter If the Password
	 * does not have a lower case letter, the method will call error text
	 * 
	 * @param password
	 * @return true
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {

		for (int i = 0; i < password.length(); i++) { 					// Goes through each character
			if (password.charAt(i) >= 97 && password.charAt(i) <= 122) { // lower case characters of ASCII values
				return true; 											// Password has lower case
			}
		}
		throw new NoLowerAlphaException(); 								// Password has no lower case
	}

	/**
	 * This method checks if there are more than 2 characters are in the same
	 * sequence
	 * 
	 * @param password
	 * @return
	 * @throws InvalidSequenceException
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {

		int num = 0;
		for (int i = 0; i < password.length(); i++) {
			if (num < 2 && i + 1 < password.length() && password.charAt(i) == password.charAt(i + 1))
				num++;
			else if (num < 2 && i + 1 < password.length() && password.charAt(i) != password.charAt(i + 1))
				num = 0;
		}

		if (num < 2) {
			return true;
		} else {
			throw new InvalidSequenceException();
		}
	}

	/**
	 * This method checks if the password contain a special character
	 * 
	 * @param password
	 * @return true
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {

		for (int i = 0; i < password.length(); i++) { 						// Loops through every password character
			if ((password.charAt(i) >= 58 && password.charAt(i) <= 64) || // All of special characters ascii value
					(password.charAt(i) >= 32 && password.charAt(i) <= 47)
					|| (password.charAt(i) >= 91 && password.charAt(i) <= 96)
					|| (password.charAt(i) >= 123 && password.charAt(i) <= 126)) {
				return true; 												// Password does have special character
			}
		}
		throw new NoSpecialCharacterException(); 						// No special character

	}

	/**
	 * This method checks if the password contains an upper case character
	 * 
	 * @param password
	 * @return true
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {

		for (int i = 0; i < password.length(); i++) { // Loops through every password character
			if (password.charAt(i) >= 65 && password.charAt(i) <= 90) { // Ascii values of upper case characters
				return true; // Password does have an upper case character
			}
		}
		throw new NoUpperAlphaException(); // Password does not have an upper case letter
	}

	/**
	 * This method checks if the password is at least six characters long
	 * 
	 * @param password
	 * @return true
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException {
		System.out.println();
		int min = 6; // Holds what is the min of password length
		if (password.length() >= min) {
			return true; // Password does have at least six characters
		} else {
			throw new LengthException(); // Password has less than six characters
		}
	}

	/**
	 * This method uses all of the validation methods to determine if the password
	 * meets all of the requirements
	 * 
	 * @param password
	 * @return true, false
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		// Uses all of the validation methods to determine if the password meets rules
		try {
			if (PasswordCheckerUtility.isValidLength(password) == true
					&& PasswordCheckerUtility.hasUpperAlpha(password) == true
					&& PasswordCheckerUtility.hasLowerAlpha(password) == true
					&& PasswordCheckerUtility.hasDigit(password) == true
					&& PasswordCheckerUtility.hasSpecialChar(password) == true
					&& PasswordCheckerUtility.hasSameCharInSequence(password) == true) {
				return true;
			}
		} catch (LengthException e) { // When password does not meet length
			// Report password does not meet length requirement
			throw new LengthException();
		} catch (NoUpperAlphaException e) { // When password does not meet upper case character
			// Reports password does not meet upper case character
			throw new NoUpperAlphaException();
		} catch (NoLowerAlphaException e) { // When password does not meet lower case character
			// Reports password does not meet lower case character
			throw new NoLowerAlphaException();
		} catch (NoDigitException e) { // When password does not meet digit
			// Reports password does not meet digit
			throw new NoDigitException();
		} catch (NoSpecialCharacterException e) { // When password does not meet special character
			// Reports password does not meet special character
			throw new NoSpecialCharacterException();
		} catch (InvalidSequenceException e) { // When password has linear sequence
			// Reports password does not meet sequence
			throw new InvalidSequenceException();
		}
		return false; // Password does not meet all of the requirements

	}

	/**
	 * This method test if the password is weak based on the length of the password
	 * 
	 * @param password
	 * @return false
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {

		if (password.length() <= 9) { // If the password is below 10 char,

			throw new WeakPasswordException(); // Password is weak
		} else {
			return false; // Password is strong
		}

	}

}