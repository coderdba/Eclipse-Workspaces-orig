package com.gm.music;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import java.util.Map;

import java.util.ArrayList;

public class SongFileReader {
	
	File infile;
	
	public SongFileReader(String filePath) {
		
		infile = new File (filePath);
		
	}

	// https://stackoverflow.com/questions/19844649/java-read-file-and-store-text-in-an-array
	public List<String> getElements()  throws Exception {

		Scanner infileScanner = new Scanner(infile);
		List<String> elements = new ArrayList<String>();
		
		// comma delimiter
		infileScanner.useDelimiter(",\\s*");
		
	    while (infileScanner.hasNext()) {
	    	
	        // find next line
	        String token = infileScanner.next();
	        elements.add(token);
	      }
	    
	    infileScanner.close();
	    
	    return elements; 
	}
	
	// Creates a map-stream of note-octave-length elements from the input file
		public List<String[]> getSongStreamArray() throws Exception {

			Scanner infileScanner = new Scanner(infile);
			List<String> elements = new ArrayList<String>();

			// this will be returned
			List<String[]> songStreamArray = new ArrayList<String[]>();
			
			// comma delimiter
			infileScanner.useDelimiter(",\\s*");
					
		    while (infileScanner.hasNext()) {
		    	
		        // find next line
		        String token = infileScanner.next();
		        elements.add(token);
		      }
		    
		    infileScanner.close();
		    
		    // Now, place the elements into note-octave-speed elements		
			//System.out.println("List of elements " + elements.toString());
		    int elementsCount = elements.size();

			for (int i=0; i<elementsCount; i++) {
				
			    String noteAndOctave;
				String note;
				String octave;
				String length;
				
				// note-octave, length
				
				String element = elements.get(i);
				
				//System.out.println("Element " + element);
				
				String[] splitString = element.split("\\.");
				
				noteAndOctave = splitString[0]; // note and octave composite string - like s0 is s and 0
				String[] splitNoteAndOctave = noteAndOctave.split("");
				
				note = splitNoteAndOctave[0];
				
				if (splitNoteAndOctave.length > 1) {
					octave = splitNoteAndOctave[1];
				}
				else {
					octave = "1";
				}
				
				if (splitString.length > 1) {
					
				    length = splitString[1];
				}
				else {
					length = "1"; 
				}
				
				String[] arrayElement = {note,octave,length};	
				songStreamArray.add(arrayElement);	
			}
			
			return songStreamArray;
		}
	
	// Creates a stream of note-octave-length elements from the input file
	public List<String[][][]> getSongStreamArray2() throws Exception {

		Scanner infileScanner = new Scanner(infile);
		List<String> elements = new ArrayList<String>();
		//List<String> songStream = new ArrayList<String>();
		List<String[][][]> songStreamArray = new ArrayList<String[][][]>();
		
		// comma delimiter
		infileScanner.useDelimiter(",\\s*");
				
	    while (infileScanner.hasNext()) {
	    	
	        // find next line
	        String token = infileScanner.next();
	        elements.add(token);
	      }
	    
	    infileScanner.close();
	    
	    // Now, place the elements into note-octave-speed elements		
		//System.out.println("List of elements " + elements.toString());
	    int elementsCount = elements.size();

		for (int i=0; i<elementsCount; i++) {
			
		    String noteAndOctave;
			String note;
			String octave;
			String length;
			
			// note-octave, length
			
			String element = elements.get(i);
			
			//System.out.println("Element " + element);
			
			String[] splitString = element.split("\\.");
			
			noteAndOctave = splitString[0]; // note and octave composite string - like s0 is s and 0
			String[] splitNoteAndOctave = noteAndOctave.split("");
			
			note = splitNoteAndOctave[0];
			
			if (splitNoteAndOctave.length > 1) {
				octave = splitNoteAndOctave[1];
			}
			else {
				octave = "1";
			}
			
			if (splitString.length > 1) {
				
			    length = splitString[1];
			}
			else {
				length = "1"; 
			}
			

			String[][][] arrayElement = {{{note,octave,length}}};	
			songStreamArray.add(arrayElement);	
		}
		
		return songStreamArray;
	}
	
	// return song of individual letters in the file
	public List<String> getSongStream() throws Exception {

			Scanner infileScanner = new Scanner(infile);
			List<String> elements = new ArrayList<String>();
			List<String> songStream = new ArrayList<String>();
			
			// comma delimiter
			infileScanner.useDelimiter(",\\s*");
					
		    while (infileScanner.hasNext()) {
		    	
		        // find next line
		        String token = infileScanner.next();
		        elements.add(token);
		      }
		    
		    infileScanner.close();
		    
		    // Now, place the elements into note-octave-speed elements		
			//System.out.println("List of elements " + elements.toString());
		    int elementsCount = elements.size();

			for (int i=0; i<elementsCount; i++) {
				
			    String noteAndOctave;
				String note;
				String octave;
				String length;
				
				// note-octave, length
				
				String element = elements.get(i);
				
				//System.out.println("Element " + element);
				
				String[] splitString = element.split("\\.");
				
				noteAndOctave = splitString[0]; // note and octave composite string - like s0 is s and 0
				String[] splitNoteAndOctave = noteAndOctave.split("");
				
				note = splitNoteAndOctave[0];
				
				if (splitNoteAndOctave.length > 1) {
					octave = splitNoteAndOctave[1];
				}
				else {
					octave = "1";
				}
				
				if (splitString.length > 1) {
					
				    length = splitString[1];
				}
				else {
					length = "1"; 
				}
				
				songStream.add(note);
				songStream.add(octave);
				songStream.add(length);

				//System.out.println("Note: " + note + " Length: " + length);
				
			}
			
			return songStream;
		}

}
