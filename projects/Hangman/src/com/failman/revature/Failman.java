package com.failman.revature;

/**
 * @author Kareem A. Henry 
 * This is my version of the game Hangman.
 *
 */

//Import need tools for project
import java.util.*;

// Create a public and class named Failman to execute a set of instructions. This is what I want to happen to and/or with this object and/or information?
public class Failman {
	
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
			// First, use this tool to listen for the information the user will enter after this /instructions how. 
		try (Scanner myScanner = new Scanner(System.in)) {
			// Set the number of times I want the user to guess the information to 7/instructions how.
			int wordParts = 7;
			// Second, send this String to the user/instructions how. 
			System.out.println("Set the word to guess: ");
			// Use this tool to except a String from the user to store/instructions how. 
			String mysteryWord = myScanner.nextLine();
			// Perform a Variable Declaration statement to return an ArrayList object as a String/instructions how.
			List<String> correctLetters = new ArrayList<String>();
			
			String originalWord = mysteryWord;
			while (wordParts > 0) {
				System.out.println("Guess a letter: ");
				String guessedLetter = myScanner.nextLine();
				if (mysteryWord.contains(guessedLetter)) {
					System.out.println(mysteryWord.contains(guessedLetter));
					System.out.println("The word contains " + guessedLetter);
					mysteryWord = mysteryWord.replaceAll(guessedLetter, "");

				} else {
					System.out.println(mysteryWord.contains(guessedLetter));
					System.out.println("The word does not contain the letter " + guessedLetter);
					wordParts--;
				}
				
				System.out.println("Game progress: ");
				for(Character letter:originalWord.toCharArray())
				{
					if(correctLetters.contains(letter.toString()))
					{
						System.out.print(letter);
					} else {
						System.out.print("#");
					}
				}
				
				System.out.println();
				if(mysteryWord.length() == 0) {
					System.out.println("Congratulations, you win!");
					break;
				}
			}
			
			if(wordParts == 0)
			{	//If you run out of chances
				System.out.println("FAILMAN, You lose. Better luck next time.");
			}
		}	

	}

}
