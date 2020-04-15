/**
 * 
 */
package com.mark;

import com.mark.controller.WordProcessor;

/**
 * @author mkulu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		start();

	}
	
	public static void start( ) {
		
		WordProcessor wordProcessor = new WordProcessor();
		int maxGuesses = 3;
		int numGuesses = 0;
		
		boolean allLettersGuessed = false;
		
		String word = "FACEBOOK";
		
		while(numGuesses < 3  && !allLettersGuessed) {
			
			System.out.println("***WELCOME TO HANGMANG***");
			System.out.println("You are allowed 3 incorrect character guesses");
			System.out.println("Enter an alphabet character to guess the word");
			System.out.println();
			
			
			
			// Accept user input
			String userIn = "";
			// Input validation check if input is single alpha letter
			boolean inputValid = wordProcessor.inputValidation(userIn);
			
			if(wordProcessor.checkGuess(word, "F")) {
				System.out.println("The character exists");
			}
			
			numGuesses += 1;
			break;
			

		}
		
	}

}
