package com.stepDefinition;

import com.generic.BaseTest;
import com.pageFactory.AutomationPracticePage;
import com.pageFactory.FBpage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	private BaseTest objBaseTest;
	private AutomationPracticePage objAutomationPracticePage;
	private FBpage objFBpage;

	public StepDefinition() {
		objBaseTest = new BaseTest();
		objAutomationPracticePage = new AutomationPracticePage();
		objFBpage = new FBpage();

	}

	@Given("^User is on landing page$")
	public void user_is_on_landing_page() throws Throwable {
		objAutomationPracticePage.openURL();
	}

	@Then("^Verify user is on landing page$")
	public void verify_user_is_on_landing_page() throws Throwable {
		objAutomationPracticePage.verifyUserIsOnPracticePage();
	}

	@When("^User clicks on radio button$")
	public void user_clicks_on_radio_button() throws Throwable {
		objAutomationPracticePage.clickOnRadioButton();
	}

	@Then("^Radio button should be selected$")
	public void radio_button_should_be_selected() throws Throwable {
		objAutomationPracticePage.verifyRadioButtonIsSelected();
	}

	@When("^Enter country in input box and select (.*) from dropdown$")
	public void enter_country_in_input_box_and_select_value_from_dropdown(String strInputName) throws Throwable {
		objAutomationPracticePage.selectDropdownValueByEnteringCountryNameInInputBox(strInputName);
		Thread.sleep(10000);
	}

	@When("^select value from dropdown$")
	public void select_value_from_dropdown() throws Throwable {
		objAutomationPracticePage.clickOnDropdown();
		objAutomationPracticePage.selectValueFromDropdown();
	}

	@Then("^User is able to click on checkbox$")
	public void user_is_able_to_click_on_checkbox() throws Throwable {
		objAutomationPracticePage.clickOnCheckbox();
	}

	@And("^Verify checkbox is selected$")
	public void verify_checkbox_is_selected() throws Throwable {
		objAutomationPracticePage.verifyCheckboxIsSelected();
	}

	@Then("^Scroll upto webtable$")
	public void scroll_upto_webtable() throws Throwable {
		objAutomationPracticePage.scrollUptoWebtable();
	}

	@Then("^Verify Fields from webtable$")
	public void verify_Fields_from_webtable() throws Throwable {

	}

	@Then("^Switch on opened window$")
	public void switch_on_opened_window() throws Throwable {
		objAutomationPracticePage.switchToWindow();
		Thread.sleep(10000);
		System.out.println("Test");
		// objAutomationPracticePage.clickOnHomeButton();
	}

	// Facebook
	@Given("^User in On facebook SignUP Page$")
	public void user_in_On_facebook_SignUP_Page() throws Throwable {
		objFBpage.openFBPage();
	}

	@When("^user click on SignUP page$")
	public void user_click_on_SignUP_page() throws Throwable {
		objFBpage.clickCreateNewAccountButton();
	}

	@Then("^user verify  all fields in facebook sign up page$")
	public void user_verify_all_fields_in_facebook_sign_up_page(DataTable dataTable) throws Throwable {
		objFBpage.verifyAllcommonFieldsFromSignUpPage(dataTable);
	}
//Switch Tab
	@When("^click on Open Tab button$")
	public void click_on_Open_Tab_button() throws Throwable {
		objAutomationPracticePage.clickOnOpenTabButton();
	}

	@Then("^verify another Tab is Opened$")
	public void verify_another_Tab_is_Opened() throws Throwable {
		objAutomationPracticePage.switchToChildTab();
		objAutomationPracticePage.verifychildTabIsOpened();
	}

	@Then("^come back to main Tab$")
	public void come_back_to_main_Tab() throws Throwable {
		objAutomationPracticePage.returnkToParentTab();
	}

	//Alert
	@When("^user click on Enter Your Name textbox$")
	public void user_click_on_Enter_Your_Name_textbox() {
		
		objAutomationPracticePage.enterTextInTextbox();
	    
	}

	@When("^user click on Alert and Handle alert$")
	public void user_click_on_Alert_and_Handle_alert() throws InterruptedException {
		objAutomationPracticePage.clickOnAlertButton();
	   
	}

	@Then("^user click on confirm button and handle Alert with Ok$")
	public void user_click_on_confirm_button_and_handle_Alert_with_Ok() throws InterruptedException {		
		objAutomationPracticePage.clickOnConfirmButton();	  
	}

	@Then("^user click on confirm button and handle Alert with cancel$")
	public void user_click_on_confirm_button_and_handle_Alert_with_cancel() throws InterruptedException {
		objAutomationPracticePage.clickOnConfirmCancelAlertButton();
	}

	//Mouse hover
	@When("^mouse hover to Mouse hover button$")
	public void mouse_hover_to_Mouse_hover_button() throws Throwable {
		objAutomationPracticePage.mouseHoverToButton();
	}
    
	@Then("^verify (\\d+) value present in List (.*)$")
	public void verify_value_present_in_List(int index, String value) throws InterruptedException {
		objAutomationPracticePage.verifyMouseHoverList(index,value);
	}
	
	//iframe
	@When("^user enter In iFrame$")
	public void user_enter_In_iFrame() throws Throwable {
		objAutomationPracticePage.enterinIframe();

	}

	@Then("^verify user in Iframe$")
	public void verify_user_in_Iframe() throws Throwable {
		objAutomationPracticePage.verifyTextInIframe();
	}
	
	//WebTable1
	@When("^verify all table data \"([^\"]*)\"$")
	public void verify_all_table_data(int intRowValue) {
		objAutomationPracticePage.getTableRowData(intRowValue);
	}
	
	//web table2
	@When("^verify Table Header$")
	public void verify_Table_Header() {
		objAutomationPracticePage.verifyHeaderOfDataTable();
	}

	@Then("^verify fields in fixed header Table$")
	public void verify_fields_in_fixed_header_Table(DataTable dataTable) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		objAutomationPracticePage.verifyDataFieldsOfTable(dataTable);
	}
	
}
