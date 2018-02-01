import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicRadioButton {
    WebDriver driver ;

    public BasicRadioButton(WebDriver driver)
    {
        this.driver = driver;
    }

    @Given("user is on test site")
    public void navigateTo(){
        driver.get("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
    }
    @When("I click on a single radio")
    public void singleRadio() {
        driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']")).click();
        driver.findElement(By.id("buttoncheck")).click();
    }

    @When("I click on a group radio")
    public void groupRadio(){
        driver.findElement(By.xpath("//input[@value='Female' and @name='gender']")).click();
        driver.findElement(By.xpath("//input[@value='15 - 50' and @name='ageGroup']")).click();
        driver.findElement(By.xpath("//button[@onclick='getValues();' and @type='button']")).click();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I check if they are correctly checked")
    public void assertion(){
        Assert.assertTrue(driver.getPageSource().contains("Radio button 'Male' is checked"));
        Assert.assertFalse(driver.getPageSource().contains("Radio button 'Female' is checked"));

        Assert.assertTrue(driver.getPageSource().contains("Sex : Female"));
        Assert.assertTrue(driver.getPageSource().contains("Age group: 15 - 50"));
        //driver.quit();
    }

}
