package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class p1
{
  public static void main(String[] args) throws EncryptedDocumentException, IOException
  {
	  FileInputStream fis=new FileInputStream("./data/Sheet1.xlsx");
	  Workbook wb = WorkbookFactory.create(fis);
	  Sheet sheet = wb.getSheet("Sheet1");
	  Row row = sheet.createRow(0);
	  Cell cell = row.createCell(1);
	  cell.setCellValue("Shivani");

	  FileOutputStream fos=new FileOutputStream("./data/Sheet1.xlsx");
	  wb.write(fos);
	  wb.close();
  }
}
