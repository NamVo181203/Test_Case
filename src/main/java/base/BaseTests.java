package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().setSize(new Dimension(375, 812));

//        WebElement elementById = driver.findElement(By.id("firstName"));
//        WebElement elementByName = driver.findElement(By.name("firstName"));
        List<WebElement> inputList = driver.findElements(By.tagName("input"));
//        WebElement elementByClass = driver.findElement(By.className("form-input"));
//        WebElement linkByText = driver.findElement(By.linkText("Home"));
//        WebElement linkByPartialText = driver.findElement(By.partialLinkText("Hom"));
//        WebElement elementByXPath = driver.findElement(By.xpath("//input[@id='firstName']"));
//        WebElement elementByCSS = driver.findElement(By.cssSelector("#firstName"));

        for (WebElement element:inputList){
            System.out.println("Element: " + element);
        }

//        System.out.println(elementById);
//        System.out.println(elementByName);
//        System.out.println(elementByClass);
//        System.out.println(linkByText);
//        System.out.println(linkByPartialText);
//        System.out.println(elementByXPath);
//        System.out.println(elementByCSS);

        System.out.println(driver.getTitle());

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.quit();
    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
