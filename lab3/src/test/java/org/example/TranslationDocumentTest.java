package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslationDocumentTest {
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
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[1]/nav/div[3]/div/button"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[3]/c-wiz/div[1]/c-wiz/div[1]/c-wiz/div[5]/button"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[3]/c-wiz/div[1]/c-wiz/div[2]/c-wiz/div[2]/div/div[3]/div/div[2]/span[5]/div[1]/div[2]"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"ucj-21\"]"))
                .sendKeys("C:\\Users\\denvv\\OneDrive\\Desktop\\6 сем\\Сети\\лаб3\\лаб3.docx");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[3]/c-wiz/div[2]/c-wiz/div/div[1]/div/div[2]/div/div/button"))
                        .click();
        Thread.sleep(10000);
        WebElement result = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[3]/c-wiz/div[2]/c-wiz/div/div[1]/div/div[2]/div/button/span[2]"));
        assertEquals(result.getText(),"Скачать перевод");
    }
}
