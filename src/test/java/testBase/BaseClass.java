package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger;


public class BaseClass {

public WebDriver driver;

public Logger logger;    //log4j

public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})   //for crossbrowsing and parallel testing
	public void setup(String os,String br) throws IOException
	{
		//loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());  //for logging
		
		switch(br.toLowerCase())
		{
		   case "chrome" :driver=new ChromeDriver(); break;
		   case "edge" :driver=new EdgeDriver(); break;
		   case "firefox" :driver=new FirefoxDriver(); break;
		   
		   default: System.out.println("Invalid Browser name..");return;
		
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		
		driver.get(p.getProperty("appURL")); //Reading url from properties file
		
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomeNumber()
	{
		String generatednumber=RandomStringUtils.randomAlphabetic(10);
		return generatednumber;
	}

	public String randomeAlphaNumberic()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomAlphabetic(3);
		return (generatedstring+"@"+generatednumber);
	}
	
}
