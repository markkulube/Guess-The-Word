/**
 * 
 */
package com.mark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;

import com.mark.controller.WordProcessor;


/**
 * @author mkulu
 *
 */
public class App {

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
		
		String secretWord = "JAVA";
		int lenSecretWord = secretWord.length();
		
		String currentGuess = String.join("", Collections.nCopies(lenSecretWord, "_ ")); //String.repeat("_"., secretWord.length());
		currentGuess = currentGuess.trim();
		HashSet<String> guessedChars = new HashSet<String>();
		
		System.out.println("***WELCOME TO HANGMANG***");
		System.out.println("");
		System.out.println("You are allowed 3 incorrect guesses");
		
		while(numGuesses < 3  && !allLettersGuessed) {

			System.out.println("Incorrect guesses = " + numGuesses + "/3");
			System.out.println("Characters guessed: " + currentGuess);
			System.out.println("Enter an alpha character to guess the word");
			
			
			// Accept user input
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String userGuess = "";
			try {
				userGuess = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 		
			secretWord = secretWord.toLowerCase();
			userGuess = userGuess.toString().toLowerCase();
			
			// Input validation check if input is single alpha letter
			boolean inputValid = wordProcessor.inputValidation(userGuess);
			
			if(inputValid && wordProcessor.checkGuess(secretWord, userGuess)) {
				System.out.println("Correct Guess - '"+userGuess+"' is in the secrect word");
				
				guessedChars.add(userGuess);
				
				currentGuess = wordProcessor.fillBlanks(secretWord, currentGuess, guessedChars);
				allLettersGuessed = wordProcessor.allGuessedFinished( secretWord, currentGuess);
				
			} else {
				System.out.println("Incorrect Guess - '"+userGuess+"' is not in the secrect word");
				numGuesses += 1;
				
			}
			
			System.out.println("\n##################################################\n");
			
			if(allLettersGuessed) {
				System.out.println("****You Win****");
				System.out.println("The Secret Word Is: "+currentGuess);
				System.out.println("****Game Over****");
			} else if(numGuesses >= 3) {
				System.out.println("****You Lose****");
				System.out.println("Too Many Incorrect Guesses: "+ numGuesses+ "/3");
				System.out.println("Try Again");
				System.out.println("****Game Over****");
			}
			
		}
		
	}

}
