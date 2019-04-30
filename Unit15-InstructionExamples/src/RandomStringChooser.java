public class RandomStringChooser{
	private String[] stringArray;
	public RandomStringChooser(String[] s){
		stringArray = s;
	}
	
	public String getNext() {
		if (stringArray.length == 0) {
			return "NONE";
		}
		else {
			String[] copy = stringArray;
			int rand = (int)(Math.random() * stringArray.length);
			String s = stringArray[rand];
			stringArray = new String[stringArray.length-1];
			int count = 0;
			for(int i = 0; i < copy.length; i++) {
				if (!copy[i].equals(s)) {
					stringArray[count] = copy[i];
					count++;
				}
			}
			return s;
		}
	}
}