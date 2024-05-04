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

public class SoundSettingTest {

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
    public void settingSoundNormal() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[1]/c-wiz/div[5]/button"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[1]/c-wiz/div[2]/c-wiz/div[2]/div/div[3]/div/div[2]/span[133]/div[1]/div[2]"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz[1]/span/span/div/textarea"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz[1]/span/span/div/textarea"))
                .sendKeys("дурак");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[2]/div[2]/div/c-wiz"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"i3\"]"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[2]/div[2]/div/c-wiz"))
                .click();
        WebElement sound = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz[2]/div/div[6]/div/div[6]/div[1]/div[2]/span/button"));
        sound.click();
        Thread.sleep(3000);
    }

    @Test
    public void settingSoundSlowly() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[1]/c-wiz/div[5]/button"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[1]/c-wiz/div[2]/c-wiz/div[2]/div/div[3]/div/div[2]/span[133]/div[1]/div[2]"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz[1]/span/span/div/textarea"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz[1]/span/span/div/textarea"))
                .sendKeys("дурак");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[2]/div[2]/div/c-wiz"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"i4\"]"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[2]/div[2]/div/c-wiz"))
                .click();
        WebElement sound = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz[2]/div/div[6]/div/div[6]/div[1]/div[2]/span/button"));
        sound.click();
        Thread.sleep(3000);
    }

    @Test
    public void settingSoundVerySlowly() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[1]/c-wiz/div[5]/button"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[1]/c-wiz/div[2]/c-wiz/div[2]/div/div[3]/div/div[2]/span[133]/div[1]/div[2]"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz[1]/span/span/div/textarea"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz[1]/span/span/div/textarea"))
                .sendKeys("дурак");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[2]/div[2]/div/c-wiz"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"i5\"]"))
                .click();
        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[2]/div[2]/div/c-wiz"))
                .click();
        WebElement sound = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz[2]/div/div[6]/div/div[6]/div[1]/div[2]/span/button"));
        sound.click();
        Thread.sleep(3000);
    }

}
