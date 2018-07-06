package com.gm.music;

import java.util.List;

public class ReadSongFileAndPrint {
	
	public static void main(String[] args) throws Exception {
		
		SongFileReader songFileReader = new SongFileReader("songfile.txt");

		
		List<String> elements = songFileReader.getElements();
		List<String> songStream = songFileReader.getSongStream();
		
		int elementsCount = elements.size();
		int songStreamLength = songStream.size();
		
		String noteAndOctave;
		String note;
		String octave;
		String length;
		
		System.out.println("List of elements " + elements.toString());
		
		// get and print only the first split
		for (int i=0; i<elementsCount; i++) {
			
			// note-octave, length
			
			String element = elements.get(i);
			
			System.out.println("Element " + element);
			
			String[] splitString = element.split("\\.");
						
			noteAndOctave = splitString[0];
			
			if (splitString.length > 1) {
				
			    length = splitString[1];
			}
			else {
				length = "1"; 
			}
			
			
			System.out.println("Note: " + noteAndOctave + " Length: " + length);
			
		}
		
		// get and split the whole stream
		for (int i=0; i<songStreamLength; i++) {
			
			// note-octave, length
			
			String element = songStream.get(i);
			
			System.out.println("Element " + element);
			
		}
		
		
	}

}
