import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Firstmenu {
	String key, path;
	String[] filename,foldersname;
	public String firstmenu()
	{
		
		boolean repeat = true;
		while (repeat) {
			Firstmenu fi = new Firstmenu();
			fi.firstDisplay();
			Scanner sc = new Scanner(System.in);
			key = sc.nextLine();
			switch (key) {			
			case "1": 	fi.allFileNames();						
						break;				
			
			case "2": 	repeat = false;
						break;
				
			case "3": 	System.out.println("Thank you for using the application");
						repeat = false;				
						break;
			default: 	System.out.println("Please enter the correct option");						
						break;
			}			
		}		
		return key;
	}
	
	
	public void firstDisplay() 
	{
		System.out.println("******************************************");
		System.out.println("\t Welcome to Lockers.com");
		System.out.println("\t Developed by Jagadeesg D S");
		System.out.println("******************************************");
		System.out.println("\t\t1. Display all the files");
		System.out.println("\t\t2. More opetion");
		System.out.println("\t\t3. Close Application");
		System.out.println("\t Enter your option");

	}
	
	public void allFileNames()
	{
		try {
			List<String> fil = new ArrayList<>();
			path = "F:\\Lockers\\";
			File f = new File(path);
			foldersname = f.list();
			for(var t:foldersname)
			{
				path = "F:\\Lockers\\"+t;
				File files = new File(path);
				filename = files.list();
				for (var st : filename) {
					fil.add(st);
				}			
			}
			Collections.sort(fil, String.CASE_INSENSITIVE_ORDER);
			for (var tval : fil) {
				System.out.println(tval);
			}
			
		} catch (Exception e) {
			System.out.println("Somthing went wrong...");
		}
		
		
	}
	
	

}
