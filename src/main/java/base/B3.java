package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class B3 {
    private WebDriver driver;

    public void runHeroku() {
        // "https://the-internet.herokuapp.com/login"
        // Setting property and get info from random URL
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().setSize(new Dimension(375, 812));

        // Find element
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");

        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("SuperSecretPassword!");


        System.out.println("Website find info is: " + driver.getTitle());
        System.out.println("Name attribute of Username button: " + userName.getAttribute("name"));
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        driver.navigate().back();

        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        System.out.println(inputList.size());

        for(WebElement element:inputList){
            System.out.println("Element: " + element.getAttribute("name"));
        }

        for(int i = 0; i < inputList.size(); i++){
            System.out.println("Element: " + inputList.get(i).getAttribute("name"));
        }
    }

    public void runDemoqua() {
        // https://demoqa.com/automation-practice-form
        // Setting property and get info from random URL
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().setSize(new Dimension(375, 812));

        // Find element
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Vo");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Nam");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("nhokmant2003@gmail.com");

        WebElement gender = driver.findElement(By.id("gender-radio-1"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", gender);

        Actions actions = new Actions(driver);
        actions.moveToElement(gender).click().perform();

        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("0935193055");

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.sendKeys("18 Dec 2003");

        WebElement hobbieSport = driver.findElement(By.id("hobbies-checkbox-1"));
        hobbieSport.click();
        WebElement hobbieRead = driver.findElement(By.id("hobbies-checkbox-2"));
        hobbieRead.click();
        WebElement hobbieMusic = driver.findElement(By.id("hobbies-checkbox-3"));
        hobbieMusic.click();

        String img_path = "src/img/img.png";
        WebElement uploadImg = driver.findElement(By.id("uploadPicture"));
        uploadImg.sendKeys(img_path);

        WebElement addRess = driver.findElement(By.id("currentAddress"));
        addRess.sendKeys("K142 Le Van Thu Street");

        driver.findElement(By.xpath("//i[contains(text(),'Submit')]")).click();

        List<WebElement> inputList = driver.findElements(By.tagName("input"));

        System.out.println("Website find info is: " + driver.getTitle());
        System.out.println(inputList.size());

        for(WebElement element:inputList){
            System.out.println("Element: " + element.getAttribute("name"));
        }

        for(int i = 0; i < inputList.size(); i++){
            System.out.println("Element: " + inputList.get(i).getAttribute("name"));
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }

    public void runTestpage(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.manage().window().setSize(new Dimension(375, 812));

        // Find element
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("namvo2003");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("0935193055Nvoz@");

        WebElement comment = driver.findElement(By.name("comments"));
        comment.sendKeys("I'm a boy IT.");

        String img_path = Paths.get("./src/img/img.png").toAbsolutePath().toString();
        WebElement uploadFile = driver.findElement(By.name("filename"));
        uploadFile.sendKeys(img_path);

        List<WebElement> checkList = driver.findElements(By.name("checkboxes[]"));
        for (WebElement checkbox: checkList) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
//        if (!checkList.get(1).isSelected()) {
//            checkList.get(1).click();
//        }

        List<WebElement> radioList = driver.findElements(By.name("radioval"));
        for (WebElement radio: radioList) {
            if (radio.getAttribute("value").equals("rd1") && !radio.isSelected()) {
                radio.click();
                break; // Dừng vòng lặp sau khi đã chọn đúng radio
            }
        }
//        if (!radioList.get(1).isSelected()) {
//            radioList.get(1).click();
//        }

        WebElement selectList = driver.findElement(By.name("multipleselect[]"));
        Select select = new Select(selectList);
        select.selectByIndex(2); // Chọn option thứ 3 (vì chỉ số bắt đầu từ 0)
//        select.selectByValue("ms3"); // Chọn option có value là "3"
//        select.selectByVisibleText("Selection Item 3"); // Chọn option có text hiển thị là "Option 3"

        WebElement selectDropdown = driver.findElement(By.name("dropdown"));
        Select dropdown = new Select(selectDropdown);
//        dropdown.selectByIndex(0);
        dropdown.selectByValue("dd1");
//        dropdown.selectByVisibleText("Drop Down Item 1");

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        List<WebElement> inputList = driver.findElements(By.tagName("li"));

        System.out.println(inputList.size());
        for(WebElement element:inputList){
            System.out.println("Content: " + element.getText());
        }

        driver.navigate().back();
    }

    public void runFormy(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().setSize(new Dimension(375, 812));

        // Element
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Vo");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Nam");

        WebElement jobTitle = driver.findElement(By.id("job-title"));
        jobTitle.sendKeys("Information Technology");

        WebElement lvEdu = driver.findElement(By.id("radio-button-3"));
        lvEdu.click();

        WebElement gender = driver.findElement(By.id("checkbox-1"));
        gender.click();

        WebElement yearExper = driver.findElement(By.id("select-menu"));
        Select year = new Select(yearExper);
        year.selectByIndex(1);

        WebElement dateOfBirth = driver.findElement(By.cssSelector("input[data-provide='datepicker']"));
        dateOfBirth.sendKeys("12/18/2003");

//        WebElement submitButton = driver.findElement(By.cssSelector("a[role='button'][href]"));
        WebElement submitButton = driver.findElement(By.xpath("//a[@role='button' and @href]"));
        submitButton.click();
    }

    public void runSwag(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().setSize(new Dimension(375, 812));

        // Element
        WebElement divAccount = driver.findElement(By.xpath("//div[h4[text()='Accepted usernames are:']]"));
        String allText = divAccount.getText();
        String[] usernamesArray = allText.split("\n"); // Chia nhỏ theo dấu ngắt dòng
        for (String username: usernamesArray) {
            System.out.println(username.trim()); // In từng tên tài khoản
        }

        WebElement passwordElement = driver.findElement(By.className("login_password"));
        String passwordList = passwordElement.getText();
        String[] passwordArray = passwordList.split("\n");
        for (String password: passwordArray) {
            System.out.println(password.trim()); // In từng tên tài khoản
        }

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys(usernamesArray[1]);

        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys(passwordArray[1]);

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
    }

    public static void main(String[] args) {
        B3 b3 = new B3();
        b3.runHeroku();
        b3.runDemoqua();
        b3.runTestpage();
        b3.runFormy();
        b3.runSwag();
    }
}
