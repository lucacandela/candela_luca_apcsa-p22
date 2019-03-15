//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	//add two instance variables
	int numerator;
	int denominator;
	
	int newNum;
	int newDenom;

	//write two constructors
	public Rational() {
		setNumerator(1);
		setDenominator(1);
	}
	
	public Rational(int num1, int num2) {
		setNumerator(num1);
		setDenominator(num2);
	}
	//write a setRational method
	public void setRational() {
	
	}

	//write  a set method for numerator and denominator
	public void setNumerator(int num) {
		numerator = num;
	}
	public void setDenominator(int num) {
		denominator = num;
	}
	public void add(Rational  other)
	{
		//num1/den1 + num2/den2 
		//new numerator = (num1 * den2 + num2 * den1)
		//new denominator = (den1 * den2)
		numerator = ((this.getNumerator() * other.getDenominator()) + (other.getNumerator() * this.getDenominator()));
		denominator = (this.getDenominator() * other.getDenominator());


		reduce();
	}

	private void reduce()
	{

		int gcd = gcd(numerator, denominator);
		
		numerator = (this.getNumerator() / gcd);
		denominator = (this.getDenominator() / gcd);
		

	}

	private int gcd(int numOne, int numTwo)
	{
		if (numOne == 0 || numTwo == 0) return numOne + numTwo;

		return gcd(numTwo, numOne%numTwo);
	}

	public Object clone ()
	{
		return "";
	}


	//ACCESSORS

	//write get methods for numerator and denominator
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public boolean equals( Object obj)
	{
		if(obj.equals(this))
			return true;
		return false;
	}

	public int compareTo(Rational other)
	{


		return -1;
	}



	
	//write  toString() method
	public String toString() {
		String output = numerator + "/" + denominator;
		return output;
		
	}
	
}