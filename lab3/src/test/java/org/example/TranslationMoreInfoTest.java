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

public class TranslationMoreInfoTest {

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
    public void translationTextRuToEng1() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[1]/c-wiz/div[5]/button"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[1]/c-wiz/div[2]/c-wiz/div[2]/div/div[3]/div/div[2]/span[5]/div[1]/div[2]"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz[1]/span/span/div/textarea"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz[1]/span/span/div/textarea"))
                .sendKeys("Привет");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz[2]/div[1]/div[6]/div/div[4]/div/a"))
                .click();
        WebElement text = driver.findElement(By.xpath("//*[@id=\"definitionsDetailsTab\"]/span[1]/span"));
        assertEquals(text.getText(),"Определения");
    }

}
