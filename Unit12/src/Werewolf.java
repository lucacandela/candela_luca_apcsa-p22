import static java.lang.System.*;

public class Werewolf implements Monster{
	private String name;
	private int size;

	public Werewolf() {
		name = "";
		size = 0;
	}
	
	public Werewolf(String n) {
		name = n;
		size = 0;
	}
	public Werewolf(int s) {
		name = "";
		size = s;
	}
	
	public Werewolf(String n, int s) {
		name = n;
		size = s;
	}
	
	public int getHowBig() {
		return size;
	}
	public String getName() {
		return name;
	}
	
	public boolean isBigger(Monster obj) {
		if(getHowBig() > obj.getHowBig())
			return true;
		return false;
	}
	
	public boolean isSmaller(Monster obj) {
		if (getHowBig() < obj.getHowBig()) {
			return true;
		}
		return false;
	}
	
	public boolean namesTheSame(Monster obj) {
		if(getName().equals(obj.getName())) {
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		return "" + getName() + " " + getHowBig();
	}
}