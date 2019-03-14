//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		pups = new Dog[size];
		
	}
	
	public void set(int spot, int age, String name)
	{
		//put a new Dog in the array at spot 
		//make sure spot is in bounds
		if (!(spot > pups.length)) {
			pups[spot] = new Dog(age,name);
		}
	}

	public String getNameOfOldest()
	{
		int oldestAge = -1;
		String oldestPup = "";
		for (int i = 0; i < pups.length; i++) {
			if (pups[i].getAge() > oldestAge)
				oldestAge = pups[i].getAge();
				oldestPup = pups[i].getName();
		}
		if (!(oldestPup.equals("")))
			return oldestPup;
		else
			return null;
	}

	public String getNameOfYoungest()
	{
		int youngestAge = 999;
		String youngestPup = "";
		
		for(int i = 0; i < pups.length; i++) {
			if(pups[i].getAge()< youngestAge){
				youngestAge = pups[i].getAge();
				youngestPup = pups[i].getName();
			}
		}
		
		return youngestPup;
	}

	public String toString()
	{
		return ""+Arrays.toString(pups);
	}
}