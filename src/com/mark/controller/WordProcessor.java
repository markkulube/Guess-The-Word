package com.mark.controller;

public class WordProcessor {
	
	public boolean checkGuess(String word, CharSequence guessedChar) {
		System.out.println("checking the guessed word: " + guessedChar);
		return word.contains(guessedChar);
	}
	
	public boolean inputValidation(CharSequence userIn) {
		System.out.println("User input validated");
		return true;
	}

}
