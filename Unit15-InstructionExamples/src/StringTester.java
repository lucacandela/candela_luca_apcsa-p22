public class StringTester{
	public static void main(String[] args) {
		String[] s = {"wheels","on","the","bus"};
		RandomStringChooser rs = new RandomStringChooser(s);
		for(int i = 0; i < 20; i++) {
			System.out.print((int)(Math.random() * 10) + " ");
		}
	}
}