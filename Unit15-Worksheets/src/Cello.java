public class Cello extends Instrument{
	private double size;
	
	public Cello(){
		super();
		size = 0;
	}
	
	public Cello(String type) {
		super(type);
		size = 0;
	}
	
	public Cello(int s) {
		super();
		size = s;
	}
	public String playString() {
		return "string";
	}
	public Cello (String type, int s) {
		super(type);
		size = s;
	}
	
	public String toString() {
		return super.toString() + " " +  size;
	}
}