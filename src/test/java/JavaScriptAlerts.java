import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Named;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlerts {
    WebDriver driver;

    public JavaScriptAlerts(WebDriver driver) { this.driver = driver; }

    @Given("user is on a Javascript Alert test site")
    public void navigateTo() { driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html"); }

    @When("I click on an Alert Box")
    public void clickAlertBox() {
        driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I assert whether the box appeared and click on OK button")
    public void alertBoxAssertion() {
        Assert.assertTrue(driver.getPageSource().contains("I am an alert box!"));
        driver.switchTo().alert().accept();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on a Confirm Box and dismiss it")
    public void clickConfirmBox() {
        driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
        driver.switchTo().alert().dismiss();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on a Prompt Box, write $name in it and accept it")
    public void clickPromptBox(@Named("name") String name) {
        driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I assert whether I'm getting \"You pressed Cancel!\" and \"You have entered '$name' !\" messages.")
    public void finalAssertion(@Named("name") String name) {
        Assert.assertTrue(driver.getPageSource().contains("You pressed Cancel!"));
        Assert.assertTrue(driver.getPageSource().contains("You have entered '" + name + "' !"));
    }
}
