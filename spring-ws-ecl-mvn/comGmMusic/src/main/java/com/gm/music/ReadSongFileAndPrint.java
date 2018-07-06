package com.gm.music;

import java.util.List;

public class ReadSongFileAndPrint {
	
	public static void main(String[] args) throws Exception {
		
		SongFileReader songFileReader = new SongFileReader("songfile.txt");
		
		List<String> elements = songFileReader.getElements();
		int elementsCount = elements.size();
		String note;
		int  length;
		
		System.out.println("List of elements " + elements.toString());
		
		for (int i=0; i<elementsCount; i++) {
			
			// note-octave, length
			
			String element = elements.get(i);
			
			System.out.println("Element " + element);
			
			String[] splitString = element.split("\\.");
						
			note = splitString[0];
			
			if (splitString.length > 1) {
				
			    length = Integer.parseInt(splitString[1]);
			}
			else {
				length = 1; 
			}
			
			System.out.println(element + " " + note + " " + length);
			
		}
		
		
	}

}
