package com.gm.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestSomething {
	
	public static void main(String[] args) throws Exception {
		
		RagaList ragaList= new RagaList();
		System.out.println(ragaList.h.get("PID")[0]); //prints "3"
        System.out.println(ragaList.h.get("PID")[1]); //prints "5"
        
    	List<String> arrayList = new ArrayList<String>();
    	
    	
    	HashMap<String, String[]> map1 = new HashMap<String, String[]>();
    	
    	map1.put("abc", new String[] {"abc","pqr"});
    	
    	//arrayList.add(e);
	}

}
