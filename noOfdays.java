

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
    public static int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public static boolean leapYear(int year)
    {
        if(year % 400 == 0)
        return true;
        
        if(year % 100 == 0)
        return false;
        
        if(year % 4 == 0)
        return true;
        
        return false;
    }
    public static int spentDays(int d, int m, int y)
    {
        int ds = d;
        
        if(m > 2 && leapYear(y))
        ds++;
        
        for(int i = 0; i < m-1; i++)
        {
            ds += days[i];
        }
        
        return ds;
    }
    
    public static int getDays(int y1, int spent1, int y2, int spent2)
    {
        if(y1 == y2)
        return Math.abs(spent1 - spent2);
        
        int rem1 = leapYear(y1)? 366 - spent1: 365 - spent1;
		    
		 for(int i = y1+1; i < y2; i++)
		 {
	       rem1 = leapYear(i)? rem1 + 366: rem1 + 365;
    	 }
    	 
    	return rem1 + spent2;
    }
	public static void main (String[] args) throws IOException
	{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String[] date1 = br.readLine().split(" ");
		    String[] date2 = br.readLine().split(" ");
		    int d1, m1, y1, d2, m2, y2;
		    
		    if(Integer.parseInt(date1[2]) < Integer.parseInt(date2[2]))
		    {
    		    d1 = Integer.parseInt(date1[0]);
    		    m1 = Integer.parseInt(date1[1]);
    		    y1 = Integer.parseInt(date1[2]);
    		    
    		    d2 = Integer.parseInt(date2[0]);
    		    m2 = Integer.parseInt(date2[1]);
    		    y2 = Integer.parseInt(date2[2]);
		    }
		    
		    else
		    {
		        d2 = Integer.parseInt(date1[0]);
    		    m2 = Integer.parseInt(date1[1]);
    		    y2 = Integer.parseInt(date1[2]);
    		    
    		    d1 = Integer.parseInt(date2[0]);
    		    m1 = Integer.parseInt(date2[1]);
    		    y1 = Integer.parseInt(date2[2]);
		    }

		    int spent1 = spentDays(d1, m1, y1);
		    int spent2 = spentDays(d2, m2, y2);
		    
		    System.out.println(getDays(y1, spent1, y2, spent2));
		  
		}
	}
}