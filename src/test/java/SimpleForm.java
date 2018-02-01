import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SimpleForm {
    WebDriver driver;

    public SimpleForm(WebDriver driver)
    {
        this.driver = driver;
    }

    @Given("user is on a Simple Form test site")
    public void navigateTo(){
        driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
    }

    @When("I type $value into form box and click the button")
    public void clickOnTextBox(@Named("value") String text)
    {
        driver.findElement(By.xpath("//input[@id='user-message']")).click();
        driver.findElement(By.xpath("//input[@id='user-message']")).clear();
        driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(text);
        driver.findElement(By.xpath("//button[@onclick='showInput();']")).click();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I type $first and $second numbers and sum them up")
    public void totalAB(@Named("first") String a, @Named("second") String b)
    {

        driver.findElement(By.xpath("//input[@id='sum1']")).sendKeys(a);
        driver.findElement(By.xpath("//input[@id='sum2']")).sendKeys(b);
        driver.findElement(By.xpath("//button[@onclick='return total()']")).click();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I assert whether Im getting $test message and a sum of $sum")
    public void assertion(@Named("$test") String a, @Named("$sum") String b){
        Assert.assertTrue(driver.getPageSource().contains(a));
        Assert.assertTrue(driver.getPageSource().contains(b));
    }
}
