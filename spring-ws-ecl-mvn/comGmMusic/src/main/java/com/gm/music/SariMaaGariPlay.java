package com.gm.music;

import com.gm.music.NotesList;

public class SariMaaGariPlay {
	
	static String raga = "mayamalavagaula";
	
	/*
	static float s2  = NotesList.s[1];
	static float r21 = NotesList.r1[1];
	static float g23 = NotesList.g3[1];
	static float m21 = NotesList.m1[1];
	static float p2  = NotesList.p[1];
	static float d21 = NotesList.d1[1];
	static float n23 = NotesList.n3[1];
	static float s3  = NotesList.s[2];
	*/
	
	public static void main(String[] args) throws Exception {
		
		RagaList ragaList= new RagaList();
		
		String[] noteList = ragaList.getRagaNotes(raga);
		
		String ragaS = noteList[0];
		String ragaR = noteList[1];
		String ragaG = noteList[2];
		String ragaM = noteList[3];
		String ragaP = noteList[4];
		String ragaD = noteList[5];
		String ragaN = noteList[6];
		
		float s2  = NotesList.s[1];
	    float r21 = NotesList.r1[1];
		float g23 = NotesList.g3[1];
		float m21 = NotesList.m1[1];
		float p2  = NotesList.p[1];
		float d21 = NotesList.d1[1];
		float n23 = NotesList.n3[1];
		float s3  = NotesList.s[2];
		
		Tone2 myTone = new Tone2();
		
		System.out.println ("The class is " + myTone.getClass().getName());
		System.out.println (myTone.toString());
		
		//myTone.playOneNoteOneSecond(100, 150);
		
		
		float[][] songLine1 = { 
				 {s2, 0.5f}, {r21, 0.5f}, {m21, 1.0f}, {g23, 0.5f}, {r21, 0.5f},
				{s2, 0.5f}, {r21, 0.5f}, {g23, 0.5f}, {r21, 0.5f}, {s2, 1.0f},
				{r21, 0.5f}, {m21, 0.5f}, {p2, 0.5f}, {d21, 0.5f}, {m21, 0.5f}, {p2, 0.5f},
				{d21, 0.5f}, {p2, 0.5f}, {m21, 0.5f}, {g23, 0.5f}, {r21, 0.5f}, {s2, 0.5f},
				{s2, 0.5f}, {r21, 0.5f}, {m21, 1.0f}, {g23, 0.5f}, {r21, 0.5f}
				,{s2, 0.5f}, {r21, 0.5f}, {g23, 0.5f}, {r21, 0.5f}, {s2, 1.0f}};

        myTone.playNoteList(songLine1, 70);
		
	}


}