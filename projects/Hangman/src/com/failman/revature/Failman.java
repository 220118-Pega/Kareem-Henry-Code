/**
 * 
 */
package com.failman.revature;

/**
 * @author Kareem A. Henry 
 * This is my version of the game Hangman.
 *
 */

//Import need tools for project
import java.util.*;

public class Failman {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner myScanner = new Scanner(System.in)) {
			// Every time you guess wrong, a letter gets added to FAILMAN. User loses once they have a FAILMAN
			int wordParts = 7;
			// Set the word you want to discover
			System.out.println("Set the word to guess: ");
			String mysteryWord = myScanner.nextLine();
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
				for(Character letter:originaWord.toCharArray())
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
