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

public class RulesAndInfoTest {
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
        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[1]/div[1]"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div/div[2]/div/c-wiz/div/div[2]/a[1]"))
                .click();
        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[1]/div[5]/span"));
        assertEquals(text.getText(),"Политика конфиденциальности и Условия использования");
    }
}
