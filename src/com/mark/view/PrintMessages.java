package com.mark.view;

/**
 * A view class that prints various messages of the game to console.
 * 
 * @author Mark Kulube
 * @email markkulube@gmail.com
 *
 */
public class PrintMessages {
	
	/**
	 * Welcome messages at game start.
	 * 
	 * @param maxGuesses
	 */
	public void welcome(int maxGuesses) {
		System.out.println("***WELCOME TO HANGMANG***");
		System.out.println("");
		System.out.println("You are allowed " + maxGuesses + " incorrect guesses");
	}
	
	/**
	 * Prompt user to guess and submit an alphabet character.
	 * 
	 * @param numGuesses
	 * @param maxGuesses
	 * @param currentGuess
	 */
	public void guessInstruction(int numGuesses, int maxGuesses, String currentGuess) {
		System.out.println("Incorrect guesses = " + numGuesses + "/" + maxGuesses);
		System.out.println("Characters guessed: " + currentGuess);
		System.out.println("Enter an alpha character to guess the word");
	}
	
	/**
	 * Feedback as to whether the guess was right or wrong.
	 * 
	 * @param charValidCorrect
	 * @param userGuess
	 */
	public void correctGuessMessage(boolean charValidCorrect, String userGuess) {
		if(charValidCorrect) {
			System.out.println("Correct Guess - '"+userGuess+"' is in the secrect word");
		} else {
			System.out.println("Incorrect Guess - '"+userGuess+"' is not in the secrect word");
		}

	}
	
	/** Delimiter after each guess. */
	public void guessBoundary() {
		System.out.println("\n##################################################\n");
	}
	
	/**
	 * End game message if the user correctly guesses all characters
	 * 
	 * @param currentGuess
	 */
	public void winMessage(String currentGuess) {
		System.out.println("****You Win****");
		System.out.println("The Secret Word Is: "+currentGuess);
		System.out.println("****Game Over****");
	}
	
	/** End game message if the user runs out of guess attempts. */
	public void loseMessage(String secretWord, int numGuesses, int maxGuesses) {
		System.out.println("****You Lose****");
		System.out.println("Too Many Incorrect Guesses: "+ numGuesses+ "/" + maxGuesses);
		System.out.println("The Secret Word Was: " + secretWord);
		System.out.println("Try Again!!!");
		System.out.println("****Game Over****");
	}

}
