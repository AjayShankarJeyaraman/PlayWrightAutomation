package Automation;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
        
		
		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(headless).newPage();
		page.navigate("https://letcode.in/dropdowns");
		//Select by the Index
		//List<String> fruidID = page.selectOption("id=fruits", "3");
		Locator fruidDD = page.locator("id=fruits");
	   // fruidDD.selectOption("2");

	    //Select by the VisibileText
    	fruidDD.selectOption(new SelectOption().setLabel("Banana"));
    	//index anotherway
	    Thread.sleep(5000);
    	fruidDD.selectOption(new SelectOption().setIndex(0));
    	
       // String notification1 = page.locator("class=notification is-success").textContent();
      //  System.out.println(notification1);
    	
    	// multiple dropdown selecting 
    	
    	Locator HeroDD = page.locator("id=superheros");
    	HeroDD.selectOption(new String[]{"th","im","mm"});
        
    	// list the language and print the last lang
    	Locator langDD = page.locator("#lang");
    	Locator options = langDD.locator("option"); // option is not a locator one of the method 
    	List<String> allInnerTexts = options.allInnerTexts();
    	allInnerTexts.forEach(i->System.out.println(i));
    	int count =options.count();
    	System.out.println("Total Length is "+ count);
    	//choosed last lang 
        langDD.selectOption(new SelectOption().setIndex(count-1));
    	
    	playwright.close();
		

	}

}
