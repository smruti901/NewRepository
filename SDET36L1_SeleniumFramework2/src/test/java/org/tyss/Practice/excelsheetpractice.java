package org.tyss.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelsheetpractice {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Flipkart.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		 Sheet sh = book.getSheet("Sheet1");
		 sh.createRow(1).createCell(1).setCellValue("admin");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Flipkart.xlsx");
		book.write(fos);
		fos.flush();
		System.out.println("pass");
		//double value = sh.getRow(2).getCell(2).getNumericCellValue();
		//System.out.println(value);
		//int lastrow = sh.getLastRowNum();
	//	for(int i=0;i<=lastrow;i++)
	//	{
		//	Row row = sh.getRow(i);
		//	for(int j=0; j<row.getLastCellNum();j++)
			{
		//DataFormatter format = new DataFormatter();
		//String data = format.formatCellValue(row.getCell(j));
		//System.out.println(data+"\t");
		//}
	//	System.out.println();
		//}
	}

}
}
