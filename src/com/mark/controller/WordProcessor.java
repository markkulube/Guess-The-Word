package com.mark.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * A controller class that validates the user input as well as
 * checks if the guess is wrong or right.
 * 
 * @author Mark Kulube
 * @email markkulube@gmail.com
 *
 */
public class WordProcessor {
	
	/**
	 * @author Mark Kulube
	 * @email markkulube@gmail.com
	 *
	 */
	public boolean checkGuess(String word, CharSequence guessedChar) {
		System.out.println("Checking the guessed character: " + guessedChar);
		return word.contains(guessedChar);
	}
	
	/**
	 *  Return true is secretWord == currentGuess
	 * 
	 * @param secretWord
	 * @param currentGuess
	 * @return true - if all characters have been guessed, false otherwise.
	 */
	public boolean  allGuessedFinished(String secretWord, String currentGuess) {
		

		String newCurrentGuess = "";
		for(int i=0; i<currentGuess.length(); i++) {
			char c = currentGuess.charAt(i);
	        if( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
	           newCurrentGuess += c;
	        }
		}
		
		return secretWord.equals(newCurrentGuess);
	}
	
	/**
	 * Return true if the userIn is a single alphabet letter, false otherwise.
	 * 
	 * @param userIn
	 * @return true - if the userIn is a single alphabet letter.
	 */
	public boolean inputValidation(CharSequence userIn) {
		//System.out.println("User input validated");
		Boolean singleChar = userIn.length()==1;
		Boolean isLetter= false;
		if(singleChar) {
			isLetter = Pattern.matches("[a-zA-Z]", userIn);
		} else {
			System.out.println("Please guess a single letter");
		}
		
		return (singleChar && isLetter);
	}
	
	/**
	 * Generate the string with with guessed letters after most recent guess.
	 * 
	 * @param secretWord
	 * @param currentGuess
	 * @param guessedChars
	 * @return currentGuess - string with all guessed letters after most recent guess.
	 */
	public String fillBlanks(String secretWord, String currentGuess, HashSet guessedChars) {
		
		int lenSecretWord = secretWord.length();
		currentGuess = "";
		for(int i=0; i< lenSecretWord; i++) {;
			if(guessedChars.contains(secretWord.substring(i, i+1))) {
				currentGuess += secretWord.charAt(i) + " ";
			} else {
				currentGuess += "_ ";
			}
		}
		
		currentGuess = currentGuess.trim();
		
		return currentGuess;
	}
	
	/**
	 * Assign a random word from WordList.txt to be secretWord.
	 * 
	 * @param fileName
	 * @return secretWord - the word to be guessed by user.
	 * @throws Exception
	 */
	public String generateSecretWord(String fileName) throws Exception {
		
		String allWords = readFileAsString(fileName);
		
		String[] allWordsList = allWords.split("\n");
		
		int wordCount = getWordCount(allWordsList);
		
		int randomWordIndex = getRandomWordIndex(wordCount);
		
		String secretWord = allWordsList[randomWordIndex];
		
		return secretWord;
	}
	
	/**Returns all the words in WordList.txt as single String. */
	public String readFileAsString(String fileName)throws Exception { 
	    String data = ""; 
	    data = new String(Files.readAllBytes(Paths.get(fileName))); 
	    return data; 
	 }
	
	/**Returns the number of words in WordList.txt. */ 
	public int getWordCount(String[] allWordsList) { 
		return allWordsList.length; 
		}
	
	public int getRandomWordIndex(int wordCount) {
		Random random = new Random();
		
		int randomWordIndex = random.nextInt(wordCount);
		
		return randomWordIndex;
	}
}
