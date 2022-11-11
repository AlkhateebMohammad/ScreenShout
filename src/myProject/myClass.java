package myProject;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class myClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\mohammed\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://127.0.0.1:5500/index.html");
		driver.manage().window().maximize();

		List<WebElement> numper = driver.findElements(By.tagName("option"));
		int theTotalItems = numper.size();

		// I need to remove one itemes

		int Rnumber = 1;
		for (int i = 0; i < Rnumber; i++) {
			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
		}
		List<WebElement> theAfterremovenumper = driver.findElements(By.tagName("option"));
		int accuailNumper = theAfterremovenumper.size();
		int expectedNumper = theTotalItems - Rnumber;
		Assert.assertEquals(accuailNumper, expectedNumper);

		Date currentDate = new Date();
		String screenshoutFileName = currentDate.toString().replace(":", "_");
		TakesScreenshot src = ((TakesScreenshot) driver);
		File SrcFile = src.getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\picture/" + screenshoutFileName + ".png");
		FileUtils.copyFile(SrcFile, Dest);

	}

}
