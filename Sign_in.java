package Test_projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sign_in {
  WebDriver driver;
	@BeforeTest()
	public void beoresuite() 
	{
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver129.exe");	
		driver=new ChromeDriver();
		driver.navigate().to("https://magento.softwaretestingboard.com/");
	}
  
  @Parameters({"us1","ps1"})
  @Test(priority=6)
  public void valid(String us,String ps) throws InterruptedException
  {
		Thread.sleep(2000);//					---------------time--------------
	  driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(us);
		driver.findElement(By.id("pass")).sendKeys(ps);
		driver.findElement(By.name("send")).click();
		Thread.sleep(2000);//					---------------time--------------
		String exp="My Account";
		String act=driver.getTitle();
		String exp1="Home Page";
		String act1=driver.getTitle();
		if(exp.equals(act))
		{
			System.out.println("run prio 6");
		}
		else if(exp1.equals(act1))
		{
			System.out.println("run prio 6");
		}
		
		driver.navigate().refresh();
		Thread.sleep(5000);//					---------------time--------------

		  driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		  driver.findElement(By.linkText("Sign Out")).click();
		  Thread.sleep(10000);//					---------------time--------------
  }
  
  @Parameters({"us2","ps2"})
  @Test(priority=2)
  public void invalid(String us2,String ps2) throws InterruptedException
  {
		Thread.sleep(2000);//					---------------time--------------
	  driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(us2);
		driver.findElement(By.id("pass")).sendKeys(ps2);
		driver.findElement(By.name("send")).click();
		Thread.sleep(2000);//					---------------time--------------
		String exp="Customer Login";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
		System.out.println("run prio 2");
  }
  
  @Parameters({"us3","ps3"})
  @Test(priority=3)
  public void partially_valid(String us3,String ps3) throws InterruptedException
  {
		Thread.sleep(2000);//					---------------time--------------
	  driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(us3);
		driver.findElement(By.id("pass")).sendKeys(ps3);
		driver.findElement(By.name("send")).click();
		Thread.sleep(2000);//					---------------time--------------
		String exp="Customer Login";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
		System.out.println("run prio 3");
  }
  
  @Parameters({"us4","ps4"})
  @Test(priority=4)
  public void Empty(String us4,String ps4) throws InterruptedException
  {
		Thread.sleep(2000);//					---------------time--------------
	  driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(us4);
		driver.findElement(By.id("pass")).sendKeys(ps4);
		driver.findElement(By.name("send")).click();
		Thread.sleep(2000);//					---------------time--------------
		String exp="Customer Login";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
		System.out.println("run prio 4");
  }
  
  @Test(priority=5)
  public void forgot_pass() throws InterruptedException
  {
		Thread.sleep(2000);//					---------------time--------------
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		driver.findElement(By.id("email_address")).sendKeys("shubham12@gmail.com");
		driver.findElement(By.xpath("//div/button[@class='action submit primary']")).click();
		
		Thread.sleep(2000);//					---------------time--------------
		String exp="Customer Login";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
		System.out.println("run prio 5");
  }


  @Test(priority=7)
  public void create_Acc() throws InterruptedException
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
		System.out.println("run prio 7");
  }
  
  @AfterTest()
	public void aftersuite()
	{
	  driver.close();
	}
}
