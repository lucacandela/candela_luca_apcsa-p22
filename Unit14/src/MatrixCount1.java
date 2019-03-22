//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class MatrixCount1
{
    private static int[][] m = {{ 1, 2, 3, 4, 5},
    										{ 6, 7, 8, 9, 0},
    										{ 6, 7, 1, 2, 5},
    										{ 6, 7, 8, 9, 0},
    										{ 5, 4, 3, 2, 1}};
    
    public static int count( int val  )
    {
		int count = 0;
		for (int i = 0; i < m.length; i++) {
			for (int s = 0; i < m[i].length; s++) {
				if (m[i][s] == val)
					count++;
			}
		}
		return count;
    }
    
    public String toString() {
    	String out = "Matrix Values:\n";
    	for (int i = 0; i < m.length; i++) {
    		for (int s = 0; i < m[i].length; i++) {
    			out += m[i][s] + " ";
    		}
    		out +="\n";
    	}
    	return out;
    }
}
