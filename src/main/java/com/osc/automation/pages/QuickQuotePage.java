package com.osc.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class QuickQuotePage {
	 WebDriver driver = null;
	 
	 @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div[1]/app-header/nav/div/div[1]/div/p")
	 public WebElement lbl_Header; 
	 
	 @FindBy(how = How.ID, using = "explore-button")
	 public WebElement btn_Explore_Button; 
	 
	 @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div[1]/app-header/nav/div/div[2]/div/a")
	 public WebElement btn_ContactUs; 
	 
	 @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div[1]/app-header/nav/div/div[2]/div/button")
	 public WebElement btn_language; 
	 
	 @FindBy(how = How.XPATH, using ="/html/body/app-root/div/div[1]/app-header/nav/div/div[1]/div/p")
	 public WebElement we_Page_Title; 
	 
	 @FindBy(how = How.XPATH, using ="/html/body/app-root/div/div[1]/app-header/nav/div/div[1]/div/p")
	 public WebElement we_Page_Title_ENG; 
	 
	 @FindBy(how = How.XPATH, using ="/html/body/app-root/div/div[1]/app-status/div/div[2]/div[1]/p")
	 
	 public WebElement we_Quick_Quote_Step; 
	 @FindBy(how = How.XPATH, using ="/html/body/app-root/div/div[1]/app-status/div/div[2]/div[2]/p")
	 public WebElement we_Personal_Details_Step; 
	 @FindBy(how = How.XPATH, using ="/html/body/app-root/div/div[1]/app-status/div/div[2]/div[3]/p")
	 public WebElement we_Pymt_Step; 
	 @FindBy(how = How.XPATH, using ="/html/body/app-root/div/div[1]/app-status/div/div[2]/div[4]/p")
	 public WebElement we_Confirm_Step; 
	 
	 
	 @FindBy(how = How.ID, using ="product-title")
	 public WebElement we_Losc_Hed; 
	 
	 
	//*[@id="product-description"]
	 
	 
	 @FindBy(how = How.ID, using ="product-description")
	 public WebElement we_Losc_Product_Desc; 
	 

	 @FindBy(how = How.XPATH, using ="//*[@id=\"main\"]/app-questions/div/div/div/div[1]/app-overview/div/div/div/p")
	 public WebElement we_Product_Other_Details; 
	 

	 @FindBy(how = How.XPATH, using ="/html/body/ngb-modal-window/div/div/app-explorebenefits/div/label/h2")
	 public WebElement we_Explore_Popup_Hed;
	 
	 @FindBy(how = How.XPATH, using ="/html/body/ngb-modal-window/div/div/app-explorebenefits/div/button/span")
	 public WebElement we_Explore_Popup_Closed;
	 
	 @FindBy(how = How.XPATH, using ="/html/body/ngb-modal-window/div/div/app-explorebenefits/div/div/ul/li[1]/div[2]")
	 public WebElement we_Explore_Popup_Point1;
	 @FindBy(how = How.XPATH, using ="/html/body/ngb-modal-window/div/div/app-explorebenefits/div/div/ul/li[2]/div[2]")
	 public WebElement we_Explore_Popup_Point2;
	 @FindBy(how = How.XPATH, using ="/html/body/ngb-modal-window/div/div/app-explorebenefits/div/div/ul/li[3]/div[2]")
	 public WebElement we_Explore_Popup_Point3;
	 @FindBy(how = How.XPATH, using ="/html/body/ngb-modal-window/div/div/app-explorebenefits/div/div/ul/li[4]/div[2]")
	 public WebElement we_Explore_Popup_Point4;
	 @FindBy(how = How.XPATH, using ="/html/body/ngb-modal-window/div/div/app-explorebenefits/div/div/ul/li[5]/div[2]")
	 public WebElement we_Explore_Popup_Point5;
	 @FindBy(how = How.XPATH, using ="/html/body/ngb-modal-window/div/div/app-explorebenefits/div/div/ul/li[6]/div[2]")
	 public WebElement we_Explore_Popup_Point6; 
	 @FindBy(how = How.XPATH, using ="/html/body/ngb-modal-window/div/div/app-explorebenefits/div/div/ul/li[7]/div[2]")
	 public WebElement we_Explore_Popup_Point7;
	 
	 
	 
	 
	 
	public QuickQuotePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}
	
	public static QuickQuotePage getQuickQuotePage(WebDriver driver) {
		return PageFactory.initElements(driver, QuickQuotePage.class);
		
	}

}
