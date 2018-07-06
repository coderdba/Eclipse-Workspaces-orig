package com.gm.music;

import java.util.List;

public class PlaySongFile {

	public static void main(String[] args) throws Exception {
		
		SongFileReader songFileReader = new SongFileReader("songfile.txt");

		List<String> songStream = songFileReader.getSongStream();
		List<String[][][]> songStreamArray = songFileReader.getSongStreamArray();
		
		int songStreamLength = songStream.size();
		int songStreamArrayLength = songStreamArray.size();
		
		String noteAndOctave;
		String note;
		String octave;
		String length;
		
		RagaList ragaList= new RagaList();
		String raga = "mayamalavagaula";
		
		String[] ragaNoteList = ragaList.getRagaNotes(raga);
		
		String S = ragaNoteList[0];
		String R = ragaNoteList[1];
		String G = ragaNoteList[2];
		String M = ragaNoteList[3];
		String P = ragaNoteList[4];
		String D = ragaNoteList[5];
		String N = ragaNoteList[6];
		
		float s = ragaList.getNoteFreq(S, 1);
		float r = ragaList.getNoteFreq(R, 1);
		float g = ragaList.getNoteFreq(G, 1);
		float m = ragaList.getNoteFreq(M, 1);
		float p = ragaList.getNoteFreq(P, 1);
		float d = ragaList.getNoteFreq(D, 1);
		float n = ragaList.getNoteFreq(N, 1);
		float n0 = ragaList.getNoteFreq(N, 0);
				
		// print whole stream (just to debug)
		/*
		for (int i=0; i<songStreamLength; i++) {
			String element = songStream.get(i);
			System.out.println("Element " + element);
		}
		*/
		
		// play the file
		float[][] songLine;
		
		for (int i=0; i<songStreamArrayLength; i++) {
			
			note   = songStreamArray.get(i)[0];
			octave = songStreamArray.get(i)[0];
			length = songStreamArray.get(i)[0];
		}
		
	}
	
}