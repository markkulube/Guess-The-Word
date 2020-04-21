/**
 * 
 */
package com.mark.main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;

import com.mark.controller.WordProcessor;
import com.mark.view.PrintMessages;


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
		
		PrintMessages printMessages = new PrintMessages();
		start(printMessages);

	}

	public static void start(PrintMessages printMessages ) {
		
		WordProcessor wordProcessor = new WordProcessor();
		int maxGuesses = 3;
		int numGuesses = 0;
		
		boolean allLettersGuessed = false;
		
		String secretWord = "JAVA";
		int lenSecretWord = secretWord.length();
		
		String currentGuess = String.join("", Collections.nCopies(lenSecretWord, "_ ")); //String.repeat("_"., secretWord.length());
		currentGuess = currentGuess.trim();
		HashSet<String> guessedChars = new HashSet<String>();
		
		printMessages.welcome();
		
		while(numGuesses < 3  && !allLettersGuessed) {
			
			printMessages.guessInstruction(numGuesses, currentGuess);
			
			// Accept user input
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String userGuess = "";
			try {
				userGuess = br.readLine();
				
				// Make sure the character and secrectWord have the same capitalization.
				secretWord = secretWord.toUpperCase();
				userGuess = userGuess.toString().toUpperCase();
				
				// Input validation check if input is single alpha letter
				boolean charValidCorrect = wordProcessor.inputValidation(userGuess)  && wordProcessor.checkGuess(secretWord, userGuess);
				
				printMessages.correctGuessMessage(charValidCorrect, userGuess);
				
				if(charValidCorrect) {		
					guessedChars.add(userGuess);
					currentGuess = wordProcessor.fillBlanks(secretWord, currentGuess, guessedChars);
					allLettersGuessed = wordProcessor.allGuessedFinished( secretWord, currentGuess);
					
				} else {
					numGuesses += 1;
					
				}
				
				printMessages.guessBoundary();
				
				if(allLettersGuessed) {
					printMessages.winMessage(currentGuess);
				} else if(numGuesses >= 3) {
					printMessages.loseMessage(numGuesses);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				
				System.out.println("There was an error, try again!");
			}		
		}		
	}
}
