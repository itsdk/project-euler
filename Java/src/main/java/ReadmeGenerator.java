package main.java;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * - generates a markdown README.md for this Project Euler repository 
 * - includes list with links to solutions to problems for each language used
 */

public class ReadmeGenerator {
	
	// file extensions to allow
	private final static String[] allowableExt = {".c", 
												".h", 
												".hs", 
												".java", 
												".pl", 
												".py", 
												".rkt" };
	
	// files to exclude (which would be allowed by their extension otherwise)
	private final static String[] exclude = { "Problem.java", 
											"ReadmeGenerator.java", 
											"ProblemsTest.java" };
	
	// final list of problem files
	private static List<File> allowList = new ArrayList<File>();
	
	// problems that have at least one solution file
	private static Set<Integer> problemSet = new TreeSet<Integer>();
	
	
	public static void main(String[] args) {
		createReadme(); // create the readme file if non-existent
		
		File curDir = new File("..");
        getAllProblems(curDir); // get all the problem files
        
        System.out.println("\nProject Euler Problems Found: ");
        for (File f : allowList) {
        	System.out.println("\t" + f.getName());
        }
        
        // get all problem numbers that have solutions
        for (File f : allowList) {
        	problemSet.add(getNum(f));
        }
        
    }
	
	/*
	 * get problem number from file name
	 */
	public static int getNum(File f) {
		int period = f.getName().indexOf(".");
		return Integer.parseInt(f.getName().substring(period-3, period));
		
	}
	
	/*
	 * get file extension (with period) from file name
	 */
	public static String getExt(File f) {
		int period = f.getName().indexOf(".");
		return f.getName().substring(period);
	}
	
	/*
	 * create new readme
	 */
	public static void createReadme() {
		try {
			File file = new File("../README.md");
			
			if (file.createNewFile()) {
				System.out.println("README.md created.");
			} else {
				System.out.println("README.md already exists.");
				System.exit(0); // exiting so that we don't accidentally overwrite readme
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * add all the problem files to allowList 
	 */
	private static void getAllProblems(File curDir) {
		List<File> files = new ArrayList<File>(Arrays.asList(curDir.listFiles()));
		for(File f : files){
            if (f.isDirectory()) {
                getAllProblems(f);
            } 
        }
		
        Iterator<File> iterator = files.iterator();
        while (iterator.hasNext()) {
            File currentFile = iterator.next();
            for (String ext : allowableExt) {            	
            	if (currentFile.getName().endsWith(ext)) {
            		boolean excluded = false;
            		for (String e : exclude) {
            			if (currentFile.getName().equals(e)) {
            				excluded = true;
            			}
            		}
            		// if not on exclude list, add
            		if (!excluded) { allowList.add(currentFile); }
            	}
            }    
        }
	}
	
}
