package genericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility implements Iautoconstants {

	Workbook workbook;
	@DataProvider(name="data")
	public Object[][] readdatafromExcel()
	{
		File fis=new File(Excel_path);
		 try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		//int rowcount=sheet.getLastRowNum();
		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();
		//int cellcount=sheet.getRow(1).getLastCellNum();
		Object [][] data=new Object[rowcount][cellcount];
		for(int row=0;row<rowcount;row++)
		{
			Row actrow = sheet.getRow(row);
			for(int cell=0;cell<actrow.getPhysicalNumberOfCells();cell++)
			{
				data[row][cell]=actrow.getCell(cell).toString();
			}
		}
		return data;
	}
}
