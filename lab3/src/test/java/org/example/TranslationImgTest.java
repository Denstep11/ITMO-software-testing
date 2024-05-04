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

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslationImgTest {

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
    public void translationEngToRu() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[1]/nav/div[2]/div/button/span"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[5]/c-wiz/div[1]/c-wiz/div[1]/c-wiz/div[5]/button"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[5]/c-wiz/div[1]/c-wiz/div[2]/c-wiz/div[2]/div/div[3]/div/div[2]/span[88]/div[1]/div[2]"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"ucj-39\"]"))
               .sendKeys("C:\\Users\\denvv\\OneDrive\\Изображения\\Screenshots\\welcome.png");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[5]/c-wiz/div[2]/c-wiz/div/div[1]/div[2]/div[1]/button"))
                .click();
        WebElement img = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[5]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]"));
        assertEquals(img.findElement(By.tagName("img")).getTagName(),"img");
    }



}
