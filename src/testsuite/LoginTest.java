package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.UtilitiesMain;

import java.time.Duration;

public class LoginTest extends UtilitiesMain {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        // enter username

        sendTextToElement(By.id("username"), "tomsmith");

        // enter password
        sendTextToElement(By.id("password"), "SuperSecretPassword!");

        // click on login
        clickOnElement(By.xpath("//button[@class='radius']"));

      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

// check expected and actual message
        String expectedMessage = "Secure Area";
        String actualTextMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Secure Area']"));
        //Validate actual and expected message
        Assert.assertEquals("No message found", expectedMessage, actualTextMessage);


    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        // enter username
        sendTextToElement(By.id("username"), "tomsmith1");

          // enter password
        sendTextToElement(By.id("password"), "SuperSecretPassword!");

            // click login
        clickOnElement(By.xpath("//button[@class='radius']"));

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));




        String expectedMessage = "Your username is invalid!\n" +
                "×";
        String actualTextMessage = getTextFromElement(By.xpath("//div[@id = 'flash']"));
        //Validate actual and expected message
        Assert.assertEquals("", expectedMessage, actualTextMessage);


    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // enter username
        sendTextToElement(By.id("username"), "tomsmith");

        // enter password
        sendTextToElement(By.id("password"), "SuperSecretPassword");

        // click on login
        clickOnElement(By.xpath("//button[@class='radius']"));


        // check vaild message occured or not
        String expectedMessage = "Your password is invalid!\n" +
                "×";
        String actualTextMessage = getTextFromElement(By.xpath("//div[@class = 'flash error']"));
        //Validate actual and expected message
        Assert.assertEquals("", expectedMessage, actualTextMessage);


    }


    @After
    public void tearDown() {
        closeBrowser();


    }


}
