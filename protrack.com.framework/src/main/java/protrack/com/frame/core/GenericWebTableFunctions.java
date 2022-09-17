package protrack.com.frame.core;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericWebTableFunctions {
	
	SeleniumHelper wrapper=new SeleniumHelper();


	public void clickCellInTable(By tableName,int rowNo,int collNo) {
		WebElement tableElement =wrapper.getDriver().findElement(tableName);
		List<WebElement> trCollection = tableElement.findElements(By.xpath("tbody/tr"));
		List<WebElement> tdCollection = trCollection.get(rowNo-1).findElements(By.xpath("td"));
		WebElement cell =tdCollection.get(collNo-1);
		cell.click();
	}

	public void clickHeaderInTable(WebDriver driver,By tableName,int rowNo,int collNo) {
		WebElement tableElement =driver.findElement(tableName);
		List<WebElement> trCollection = tableElement.findElements(By.xpath("tbody/tr"));
		List<WebElement> tdCollection = trCollection.get(rowNo-1).findElements(By.xpath("td"));
		WebElement cell =tdCollection.get(collNo);
		cell.click();
	}

	public String getCellData(By tableName,int rowNo,int collNo) {
		WebElement tableElement =wrapper.getDriver().findElement(tableName);

		List<WebElement> trCollection = tableElement.findElements(By.xpath("tbody/tr"));
		List<WebElement> tdCollection = trCollection.get(rowNo-1).findElements(By.xpath("td"));
		WebElement cell =tdCollection.get(collNo-1);
		String cellData =cell.getText();
		if(cellData==null) {
			return "";
		}
		else 
		{
			return cellData.trim();
		}
	}

	public int getRowCount(WebDriver driver,By tableName) {
		WebElement tableElement =driver.findElement(tableName);
		List<WebElement> trCollection = tableElement.findElements(By.xpath("tbody/tr"));
		return trCollection.size();
	}

	public int getColumncount(WebDriver driver,By tableName,int rowNo) {
		WebElement tableElement =driver.findElement(tableName);
		System.out.println(tableElement);
		List<WebElement> trCollection = tableElement.findElements(By.xpath("tbody/tr"));
		List<WebElement> tdCollection = trCollection.get(rowNo-1).findElements(By.xpath("td"));
		return tdCollection.size();
	}

	public int getHeaderCount(WebDriver driver,By tableName,int rowNo) 
	{
		WebElement tableElement =driver.findElement(tableName);
		List<WebElement> trCollection = tableElement.findElements(By.xpath("thead/tr"));
		List<WebElement> tdCollection = trCollection.get(0).findElements(By.xpath("th"));
		return tdCollection.size();
	}


	public List<String> getRowList(WebDriver driver,By tableName,int rowNo) {
		ArrayList<String> rowList =new ArrayList<String>();
		WebElement tableElement =driver.findElement(tableName);
		List<WebElement> trCollection = tableElement.findElements(By.xpath("tbody/tr"));

		List<WebElement> tdCollection = trCollection.get(rowNo-1).findElements(By.xpath("td"));
		for(int i=0;i<tdCollection.size();i++)
		{
			rowList.add(tdCollection.get(i).getText());
		}


		return rowList;
	} 


	public String getHeaderText(WebDriver driver,By tableName, int ColumnCount) 
	{
		WebElement tableElement =driver.findElement(tableName);
		List<WebElement> trCollection = tableElement.findElements(By.xpath("thead/tr"));
		List<WebElement> tdCollection = trCollection.get(0).findElements(By.xpath("th"));

		return tdCollection.get(ColumnCount-1).getText();
	}

	public List<String> getHeaderList(WebDriver driver,By tableName) 
	{
		ArrayList<String> headerList =new ArrayList<String>();
		WebElement tableElement =driver.findElement(tableName);
		WebElement trCollection = tableElement.findElement(By.xpath("thead/tr"));
		List<WebElement> tdCollection = trCollection.findElements(By.xpath("th"));
		int total=tdCollection.size();
		for(int i=0;i<total;i++){
			headerList.add(tdCollection.get(i).getText());
		}
		return headerList;
	}

}
