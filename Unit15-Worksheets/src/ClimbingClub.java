import java.util.ArrayList;
import java.util.List;

public class ClimbingClub{
	private List<ClimbInfo> climbList;
	public ClimbingClub() {
		climbList = new ArrayList<ClimbInfo>();
		addNoOrder("Algonquin",225);
		addNoOrder("Monadnock",237);
		addNoOrder("Monadnock",344);
		addNoOrder("Whiteface",301);
	}
	
	
	public void addNoOrder(String peakName, int time) {
		climbList.add(new ClimbInfo(peakName,time));
	}
	
	public void addAlpha(String peakName, int time) {
		int index = 0;
		for (int i = 0; i < climbList.size(); i++) {
			if (peakName.compareTo(climbList.get(i).getName()) > 0) {
				index = i;
			}
		}
		climbList.add(index,new ClimbInfo(peakName,time));
	}
	public String toString() {
		String out = "";
		for (ClimbInfo  climb : climbList) {
			out+= climb.getName() + " " + climb.getTime() + ", ";
		}
		return out;
	}
}