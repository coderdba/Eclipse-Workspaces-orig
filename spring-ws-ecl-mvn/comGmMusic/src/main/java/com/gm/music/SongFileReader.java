package com.gm.music;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;

public class SongFileReader {
	
	File infile;
	
	public SongFileReader(String filePath) {
		
		infile = new File (filePath);
		
	}

	// https://stackoverflow.com/questions/19844649/java-read-file-and-store-text-in-an-array
	public List<String> getElements()  throws Exception {

		Scanner infileScanner = new Scanner(infile);
		
		// comma delimiter
		infileScanner.useDelimiter(",\\s*");
				
		List<String> elements = new ArrayList<String>();
		
	    while (infileScanner.hasNext()) {
	    	
	        // find next line
	        String token = infileScanner.next();
	        elements.add(token);
	      }
	    
	    infileScanner.close();
	    
	    return elements; 
	}

}
