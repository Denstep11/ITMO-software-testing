package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslationSiteTest {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://translate.google.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void translationRuToEng() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[1]/nav/div[4]/div/button"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[4]/c-wiz/div[1]/c-wiz/div[1]/c-wiz/div[5]/button"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[4]/c-wiz/div[1]/c-wiz/div[2]/c-wiz/div[2]/div/div[3]/div/div[2]/span[88]/div[1]/div[2]"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"i48\"]"))
                .sendKeys("https://www.selenium.dev/");
        Thread.sleep(2000);
        String mainWindowHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[4]/c-wiz/div[2]/div/span/button"))
                .click();
        Thread.sleep(5000);
        for (String windowHandle : driver.getWindowHandles()){
            if (!windowHandle.equals(mainWindowHandle)){
                driver.switchTo().window(windowHandle);
            }
        }
        assertEquals(driver.getCurrentUrl(),"https://www-selenium-dev.translate.goog/?_x_tr_sl=auto&_x_tr_tl=ru&_x_tr_hl=ru&_x_tr_pto=wapp");
    }

}
