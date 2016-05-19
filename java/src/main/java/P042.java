package main.java;

/*
 * The nth term of the sequence of triangle numbers is given by, tn = 0.5n(n+1); 
 * so the first ten triangle numbers are:
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 
 * By converting each letter in a word to a number corresponding to its alphabetical position 
 * and adding these values we form a word value. For example, the word value for SKY 
 * is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call 
 * the word a triangle word.
 * 
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing 
 * nearly two-thousand common English words, how many are triangle words?
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class P042 extends Problem {

	@Override
	public String solve() {
		String path = new File("../res/p042_words.txt").getAbsolutePath();
		String file = "";
		try {
			file = readFile(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			return "ERROR: could not read file: " + e.getMessage();
		}
		
		String[] words = file.split("\",\""); // get array of just words
		// remove quote at start of first word, and end of last word:
		words[0] = words[0].substring(1); 
		words[words.length-1] = words[words.length-1].substring(0, words[words.length-1].length()-1); 
		
		// get the word value for each word:
		int[] wordScore = new int[words.length];
		int maxScore = 0; // largest word score
		for (int i=0; i<wordScore.length; i++) {
			int score = alphaScore(words[i]);
			wordScore[i] = score;
			if (score > maxScore) maxScore = score;
		}
		
		// get all triangular numbers needed:
		HashSet<Integer> triangularNumbers = new HashSet<Integer>();
		int triangleNumber = 0;
		long tnCount = 1;
		while (triangleNumber < maxScore) {
			triangleNumber = (int)getTriangularNumber(tnCount);
			triangularNumbers.add(triangleNumber);
			tnCount++;
		}
		
		int numberTriangleWords = 0; // number of triangle words in the file
		for (int i=0; i<wordScore.length; i++) {
			if (triangularNumbers.contains(wordScore[i])) numberTriangleWords++;
		}
		
		return Integer.toString(numberTriangleWords);
	}

}
