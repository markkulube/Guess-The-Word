package com.mark.controller;

import java.util.HashSet;
import java.util.regex.Pattern;

public class WordProcessor {
	
	public boolean checkGuess(String word, CharSequence guessedChar) {
		System.out.println("Checking the guessed character: " + guessedChar);
	
		return word.contains(guessedChar);
	}
	
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

}
