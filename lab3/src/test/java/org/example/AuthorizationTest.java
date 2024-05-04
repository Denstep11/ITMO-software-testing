package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorizationTest {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://translate.google.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void authorisation() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div[1]/a"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]"))
                .sendKeys("denis@gmail.com", Keys.ENTER);
        Thread.sleep(2000);
        WebElement result = driver.findElement(By.xpath("//*[@id=\"headingText\"]/span"));
        assertEquals(result.getText(),"Не удалось войти в аккаунт");
    }
}
