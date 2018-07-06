package com.gm.music;

import java.util.List;

public class ReadSongFileAndPrint {
	
	public static void main(String[] args) throws Exception {
		
		SongFileReader songFileReader = new SongFileReader("songfile.txt");
		
		List<String> elements = songFileReader.getElements();
		
		System.out.println(elements.toString());
	}

}
