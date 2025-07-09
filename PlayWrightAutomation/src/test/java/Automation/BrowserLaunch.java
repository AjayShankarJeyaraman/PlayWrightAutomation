package Automation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserLaunch {
public  static void main(String [] args ) {
 
	
	
	
	
	
	
	Playwright playwright = Playwright.create();
	
	Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
	
	Page page = browser.newPage();
	page.navigate("https://letcode.in/edit");
	String title = page.title();
	String url = page.url();
	
	System.out.println("Title of the Page :" + title);
	System.out.println("URL of the Page :" +  url);
	
	page.fill("id=fullName", "AjayShankarJeyaram");
	
	Locator locator = page.locator("id=join");
	locator.press("End");
	locator.type(" Person");
	locator.press("Tab");
	
	String attribute = page.locator("id=getMe").getAttribute("value");
	
	System.out.println("Attrivute value is :" + attribute);
	
	page.locator("id=clearMe").clear();
	
	
	
     page.close();
	browser.close();
	playwright.close();
	
	
	
	
	
	
	
}	
	}

