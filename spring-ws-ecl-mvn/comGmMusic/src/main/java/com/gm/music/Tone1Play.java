package com.gm.music;


public class Tone1Play {
	
	public static void main(String[] args) throws Exception {
		
		Tone1 myTone = new Tone1();
		
		System.out.println(myTone.toString());
		
		myTone.playOneNote(100, 150);
		
		 /*
		 createTone(261, 100); // c4 sa 
		 createTone(277, 100); // c#4 ri1
		 createTone(329, 100); // e g3
		 createTone(349, 100); // f m1
		 createTone(392, 100); // g p
		 createTone(415, 100); // g# d1
		 createTone(494, 100); // b n3
		 createTone(523, 100); // c5 s
		 */
		
		int[] songLine1 = {261,277,329,349,392,415,494,523};
		myTone.playNoteList(songLine1, 100);
	}


}
