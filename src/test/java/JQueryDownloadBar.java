import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JQueryDownloadBar {

    WebDriver driver;

    public JQueryDownloadBar(WebDriver driver){
        this.driver = driver;
    }

    @Given("user is on a download test site")
    public void navigateTo(){
        driver.get("http://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
    }

    @When("I click on download button")
    public void startDownload(){
        driver.findElement(By.xpath("//button[@id='downloadButton']")).click();
        try{
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I assert wheter the download was succesful")
    public void assertion(){
        Assert.assertTrue(driver.getPageSource().contains("Complete!"));
    }

    @Then("I click a button to finish")
    public void finishDownload(){
        driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']")).click();
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.quit();
    }

}
