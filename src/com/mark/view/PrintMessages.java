package com.mark.view;

public class PrintMessages {
	
	public void welcome() {
		System.out.println("***WELCOME TO HANGMANG***");
		System.out.println("");
		System.out.println("You are allowed 3 incorrect guesses");
	}
	
	public void guessInstruction(int numGuesses, String currentGuess) {
		System.out.println("Incorrect guesses = " + numGuesses + "/3");
		System.out.println("Characters guessed: " + currentGuess);
		System.out.println("Enter an alpha character to guess the word");
	}
	
	public void correctGuessMessage(boolean charValidCorrect, String userGuess) {
		if(charValidCorrect) {
			System.out.println("Correct Guess - '"+userGuess+"' is in the secrect word");
		} else {
			System.out.println("Incorrect Guess - '"+userGuess+"' is not in the secrect word");
		}

	}
	
	public void guessBoundary() {
		System.out.println("\n##################################################\n");
	}
	
	public void winMessage(String currentGuess) {
		System.out.println("****You Win****");
		System.out.println("The Secret Word Is: "+currentGuess);
		System.out.println("****Game Over****");
	}
	
	public void loseMessage(int numGuesses) {
		System.out.println("****You Lose****");
		System.out.println("Too Many Incorrect Guesses: "+ numGuesses+ "/3");
		System.out.println("Try Again");
		System.out.println("****Game Over****");
	}

}
