package com.osc.automation.testcases;

import org.testng.annotations.Test;

import com.osc.automation.pages.QuickQuotePage;
import com.osc.automation.utils.DriverType;
import com.osc.automation.utils.Utils;
import com.osc.automation.variables.QuickQuotePageVariables;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class QuickQuotePageTest {
	WebDriver driver;
	QuickQuotePage quickQuotePage;

	@BeforeClass
	public void setUp() {

		// WebDriverManager.chromedriver().setup();
		driver = Utils.intializDriver(DriverType.CHROME.value());
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		/// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		/// driver = Utils.intializDriver(DriverType.CHROME.value());
		quickQuotePage = QuickQuotePage.getQuickQuotePage(driver);
		System.out.println("Driver Initializ");
		driver.get("https://nonprod-studytrip.lmig.com/");

	}

	
	@Test(priority = 2)
	public void verifyThatQuickQuotePageIsOpen() {

		String bodyText = quickQuotePage.lbl_Header.getText();
		//System.out.println("testQuickQuotePageHeader");
		Assert.assertEquals(bodyText, QuickQuotePageVariables.PAGE_HEADING);
	}

	@Test(priority = 3)
	public void verifyQuickQuotePageTabTitle() {
		//System.out.println("testQuickQuotePageTabTitle");
		Assert.assertEquals(driver.getTitle(), QuickQuotePageVariables.PAGE_HEADING);
	}

	@Test(priority = 4)
	public void verifyQuickQuotePageContacUsButtonText() {
		Assert.assertEquals(quickQuotePage.btn_ContactUs.getText(), QuickQuotePageVariables.CONTACT_US_TXT);

	}

	@Test(priority = 5)
	public void veryfyQuickQuotePageContacUsButtonFunctionalityWhenDefaultLanguageSelected() throws InterruptedException {
		// Check Contact Us Action
		// Click on Contact Us
		quickQuotePage.btn_ContactUs.click();
		Utils.waitFor(5000);
		List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1));
		String pageTitle = driver.getTitle();
		String pageUrl = driver.getCurrentUrl();
		//System.out.println("pageTitle :" + pageTitle);
		//System.out.println("pageUrl :" + pageUrl);
		if (pageTitle.equals(QuickQuotePageVariables.CONTACT_US_TITLE)
				&& pageUrl.equals(QuickQuotePageVariables.CONTACT_US_URL)) {
			//System.out.println("assertTrue");
			Assert.assertTrue(true);

		} else {

			//System.out.println("assert true");
			Assert.assertTrue(false);

		}
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
	}

	@Test(priority = 6)
	public void verifyQuickQuotePageLanguageSwitcherTextWhenDefault() {
		Assert.assertEquals(QuickQuotePageVariables.LANGUAGE_BTN_TEXT_CHINESE, quickQuotePage.btn_language.getText());
	}

	@Test(priority = 7)
	public void veryfyChinesTextOfQuickQuotePageLanguageSwitchButton() throws InterruptedException {
		quickQuotePage.btn_language.click();
		Utils.waitFor(5000);
		Assert.assertEquals(QuickQuotePageVariables.LANGUAGE_BTN_TEXT_ENGLISH, quickQuotePage.btn_language.getText());
		quickQuotePage.btn_language.click();
		Utils.waitFor(1000);
	}

	@Test(priority = 8)
	public void verifyQuickQuotePageWhenSelectLanguageChinese() throws InterruptedException {
		quickQuotePage.btn_language.click();
		Utils.waitFor(5000);
		/*
		 * if(quickQuotePage.btn_language.getText().equals(QuickQuotePageVariables.
		 * LANGUAGE_BTN_TEXT_CHINESE)){ quickQuotePage.btn_language.click(); }
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pageHedChi = driver.getTitle();
		if (pageHedChi.equals(QuickQuotePageVariables.TXT_PAGE_TAB_TEXT_CHI)
				&& quickQuotePage.we_Page_Title.getText().equals(QuickQuotePageVariables.TXT_OSC_CHI)) {

			Assert.assertTrue(true);

		} else {

			Assert.assertTrue(false);

		}

	}

	@Test(priority = 9)
	public void verifyQuickQuotePageTitleWhenLanguageSwitchToChinese() {
		// quickQuotePage.btn_language.click();
		/*
		 * if(quickQuotePage.btn_language.getText().equals(QuickQuotePageVariables.
		 * LANGUAGE_BTN_TEXT_CHINESE)){ quickQuotePage.btn_language.click(); }
		 */
		if (quickQuotePage.we_Page_Title.getText().equals(QuickQuotePageVariables.TXT_OSC_CHI)) {

			Assert.assertTrue(true);

		} else {

			Assert.assertTrue(false);

		}

	}

	@Test(priority = 10)
	public void verifyQuickQuotePageStepsWhenLanguageSelectedToChinese() {
		// if(quickQuotePage.btn_language.getText().equals(QuickQuotePageVariables.LANGUAGE_BTN_TEXT_CHINESE)){
		// quickQuotePage.btn_language.click();
		// }
		if (quickQuotePage.we_Quick_Quote_Step.getText().equals(QuickQuotePageVariables.TXT_QUICK_QUOTE_STEP_CHI)
				&& quickQuotePage.we_Personal_Details_Step.getText()
						.equals(QuickQuotePageVariables.TXT_PER_DET_STEP_CHI)
				&& quickQuotePage.we_Pymt_Step.getText().equals(QuickQuotePageVariables.TXT_PYMT_STEP_CHI)
				&& quickQuotePage.we_Confirm_Step.getText().equals(QuickQuotePageVariables.TXT_CNF_CHI)) {

			Assert.assertTrue(true);

		} else {

			Assert.assertTrue(false);

		}

	}

	@Test(priority = 11)
	public void verifyQuickQuotePageOSCProductDetailsWhenLanguageSelectedToChinese() {
		/*
		 * if(quickQuotePage.btn_language.getText().equals(QuickQuotePageVariables.
		 * LANGUAGE_BTN_TEXT_CHINESE)){ quickQuotePage.btn_language.click(); }
		 */
		/*
		 * System.out.println("------Check-----");
		 * System.out.println(quickQuotePage.we_Losc_Hed.getText());
		 * System.out.println(QuickQuotePageVariables.TXT_TILE_PARA_LOSC_CHI);
		 * System.out.println(quickQuotePage.we_Losc_Product_Desc.getText());
		 * System.out.println(QuickQuotePageVariables.TXT_PRODUCT_DESC_CHI);
		 * System.out.println(quickQuotePage.we_Product_Other_Details.getText());
		 * System.out.println(QuickQuotePageVariables.TXT_PRODUCT_OTHER_DESC_CHI);
		 */
		
		
		if (quickQuotePage.we_Losc_Hed.getText().equals(QuickQuotePageVariables.TXT_TILE_PARA_LOSC_CHI)
				&& quickQuotePage.we_Losc_Product_Desc.getText().equals(QuickQuotePageVariables.TXT_PRODUCT_DESC_CHI)
				&& quickQuotePage.we_Product_Other_Details.getText()
						.equals(QuickQuotePageVariables.TXT_PRODUCT_OTHER_DESC_CHI)) {

			Assert.assertTrue(true);

		} else {

			Assert.assertTrue(false);

		}

	}

	@Test(priority = 12)
	public void verifyQuickQuotePageWhenLanguageSwitchToEnglishFromChinese() throws InterruptedException {

		quickQuotePage.btn_language.click();
		Utils.waitFor(5000);
		String pageHedChi = driver.getTitle();

		if (pageHedChi.equals(QuickQuotePageVariables.PAGE_HEADING)
				&& quickQuotePage.we_Page_Title_ENG.getText().equals(QuickQuotePageVariables.TXT_OSC_ENG)) {

			Assert.assertTrue(true);

		} else {

			Assert.assertTrue(false);

		}

	}

	@Test(priority = 13)
	public void verifyQuickQuotePageTitleWhenLanguageSwitchToEnglishFromChinese() {

		/*
		 * System.out.println(quickQuotePage.we_Page_Title.getText());
		 * System.out.println(QuickQuotePageVariables.TXT_OSC_ENG);
		 */
		if (quickQuotePage.we_Page_Title.getText().equals(QuickQuotePageVariables.TXT_OSC_ENG)) {

			Assert.assertTrue(true);

		} else {

			Assert.assertTrue(false);

		}

	}

	@Test(priority = 14)
	public void verifyQuickQuotePageStepsTextWhenLanguageSelectedToEnglish() {

		if (quickQuotePage.we_Quick_Quote_Step.getText().equals(QuickQuotePageVariables.TXT_QUICK_QUOTE_STEP_ENG)
				&& quickQuotePage.we_Personal_Details_Step.getText()
						.equals(QuickQuotePageVariables.TXT_PER_DET_STEP_ENG)
				&& quickQuotePage.we_Pymt_Step.getText().equals(QuickQuotePageVariables.TXT_PYMT_STEP_ENG)
				&& quickQuotePage.we_Confirm_Step.getText().equals(QuickQuotePageVariables.TXT_CNF_ENG)) {

			Assert.assertTrue(true);

		} else {

			Assert.assertTrue(false);

		}

	}

	@Test(priority = 15)
	public void verifyQuickQuotePageOSCProductDetailsWhenLanguageSelectedToEnglish() {

		String flag1 = null;
		String flag2 = null;
		String flag3 = null;
		if (quickQuotePage.we_Losc_Hed.getText().equals(QuickQuotePageVariables.TXT_TILE_PARA_LOSC_ENG)) {
			
			//System.out.println("1");
			flag1 = "TRUE";
		}
		if (quickQuotePage.we_Losc_Product_Desc.getText().equals(QuickQuotePageVariables.TXT_PRODUCT_DESC_ENG)) {
			//System.out.println("2");
			flag2 = "TRUE";
			
		}
		/*
		 * if (quickQuotePage.we_Product_Other_Details.getText()
		 * .equals(QuickQuotePageVariables.TXT_PRODUCT_OTHER_DESC_ENG)) {
		 * //System.out.println("3"); flag3 = "TRUE";&& flag3.equals("TRUE") }
		 */

		if (flag1.equals("TRUE") && flag2.equals("TRUE")) {

			Assert.assertTrue(true);
			

		} else {

			Assert.assertTrue(false);

		}

	}

	@Test(priority = 16)
	public void verifyExploreBenefitsButtonText() {
		
		System.out.println("");

		if (quickQuotePage.btn_Explore_Button.getText().equals(QuickQuotePageVariables.TXT_BTN_EXPLORE_BENIFITS_ENG)) {

			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}
	}

	@Test(priority = 17)
	public void verifyExploreBenefitsPopupWhenClickOnButton() throws InterruptedException {
		// System.out.println("verify Explore Benefits popup is open when Click on
		// button");
		// System.out.println("Step1: Click on Explore Benefits Button.");
		quickQuotePage.btn_Explore_Button.click();
		Utils.waitFor(5000);
		// System.out.println("Step2: Wait for Popup open.");
		// System.out.println("Step3: Get popup heading text.");
		// System.out.println("Step4: Check expected with actual.");

		if (quickQuotePage.we_Explore_Popup_Hed.getText().equals(QuickQuotePageVariables.EXPLORE_BENFITS_POPUP_HED)) {

			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}
		quickQuotePage.we_Explore_Popup_Closed.click();
		Utils.waitFor(5000);
		//Thread.sleep(500);
		// System.out.println("Step5: Closed the popup.");

	}

	@Test(priority = 18)
	public void verifyExploreBenefitsPopupContent() throws InterruptedException {
		quickQuotePage.btn_Explore_Button.click();
		Utils.waitFor(5000);
		
		String flag1;
		String flag2;
		String flag3;
		String flag4;
		String flag5;
		String flag6;
		String flag7;
		
		

		
		if (quickQuotePage.we_Explore_Popup_Point2.getText()
				.equals(QuickQuotePageVariables.EXPLORE_BENFITS_POPUP_POINT2)) {

			//System.out.println("point2:" + quickQuotePage.we_Explore_Popup_Point2.getText());
			flag2 = "TRUE";
			

		} else {
			flag2 = "FALSE";
			//System.out.println("point2:" + flag2);
		}

		if (quickQuotePage.we_Explore_Popup_Point3.getText()
				.equals(QuickQuotePageVariables.EXPLORE_BENFITS_POPUP_POINT3)) {

			//System.out.println("point3:" + quickQuotePage.we_Explore_Popup_Point3.getText());
			flag3 = "TRUE";
			

		} else {
			flag3 = "FALSE";
			//System.out.println("point3:" + flag3);
		}

		if (quickQuotePage.we_Explore_Popup_Point4.getText()
				.equals(QuickQuotePageVariables.EXPLORE_BENFITS_POPUP_POINT4)) {

			//System.out.println("point4:" + quickQuotePage.we_Explore_Popup_Point4.getText());
			flag4 = "TRUE";
			
		} else {
			flag4 = "FALSE";
			//System.out.println("point4:" + flag4);
		}

		if (quickQuotePage.we_Explore_Popup_Point5.getText()
				.equals(QuickQuotePageVariables.EXPLORE_BENFITS_POPUP_POINT5)) {

			//System.out.println("point5:" + quickQuotePage.we_Explore_Popup_Point5.getText());
			flag5 = "TRUE";
		

		} else {
			flag5 = "FALSE";
			//System.out.println("point5:" + flag5);
		}

		if (quickQuotePage.we_Explore_Popup_Point6.getText()
				.equals(QuickQuotePageVariables.EXPLORE_BENFITS_POPUP_POINT6)) {

			//System.out.println("point6:" + quickQuotePage.we_Explore_Popup_Point6.getText());
			flag6 = "TRUE";
			

		} else {
			flag6 = "FALSE";
			//System.out.println("point6:" + flag6+"  "+quickQuotePage.we_Explore_Popup_Point6.getText());
		}

		/*
		 * if (quickQuotePage.we_Explore_Popup_Point7.getText()
		 * .equals(QuickQuotePageVariables.EXPLORE_BENFITS_POPUP_POINT7)) {
		 * 
		 * //System.out.println("point7:" +
		 * quickQuotePage.we_Explore_Popup_Point7.getText()); flag7 = "TRUE";
		 * 
		 * } else { flag7 = "FALSE"; //System.out.println("point7:" + flag7); }
		 */
	 
		if(flag2.equals("TRUE")&& flag3.equals("TRUE")&& flag4.equals("TRUE")&& flag5.equals("TRUE")&& flag6.equals("TRUE")){

			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}
		quickQuotePage.we_Explore_Popup_Closed.click();
	}
	
	
	@AfterClass
	public void endTest() {

		driver.close();
		driver.quit();

	}

}
