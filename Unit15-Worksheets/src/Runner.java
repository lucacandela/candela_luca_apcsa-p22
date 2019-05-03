

public class Runner {

	public static void main(String[] args) {
	Instrument i = new Instrument();
	System.out.println(i);
	
	i = new Cello();

	
	Cello c = new Cello("Cello", 3);

	Instrument[] x = new Instrument[2];
	x[0] = i;
	x[1] = c;
	

	Cello[] cellos = new Cello[2];
	cellos[0] = c;
	cellos[1] = (Cello)i;
	
	for (Instrument ins : x) {
		System.out.println(ins);
	}
	}
}