//The file name should be the class name 'Testcase101.java'

package com.org.happyfox;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//Line 21, 120 -Having multiple main classes (Testcase101 and PagesforAutomationAssignment) within the same file is not recommended. Each class should ideally be in its own file.
// (PagesforAutomationAssignment) should be in base reusable code file

//The code don't have comments explaining its functionality and purpose, making it difficult to understand for new joiners or freshers and also other developers

public class Testcase101 {

	public static void main(String[] args) throws InterruptedException, AWTException {

//line 29, 125- Without download Geckodriver.exe file,because need download .exe for every updation.  Add the WebDriverManager dependency to pom.xml file 
//Use WebDriverManager in code to set up the WebDriver, Create a new instance of FirefoxDriver


		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Johny\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://interview.supporthive.com/staff/");

//line 34,108-The usage of implicitlyWait is discouraged when explicit waits can be used. Implicit waits can lead to unexpected behavior       
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

// line 38,39 -Credentials like username and password are hardcoded directly into the code. It's better to use a configuration file or environment variables to store sensitive information      
		driver.findElement(By.id("id_username")).sendKeys("Agent");
		driver.findElement(By.id("id_password")).sendKeys("Agent@123");
		driver.findElement(By.id("btn-submit")).click();
		WebElement tickets = driver.findElement(By.id("ember29"));
		Actions action = new Actions(driver);
		action.moveToElement(tickets).build().perform();
		WebElement statuses = driver.findElement(By.linkText("Statuses"));
		statuses.click();

 //line 48, 111,117 -XPath expressions like /html/body/div[3]/div/section/section/div/header/button are absolute, making them brittle. Prefer to use relative XPath       
		driver.findElement(By.xpath("/html/body/div[3]/div/section/section/div/header/button")).click();

  //Should create a separate Ex.elementLocator.java' file for dedicated to storing locators      
		driver.findElement(By.tagName("input")).sendKeys("Issue Created");
		WebElement statusColourSelect =
		          driver.findElement(By.xpath("//div[@class='sp-replacer sp-light']"));
		          statusColourSelect.click();

		          WebElement statusColourEnter =
		          driver.findElement(By.xpath("//input[@class='sp-input']"));
		          statusColourEnter.clear(); statusColourEnter.sendKeys("#47963f");

		          Robot r = new Robot();
		          r.keyPress(KeyEvent.VK_ESCAPE);
	
        WebElement firstElement = driver.findElement(By.xpath("//a[@id='first-link']"));
        firstElement.click();

       
        WebElement secondElement = driver.findElement(By.xpath("//a[@id='second-link']"));
        secondElement.click();
        

		
		driver.findElement(By.tagName("textarea")).sendKeys("Status when a new ticket is created in HappyFox");
		WebElement addCreate = driver.findElement(By.xpath("//button[@class ='hf-entity-footer_primary hf-primary-action ember-view']"));
	      addCreate.click();


//line 79,85,100,116 - usage of Thread.sleep() can cause unnecessary delays and make the script less reliable. Consider using explicit waits instead

	      Thread.sleep(3000);

	      WebElement moveTo = driver.findElement(By.xpath("//td[@class ='lt-cell align-center hf-mod-no-padding ember-view']"));
	      action.moveToElement(moveTo).build().perform();
	      moveTo.click();
	     
	      Thread.sleep(9000);
	      
	      WebElement issue = driver.findElement(By.xpath("//div[contains(text(),'Issue Created')]"));
			action.moveToElement(issue).build().perform();
			
			
	      WebElement make = driver.findElement(By.linkText("Make Default"));
	      make.click();
	      driver.findElement(By.linkText("Priorities")).click();
	      driver.findElement(By.xpath("//header/button[1]")).click();
	      driver.findElement(By.tagName("input")).sendKeys("Assistance required");
	      driver.findElement(By.tagName("textarea")).sendKeys("Priority of the newly created tickets");
	      WebElement button = driver.findElement(By.cssSelector("button[data-test-id='add-priority']"));
	      button.click();
	      
Thread.sleep(9000);

WebElement tickets2 = driver.findElement(By.id("ember29"));
action.moveToElement(tickets2).build().perform();
WebElement priorities2 = driver.findElement(By.linkText("Priorities"));
priorities2.click();


driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//Prefer to use relative XPath
driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")).click();
driver.findElement(By.linkText("Delete")).click();
WebElement delete = driver.findElement(By.cssSelector("button[data-test-id='delete-dependants-primary-action']"));
delete.click();

Thread.sleep(9000);
driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]")).click();
driver.findElement(By.linkText("Logout")).click();

public class PagesforAutomationAssignment {

    public static void main(String[] args) {

//line 125 -Use WebDriverManager in code to set up the WebDriver, Create a new instance of ChromeDriver
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.happyfox.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("username", "password");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();

        driver.quit();
    }

    static class BasePage {
        protected WebDriver driver;

        public BasePage(WebDriver driver) {
            this.driver = driver;
        }
    }

    static class LoginPage extends BasePage {
        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public void login(String username, String password) {

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("loginButton")).click();
        }

        public void forgotPassword() {
            driver.findElement(By.linkText("Forgot password?")).click();
        }
    }

    static class HomePage extends BasePage {
        public HomePage(WebDriver driver) {
            super(driver);
        }

        public void verifyHomePage() {
            if (!driver.getCurrentUrl().equals("https://www.happyfox.com/home")) {
                throw new IllegalStateException("Not on the home page");
            }
        }

        public void navigateToProfile() {
            driver.findElement(By.id("profileLink")).click();
        }

    public class TablePage extends BasePage {

    private By rowLocator = By.xpath("//table[@id='dataTable']/tbody/tr");

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public void retrieveRowTexts() {
        List<WebElement> rows = driver.findElements(rowLocator);

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            String rowText = row.getText();
            System.out.println("Row " + i + " Text: " + rowText);
        }
    }




	}

}
