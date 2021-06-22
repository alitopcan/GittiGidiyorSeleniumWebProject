package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AppTest {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 15, 750);
        driver.get("https://www.gittigidiyor.com/");

    }

    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
        driver.findElement(By.cssSelector("a[class='tyj39b-5 lfsBU']")).click();
        TimeUnit.SECONDS.sleep(2);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("div[data-cy=\"header-user-menu\"]"))).build().perform();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("a[data-cy='header-login-button']")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.id("L-UserNameField")).sendKeys("alitopcan@outlook.com");
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("L-PasswordField")).sendKeys("atopcan20");
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("gg-login-enter")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.name("k")).sendKeys("bilgisayar");
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("button[data-cy='search-find-button']")).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a")).click();
        TimeUnit.SECONDS.sleep(2);

        List <WebElement> listings = driver.findElements(By.id("best-match-right"));
        System.out.println(listings.size());
        Random r = new Random();
        int randomValue = r.nextInt(listings.size());
        listings.get(randomValue).click();
        TimeUnit.SECONDS.sleep(3);

        driver.findElement(By.id("add-to-basket")).click();
        TimeUnit.SECONDS.sleep(3);
//        actions.moveToElement(driver.findElement(By.cssSelector("div[class='basket-container robot-header-iconContainer-cart']"))).build().perform();
//        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("a[class='gg-ui-btn-default padding-none']")).click();
        TimeUnit.SECONDS.sleep(3);

        Select select = new Select(driver.findElement(By.cssSelector("select[class='amount']")));
        TimeUnit.SECONDS.sleep(2);
        select.selectByVisibleText("2");
        driver.findElement(By.cssSelector("a[class='btn-delete btn-update-item']")).click();
        TimeUnit.SECONDS.sleep(3);

    }

    @After
    public void tearDown() {
        driver.close();
//        driver.quit();
    }
}
