
public class Main {
	

	public static void main(String[] args) {
		String key;
		boolean mainr = true;
		
		Firstmenu first = new Firstmenu();
		key = first.firstmenu();
		while (mainr) {
		if (key.equals("2")) {
			Secondmenu second = new Secondmenu();
			key = second.secondMenu();
			if (key.equals("5")) {
				key = null;
				key = first.firstmenu();
				if (key.equals("2")) {
					mainr = true;
				}
				else
				{
					mainr = false;
				}
			}		
		}
	}
		
	}
	
}
