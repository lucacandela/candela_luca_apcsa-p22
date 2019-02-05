//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class Discount
{
	private double billAmt;
	public Discount(double amt) {
		getDiscountedBill(amt);
	}
	
	//getDiscountedBill() will return final amount of the bill
	//			if the bill is >2000, the bill receives a 15% discount
	public void getDiscountedBill(double bill)
	{
		if (bill > 2000) {
			bill*=.85;
		}
		billAmt = bill;
	}
	
	public void printDiscount() {
		out.printf("Bill after discount :: %.2f",billAmt);
	}
}