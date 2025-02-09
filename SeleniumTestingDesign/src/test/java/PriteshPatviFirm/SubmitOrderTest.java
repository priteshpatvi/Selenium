package PriteshPatviFirm;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PriteshPatviFirm.pageobjects.LandingPage;
import PriteshPatviFirm.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productname="ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		LandingPage landingpage = new LandingPage(driver);
		
		
		landingpage.goTo();
		landingpage.LoginApplication("learnwithpritesh@gmail.com", "Pritesh@123");
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mb-3")));
		//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		List<WebElement>products=productCatalogue.getProductList();
		
		
		WebElement prod = products.stream()
                .filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productname))
                .findFirst()
                .orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("toast-container")));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	
		driver.findElement(By.cssSelector("button[routerlink*=cart]")).click();
		
		List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cartSection h3"));
	
		boolean match= cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productname));
		
		Assert.assertTrue(match);
	
		driver.findElement(By.cssSelector(".totalRow button")).click();
	
		
		Actions a= new Actions (driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder=\"Select Country\"]")), "india").build().perform();		
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		//Not told in lect of projectframework-1 We Face Issue that why we added this.
	JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String message= driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		System.out.println(message);																										 
		driver.quit();
	
	}
	
}