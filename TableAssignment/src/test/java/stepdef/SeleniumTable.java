package stepdef;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTable {
	
	WebDriver driver;
	int size,count;
	String str[] = new String[3];
	String[] arrStr;
	boolean b;
	
	
	

	@When("^the user navigate to the url \"([^\"]*)\"$")
	public void the_user_navigate_to_the_url(String arg1) throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(arg1);
	
	}

	@And("^the user verifies the details in the bears table$")
	public void the_user_verifies_the_details_in_the_bears_table() throws Throwable {
		size= driver.findElements(By.xpath("//table[@class='adap-table']//td[text()='Black']")).size();
			
	}

	@Then("^the number of rows returned should be (\\d+)$")
	public void the_number_of_rows_returned_should_be(int arg1) throws Throwable {
		System.out.println(size);
		Assert.assertEquals(size, arg1);
	   
	}
	
	@And("^close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.quit();
	}

	
	@And("^the user verifies the details in the cat table$")
	public void the_user_verifies_the_details_in_the_cat_table() throws Throwable {
		int i = 0;
		List<WebElement> catCount = driver.findElements(By.xpath(
				"//table[@class='adap-table']//following-sibling::table//tbody//tr//child::td[contains(text(),'lbs')]"));
		for (WebElement s : catCount) {
			str[i] = s.getText();
			arrStr = str[i].split(" ");
			
			if (Integer.parseInt(arrStr[0]) < 15) {
				b = true;
			} else {
				b = false;
				break;
			}

			i++;
		}
		
	    System.out.println(b);
	   }
	
	@Then("^it should return \"([^\"]*)\"$")
	public void it_should_return(String arg1) throws Throwable {
	    Assert.assertFalse(Boolean.valueOf(arg1));
	}

	
	@And("^the user verifies the number of rows in the STAR WARS table$")
	public void the_user_verifies_the_number_of_rows_in_the_STAR_WARS_table() throws Throwable {
		count = driver
				.findElements(By.xpath("//table[@class='adap-table']//following-sibling::table[2]//tbody//tr")).size();
	}
	
	@Then("^the number of rows should be (\\d+)$")
	public void the_number_of_rows_should_be(int arg1) throws Throwable {
		System.out.println(count);
		Assert.assertEquals(count, arg1);
	    
	}
	
	
	
	@And("^the user counts number of characters in the description column$")
	public void the_user_counts_number_of_characters_in_the_description_column() throws Throwable {
		String s2;
		List<WebElement> starList = driver.findElements(By.xpath(
				"//table[@class='adap-table']//following-sibling::table[2]//tbody//tr//child::td[@class='description']"));
		for (WebElement s : starList) {
			s2 = s.getText();
			
			if (s2.length() < 350) {
				b = true;
			} else {
				b = false;
				break;
			}

		}
		System.out.println(b);
	   
	}
	
	
	@Then("^the user should return \"([^\"]*)\"$")
	public void the_user_should_return(String arg1) throws Throwable {
		 Assert.assertTrue(Boolean.valueOf(arg1));
	}

	
}
