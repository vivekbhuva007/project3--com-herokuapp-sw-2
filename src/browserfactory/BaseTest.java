package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        // We don't require this line once we assign variable into paranthesis String baseUrl = "https://demo.nopcommerce.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        // Object creation
        driver = new ChromeDriver();

        // Launch the URL
        driver.get(baseUrl);

        // Maximise Window
        driver.manage().window().maximize();

        // We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }

    public void closeBrowser() {
        driver.quit();


    }

}
