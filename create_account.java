package Test_projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class create_account {
	WebDriver driver;
	@BeforeSuite()
	public void beoresuite() 
	{
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver129.exe");	
		driver=new ChromeDriver();
		driver.navigate().to("https://magento.softwaretestingboard.com/");
	}
	@Test(priority=1)
	public void valid_credentials() throws InterruptedException
	{
		driver.findElement(By.linkText("Create an Account")).click();
		Thread.sleep(2000);//					---------------time--------------
		driver.findElement(By.id("firstname")).sendKeys("shubham");
		driver.findElement(By.id("lastname")).sendKeys("thange");
		driver.findElement(By.id("email_address")).sendKeys("shubham112@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Pass12@12");
		driver.findElement(By.id("password-confirmation")).sendKeys("Pass12@12");
		driver.findElement(By.xpath("//div/div/button[@title='Create an Account']")).click();
		
		Thread.sleep(2000);//					---------------time--------------
		String exp="My Account";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
		
		System.out.println("run prio 1");
	}
	
	@Test(priority=2)
	public void invalid_credentials() throws InterruptedException
	{
		driver.findElement(By.linkText("Create an Account")).click();
		Thread.sleep(2000);//					---------------time--------------
		driver.findElement(By.id("firstname")).sendKeys("shuam");
		driver.findElement(By.id("lastname")).sendKeys("than");
		driver.findElement(By.id("email_address")).sendKeys("shubham12@gmail");
		driver.findElement(By.id("password")).sendKeys("Pass2@2");
		driver.findElement(By.id("password-confirmation")).sendKeys("Pass112");
		driver.findElement(By.xpath("//div/div/button[@title='Create an Account']")).click();
		
		Thread.sleep(2000);//					---------------time--------------
		String exp="Create New Customer Account";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
		System.out.println("run prio 2");
	}
	
	@Test(priority=4)
	public void partially_invalid_credentials() throws InterruptedException
	{
		driver.findElement(By.linkText("Create an Account")).click();
		Thread.sleep(2000);//					---------------time--------------
		driver.findElement(By.id("firstname")).sendKeys("shubham");
		driver.findElement(By.id("lastname")).sendKeys("thange");
		driver.findElement(By.id("email_address")).sendKeys("shubham12@gmailom");
		driver.findElement(By.id("password")).sendKeys("Pass12@12");
		driver.findElement(By.id("password-confirmation")).sendKeys("Pass@12");
		driver.findElement(By.xpath("//div/div/button[@title='Create an Account']")).click();
		
		Thread.sleep(2000);//					---------------time--------------
		String exp="Create New Customer Account";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
		
		System.out.println("run prio 4");
	}
	
	@Test(priority=3)
	public void empty_field() throws InterruptedException
	{
		driver.findElement(By.linkText("Create an Account")).click();
		Thread.sleep(2000);//					---------------time--------------
		driver.findElement(By.id("firstname")).sendKeys(" ");
		driver.findElement(By.id("lastname")).sendKeys("");
		driver.findElement(By.id("email_address")).sendKeys(" ");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("password-confirmation")).sendKeys("");
		driver.findElement(By.xpath("//div/div/button[@title='Create an Account']")).click();
		
		Thread.sleep(2000);//					---------------time--------------
		String exp="Create New Customer Account";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
		System.out.println("run prio 3");
	}
	
	@Test(priority=5)
	public void partially_empty_field() throws InterruptedException
	{
		driver.findElement(By.linkText("Create an Account")).click();
		Thread.sleep(2000);//					---------------time--------------
		driver.findElement(By.id("firstname")).sendKeys("shubham");
		driver.findElement(By.id("lastname")).sendKeys("");
		driver.findElement(By.id("email_address")).sendKeys("shubham12@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Pass12@12");
		driver.findElement(By.id("password-confirmation")).sendKeys("");
		driver.findElement(By.xpath("//div/div/button[@title='Create an Account']")).click();
		
		Thread.sleep(2000);//					---------------time--------------
		String exp="Create New Customer Account";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
		System.out.println("run prio 5");
	}
	
	
	@AfterSuite()
	public void aftersuite()
	{
		driver.close();
	}

}
