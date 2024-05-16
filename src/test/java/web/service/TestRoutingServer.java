package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class TestRoutingServer {
    private WebDriver driver;
    private final String LOGIN_URL = "http://localhost:8080/login";
    private final String Q1_URL = "http://localhost:8080/q1";
    private final String Q2_URL = "http://localhost:8080/q2";
    private final String Q3_URL = "http://localhost:8080/q3";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Mansheen Kaur\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testQ1PageValidInput() {
        login();
        driver.get(Q1_URL);
        WebElement number1Input = driver.findElement(By.id("number1"));
        WebElement number2Input = driver.findElement(By.id("number2"));
        WebElement resultInput = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        number1Input.sendKeys("4");
        number2Input.sendKeys("5");
        resultInput.sendKeys("9");
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/q2"));
    }

    @Test
    public void testQ1PageEmptyInput() {
        login();
        driver.get(Q1_URL);
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        submitButton.click();
        assertEquals("Empty input", driver.findElement(By.tagName("div")).getText());
    }

    @Test
    public void testQ1PageNonNumericInput() {
        login();
        driver.get(Q1_URL);
        WebElement number1Input = driver.findElement(By.id("number1"));
        WebElement number2Input = driver.findElement(By.id("number2"));
        WebElement resultInput = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        number1Input.sendKeys("d");
        number2Input.sendKeys("i");
        resultInput.sendKeys("b");
        submitButton.click();
        assertEquals("Invalid input, please enter valid numbers.", driver.findElement(By.tagName("div")).getText());
    }

    @Test
    public void testQ2PageValidInput() {
        driver.get(Q2_URL);
        WebElement number1Input = driver.findElement(By.id("number1"));
        WebElement number2Input = driver.findElement(By.id("number2"));
        WebElement resultInput = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        number1Input.sendKeys("8");
        number2Input.sendKeys("5");
        resultInput.sendKeys("3");
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/q3"));
    }

    @Test
    public void testQ2PageEmptyInput() {
        driver.get(Q2_URL);
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        submitButton.click();
        assertEquals("Empty input", driver.findElement(By.tagName("div")).getText());
    }

    @Test
    public void testQ2PageNonNumericInput() {
        driver.get(Q2_URL);
        WebElement number1Input = driver.findElement(By.id("number1"));
        WebElement number2Input = driver.findElement(By.id("number2"));
        WebElement resultInput = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        number1Input.sendKeys("h");
        number2Input.sendKeys("vr");
        resultInput.sendKeys("gvh");
        submitButton.click();
        assertEquals("Invalid input, please enter valid numbers.", driver.findElement(By.tagName("div")).getText());
    }

    @Test
    public void testQ3PageValidInput() {
        driver.get(Q3_URL);
        WebElement number1Input = driver.findElement(By.id("number1"));
        WebElement number2Input = driver.findElement(By.id("number2"));
        WebElement resultInput = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        number1Input.sendKeys("3");
        number2Input.sendKeys("3");
        resultInput.sendKeys("9");
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/login"));
    }

    @Test
    public void testQ3PageEmptyInput() {
        driver.get(Q3_URL);
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        submitButton.click();
        assertEquals("Empty input", driver.findElement(By.tagName("div")).getText());
    }

    @Test
    public void testQ3PageNonNumericInput() {
        driver.get(Q3_URL);
        WebElement number1Input = driver.findElement(By.id("number1"));
        WebElement number2Input = driver.findElement(By.id("number2"));
        WebElement resultInput = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        number1Input.sendKeys("h");
        number2Input.sendKeys("fr");
        resultInput.sendKeys("e");
        submitButton.click();
        assertEquals("Invalid input, please enter valid numbers.", driver.findElement(By.tagName("div")).getText());
    }

    private void login() {
        driver.get(LOGIN_URL);
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        usernameInput.sendKeys("ahsan");
        passwordInput.sendKeys("ahsan_pass");
        loginButton.click();
        assertEquals(Q1_URL, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
