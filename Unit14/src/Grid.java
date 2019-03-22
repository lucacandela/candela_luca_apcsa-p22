//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Grid
{
   private String[][] grid;
   private String[] values;
   private int rLength;
   private int cLength;
   //load vals into the rows x cols grid randomly
	public Grid(int rows, int cols, String[] vals)
	{
		rLength = rows;
		cLength = cols;
		grid = new String[rLength][cLength];
		values = vals;
		
		
		int rand;
		
		for (int i = 0; i < rLength; i++) {
			for (int x = 0; x < cLength; x++) {
				rand = (int)(Math.random() * vals.length);
				grid[i][x] = vals[rand] ;
			}
		}
	}
	public String[] values() {
		return values;
	}
	//find out which of the vals occurs the most
	public String findMax(String[] vals)
	{
		String out = "";
		int count = 0;
		int highest = 0;
		String most = "";
		for (int i = 0; i < vals.length; i++) {
			count = countVals(vals[i]);
			if (count > highest) {
				highest = count;
				most = vals[i];
				
			}
			out += vals[i] + " count is " + count + "\n";
		}
		if (highest == 0)
			return "nothing yet";
		out += "\n" + most + " occurs the most at " + highest + " times.";
		return out;
		
	}

	//returns a count of how many times val occurs in the matrix
	private int countVals( String val )
	{
		int count = 0;
		for (int i = 0; i < rLength; i++) {
			for (int x = 0; x < cLength; x++) {
				if(grid[i][x].equals(val)) {
					count++;
				}
			}
		}
		return count;
	}

	//display the grid
	public String toString()
	{
		String output="";
		for (int i = 0; i < rLength; i++) {
			for (int x  = 0; x < cLength; x++) {
				output += grid[i][x] + " ";
			}
			output += "\n";
		}
		return output;
	}
}