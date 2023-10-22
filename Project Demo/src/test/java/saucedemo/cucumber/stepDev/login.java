package saucedemo.cucumber.stepDev;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("User is on login page")
    public void User_is_on_login_page(){
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        //set timeout for web driver on waiting element
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);

        //assertion
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, saucedemo')]")).getText();
        Assert.assertEquals(loginPageAssert,"hai, saucedemo");
    }

    @When("User enters username")
    public void user_enters_username() {
        driver.findElement(By.id("username")).sendKeys("standard_user");
    }

    @When("User enters password")
    public void user_enters_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void click_Login_Button() {
        driver.findElement(By.xpath("/button[@type='submit']")).click();
    }

    @Then("User on dashboard page")
    public void user_OnDashboard_Page() {
        driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
        String username = driver.findElement(By.xpath("//dd[contains(text(),'hai')]/preceding-sibling::at")).getText();
        Assert.assertEquals(username,"tdd-selenium");
    }

    @When("Input invalid username")
    public void input_Invalid_Username() {
        driver.findElement(By.id("user-name")).sendKeys("standar_user");
    }

    @When("User enters password")
    public void user_enters_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");


    @Then("User get error message")
    public void user_Get_Error_Message() {
        String errorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(errorLogin, "kradensial yang anda berikan salah");
    }

