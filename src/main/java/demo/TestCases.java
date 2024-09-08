package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.LocalDate;

public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.contains("calendar")){
            System.out.println("Test Case 01: PASS");
        }else{
            System.out.println("Test Case 01: FAIL");
        }
        System.out.println("end Test case: testCase02");
    }

    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://calendar.google.com/");
        Thread.sleep(3000);
        
        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[2]/div[3]/div/div/div/div[5]/div/div[1]/div[1]/div/button/span"));
        dropdownElement.click();
        //System.out.println("endkk");
        Thread.sleep(5000);
        List<WebElement> dropdownListElement = driver.findElements(By.xpath("//li[@class='OwNvm VfPpkd-StrnGf-rymPhb-ibnC6b']"));
        for(WebElement List: dropdownListElement){
            if(List.getText().contains("Month")){
                List.click();
            }
        }
        // int today = LocalDate.now().getDayOfMonth();
        // System.out.println("Todays's Day:" + today);

        // List<WebElement> allTheDates = driver.findElements(By.xpath("(//div[@role='presentation' ])[5]"));
        //  for(WebElement dateElement : allTheDates){
        //     String dayText = dateElement.getText();
        //     if(dayText.equals(String.valueOf(today))){
        //         System.out.println("Clicking on today's date: " + dayText);
        //         dateElement.click(); // Click on today's date
        //         Thread.sleep(3000);
        //         return;
        //     }
        // }
        

        //  WebElement titleElement = driver.findElement(By.xpath("//i[text()='arrow_drop_down']"));
        // titleElement.sendKeys("Crio INTV Task Automation");
        WebElement createButtonlement = driver.findElement(By.xpath("//div[text()='Create']"));
        createButtonlement.click();
        Thread.sleep(2000);
        WebElement taskTabElement = driver.findElement(By.xpath("//*[@aria-label='Task']"));
         taskTabElement.click();
        Thread.sleep(2000);
        WebElement titleElement = driver.findElement(By.xpath("//input[@placeholder='Add title']"));
        titleElement.sendKeys("Crio INTV Task Automation");
        WebElement descriptionElement = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        descriptionElement.sendKeys("Crio INTV Calendar Task Automation");
       
        Thread.sleep(2000);
        WebElement saveButtonElement = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div/div/div[2]/span/div/div[1]/div[2]/div[2]/div[4]/button"));
        saveButtonElement.click();
        Thread.sleep(3000);
        WebElement taskElement = driver.findElement(By.xpath("(//div[@class='vEJ0bc ChfiMc rFUW1c Po94xd'])[last()]/*[last()]"));
        taskElement.click();
        WebElement updatedElement = driver.findElement(By.xpath("//div[@class='toUqff vfzv']"));
        
        String getupdatedesc = updatedElement.getText();
        System.out.println(getupdatedesc);
        if(updatedElement.getText().contains("Crio INTV Calendar Task Automation")){
            System.out.println("Test case02: PASS- discription is displayed.");
        }else{
            System.out.println("Test Case 02: FAIL");
        }


        // int today = LocalDate.now().getDayOfMonth();
        // System.out.println("Todays's Day:" + today);

        
        
    }
    public void testCase03 () throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://calendar.google.com/");
        Thread.sleep(5000);
      
        WebElement taskElement = driver.findElement(By.xpath("(//div[@class='vEJ0bc ChfiMc rFUW1c Po94xd'])[last()]/*[last()]"));
        taskElement.click();
        Thread.sleep(5000);
        WebElement editButton = driver.findElement(By.xpath("//button[@aria-label='Edit task']"));
        editButton.click();
        Thread.sleep(5000);
        WebElement descriptionElement = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        descriptionElement.clear();
        descriptionElement.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        Thread.sleep(5000);
        WebElement saveButtonElement = driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[6]"));
        saveButtonElement.click();
        Thread.sleep(3000);
        WebElement taskupdatedElement = driver.findElement(By.xpath("(//div[@class='vEJ0bc ChfiMc rFUW1c Po94xd'])[last()]/*[last()]"));
        taskupdatedElement.click();
        Thread.sleep(5000);
        WebElement updatedElement = driver.findElement(By.xpath("//div[@class='toUqff vfzv']"));
        
        String getupdatedesc = updatedElement.getText();
        System.out.println(getupdatedesc);
        if(updatedElement.getText().contains("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application")){
            System.out.println("Test case03: PASS- Updated description is displayed.");
        }else{
            System.out.println("Test Case 03: FAIL");
        }
    }

    public void testCase04 () throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        driver.get("https://calendar.google.com/");
        Thread.sleep(5000);

        WebElement taskElement = driver.findElement(By.xpath("(//div[@class='vEJ0bc ChfiMc rFUW1c Po94xd'])[last()]/*[last()]"));
        taskElement.click();
        Thread.sleep(5000);

        WebElement titleElement= driver.findElement(By.xpath("(//div[@class='toUqff '])[1]"));
        String titleText = titleElement.getText();
        System.out.println("Current tittle of the task is: "+ titleText);
        Thread.sleep(4000);
        WebElement deleteButton = driver.findElement(By.xpath("(//button[@class='VfPpkd-Bz112c-LgbsSe yHy1rc eT1oJ mN1ivc m2yD4b HfYfLe'])[2]"));
        deleteButton.click();
        Thread.sleep(2000);
        
        WebElement deleteText = driver.findElement(By.xpath("//div[@class='YrbPvc']"));
        boolean status = deleteText.isDisplayed();
        String message = deleteText.getText();
        System.out.println(message +" status :"+ status);
        if(!message.contains("Task deleted")){
            System.out.println("Test case 04: Fail ");
        
        }
        System.out.println("End Test Case 04");
    }



}
