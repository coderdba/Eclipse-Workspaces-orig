package com.gm.music;

import com.gm.music.NotesList;

public class SariMaaGariPlay {
	
	static String raga = "mayamalavagaula";
	//static String raga = "shankarabharana";
	
	static float s2  = NotesList.s[1];
	static float r12 = NotesList.r1[1];
	static float g32 = NotesList.g3[1];
	static float m12 = NotesList.m1[1];
	static float p2  = NotesList.p[1];
	static float d12 = NotesList.d1[1];
	static float n32 = NotesList.n3[1];
	static float s3  = NotesList.s[2];
	
	public static void main(String[] args) throws Exception {
		
		RagaList ragaList= new RagaList();
		
		String[] ragaNoteList = ragaList.getRagaNotes(raga);
		
		String S = ragaNoteList[0];
		String R = ragaNoteList[1];
		String G = ragaNoteList[2];
		String M = ragaNoteList[3];
		String P = ragaNoteList[4];
		String D = ragaNoteList[5];
		String N = ragaNoteList[6];
		
		float s = ragaList.getNoteFreq(S, 0);
		float r = ragaList.getNoteFreq(R, 0);
		float g = ragaList.getNoteFreq(G, 0);
		float m = ragaList.getNoteFreq(M, 0);
		float p = ragaList.getNoteFreq(P, 0);
		float d = ragaList.getNoteFreq(D, 0);
		float n = ragaList.getNoteFreq(N, 0);
		
		Tone2 myTone = new Tone2();
		
		System.out.println ("The class is " + myTone.getClass().getName());
		System.out.println (myTone.toString());
		
		//myTone.playOneNoteOneSecond(100, 150);
		
		/*
		System.out.println("Playing once");
		
		float[][] songLine1 = { 
				 {s2, 0.5f}, {r12, 0.5f}, {m12, 1.0f}, {g32, 0.5f}, {r12, 0.5f},
				{s2, 0.5f}, {r12, 0.5f}, {g32, 0.5f}, {r12, 0.5f}, {s2, 1.0f},
				{r12, 0.5f}, {m12, 0.5f}, {p2, 0.5f}, {d12, 0.5f}, {m12, 0.5f}, {p2, 0.5f},
				{d12, 0.5f}, {p2, 0.5f}, {m12, 0.5f}, {g32, 0.5f}, {r12, 0.5f}, {s2, 0.5f},
				{s2, 0.5f}, {r12, 0.5f}, {m12, 1.0f}, {g32, 0.5f}, {r12, 0.5f}
				,{s2, 0.5f}, {r12, 0.5f}, {g32, 0.5f}, {r12, 0.5f}, {s2, 1.0f}};

        myTone.playNoteList(songLine1, 70);
        */
		
        System.out.println("Playing again");
        
		float[][] songLine2 = { 
				 {s, 0.5f}, {r, 0.5f}, {m, 1.0f}, {g, 0.5f}, {r, 0.5f},
				{s, 0.5f}, {r, 0.5f}, {g, 0.5f}, {r, 0.5f}, {s, 1.0f},
				{r, 0.5f}, {m, 0.5f}, {p, 0.5f}, {d, 0.5f}, {m, 0.5f}, {p, 0.5f},
				{d, 0.5f}, {p, 0.5f}, {m, 0.5f}, {g, 0.5f}, {r, 0.5f}, {s, 0.5f},
				{s, 0.5f}, {r, 0.5f}, {m, 1.0f}, {g, 0.5f}, {r, 0.5f}
				,{s, 0.5f}, {r, 0.5f}, {g, 0.5f}, {r, 0.5f}, {s, 1.0f}};

       myTone.playNoteList(songLine2, 70);
		
	}


}