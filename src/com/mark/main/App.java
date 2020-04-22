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
 * The main class that start the program as well as the game.
 * 
 * @author Mark Kulube
 * @email markkulube@gmail.com
 *
 */
public class App {

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		PrintMessages printMessages = new PrintMessages();
		WordProcessor wordProcessor = new WordProcessor();
		
		String fileName = "src\\WordList.txt";
		try {
			String secretWord = wordProcessor.generateSecretWord(fileName).trim().toUpperCase();
			start_game(secretWord, printMessages, wordProcessor);
		} catch (Exception e) {

			System.out.println("There is an error with src\\WordList.txt. The game will not run.");
			// e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param secretWord
	 * @param printMessages
	 * @param wordProcessor
	 */
	public static void start_game(String secretWord, PrintMessages printMessages, WordProcessor wordProcessor) {
		
		int maxGuesses = (int) Math.ceil((secretWord.length() * 1.5));
		int numGuesses = 0;
		
		boolean allLettersGuessed = false;
		
		int lenSecretWord = secretWord.length();
		
		String currentGuess = String.join("", Collections.nCopies(lenSecretWord, "_ ")); //String.repeat("_"., secretWord.length());
		currentGuess = currentGuess.trim();
		HashSet<String> guessedChars = new HashSet<String>();
		
		printMessages.welcome(maxGuesses);
		
		while(numGuesses < maxGuesses  && !allLettersGuessed) {
			
			printMessages.guessInstruction(numGuesses, maxGuesses, currentGuess);
			
			// Accept user input
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String userGuess = "";
			try {
				userGuess = br.readLine();
				
				// Make sure the character and secrectWord have the same capitalization.
				userGuess = userGuess.toString().toUpperCase();
				
				// Input validation check if input is single alpha letter
				boolean charValidCorrect = wordProcessor.inputValidation(userGuess) && wordProcessor.checkGuess(secretWord, userGuess);
				
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
				} else if(numGuesses >= maxGuesses) {
					printMessages.loseMessage(secretWord, numGuesses, maxGuesses);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				
				System.out.println("There was an error, try again!");
			}		
		}		
	}
}
