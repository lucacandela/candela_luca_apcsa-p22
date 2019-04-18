

public class Runner {

	public static void main(String[] args) {
	Instrument i = new Instrument();
	System.out.println(i);
	
	i = new Cello();
	System.out.println(i);
	
	Cello c = new Cello("Cello", 3);
	System.out.println(c);
	}
}