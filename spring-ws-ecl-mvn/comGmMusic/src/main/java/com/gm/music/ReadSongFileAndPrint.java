package com.gm.music;

import java.util.List;

public class ReadSongFileAndPrint {
	
	public static void main(String[] args) throws Exception {
		
		SongFileReader songFileReader = new SongFileReader("songfile.txt");
		
		List<String> elements = songFileReader.getElements();
		int elementsCount = elements.size();
		
		System.out.println(elements.toString());
		
		for (int i=0; i<elementsCount; i++) {
			
			// note, octave, length
			
		}
		
		
	}

}
