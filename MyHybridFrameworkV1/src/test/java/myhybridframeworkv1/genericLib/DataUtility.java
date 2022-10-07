package myhybridframeworkv1.genericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {

	String dataPath;
	public String getDataFromPropertiesFile(String key) throws IOException {
		dataPath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(dataPath+"/CommonUtility/TestDataProperties.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
	
	public String getDataFromExcelSheet(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		dataPath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(dataPath+"/CommonUtility/TestDataExcel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(sh.getRow(rowNum).getCell(cellNum));
		return value;
	}
}