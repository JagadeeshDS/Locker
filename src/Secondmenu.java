import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Secondmenu {
	boolean a = false;
	boolean repeat = true;
	String key,filename,path;
	Scanner sc = new Scanner(System.in);
	public String secondMenu()
	{
		
		while (repeat) {
			Secondmenu se = new Secondmenu();
			se.secondaryDisplay();
			Scanner sc = new Scanner(System.in);
			key = sc.nextLine();
			
			switch (key) {
			
			case "1": 	se.addfile();						
						break;
				
			case "2": 	se.deleteFile();					  
						break;
			
			case "3": 	se.userFileSearch();						
						break;
				
			case "4": 	se.creatFolder();						
						break;
			
			case "5": 	repeat = false;			
						break;

			default: 	System.out.println("Please enter the correct option");
						break;
			}
		
		}
		
		return key;
	}
	
	public void secondaryDisplay()
	{
		System.out.println("******************************************");
		System.out.println("\t More option");
		System.out.println("******************************************");
		System.out.println("\t\t1. Add file");
		System.out.println("\t\t2. Delete file");
		System.out.println("\t\t3. Search file");
		System.out.println("\t\t4. Creat User");
		System.out.println("\t\t5. Back");
	
	}
	
	
	public void addfile() 
	{
		try {
			Secondmenu se = new Secondmenu();
			System.out.println("Enter the user name to add files");
			String username = sc.nextLine();
			boolean folder = se.folderExist(username);
			if (!folder) {
				System.out.println("User doesn't exist");
				//dis.secondaryDisplay();
			}
			else {
				
				path = "F:\\Lockers\\"+username+"\\";					
				filename = se.fileName(username);
				path += filename+".txt";
				File f = new File(path);
				if (f.createNewFile()) {
					
					System.out.println("File added successfully");
					//dis.secondaryDisplay();
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("Somthing went wrong...! Please try again later");
		}

	}
	
	
	public void deleteFile()
	{
		try {
			
			Secondmenu se = new Secondmenu();
			System.out.println("Enter the user name to delete files");
			String username = sc.nextLine();
			boolean folder = se.folderExist(username);
			if (!folder) {
				System.out.println("User doesn't exist");
			}
			else
			{
				path = "F:\\Lockers\\";
				System.out.println("Enter the file name to delete");
				filename = sc.nextLine();
				path = "F:\\Lockers\\"+username+"\\";
				path += filename+".txt";
				File f = new File(path);
				if(f.delete())
				{
					System.out.println("File deleted successfully");
				}
				else
				{
					System.out.println("File doesn't exist");
				}
			}
			
		} catch (Exception e) {
			System.out.println("Somthing went wrong...! Please try again later");
		}
		
		
		
	}
	
	public void userFileSearch()
	{
		try {
			Secondmenu se = new Secondmenu();
			System.out.println("Enter the user name to search files");
			String username = sc.nextLine();
			boolean folder = se.folderExist(username);
			if (!folder) {
				System.out.println("User doesn't exist");
				//dis.secondaryDisplay();
			}
			else {
				System.out.println("Enter the file name to search files");
				filename = sc.nextLine();
				path = "F:\\Lockers\\"+username+"\\"+filename+".txt";
				File f = new File(path);
				boolean exi = f.exists();
				if (exi) {
					System.out.println("File exit");
				} else {
					System.out.println("File doesn't exit");
				}
			}
			
		} catch (Exception e) {
			System.out.println("Somthing went wrong...! Please try again later");
		}
		
		
	}
	
	
	public void creatFolder()
	{
		try {
			Secondmenu se = new Secondmenu();
			System.out.println("Enter the user name");
			String username = sc.nextLine();
			boolean folder = se.folderExist(username);
			if (folder) {
				System.out.println("User already exist");
			}
			else {
				File g = new File("F:\\Lockers\\"+username);
				Boolean df = g.mkdir();
				if (df) {
					System.out.println("User Created");
				}
				else
				{
					System.out.println("User Not created");
				}
			}
		} catch (Exception e) {
			System.out.println("Somthing went wrong...! Please try again later");
		}
		
	}
	
	
	//Checking the file name exist or not, If not exist return file name
		public String fileName(String username)
		{
			try {
				System.out.println("Enter the file name");
				while(!a)
				{
					System.out.println("File name should alphabet only");
					filename = sc.nextLine();
					a = Pattern.matches("^[a-zA-Z]+$", filename);
					if (a) {
						path = "F:\\Lockers\\"+username;
						File f = new File(path);  
						for(var file: f.listFiles())
						{
							String name  = file.getName();
							if(filename.equals(name.substring(0, name.lastIndexOf('.'))))
							{
								System.out.println("File name already exit");
								a = false;
								break;
							}
							
						}
						
					}
					
				}
			} 
			catch (Exception e) {
				System.out.println("Somthing went wrong...! When entering file name");
			}
			return filename;
		}
		
		
		public boolean folderExist(String name)
		{
			File g = new File("F:\\Lockers\\");
			String ll[] = g.list();
			for (String naam : ll) {
				if (naam.equalsIgnoreCase(name)) 
				{
					return true;
				}
			}
			
			return false;
		}
	
	
}
