package SitePractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImrozNiwas {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 
		WebDriverManager.chromedriver().clearResolutionCache();
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("121.0.6167.185").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://imrozniwasold.wpenginepowered.com/");
		// In menu select the wood page 
		driver.findElement(By.xpath("//a[@class='menu-link']")).click();
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//a[@title='Wood']")).click();
		driver.findElement(By.xpath("(//div[@class='serviceSingle'])[3]")).click();
		
		//To increase the quantity in add to cart 
		
		WebElement quantityInput = driver.findElement(By.xpath("//div[@class='quantity']//input[@type='number']"));
		quantityInput.clear(); // Clear the existing value
        quantityInput.sendKeys("3");
        
      WebElement addtocart =  driver.findElement(By.xpath("//button[@name='add-to-cart']"));
      addtocart.click();
      
      //navigate back to home page 
      driver.navigate().to("https://imrozniwasold.wpenginepowered.com/");
      
      //open the corporate page 
      driver.findElement(By.xpath("(//a[@class='btn theme-btn'])[2]")).click();
      
      //open the contact us page through corporate page 
      driver.findElement(By.xpath("//a[@class='btn contact_btn theme-btn']")).click();
      driver.findElement(By.name("fname")).sendKeys("Shakshi");
      driver.findElement(By.name("lname")).sendKeys("Kumar");
      driver.findElement(By.name("useremail")).sendKeys("testingupdate2@gmail.com");
      driver.findElement(By.name("phone")).sendKeys("9876543210");
     a.sendKeys(driver.findElement(By.xpath("//div[@class='formrow fullwidth']//select[@class='wpcf7-form-control wpcf7-select']")),"Corporate Gifting Inquiry").build().perform();
      driver.findElement(By.name("message")).sendKeys("Hi how are you");
     // driver.findElement(By.xpath("//div[@class='formrow fullwidth']//input[@type='submit']")).click();
      
      //open the earth page through navigate 
      driver.navigate().to("https://imrozniwasold.wpenginepowered.com/product-category/earth/");
      driver.findElement(By.xpath("(//div[@class='serviceSingle'])[4]")).click();
     WebElement addquantity =  driver.findElement(By.xpath("//div[@class='quantity']//input[@type='number']"));
      addquantity.clear();
      addquantity.sendKeys("2");
      
      WebElement adddata =driver.findElement(By.xpath("//button[@name='add-to-cart']"));
      adddata.click();
      
      driver.findElement(By.xpath("//a[@class='headercartlink']")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//div[@class='cartitems']//a[@class='button checkout wc-forward']")).click();
      
      //Checkout page
      
      driver.findElement(By.id("billing_first_name")).sendKeys("Rahul");
      driver.findElement(By.id("billing_last_name")).sendKeys("Kapoor");
      driver.findElement(By.id("billing_company")).sendKeys("ABCgroup");
      Thread.sleep(5000);
      
      WebElement selectElement = driver.findElement(By.xpath("//select[@name='billing_country']"));
      Select countryDropdown = new Select(selectElement);
      countryDropdown.selectByVisibleText("India");
    //  Actions a1 = new Actions(driver);
		//a1.sendKeys(driver.findElement(By.cssSelector("[data-placeholder*='Select a country / region…']")), "India").build().perform();


     Thread.sleep(5000);
      driver.findElement(By.name("billing_address_1")).sendKeys("1456 Sunny Enclave");
      driver.findElement(By.id("billing_city")).sendKeys("Chandigarh");
  	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-placeholder='State']")));

	Select provinceDropdown = new Select(dropdown);
	provinceDropdown.selectByVisibleText("Chandigarh");
	
      driver.findElement(By.id("billing_postcode")).sendKeys("160102");
      driver.findElement(By.id("billing_phone")).sendKeys("905-911-6411");
      driver.findElement(By.id("billing_email")).sendKeys("testingupdate2@gmail.com");
      
      //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("number")));
      //WebElement iframeElement = driver.findElement(By.tagName("iframe"));
     // driver.switchTo().frame(iframeElement);
      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='form-row form-row-wide' and label[@id='wc-cybersource-credit-card-account-number-label']]")));

      // Scroll to the element
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
      element.sendKeys("424242424242d");
     
      
      
      //driver.switchTo().defaultContent();
      
      /*JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement table = driver.findElement(By.id("number"));
		js.executeScript("arguments[0].scrollIntoView();", table);
		Thread.sleep(3000);
      //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wc-cybersource-credit-card-account-number-hosted")));
      driver.findElement(By.id("number")).sendKeys("424242424242");*/
      
     // driver.findElement(By.id("wc-cybersource-credit-card-expiry")).sendKeys("03/26");
    //  driver.findElement(By.id("wc-cybersource-credit-card-csc-hosted")).sendKeys("456");
     
      WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait11.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockUI.blockOverlay")));

      // Scroll to the button
      WebElement button = driver.findElement(By.id("place_order"));
      Actions actions = new Actions(driver);
      actions.moveToElement(button).perform();

      // Click the button
      button.click();
      
      
      
		
	}

}
