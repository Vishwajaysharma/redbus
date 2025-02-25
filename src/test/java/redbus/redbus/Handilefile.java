package redbus.redbus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Handilefile {
//create a file if not exist
	public static void createFile (String filepath) {
		 File obj1 = new File(filepath);
		 
		 try {
			if (obj1.createNewFile())
			{
				 System.out.println("file created "+ filepath);
				 
			 }
			else 
			 {
				
				System.out.println("file alrady exist"+ filepath); 
				
			 }
			
		} 
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void writefile (String filepath) {
		FileWriter myWeiter;
		try {
			myWeiter = new  FileWriter(filepath);
			myWeiter.write("welcome to java file ");
			myWeiter.close();
			System.out.println("done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("errtoer");
			e.printStackTrace();
		}
		
		
	}
	public static void readfile (String filepath) {
		
		File obj1 = new File(filepath);
		Scanner myReader;
		
			try {
				myReader = new Scanner(obj1);
			
		while (myReader.hasNextLine()) {
			String data= myReader.nextLine();
			System.out.println(data);
		}
		myReader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filepath	=  "C:\\fgg\\myfi4e.txt"	;
		String filepath2	=  "C:\\fgg\\myfile.txt"	;
		createFile (filepath );
		writefile(filepath);
		readfile( filepath);
		rename (filepath, filepath2);
		delete ( filepath);
	}
	
	
	public static void rename (String oldpath, String newpath) {
		
		File  oldname	=  new File(oldpath);
		File  newname	=  new File(newpath);
		oldname.renameTo(newname);
		if(oldname.renameTo(newname))
		{
		System.out.println("file is renamed");
		}
		else {
			System.out.println("file cannotbr renamed");
		}
		
	}
	
	public static void delete (String filepath) {
		
		File obj1 = new File(filepath);
		
		if (obj1.delete()) {
			System.out.println("deleted successfully");
		}
		else
		{
			System.out.println("cant deleted ");
			
		}
		
		
	}
	
	

}
