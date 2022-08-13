package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet2
{
   public static void main(String[] args) throws EncryptedDocumentException, IOException
   {
	  FileInputStream fis=new FileInputStream("./data/Book4.xlsx");
	   Workbook wb = WorkbookFactory.create(fis);
	   Sheet sheet = wb.getSheet("Sheet1");
	   for(int i=0;i<=5;i++)
	   {
		   Row row = sheet.getRow(i);


		    for(int j=0;j<=2;j++)
		    {

	         Cell cell = row.getCell(j);
	          double d1 = cell.getNumericCellValue();
	          String value = cell.getStringCellValue();
		        System.out.println(value);
		    }
	   }
   }
}
