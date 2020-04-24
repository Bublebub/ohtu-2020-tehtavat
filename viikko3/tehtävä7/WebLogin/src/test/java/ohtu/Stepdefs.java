package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @Given("command new user is selected")
    public void newUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }
    
    @Given("user with username {string} with password {string} is successfully created")
    public void newUserIsCreated(String username, String password) {
        newUserIsSelected();
        validRegistrationInformationIsEntered(username, password);
    }
    
    @Given("user with username {string} and password {string} is tried to be created")
    public void newUserIsTried(String username, String password) {
        newUserIsSelected();
        signupWith(username, password, password);
    }
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validRegistrationInformationIsEntered(String username, String password) {
        signupWith(username, password, password);
    }
    
    @When("a too short username {string} and password {string} and matching password confirmation are entered")
    public void tooShortUsernameAndPasswordAreEntered(String username, String password) {
        signupWith(username, password, password);
    }
    
    @When("a valid username {string} and a too short password {string} and a matching password confirmation are entered")
    public void usernameAndATooShortPasswordAreEntered(String username, String password) {
        signupWith(username, password, password);
    }
    
    @When("invalid username {string} and invalid password {string} are entered")
    public void invalidUsernameAndInvalidPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
            
    @When("a valid username {string} and password {string} and a not matching password confirmation are entered")
    public void notMatchingPasswordConfirmationIsEntered(String username, String password) {
        signupWith(username, password, '#' + password);
    }
    
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @When("incorrect username {string} and password {string} are given")
    public void incorrectUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @Then("a new user is created")
    public void userIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String error) {
        pageHasContent("Create username and give password");
        pageHasContent(error);
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }
    
    private void signupWith(String username, String password, String passwordConfirmation) {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        
        WebElement signup = driver.findElement(By.name("signup"));
        signup.click();
    }
    
}
