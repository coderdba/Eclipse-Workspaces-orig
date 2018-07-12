package com.gm.music;

public class PlaySong {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SongFilePlayer songFilePlayer = new SongFilePlayer("sarimagari.txt", "mayamalavagaula");
		
		songFilePlayer.playSong();

	}

}
