package com.pageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.generic.Pojo;

import cucumber.api.DataTable;

public class AutomationPracticePage {

	public void openURL() {
		Pojo.getDriver().navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		Pojo.getDriver().manage().window().maximize();
		System.out.println("Browser is opened");
	}

	public void verifyUserIsOnPracticePage() {
		Pojo.getDriver().findElement(By.xpath("//h1[text()='Practice Page']")).isDisplayed();
		System.out.println("User is on practice page");
	}

	public void clickOnRadioButton() {
		Pojo.getDriver().findElement(By.xpath("//input[@value='radio1']")).click();
		System.out.println("Radio button 1 is selected");
		Pojo.getDriver().findElement(By.xpath("//input[@value='radio2']")).click();
		System.out.println("Radio button 2 is selected");
		Pojo.getDriver().findElement(By.xpath("//input[@value='radio3']")).click();
		System.out.println("Radio button 3 is selected");
	}

	public void verifyRadioButtonIsSelected() {
		Pojo.getDriver().findElement(By.xpath("//input[@value='radio3']")).isSelected();
		System.out.println("Radio button 3 is selected");
	}

	public void selectDropdownValueByEnteringCountryNameInInputBox(String strInputName) throws InterruptedException {
		By locator = By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']//li//div");
		WebElement webElement = Pojo.getDriver()
				.findElement(By.xpath("//input[@id='autocomplete'][@placeholder='Type to Select Countries']"));
		webElement.sendKeys(strInputName);
		Thread.sleep(2000);
		List<WebElement> listElement = Pojo.getDriver().findElements(locator);
		for (WebElement webElement_1 : listElement) {
			String strCountryName = webElement_1.getText().trim();
			if (strCountryName.toLowerCase().equals(strInputName.toLowerCase())) {
				webElement_1.click();
				break;
			}
		}
	}

	public void clickOnDropdown() {
		Pojo.getDriver().findElement(By.xpath("//select[@id='dropdown-class-example']")).click();
		System.out.println("User is able to click on dropdown");

	}

	public void selectValueFromDropdown() throws InterruptedException {
		Select selectOption = new Select(
				Pojo.getDriver().findElement(By.xpath("//select[@id='dropdown-class-example']")));
		selectOption.selectByValue("option1");
		Thread.sleep(2000);
		System.out.println("User selects first option");
	}

	public void clickOnCheckbox() {
		Pojo.getDriver().findElement(By.xpath("//input[@value='option1']")).click();
		System.out.println("User is able to click on checkbox");
	}

	public void verifyCheckboxIsSelected() {
		Pojo.getDriver().findElement(By.xpath("//input[@value='option1']")).isSelected();
		System.out.println("option1 checkbox is selected");

	}

	// Alert
	public void enterTextInTextbox() {
		WebElement webElement = Pojo.getDriver().findElement(By.xpath("//input[@id='name']"));
		webElement.sendKeys("VerveSquare..");
	}

	public void clickOnAlertButton() throws InterruptedException {
		WebElement webElement = Pojo.getDriver().findElement(By.xpath("//input[@id='alertbtn']"));
		webElement.click();
		String strAlertText = Pojo.getDriver().switchTo().alert().getText();
		System.out.println(strAlertText);
		Pojo.getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	}

	public void clickOnConfirmButton() throws InterruptedException {
		WebElement webElement = Pojo.getDriver().findElement(By.xpath("//input[@id='confirmbtn']"));
		webElement.click();
		String strAlertText = Pojo.getDriver().switchTo().alert().getText();
		System.out.println(strAlertText);
		Pojo.getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	}

	public void clickOnConfirmCancelAlertButton() throws InterruptedException {
		WebElement webElement = Pojo.getDriver().findElement(By.xpath("//input[@id='confirmbtn']"));
		webElement.click();
		String strAlertText = Pojo.getDriver().switchTo().alert().getText();
		System.out.println(strAlertText);
		Pojo.getDriver().switchTo().alert().dismiss();
		Thread.sleep(2000);
	}

	// WebTtable1
	public void getTableRowData(int rowList) {
		WebElement webElement = Pojo.getDriver().findElement(By.xpath("//table[@id='product']"));
		List<WebElement> rowData = webElement.findElements(By.tagName("tr"));
		List<WebElement> colmnData = webElement.findElements(By.tagName("td"));
		int intColSize = colmnData.size();
		for (int j = 0; j < intColSize; j++) {
			String strValue = colmnData.get(j).getText();
			System.out.println("Cell value of Row " + rowList + " and Column Value" + j + " Data is " + strValue);
		}

	}

	// web table fixed header
	public void scrollUptoWebtable() {
		JavascriptExecutor js = (JavascriptExecutor) Pojo.getDriver();
		js.executeScript("window.scrollBy(0,280)", "");

	}

