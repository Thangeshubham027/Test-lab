package Test_projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;

public class e_comm_project {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver129.exe");
		WebDriver driver=new ChromeDriver();
		
//		creating object for action class
		Actions a = new Actions(driver);

//		creating object for JavaExecutor class
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		
		Thread.sleep(2000);//					---------------time------------
		//driver.get("https://www.google.com");
		driver.navigate().to("https://magento.softwaretestingboard.com/");
//		Thread.sleep(2000);//					---------------time-------------
		driver.manage().window().maximize();
		driver.navigate().refresh();
//		String title=driver.getTitle();  //get the title of the webpage
//		System.out.println("Title of the WebPage : "+title);
//		System.out.println(driver.getTitle());
		
//		Test Scenario 1
////		account creation
//		driver.findElement(By.linkText("Create an Account")).click();
//		Thread.sleep(2000);//					---------------time--------------
//		driver.findElement(By.id("firstname")).sendKeys("shubham");
//		driver.findElement(By.id("lastname")).sendKeys("thange");
//		driver.findElement(By.id("email_address")).sendKeys("shubham12@gmail.com");
//		driver.findElement(By.id("password")).sendKeys("Pass12@12");
//		driver.findElement(By.id("password-confirmation")).sendKeys("Pass12@12");
//		driver.findElement(By.xpath("//div/div/button[@title='Create an Account']")).click();
//		
		
//		sign in
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("shubham12@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Pass12@12");
		driver.findElement(By.name("send")).click();
		
		
//		search,select product and select color and size
//		WebElement product = driver.findElement(By.id("search"));
//		product.sendKeys("man hoodie");
//		product.sendKeys(Keys.ENTER);
//		Thread.sleep(5000);//					---------------time--------------
//		
//		WebElement prod = driver.findElement(By.xpath("//img[@src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/m/h/mh09-blue_main_1.jpg']"));
//		JS.executeScript("arguments[0].scrollIntoView()",prod);
//		Thread.sleep(2000);//					---------------time------------
//		prod.click();
//		Thread.sleep(2000);//					---------------time------------
//
//		driver.findElement(By.id("option-label-size-143-item-168")).click();
//		driver.findElement(By.id("option-label-color-93-item-53")).click();
//		driver.findElement(By.id("qty")).clear();
//		driver.findElement(By.id("qty")).sendKeys("5");
//		driver.findElement(By.id("product-addtocart-button")).click();
		driver.navigate().refresh();
		Thread.sleep(5000);//					---------------time------------
//		driver.findElement(By.linkText("My Cart")).click();
		driver.navigate().refresh();
		Thread.sleep(5000);//					---------------time------------
		driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		driver.findElement(By.xpath("//a[@class='action viewcart']")).click();
		driver.findElement(By.xpath("//button[@data-role='proceed-to-checkout']")).click();
		Thread.sleep(10000);//					---------------time------------
		driver.findElement(By.xpath("//button[@class='action action-show-popup']")).click();
		
		Thread.sleep(5000);//					---------------time------------

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
		WebElement sadd = driver.findElement(By.xpath("//input[@type='checkbox']"));
		if (sadd.isSelected())
		{
			sadd.click();
		}
		
		driver.findElement(By.xpath("//button[@class='action primary action-save-address']")).click();
		Thread.sleep(10000);//					---------------time------------

		driver.findElement(By.className("radio")).click();
		driver.findElement(By.xpath("//div/button[@data-role='opc-continue']")).click();
		Thread.sleep(5000);//					---------------time------------
		driver.findElement(By.xpath("//button[@title='Place Order']")).click();
		
		Thread.sleep(10000);//					---------------time------------

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
		
		
		


		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Thread.sleep(2000);//					---------------time--------------		
		driver.close();
	}
}
