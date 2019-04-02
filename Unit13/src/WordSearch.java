//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class WordSearch
{
    private String[][] m;

    public WordSearch( int size, String str )
    {
    	m = new String[size][str.length()/size];
    	int count = 0;
    	for(int i = 0; i < m.length; i++) {
    		for (int x = 0; x < m[i].length; x++) {
    			m[i][x] = str.substring(count, count+1);
    			count++;
    		}
    	}
    	
    }

    public boolean isFound( String word )
    {	for(int r = 0; r < m.length; r++) {
    		for(int c = 0; c < m[r].length; c++) {
 	    		if(checkRight(word,r,c) || checkLeft(word,r,c) || checkUp(word,r,c) || checkDown(word,r,c)
	    			|| checkDiagUpRight(word,r,c) || checkDiagUpLeft(word,r,c)
	    			|| checkDiagDownRight(word,r,c) || checkDiagDownLeft(word,r,c)) {
	    			return true;
	    		}
    		}
    	}
    	return false;
    }

	public boolean checkRight(String w, int r, int c)
   {
		String s = "";
		if((w.length() + c) > m[r].length) {
			return false;
		}
		else {
			for (int i = 0; i < w.length(); i++) {
				s += m[r][c+i]; 
			}
			if(s.equals(w)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkLeft(String w, int r, int c)
	{
		/*String[] forwards = w.split("");
		String backwards = "";
		for(int i = w.length()-1; i >= 0; i--) {
			backwards += forwards[i];
		}*/
		String s = "";
		if((c+1 - w.length()) <= -1) {
			return false;
		}
		for(int i = 0; i < w.length(); i++) {
			s += m[r][c-i];
		}
		if(s.equals(w)) {
			return true;
		}
		
		return false;
	}

	public boolean checkUp(String w, int r, int c)
	{
		String s = "";
		if((r+1 - w.length()) < 0)
			return false;
		else {
			for(int i = 0; i < w.length(); i++) {
				s += m[r-i][c];
			}
			if (s.equals(w))
				return true;
		}
		return false;
	}

	public boolean checkDown(String w, int r, int c)
   {
		String s = "";
		if(r + w.length() > m.length)
			return false;
		for(int i = 0; i < w.length(); i++) {
			s+= m[r+i][c];
		}
		if (s.equals(w))
			return true;
		return false;
   }

	public boolean checkDiagUpRight(String w, int r, int c)
	{
		String s = "";
		if( ((r+1 - w.length()) < 0) || ((w.length() + c) > m[r].length)) {
			return false;
		}
		for(int i = 0; i < w.length(); i++) {
			s+= m[r-i][c+i];
		}
		if(s.equals(w))
			return true;
		return false;
	}

	public boolean checkDiagUpLeft(String w, int r, int c)
	{
		String s = "";
		if( ((r+1 - w.length()) < 0) || ((c+1 - w.length()) <= -1) ) {
			return false;
		}
		for(int i = 0; i < w.length(); i++) {
			s+= m[r-i][c-i];
		}
		if(s.equals(w))
			return true;
		return false;
	}

	public boolean checkDiagDownLeft(String w, int r, int c)
   {	
		String s = "";
		if( (r + w.length() > m.length) || ((c+1 - w.length()) <= -1) ) {
			return false;
		}
		for(int i = 0; i < w.length(); i++) {
			s+=m[r+i][c-i];
		}
		if(s.equals(w)) {
			return true;
		}
		return false;
	}

	public boolean checkDiagDownRight(String w, int r, int c)
	{
		String s = "";
		if( (r + w.length() > m.length) || ((w.length() + c) > m[r].length) ) {
			return false;
		}
		for(int i = 0; i < w.length(); i++) {
			s+= m[r+i][c+i];
		}
		if(s.equals(w))
			return true;
		return false;
	}

    public String toString()
    {
 		String out = "";
 		for(int r = 0; r < m.length; r++) {
 			for(int c = 0; c < m[r].length; c++) {
 				out+=m[r][c] + " ";
 			}
 			out+="\n";
 		}
 		
 		return out;
    }
}
