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

	private void playOneNote (int Hertz, int volume) throws Exception {
		play (Hertz, volume);
	}
	
	private void play(int Hertz, int volume) throws LineUnavailableException {
		/** Exception is thrown when line cannot be opened */
				 
	    float rate = 44100;
	    byte[] buf;
	    AudioFormat audioF;
				 
		buf = new byte[1];
		audioF = new AudioFormat(rate,8,1,true,false);  //sampleRate, sampleSizeInBits,channels,signed,bigEndian
				    
		SourceDataLine sourceDL = AudioSystem.getSourceDataLine(audioF);
		sourceDL = AudioSystem.getSourceDataLine(audioF);
		sourceDL.open(audioF); //orig
		//sourceDL.open(audioF,44100/16);
		sourceDL.start();
				 
		for(int i=0; i<rate; i++){

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
