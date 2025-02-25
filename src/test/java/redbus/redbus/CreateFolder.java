package redbus.redbus;

import java.io.File;

public class CreateFolder {

	
	
	
	public static void foldercreation(String folderpath) {
		
		File folder = new File (folderpath );
		if (!folder.exists()) {
			folder.mkdir();
			System.out.println("folder created" + folderpath );
		}
		else
		{System.out.println("mmm");
		}
		
	}
	
	public static void	delete (String folderpath) {
		File folder = new File (folderpath );
	if (folder.exists()){
		folder.delete();
	}
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String folderpath = "E:\\mmmg";
		foldercreation( folderpath);
		boolean folderexist = checkiffolderexist ( folderpath);
		System.out.println(folderexist); 
		delete ( folderpath);
		boolean folderexist2 = checkiffolderexist ( folderpath);
		System.out.println(folderexist2); 
	}
	
	
	
	
	public static boolean checkiffolderexist (String folderpath) {
		
		File folder = new File (folderpath );
		return folder.exists();

	}
}
