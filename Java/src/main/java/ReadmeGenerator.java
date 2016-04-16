package main.java;

/*
 * Generates a markdown README.md for this Project Euler repository, which
 * includes a list with links to solutions to problems for each language used.
 * 
 * change:
 * - repoLink     = link of this repo, including the branch
 *                  ie. "https://github.com/pepers/project-euler/blob/master"
 * - allowableExt = extensions of solution source code files 
 *                  (order determines titles in table)
 * - exclude      = names of files to exclude which would otherwise be included because
 *                  they have file extensions in allowableExt
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ReadmeGenerator {
	
	private final static String repoLink = "https://github.com/pepers/project-euler/blob/master";
	
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
		File readme = createReadme(); // create the readme file if non-existent
		
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
        
        // fill readme
        try (PrintWriter out = new PrintWriter(readme)) {
        	out.println("# project-euler");
        	out.println("solutions to problems from ProjectEuler.net");
        	out.println("\n### Table of Solutions:");
        	out.println(generateTable());
        	System.out.print("\nTable of solutions has been generated.");
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }        
    }
	
	/*
	 * generate solution files table in markdown
	 */
	private static String generateTable() {
		String titleRow = "| # | ";
		String headerRow = "\n| --- | ";
		String problems = "";
		
		// fill in title and header
		for (String t : allowableExt) {
			titleRow += t + " | ";
			headerRow += "--- | ";
		}
		
		// fill in rows of table
		for (Integer i : problemSet) {
			problems += "\n| " + i + " | ";
			for (String ext : allowableExt) {
				boolean noSolution = true;
				for (File f : allowList) {
					// solution file found
					if ((getNum(f) == i) && (getExt(f).equals(ext))){
						problems += getLinkMD(f) + " | "; 
						noSolution = false;
						break;
					}
				}
				// no solution file found
				if (noSolution) {
					problems += " | ";
				}
			}
		}
	
		return titleRow + headerRow + problems;
	}
	
	/*
	 * get problem number from file name
	 */
	private static int getNum(File f) {
		int period = f.getName().indexOf(".");
		return Integer.parseInt(f.getName().substring(period-3, period));
		
	}
	
	/*
	 * get file extension (with period) from file name
	 */
	private static String getExt(File f) {
		int period = f.getName().indexOf(".");
		return f.getName().substring(period);
	}
	
	/*
	 * get the markdown for a link to the file
	 */
	private static String getLinkMD(File f) {
		String name = "[" + f.getName() + "]";
		String path = f.getPath().substring(2).replace("\\", "/");
		String link = repoLink + path;
		return name + "(" + link + ")";
	}
	
	/*
	 * create new readme
	 */
	private static File createReadme() {
		File file = null;
		try {
			file = new File("../README.md");
			
			if (file.createNewFile()) {
				System.out.println("README.md created.");
			} else {
				System.out.println("README.md already exists.");
				System.exit(0); // exiting so that we don't accidentally overwrite readme
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
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
