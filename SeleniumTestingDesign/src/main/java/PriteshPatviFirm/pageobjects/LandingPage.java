package PriteshPatviFirm.pageobjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PriteshPatviFirm.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	// TODO Auto-generated method stub
		WebDriver driver;
		
		public LandingPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		//WebElement userEmail=driver.findElement(By.id("userEmail"));
		//PageFactory
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement Password;
		
		@FindBy(id="login")
		WebElement submit;
		//You can take xpath css tagname any locator in case of id.
			
		public void LoginApplication(String email, String password) {
			userEmail.sendKeys(email);
			Password.sendKeys(password);
			submit.click();
		}
		
		public void goTo() {
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		
}