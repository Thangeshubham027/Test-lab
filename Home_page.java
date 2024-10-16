package Test_projects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Home_page {
  
	WebDriver driver;
	WebDriverWait wait;
	Actions ac; 


	
	@BeforeTest
	public void Driver()
	{
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver129.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("shubham12@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Pass12@12");
		driver.findElement(By.name("send")).click();
	
	}
	
	
	@Test
	public void my_acc() throws InterruptedException 
	{
		
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		  driver.findElement(By.linkText("My Account")).click();
			Thread.sleep(2000);//					---------------time--------------
			
			String act="My Account";
			String exp=driver.getTitle();
			Assert.assertEquals(act, exp);
			
	}
	
	@Test
	public void wish_list() throws InterruptedException
	{
		driver.navigate().back();
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		  driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[2]/a")).click();
			Thread.sleep(2000);//					---------------time--------------
			
			String act="My Wish List";
			String exp=driver.getTitle();
			Assert.assertEquals(act, exp);
	}
	
	@Test
	public void what_new()
	{
		driver.navigate().back();
		driver.findElement(By.linkText("What's New")).click();
		String act="What's New";
		String exp=driver.getTitle();
		Assert.assertEquals(act, exp);
		
	}
	
	@Test
	public void men_func() throws InterruptedException
	{
	
		driver.navigate().back();
		ac = new Actions(driver);
		wait = new WebDriverWait(driver,10);
		
		WebElement men =driver.findElement(By.xpath("//a[@id='ui-id-5']/span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
		ac.moveToElement(men).perform();
		WebElement bottom =driver.findElement(By.xpath("//a[@id='ui-id-18']"));
		ac.moveToElement(bottom).perform();
		driver.findElement(By.xpath("//a[@id='ui-id-24']")).click();

		String act="Shorts - Bottoms - Men";
		String exp=driver.getTitle();
		Assert.assertEquals(exp,act);
		
		
		driver.findElement(By.id("mode-list")).click();
		WebElement sort = driver.findElement(By.id("sorter"));
		Select sc = new Select(sort);
		sc.selectByVisibleText("Price");
	}
	
	@Test
	public void comp_prod() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@class='logo']"));
		ac = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement men =driver.findElement(By.xpath("//a[@id='ui-id-5']/span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
		ac.moveToElement(men).perform();
		WebElement bottom =driver.findElement(By.xpath("//a[@id='ui-id-18']"));
		ac.moveToElement(bottom).perform();
		driver.findElement(By.xpath("//a[@id='ui-id-24']")).click();
		
		driver.findElement(By.id("mode-list")).click();
		WebElement sort = driver.findElement(By.id("sorter"));
		Select sc = new Select(sort);
		sc.selectByVisibleText("Price");
		
		WebElement prod1=driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div[1]/div[2]/a[2]"));
		js.executeScript("arguments[0].scrollIntoView()",prod1);
		prod1.click();
		Thread.sleep(2000);//					---------------time--------------
		WebElement prod2=driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[2]/div/div/div[4]/div[1]/div[2]/a[2]"));
		js.executeScript("arguments[0].scrollIntoView()",prod2);
		prod2.click();
		Thread.sleep(2000);//					---------------time--------------
		WebElement prod3=driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[3]/div/div/div[3]/div[1]/div[2]/a[2]"));
		js.executeScript("arguments[0].scrollIntoView()",prod3);
		prod3.click();
		Thread.sleep(2000);//					---------------time--------------
		
		driver.findElement(By.xpath("//a[@class='action compare']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/table/tbody[1]/tr/td[1]/div[3]/div[1]/form/button/span")).click();
		Thread.sleep(2000);//					---------------time--------------
		
		driver.findElement(By.id("option-label-size-143-item-177")).click();
		driver.findElement(By.id("option-label-color-93-item-49")).click();
		WebElement qty = driver.findElement(By.id("qty"));
		qty.clear();
		qty.sendKeys("2");
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(2000);//					---------------time--------------

		
		
		driver.findElement(By.xpath("//a[@class='action compare']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/table/tbody[1]/tr/td[2]/div[2]/div[2]/a")).click();
	}
	
	@Test
	public void sel_prod() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@class='logo']"));
		
		WebElement product = driver.findElement(By.id("search"));
		product.sendKeys("man hoodie");
		product.sendKeys(Keys.ENTER);
		Thread.sleep(2000);//					---------------time--------------
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		WebElement prod = driver.findElement(By.xpath("//img[@src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/m/h/mh09-blue_main_1.jpg']"));
		JS.executeScript("arguments[0].scrollIntoView()",prod);
		Thread.sleep(2000);//					---------------time------------
		prod.click();
		Thread.sleep(2000);//					---------------time------------

		driver.findElement(By.id("option-label-size-143-item-168")).click();
		driver.findElement(By.id("option-label-color-93-item-53")).click();
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("5");
		
//		Actions ac = new Actions (driver);
////		WebElement img1 = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]/img"));
////		ac.moveToElement(img1);
//		Thread.sleep(2000);//					---------------time------------		
//		driver.findElement(By.xpath("//div[@class='fotorama__arr fotorama__arr--next']")).click();
//		Thread.sleep(2000);//					---------------time------------
//
//		driver.findElement(By.xpath("//div[@class='fotorama__arr fotorama__arr--next']")).click();
//		Thread.sleep(2000);//					---------------time------------
//		
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(2000);//					---------------time------------

		
		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[5]/div/a[1]/span")).click();
		Thread.sleep(2000);//					---------------time------------
		driver.navigate().back();

		driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[5]/div/a[2]/span")).click();
		Thread.sleep(2000);//					---------------time------------
		
		driver.findElement(By.id("tab-label-additional-title")).click();
		WebElement star = driver.findElement(By.id("tab-label-reviews-title"));
		JS.executeScript("arguments[0]", "scrollIntoView()",star);
		star.click();
//		driver.findElement(By.id("Rating_4_label")).click();
		driver.findElement(By.id("summary_field")).sendKeys("best");
		driver.findElement(By.id("review_field")).sendKeys("good product");
		driver.findElement(By.xpath("//button/span[text()='Submit Review']")).click();
	}
	
	@Test
	public void cart() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@class='logo']"));
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[4]/ol/li[1]/div/div/div[1]/span")).click();
		WebElement qty = driver.findElement(By.id("cart-item-374484-qty"));
		Thread.sleep(2000);//					---------------time--------------
		qty.clear();
		Thread.sleep(2000);//					---------------time--------------
		qty.sendKeys("2");
		
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[4]/ol/li[1]/div/div/div[2]/div[2]/button/span")).click();
		Thread.sleep(5000);//					---------------time--------------
		driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/checkout/cart/configure/id/374357/product_id/414/']")).click();
		Thread.sleep(5000);//					---------------time--------------
		driver.findElement(By.id("option-label-size-143-item-167")).click();
		driver.findElement(By.id("option-label-color-93-item-49")).click();
		WebElement cqty=driver.findElement(By.id("qty"));
		cqty.clear();
		cqty.sendKeys("2");
		driver.findElement(By.id("product-updatecart-button")).click();
		Thread.sleep(5000);//					---------------time--------------
		
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[5]/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/form/div[1]/table/tbody[3]/tr[2]/td/div/a[1]/span")).click();


	}
	@AfterTest
	public void close()
	{
		driver.close();
		
	}
	
}
