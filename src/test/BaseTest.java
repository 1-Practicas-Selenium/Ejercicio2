package test;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {
	
	static WebDriver driver;
	
	
	public static void buttonback() {
		WebDriverWait wait = new WebDriverWait(driver,15);
		WebElement buttonBack = wait
									.until(
											ExpectedConditions
											.presenceOfElementLocated(
													By.xpath("//a[@class = 'btn btn-primary']")));
		buttonBack.click();
		
	}
	
	public static void change_color() {
		List<WebElement> links = driver.findElements(By.xpath("//div[@class = 'card light-blue darken-1']"));
		String color1 = links.get(2).getCssValue("background-color");
		System.out.println("The color the movie es: " + color1);
					
	}
	
	public static void page_back() {
		driver.navigate().back();
		
	}

	public static void clickLink() {
		List<WebElement> links = driver.findElements(By.xpath("//a[text()='URL']"));
	 	if (links.size() > 1) {
			System.out.println("Existen: " + links.size() + " movies.");
			links.get(1).click();
		} else {
			System.out.println("Existen:" + links.size());
			System.exit(-1);
		}

	}
	
	
	public static void searchtvShow(String Batman) {
		driver.manage().window().maximize();
		// busqueda
		WebElement searchBox = driver.findElement(By.name("search"));
		WebElement searchButton = driver.findElement(By.xpath("//i[text()='search']"));

		searchBox.clear();
		searchBox.sendKeys(Batman);
		searchButton.click();

	}

	public static void setUp(String browser, String url) {
		switch (browser) {
		case "Chrome":
			// System.setProperty("webdriver.chrome.driver", "/test_automation");
			driver = new ChromeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		case "Ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Ese browser no existe");
			System.exit(-1);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

	}

	public static void closeBrowser() {
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.close();
	
}

}
