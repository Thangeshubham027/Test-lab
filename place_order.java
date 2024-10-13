//sign in and place order first time................


package Test_projects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class place_order {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver129.exe");
		WebDriver driver=new ChromeDriver();
		
//		creating object for action class
		Actions a = new Actions(driver);
		
//		implicit wait
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		creating object for wait method
		WebDriverWait wait = new WebDriverWait(driver,10);

//		creating object for JavaExecutor class
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		
		Thread.sleep(2000);//					---------------time------------
		//driver.get("https://www.google.com");
		driver.navigate().to("https://magento.softwaretestingboard.com/");
//		Thread.sleep(2000);//					---------------time-------------
//		driver.manage().window().maximize();
		driver.navigate().refresh();
		
		
//		sing in ..........
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("sej88@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("sej88@gmail.com1");
		WebElement sign_in=driver.findElement(By.name("send"));
		WebElement clk_sign = wait.until(ExpectedConditions.elementToBeClickable(sign_in));
		clk_sign.click();
	
		
//		search,select product and select color and size
		WebElement product = driver.findElement(By.id("search"));
		product.sendKeys("man hoodie");
		product.sendKeys(Keys.ENTER);
		Thread.sleep(2000);//					---------------time--------------
		
		WebElement prod = driver.findElement(By.xpath("//img[@src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/m/h/mh09-blue_main_1.jpg']"));
		JS.executeScript("arguments[0].scrollIntoView()",prod);
		WebElement prod_w = wait.until(ExpectedConditions.elementToBeClickable(prod));
		prod_w.click();
		
		Thread.sleep(2000);//					---------------time------------
		driver.findElement(By.id("option-label-size-143-item-168")).click();
		driver.findElement(By.id("option-label-color-93-item-53")).click();
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("5");
		driver.findElement(By.id("product-addtocart-button")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);//					---------------time------------
		
		WebElement cart= driver.findElement(By.xpath("//a[@class='action showcart']"));
		WebElement cart_w= wait.until(ExpectedConditions.elementToBeClickable(cart));
		cart_w.click();
		
		WebElement sh_cart = driver.findElement(By.xpath("//a[@class='action viewcart']"));
		JS.executeScript("arguments[0].scrollIntoView()",sh_cart);

		WebElement sh_cart_w = wait.until(ExpectedConditions.elementToBeClickable(sh_cart));
		sh_cart_w.click();
		
		
		driver.findElement(By.xpath("//button[@data-role='proceed-to-checkout']")).click();
		Thread.sleep(2000);//					---------------time------------
		driver.findElement(By.name("company")).sendKeys("SST infotech");
		driver.findElement(By.name("street[0]")).sendKeys("Sivshastri nagar");
		driver.findElement(By.name("street[1]")).sendKeys("Cuffe Parade");
		driver.findElement(By.name("street[2]")).sendKeys("Colaba");
		driver.findElement(By.name("city")).sendKeys("Mumbai");
		WebElement country = driver.findElement(By.name("country_id"));
		Select s2 = new Select(country);
		s2.selectByVisibleText("India");
		
		WebElement state=driver.findElement(By.name("region_id"));
		Select s1 = new Select(state);
		s1.selectByVisibleText("Maharashtra");
		
		driver.findElement(By.name("postcode")).sendKeys("400005");
		driver.findElement(By.name("telephone")).sendKeys("9658741526");
		
		Thread.sleep(5000);//					---------------time------------
//		driver.findElement(By.xpath("//div[@class='title']")).click();
//		
//		driver.findElement(By.xpath("//div[@class='product options']")).click();
		
		driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
		Thread.sleep(5000);//					---------------time------------
//		driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
		WebElement plc_ord = driver.findElement(By.xpath("//button/span[text()='Place Order']"));
		WebElement plc_ord_w = wait.until(ExpectedConditions.elementToBeClickable(plc_ord));
		plc_ord_w.click();
		Thread.sleep(2000);//					---------------time------------
		
		String comp=driver.getTitle();
		String act="Success Page";
		if (comp.equals(act))
		{
			System.out.println("Order successfully placed ");
		}
		else
		{
			System.out.println("Order not Places !!! ");
		}
		
		driver.close();
	}

}