	public void verifyHeaderOfDataTable() {
		WebElement webElement = Pojo.getDriver().findElement(By.xpath("//legend[text()='Web Table Fixed header']"));
		String strHeader = webElement.getText();
		Assert.assertEquals(strHeader, "Web Table Fixed header");
		System.out.println("Web Table Fixed Header is Displayed...");
	}

	public void verifyDataFieldsOfTable(DataTable dataTable) {
		List<Map<String, String>> map = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < map.size(); i++) {
			// System.out.println("@@@@"+map.get(i));
			String strData = map.get(i).get("HeaderName");
			WebElement webElement = Pojo.getDriver()
					.findElement(By
							.xpath("//legend[text()='Web Table Fixed header']//parent::fieldset//descendant::table[@id='product']//descendant::th[text()='"
									+ strData + "']"));

			if (!strData.equals("")) {
				Assert.assertTrue(webElement.isDisplayed());
				System.out.println("User verify fields: " + strData);
			}
		}

	}

	public void switchToWindow() throws InterruptedException {
		String MainWindow = Pojo.getDriver().getWindowHandle();
		System.out.println("ParentWindow= " + MainWindow);
		String title = Pojo.getDriver().getTitle();
		System.out.println("MainWindow_Title:" + title);
		Pojo.getDriver().findElement(By.xpath("//button[@id='openwindow']")).click();
		Set<String> s1 = Pojo.getDriver().getWindowHandles();
		for (String s2 : s1) {
			if (!s2.equals(MainWindow))
				Pojo.getDriver().switchTo().window(s2);
			System.out.println("child window= " + s2);
			String title1 = Pojo.getDriver().getTitle();
			System.out.println(title1);
			Thread.sleep(5000);
			Pojo.getDriver().close();
			// Assert.assertTrue("QA Click Academy |
			// Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training
			// Academy".equals(title1));
			// Assert.assertEquals("QA Click Academy |
			// Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training
			// Academy", title);
		}
	}

	// child Tab
	String strParentTab = "";
	String strActualTabUrl = "";

	public void clickOnOpenTabButton() {
		strParentTab = Pojo.getDriver().getWindowHandle();
		System.out.println("Parent Tab Id: " + strParentTab);
		Pojo.getDriver().findElement(By.xpath("//a[@id='opentab']")).click();

	}

	public void switchToChildTab() {
		ArrayList<String> allTab = new ArrayList<String>(Pojo.getDriver().getWindowHandles());
		for (String childTab : allTab) {
			if (!strParentTab.equalsIgnoreCase(childTab)) {
				Pojo.getDriver().switchTo().window(childTab);
				strActualTabUrl = Pojo.getDriver().getCurrentUrl();
			}
		}
	}

	public void verifychildTabIsOpened() throws InterruptedException {
		String strExpectedUrl = "https://www.rahulshettyacademy.com/";
		Assert.assertEquals(strActualTabUrl, strExpectedUrl);
		Thread.sleep(5000);
		Pojo.getDriver().close();
		System.out.println("Child Tab is Open Successfully..");
	}

	public void returnkToParentTab() throws InterruptedException {
		String strExpectedParentUrl = "https://rahulshettyacademy.com/AutomationPractice/";
		Pojo.getDriver().switchTo().window(strParentTab);
		String strParentWindowUrl = Pojo.getDriver().getCurrentUrl();
		Thread.sleep(5000);
		Assert.assertEquals(strParentWindowUrl, strExpectedParentUrl);
		System.out.println("Parent Tab is Open Successfully..");
		
	}

	// Mouse Hover
	public void mouseHoverToButton() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Pojo.getDriver();
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(5000);
		WebElement webElement = Pojo.getDriver().findElement(By.xpath("//button[@id='mousehover']"));
		Actions action = new Actions(Pojo.getDriver());
		action.moveToElement(webElement).build().perform();
		Thread.sleep(5000);

	}

	public void verifyMouseHoverList(int intIndex, String strExpectedValue) throws InterruptedException {
		WebElement webElement = Pojo.getDriver()
				.findElement(By.xpath("(//button[@id='mousehover']//parent::div//ancestor::a)[" + intIndex + "]"));
		Thread.sleep(5000);
		String strActualValue = webElement.getText();
		System.out.println("List value " + strActualValue);
		Assert.assertEquals(strActualValue, strExpectedValue);
	}

	// Iframe
	public void enterinIframe() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Pojo.getDriver();
		js.executeScript("window.scrollBy(0,1200)", "");
		
		Thread.sleep(5000);
		Pojo.getDriver().switchTo().frame("courses-iframe");

	}

	public void verifyTextInIframe() {
		WebElement webElement = Pojo.getDriver()
				.findElement(By.xpath("(//li[@class='current'][1]//a[text()='Home'])[1]"));
		String strActualValue = webElement.getText();
		Assert.assertEquals(strActualValue, "Home");
	}
}
