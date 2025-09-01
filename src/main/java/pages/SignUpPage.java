package pages;  
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 

public class SignUpPage {  
  WebDriver driver;      
  By signupBtn = By.id("signin2");     
  By usernameInput = By.id("sign-username");     
  By passwordInput = By.id("sign-password");     
  By submitBtn = By.xpath("//button[text()='Sign up']");      
  
  public SignUpPage(WebDriver driver) {         
    this.driver = driver; 
    
  }      
  public void signUp(String username, String password) {         
    
  driver.findElement(signupBtn).click();         
  driver.findElement(usernameInput).sendKeys(username);         
  driver.findElement(passwordInput).sendKeys(password);         
  driver.findElement(submitBtn).click();     
    
     }
  }

