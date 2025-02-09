package PriteshPatviFirm.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PriteshPatviFirm.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	// TODO Auto-generated method stub
		WebDriver driver;
		
		public ProductCatalogue(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		//WebElement userEmail=driver.findElement(By.id("userEmail"));
		//PageFactory
		
		//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		@FindBy(css=".mb-3")
		List<WebElement> products;
		
		By productsBy=By.cssSelector(".mb-3");
		
		public List<WebElement> getProductList() {
			WaitForElementToAppear(productsBy);
			return products;
		}
		
		//You can take xpath css tagname any locator in case of id.

		
}