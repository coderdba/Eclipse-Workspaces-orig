package com.gm.music;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.AbstractMap;
import java.util.ArrayList;

public class RagaList {
	
	
	private  String[] mayamalavagaula = {"s","r1","g3","m1","p","d1","n3"};	
	private  String[] shankarabharana = {"s","r2","g3","m1","p","d1","n3"};	
	
	HashMap<String, String[]> ragaList = new HashMap<String, String[]>();
	
	public RagaList() {
		ragaList.put("mayamalavagaula", mayamalavagaula);
		ragaList.put("shankarabharana", shankarabharana);
	}
	
	public String[] getRagaNotes (String ragaName) {
		
	return ragaList.get(ragaName);
		
	}
}

