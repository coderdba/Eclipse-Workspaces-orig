package com.gm.music;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Tone1 {

	String toneName;

	public Tone1() {
		toneName = "piano";
	}

	public String toString() {
		return "this is a " + toneName;
	}

	public void playOneNote (int Hertz, int volume) throws Exception {
		playOneSecond (Hertz, volume);
	}
	
	public void playNoteListOneSecond (int[] notesHertz, int volume) throws Exception {
		
		int i = 0;
		
		System.out.println("There are " + notesHertz.length + " notes to play.");
		
		while (i < notesHertz.length) {
			
	    System.out.println("Playing " + notesHertz[i]);
		playOneSecond (notesHertz[i], volume);
		
		i++;
		
		}
	}
	
	public void playNoteList (int[] notesHertz, int volume, float lengthSeconds) throws Exception {
		
		int i = 0;
		
		System.out.println("There are " + notesHertz.length + " notes to play.");
		
		while (i < notesHertz.length) {
			
	    System.out.println("Playing " + notesHertz[i]);
		play (notesHertz[i], volume, lengthSeconds);
		
		i++;
		
		}
	}
	
	public void playNoteList (float[][] notes, int volume) throws Exception {
		
		int i = 0;
		
		System.out.println("There are " + notes.length + " notes to play.");
		
		while (i < notes.length) {
			
	    System.out.println("Playing " + notes[i][0] + " for " + notes[i][1] + " seconds.");
		play ((int)notes[i][0], volume, notes[i][1]);
		
		i++;
		
		}
	}
	
	private void playOneSecond (int Hertz, int volume) throws LineUnavailableException {
		/** Exception is thrown when line cannot be opened */
				
	    float rate = 44100;
	    float lengthAsRate = rate;
	    byte[] buf;
	    AudioFormat audioF;
				 
		buf = new byte[1];
		audioF = new AudioFormat(rate,8,1,true,false);  //sampleRate, sampleSizeInBits,channels,signed,bigEndian
				    
		SourceDataLine sourceDL = AudioSystem.getSourceDataLine(audioF);
		sourceDL = AudioSystem.getSourceDataLine(audioF);
		sourceDL.open(audioF); //orig
		//sourceDL.open(audioF,44100/16);
		sourceDL.start();
				 
		for(int i=0; i<lengthAsRate; i++){

			// https://dsp.stackexchange.com/questions/46598/mathematical-equation-for-the-sound-wave-that-a-piano-makes?rq=1
			// https://www.desmos.com/calculator/v5wrctppk1
			double angle1 = (i/rate)*Hertz*2.0*Math.PI; //new orig
			double angle2 = (((i/rate))*Hertz*2.0 + 2/3)*Math.PI; //new orig
				      
			// additional
			// double angle3 = (((i/rate))*Hertz)*Math.PI;
				      
			//double angle2 = ((i/rate))*Hertz*2.0*Math.PI;
				     
			// sin(pi*x)**3 + sin (pi(x+(2/3)))
			double sinAngle1 = Math.sin(angle1);
			double cosAngle1 = Math.cos(angle1);
				      
			//buf[0] = (byte)((Math.pow(sinAngle1, 3) + Math.sin(angle2)) * volume); // new orig
			//buf[0] = (byte)((Math.pow(cosAngle1, 3) + Math.pow(sinAngle1, 3) + Math.sin(angle2)) * volume); // new orig
			//buf[0] = (byte)((Math.pow(sinAngle1, 3) + Math.sin(angle2) + Math.sin(angle3)) * volume);
			buf[0] = (byte)((Math.pow(cosAngle1,106) + Math.sin(angle2)) * volume); //good
				      
			sourceDL.write(buf,0,1);
				     
			}
				 
			sourceDL.drain();
			sourceDL.stop();
			sourceDL.close();
				  
	 }
	
	private void play (int Hertz, int volume, float lengthSeconds) throws LineUnavailableException {
		/** Exception is thrown when line cannot be opened */
				
		float rate=44100;
		float lengthAsRate = Math.round(rate * lengthSeconds);
	    	    
	    byte[] buf;
	    AudioFormat audioF;
				 
		buf = new byte[1];
		audioF = new AudioFormat(rate,8,1,true,false);  //sampleRate, sampleSizeInBits,channels,signed,bigEndian
				    
		SourceDataLine sourceDL = AudioSystem.getSourceDataLine(audioF);
		sourceDL = AudioSystem.getSourceDataLine(audioF);
		sourceDL.open(audioF); //orig
		//sourceDL.open(audioF,44100/16);
		sourceDL.start();
				 
		for(int i=0; i<lengthAsRate; i++){

			// https://dsp.stackexchange.com/questions/46598/mathematical-equation-for-the-sound-wave-that-a-piano-makes?rq=1
			// https://www.desmos.com/calculator/v5wrctppk1
			double angle1 = (i/rate)*Hertz*2.0*Math.PI; //new orig
			double angle2 = (((i/rate))*Hertz*2.0 + 2/3)*Math.PI; //new orig
				      
			// additional
			// double angle3 = (((i/rate))*Hertz)*Math.PI;
				      
			//double angle2 = ((i/rate))*Hertz*2.0*Math.PI;
				     
			// sin(pi*x)**3 + sin (pi(x+(2/3)))
			double sinAngle1 = Math.sin(angle1);
			double cosAngle1 = Math.cos(angle1);
				      
			//buf[0] = (byte)((Math.pow(sinAngle1, 3) + Math.sin(angle2)) * volume); // new orig
			//buf[0] = (byte)((Math.pow(cosAngle1, 3) + Math.pow(sinAngle1, 3) + Math.sin(angle2)) * volume); // new orig
			//buf[0] = (byte)((Math.pow(sinAngle1, 3) + Math.sin(angle2) + Math.sin(angle3)) * volume);
			buf[0] = (byte)((Math.pow(cosAngle1,106) + Math.sin(angle2)) * volume); //good
				      

			sourceDL.write(buf,0,1);
				     
			}
				 
			sourceDL.drain();
			sourceDL.stop();
			sourceDL.close();	  
	 }
}
