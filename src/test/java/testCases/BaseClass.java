package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws IOException

	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());

		switch (br.toLowerCase()) {
		case "edge":
			driver = new EdgeDriver();
		case "chrome":
			driver = new ChromeDriver();
		default:
			System.out.println("Invalid Browser");
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
