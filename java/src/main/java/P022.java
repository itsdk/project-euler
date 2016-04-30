package main.java;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/*
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, 
 * begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, 
 * multiply this value by its alphabetical position in the list to obtain a name score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, 
 * which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 */

public class P022 extends Problem {

	@Override
	public String solve() {
		String path = new File("../res/p022_names.txt").getAbsolutePath();
		String file = "";
		try {
			file = readFile(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			return "ERROR: could not read file: " + e.getMessage();
		}
		
		String[] names = file.split("\",\""); // get array of just names
		// remove quote at start of first name, and end of last name:
		names[0] = names[0].substring(1); 
		names[names.length-1] = names[names.length-1].substring(0, names[names.length-1].length()-1); 
		
		Arrays.sort(names); // sort the names
		
		int nameScoreTotal = 0; // the total name score, for all names
		for (int i=0; i<names.length; i++) {
			nameScoreTotal += alphaScore(names[i]) * (i+1);
		}
		
		return Integer.toString(nameScoreTotal);
	}

}
