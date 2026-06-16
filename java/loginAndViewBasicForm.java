import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class loginAndViewBasicForm {
    WebDriver driver;

    @Test
    public void loginToNdosiWebsiteTests() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")).click();
        driver.findElement(By.id("login-email")).sendKeys("immortalaromascents@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("P@ssword1");
        Thread.sleep(2000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(2000);
        String welcomeText  = driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/div[1]/h2/span[2]")).getText();
        Assert.assertEquals(welcomeText,"back,");
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"tab-btn-password\"]/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("basic-form-requirements")).click();
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.id("name"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        Thread.sleep(1000);
    }

    @AfterTest
    public void closeBrowser(){

        driver.quit();
    }


}

