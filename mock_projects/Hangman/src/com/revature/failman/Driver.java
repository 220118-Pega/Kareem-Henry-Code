package com.revature.failman;

/**
 * @author Kareem A. Henry 
 * This is my version of the game Hangman.
 *
 */

//Import need tools for project
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Create a public and class named Failman to execute a set of instructions. This is what I want to happen to and/or with this object and/or information?
public class Driver {
	
	/**
	 * @param args
	 */
	
	/*
	 * Execute a public and static method(tool) named main that accepts an Array of Strings from the user as an input parameter and returns nothing, or void.
	 * (If your class does not have a main method, then it cannot be run as a program.
	 * Of course, some classes are just used to represent data, and they dont need main methods.)
	 * 
	 */
	public static void main(String[] args) {
			// First, set this tool to listen for the information the user input and name it myScanner/instructions how. 
		try (Scanner myScanner = new Scanner(System.in)) {
			// Set the number of times I want the user to guess the information to 7/instructions how.
			int wordParts = 7;
			// Second, send this String to the user/instructions how. 
			System.out.println("Set the word to guess: ");
			// Use this tool to except a String from the user to store/instructions how. 
			String mysteryWord = myScanner.nextLine();
			// Create an empty array called correctLetters to return an ArrayList object as a String/instructions how.
			List<String> correctLetters = new ArrayList<String>();
			// Create a second String with the users input/instructions how.
			String originalWord = mysteryWord;
			// Start a condition using the wordParts created for the chances to guess until 
			while (wordParts > 0) {
				// Send this String to ask user for a letter they think is in the mystery word
				System.out.println("Guess a letter in the word: ");
				// Use this the myScanner tool to listen for the user letter input and create a string object on the nextLine called guessedLetter
				String guessedLetter = myScanner.nextLine();
				// Use if else statement to specify what to print out information if the user guesses a letter or not of the mysteryWord string
				if (mysteryWord.contains(guessedLetter)) {
					// Do this if the guessedLetter is found in the mysteryWord "if return true"
					// Print this string and the guessedLetter input
					System.out.println("You're right! The mystery word contains this letter: " + guessedLetter);
					
					
					// "Remove" all correctly guessed letters from mysteryWord to measure completion
					mysteryWord = mysteryWord.replaceAll(guessedLetter, "");
					// Add all correctly guessed letters to the correctLetters arraylist 
					correctLetters.add(guessedLetter);
					
				} else {
					// Do this if the guessedLetter is not found in the mysteryWord "if return false"
					// Print this string and the guessedLetter input
					System.out.println("Bad guess! The mystery word does not contain this letter: " + guessedLetter);
					// Do this 7 times according to the number of wordParts. The parts are 7 accord to FAILMAN.
					wordParts--;
				}
				

				// Print this String to show the progress of this process after every play. 
				System.out.println("Here's your progress: ");
				
				// Use the wrapper class Character instead of char primitive, so we can make use of the toString method available to Objects
				// primitives don't have access to certain object methods, we use wrapper classes to "wrap" around primitive data types 
				// to be able to treat them like objects 
				
				// Use a for each loop to loop through an array named.
				
				/* for (type variableName(i) : arrayName) {
				 * 		code block to be executed
				 * }
				 * */
				
				for(Character letter : originalWord.toCharArray())
				{
					// Use if else statement to specify what to do if the user guesses a letter or not of the mysteryWord string
					if(correctLetters.contains(letter.toString()))
					{
						// Print out the letter if it is found in the Character object
						System.out.print(letter);
					} else {
						// Else if the letter is not guessed use this blank character.
						System.out.print("#");
					}
				
				}
				
				// Use the print line command to break to a new line
				System.out.println();
				// Program loops again until mysteryWord is 0 or wordParts is 0.
				
				// If the mysteryWord length is brought to 0 from print out this String
				if(mysteryWord.length() == 0) {//If you guess all wordParts
					System.out.println("Congratulations you've guessed all the letters in the word");
					break;
				}
			}
			// If the wordWord length is brought to 0 from print out this String
			if(wordParts == 0)
			{	//If you run out of chances
				System.out.println("You Loose! Better luck next time :-( !");
			}
		}	

	}

}
