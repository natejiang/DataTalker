package com.cttbj;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SortMap {  
	
    public static void printMap(Map<String,Float> map){  
        System.out.println("===================Start==================");  
        Iterator<Entry<String, Float>> it = map.entrySet().iterator();  
        while(it.hasNext()){  
            Map.Entry<String,Float> entry = (Map.Entry<String,Float>) it.next(); 
            System.out.println(entry.getKey() + ":" + entry.getValue());  
        }  
        System.out.println("====================End===================");  
    }   
    
    public static void printMapPlus(Map<String,Float> map,Result result){  
        System.out.println("===================Start=================="); 
        System.out.println("total:" + result.getTotal());
        Iterator<Entry<String, Float>> it = map.entrySet().iterator();  
        while(it.hasNext()){  
            Map.Entry<String,Float> entry = (Map.Entry<String,Float>) it.next(); 
            NumberFormat nt = NumberFormat.getPercentInstance(); 
			nt.setMinimumFractionDigits(2); 	
            System.out.println(entry.getKey() + ":" + entry.getValue() +"  "+ nt.format(entry.getValue()/result.getTotal()));  
        }  
        System.out.println("====================End===================");  
    }   

    public static Map<String,Float> sortMap(Map<String,Float> oldMap) {  
        ArrayList<Map.Entry<String, Float>> list = new ArrayList<Map.Entry<String, Float>>(oldMap.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Float>>() {  
  
            @Override  
            public int compare(Entry<java.lang.String, Float> arg0,  
                    Entry<java.lang.String, Float> arg1) {  
                return (int) (arg1.getValue() - arg0.getValue());  
            }  
        });  
        Map<String,Float> newMap = new LinkedHashMap<String,Float>();  
        for (int i = 0; i < list.size(); i++) {  
            newMap.put(list.get(i).getKey(), list.get(i).getValue());  
        }  
        return newMap;  
    }  
} 
