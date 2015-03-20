package com.cttbj;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileCounter 
{

	public static Result countTarget(String filename,String target) throws FileNotFoundException, IOException
	{
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer strb = new StringBuffer();
		Result result = new Result();
		float count = 0;
		float total = 0;
		while(true)
		{
			String line = br.readLine();		
			if (line == null)
			{
				break;
			}
			strb.append(line);
			total++;
		}
		br.close();			
		String str = strb.toString();
		int index = 0;
	    while(true)
	    {
	    	index = str.indexOf(target, index + 1);
	    	if(index > 0)
	    	{
	    		count++;
	    	}
	    	else
	    	{
	    		break;
	    	}
	    }
	    result.setCount(count);
	    result.setTotal(total); 
		return result;	
	}

}
