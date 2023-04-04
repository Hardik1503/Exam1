package lambda.LambdaGit;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Github {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().deleteAllCookies();
        
        
        //TestCase 1
        driver.get("https://www.lambdatest.com/selenium-playground");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@href='https://www.lambdatest.com/selenium-playground/simple-form-demo']")).click();
        String Variable = "Welcome to lambda Test";
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,270)");
        
        driver.findElement(By.id("user-message")).sendKeys(Variable);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Get Checked value']")).click();
        Thread.sleep(1000);
        
        String Expectedmsg = driver.findElement(By.xpath("//*[@id='message']")).getText();
        String Actualmsg = "Welcome to lambda Test";
        Assert.assertEquals(Actualmsg, Expectedmsg);
        
        //TestCase 2
        driver.get("https://www.lambdatest.com/selenium-playground");
        Thread.sleep(10000);
        
        js.executeScript("window.scrollBy(0,270)");
        Thread.sleep(1000);
        
      //  driver.findElement(By.xpath("//*[text()='Progress Bar & Sliders']")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[text()='Drag & Drop Sliders']")).click();
        Thread.sleep(1000);
        
        WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(slider, 120, 0).build();
        action.perform();
        
        //TestCase 3
        
        driver.get("https://www.lambdatest.com/selenium-playground");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[text()='Input Form Submit']")).click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(1000);
        //Submit without filling details
        driver.findElement(By.xpath("//*[@class='btn btn-dark selenium_btn bg-black text-white hover:bg-lambda-900 py-5 px-10 rounded']")).click();
        Thread.sleep(1000);
        
     //   String verifyMSG = driver.findElement(By.xpath("//*[text()='Please fill out this field.']")).getText();
    //    Boolean verifypopUP = verifyMSG.equalsIgnoreCase("Please fill out this field.");
    //    assertTrue(true);
        
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("FirstName");
        driver.findElement(By.xpath("//*[@id='inputEmail4']")).sendKeys("brv1@brv.com");
        driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys("Brain@123");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("BRV");
        driver.findElement(By.xpath("//input[@id='websitename']")).sendKeys("www.lambdatest.com");
        driver.findElement(By.xpath("//input[@id='inputCity']")).sendKeys("Seguin");
        driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys("2 3th");
        driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys("BLVD Street");
        driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("Texas");
        driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys("38155");
        
        Select Country = new Select(driver.findElement(By.xpath("//*[@name='country']")));
        Thread.sleep(1000);
        Country.selectByVisibleText("United States");
        Thread.sleep(1000);
        
        
        
      //Hoover Over Mouse Action  
        try
        {
        	WebElement ele = driver.findElement(By.xpath("//*[@id='exit_popup_close']"));
            Actions action1 = new Actions(driver);
        	action1.moveToElement(ele).click().perform();
            Thread.sleep(1000);
        }
     catch(NoSuchElementException e)
       {
          System.out.println("PoP up didnt occur");
       }
        
        
      //Submit
        driver.findElement(By.xpath("//*[@class='btn btn-dark selenium_btn bg-black text-white hover:bg-lambda-900 py-5 px-10 rounded']")).click();
        Thread.sleep(1000);
        
        
        String ExpectedSucessfulMSG = driver.findElement(By.xpath("//*[@class='success-msg hidden']")).getText();
        String ActualSucessfulMSG = "Thanks for contacting us, we will get back to you shortly.";
        Assert.assertEquals(ExpectedSucessfulMSG, ActualSucessfulMSG);
        Thread.sleep(1000);
        
        System.out.println("Script Ran!");
       
        
                
       
        
        
        
        
        
        
        
        
      
	}

}
