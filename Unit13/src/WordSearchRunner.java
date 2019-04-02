//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class WordSearchRunner
{
    public static void main(String[] args) throws Exception
    {
    	  WordSearch ms = new WordSearch(8,		"APPLEXYP"
    	  									+ 	"XLHJKEED"
    	  									+ 	"EGGLMXXC"
    	  									+ 	"HFPUGOGN"
    	  									+ 	"IYGEAHUU"
    	  									+ 	"PUMDGBTS"
    	  									+ 	"PTHIGHMS"
    	  									+ 	"OLKXLTHIS");
    	  String[] words = "APPLE AXE APEX CAT HEX EGG HAT GEM GUM THIS TUG THIGH HIPPO".split(" ");
    	  System.out.println( ms );
    	  for( String s : words )
    	  {
    	  	  if( ms.isFound( s) )
    	  	  {
    	  	  	  System.out.println( s + " was found in the matrix.");
    	  	  }
    	  	  else
    	  	  {
    	  	     System.out.println( s + " was not found in the matrix.");
    	  	  }
    	  }
    }
}
