//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;

public class TotalRow
{
    public static List<Integer> getRowTotals( int[][] m )
    {
    	List<Integer> total = new ArrayList<Integer>();
    	int count = 0;
    	for (int x = 0; x < m.length; x++) {
    		for (int y = 0; y < m[x].length; y++) {
    			count += m[x][y];
    		}
    		total.add(count);
    		count = 0;
    	}
		return total;
    }
}
