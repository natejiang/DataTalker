package com.cttbj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataTalker {

	public static void main(String[] args) {

		FileReader fr;
		Result result = null;
		Map<String,Float> map = new LinkedHashMap<String,Float>();
		try 
		{
			fr = new FileReader("/data/targets.txt"); //读取搜索字段
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			while (true)
			{
				String line;
				line = br.readLine();
				if (line == null)
				{
					break;
				}				
				result = FileCounter.countTarget("/data/data.txt",line); //读取分析数据
				map.put(line, result.getCount());
			}  
			br.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map = SortMap.sortMap(map);
		SortMap.printMapPlus(map,result);		 
	}
	
}
