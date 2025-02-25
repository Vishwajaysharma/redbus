package xslfile.read;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXlfile {
	
	 public static	 FileOutputStream fos;
	 public static	 FileInputStream fis;
	 public static   Workbook workbook;
	 public static   Sheet sheet;
	 public static	 File file;
	 
    public static void main(String[] args) {
    	
    	file = new File( "E:/mummy/datajb.xlsx");

        try {
             fis = new FileInputStream(file);
             workbook = new XSSFWorkbook(fis);
             sheet = workbook.getSheet("people"); 

            if (sheet == null) {
                System.out.println("Sheet not found!");
                
            }

            // Loop through rows 
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            	
            	
                Row row = sheet.getRow(i);
                
                if (row != null) {
                	
                    Cell ageCell = row.getCell(1); // Age column (B)
                    
                    Cell statusCell = row.getCell(2); // Status column (C)

                    
                    if (ageCell != null && ageCell.getCellType() == CellType.NUMERIC) {
                    
                    	int age = (int) ageCell.getNumericCellValue();

                        // Create status cell if it doesn't exist
                        
                    	if (statusCell == null) {
                        
                    		statusCell = row.createCell(2);
                        }

                        // Set Minor/Adult based on age
                        if (age < 18) {
                            
                        	statusCell.setCellValue("Minor");
                        } 
                        else {
                            statusCell.setCellValue("Adult");
                        }
                    }
                }
            }

            fis.close();

            // Save the updated file
            fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();
            workbook.close();

            System.out.println("Excel file updated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error ");
        }
    }
}
