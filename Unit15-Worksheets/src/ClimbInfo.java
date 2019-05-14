public class ClimbInfo {
	private String peak;
	private int time;
	public ClimbInfo(String peakName, int climbTime) {
		peak = peakName;
		time = climbTime;
	}
	
	public String getName() {
		return peak;
	}
	
	public int getTime() {
		return time;
	}
}