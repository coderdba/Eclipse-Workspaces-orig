package com.gm.music;

import java.util.List;

public class PlaySongFile {

	public static void main(String[] args) throws Exception {
		
		SongFileReaderPlayer songFileReaderPlayer = new SongFileReaderPlayer("sarimagari.txt", "mayamalavagaula");
		
		songFileReaderPlayer.playSong();
	}
	
}