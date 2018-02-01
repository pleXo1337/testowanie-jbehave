import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicCheckbox {
    WebDriver driver;

    public BasicCheckbox(WebDriver driver){
        this.driver = driver;
    }

    @Given("user is on a Basic Checkbox test site")
    public void navigateTo(){
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }

    @When("I click on a checkbox")
    public  void clickOnCheckBox(){
        driver.findElement(By.id("isAgeSelected")).click();
    }

    @When("I click on Check All button")
    public void clickOnCheckBoxButton(){
        driver.findElement(By.xpath("//input[@value='Check All']")).click();

        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I assert whether there is \"Success - Check box is checked\" message and the \"Check All\" button now says \"Uncheck All\"")
    public void assertion(){
        Assert.assertTrue(driver.getPageSource().contains("Success - Check box is checked"));
        Assert.assertTrue(driver.getPageSource().contains("Uncheck All"));
    }
}
