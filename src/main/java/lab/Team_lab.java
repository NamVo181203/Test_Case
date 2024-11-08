package lab;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Team_lab {
    private WebDriver driver;

    public void runWed(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
    }

    public void login(){
        String username = "Admin";
        String password = "Admin123";

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(username);

        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys(password);


        WebElement locationToClick = driver.findElement(By.xpath("//li[text()='Inpatient Ward']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", locationToClick);

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    public void findPatient(){
        WebElement findPatientButton = driver.findElement(By.xpath("//a[@type='button']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", findPatientButton);

        WebElement patientSearch = driver.findElement(By.id("patient-search"));
        patientSearch.sendKeys("1003T6");

        WebElement patient = driver.findElement(By.xpath("//tr[@class='odd']"));
        js.executeScript("arguments[0].click();", patient);

        driver.navigate().back();
        driver.navigate().back();
    }

    public void logout(){
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='\n" +
                "                        Logout\n" +
                "                        ']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", logoutButton);
    }

    public static void main(String[] args){
        Team_lab lab = new Team_lab();
        lab.runWed();
        lab.login();
        lab.findPatient();
    }

}
