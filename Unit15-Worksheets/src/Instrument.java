public class Instrument{
	private String type;
	
	public Instrument() {
		type = "Marimba";
	}
	
	public Instrument(String t) {
		type = t;
	}
	
	public String toString() {
		return type + "\n";
	}
}