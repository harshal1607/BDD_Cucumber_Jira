package com.pageFactory;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.generic.Pojo;

import cucumber.api.DataTable;

public class FBpage {
	public void openFBPage() {
		Pojo.getDriver().navigate().to("https://www.facebook.com/");
		Pojo.getDriver().manage().window().maximize();
	}

	public void clickCreateNewAccountButton() throws InterruptedException {
		Thread.sleep(3000);
		Pojo.getDriver().findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		System.out.println("click on sign up button");
		Thread.sleep(10000);
	}

	public void verifyAllcommonFieldsFromSignUpPage(DataTable dataTable) {
		List<Map<String, String>> listName = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < listName.size(); i++) {
			String strData = listName.get(i).get("FieldsNameValue");

			if (strData.equals("firstname") || strData.equals("lastname") || strData.equals("reg_email__")
					|| strData.equals("reg_passwd__")) {
				WebElement webElementName = Pojo.getDriver().findElement(By.xpath("//input[@name='" + strData + "']"));
				if (!strData.equals("")) {
					Assert.assertTrue(webElementName.isDisplayed());
					System.out.println("Verify name fields: " + strData);
				}
			} else if (strData.equals("birthday_day") || strData.equals("birthday_month")
					|| strData.equals("birthday_year")) {
				WebElement webElementDate = Pojo.getDriver().findElement(By.xpath("//select[@name='" + strData + "']"));
				if (!strData.equals("")) {
					Assert.assertTrue(webElementDate.isDisplayed());
					System.out.println("Verify birth date fields: " + strData);
				}
			} else if (strData.equals("Female") || strData.equals("Male") || strData.equals("Custom")) {
				WebElement webElementGender = Pojo.getDriver()
						.findElement(By.xpath("//span//label[text()='" + strData + "']"));
				if (!strData.equals("")) {
					Assert.assertTrue(webElementGender.isDisplayed());
					System.out.println("Verify gender fields: " + strData);
				}
			} else {
				System.out.println("Not Having Field in Data List..........");
			}
		}
	}
}
