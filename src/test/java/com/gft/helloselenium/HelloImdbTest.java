package com.gft.helloselenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HelloImdbTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeAll
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterAll
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void helloImdb() {
        // Test name: HelloImdb
        // Step # | name | target | value
        // 1 | open | https://www.imdb.com/ |
        driver.get("https://www.imdb.com/");
        // 2 | setWindowSize | 1024x859 |
        driver.manage().window().setSize(new Dimension(1024, 859));
        // 3 | type | id=suggestion-search | el juego del calamar
        driver.findElement(By.id("suggestion-search")).sendKeys("el juego del calamar");
        // 4 | runScript | window.scrollTo(0,0) |
        js.executeScript("window.scrollTo(0,0)");
        // 5 | sendKeys | id=suggestion-search | ${KEY_ENTER}
        driver.findElement(By.id("suggestion-search")).sendKeys(Keys.ENTER);
        // 6 | click | linkText=Squid Game |
        driver.findElement(By.linkText("Squid Game")).click();
        // 7 | assertText | xpath=//h1 | Squid Game
        assertThat(driver.findElement(By.xpath("//h1")).getText(), is("Squid Game"));
    }
}