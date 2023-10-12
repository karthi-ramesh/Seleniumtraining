package org.basecls;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	public static void LanchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void WindowMaximize() {
	driver.manage().window().maximize();
	}
	
	public static void lanchUrl(String url) {
		driver.get(url);
	}
	
	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static String pageUrl() {
		
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}
	
	public static void closeEntireBrowser() {
		driver.quit();
	}
	
	public static void clickBtn(WebElement ele) {
		ele.click();
	}
	
	public static void screenShot(String imgName) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("Location + imgName.png");
		FileUtils.copyFile(image, f);			
	}
	
	 public static Actions a;
	 public static void moveThecursor(WebElement targetWebElement) {
		 a = new Actions (driver);
		 a.moveToElement(targetWebElement).perform();
	 }
	
	 public static void dragDrop(WebElement dragWebElement,WebElement dropWebElement) {
		 a = new Actions(driver);
		 a.dragAndDrop(dragWebElement, dropWebElement).perform();
	}
	
	public static JavascriptExecutor js;
	
	public static void scrollThepage(WebElement tarWebEle) {
		js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(true)", tarWebEle);
	}
	
	public static void scroll(WebElement element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(false)", element);
	}
	
	public static void excellRead(String sheetNAme, int rowNum, int cellNum)throws IOException{
		File f = new File("excellocation.xlsx");
		FileInputStream file = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(file);
		Sheet mysheet = wb.getSheet("Data");
		Row row = mysheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
	    int cellType = cell.getCellType();
	
	    String value = "";
	    if (cellType ==1) {
			String value2 = cell.getStringCellValue();
		}
	    
	    else if (DateUtil.isCellDateFormatted(cell)) {
	    	SimpleDateFormat s = new SimpleDateFormat(value);
		}
	    else {
			double numvalue = cell.getNumericCellValue();
			long l = (long) numvalue;
			String valueof = String.valueOf(l);
			
		}	 
	}
	
		public static void createNewExcelfile(int rowNum,int cellNum,String writeData)throws IOException{
			File f = new File("C:\\Users\\elcot\\eclipse-workspace\\Mavenproject\\Excel\\newfile.xlsx");
			Workbook w = new XSSFWorkbook();
			Sheet newSheet = w.createSheet("Data");
			Row newRow = newSheet.createRow(rowNum);
			Cell newCell = newRow.createCell(cellNum);
			newCell.setCellValue(writeData);
			FileOutputStream file = new FileOutputStream(f);
			w.write(file);
		}
	
		public static void createCell(int getRow, int creCell, String newData)throws IOException{
			File f = new File("C:\\Users\\elcot\\eclipse-workspace\\Mavenproject\\Excel\\newfile.xlsx");
			FileInputStream file = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(file);
			Sheet mysheet = wb.getSheet("Data");
			Row row = mysheet.getRow(getRow);
			Cell cre = row.createCell(creCell);
			cre.setCellValue(newData);
			FileOutputStream fil = new FileOutputStream(f);
			wb.write(fil);
		}
	
		public static void createRow(int creRow, int creCell, String newData)throws IOException{
			File f = new File("C:\\Users\\elcot\\eclipse-workspace\\Mavenproject\\Excel\\newfile.xlsx");
			FileInputStream file = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(file);
			Sheet mysheet = wb.getSheet("Data");
			Row row = mysheet.createRow(creRow);
			Cell cre = row.createCell(creCell);
			cre.setCellValue(newData);
			FileOutputStream fil = new FileOutputStream(f);
			wb.write(fil);
		}
	
		public static void updateDataParticularCell(int getTheRow, int getTheCell, String exisitingData,String writeNewData) throws IOException {
			File f = new File("C:\\Users\\elcot\\eclipse-workspace\\Mavenproject\\Excel\\newfile.xlsx");
			FileInputStream file = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(file);
			Sheet mysheet = wb.getSheet("Data");
			Row row = mysheet.getRow(getTheRow);
			Cell cell = row.getCell(getTheCell);
			String str = cell.getStringCellValue();
			if (str.equals(exisitingData)) {
				cell.setCellValue(writeNewData);
				
			}
			FileOutputStream fil = new FileOutputStream(f);
			wb.write(fil);
			
		}
	
	
}
