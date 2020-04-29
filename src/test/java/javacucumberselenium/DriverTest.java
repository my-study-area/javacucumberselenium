package javacucumberselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverTest {


	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "/home/adriano/workspace-neon-2/chromedriver");
		System.setProperty("webdriver.gecko.driver","/home/adriano/workspace-neon-2/geckodriver");

//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.goole.com.br/");
		System.out.println("O título da página é: " + driver.getTitle());
		driver.close();
	}

}
