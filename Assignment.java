import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
public class Assignment {
   

	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
    	
        	 driver.get("https://www.fitpeo.com/");
        	 driver.manage().window().maximize();
        	 driver.navigate().to("https://www.fitpeo.com/revenue-calculator");
        	 
        	 WebElement slider = driver.findElement(By.className("MuiSlider-thumbSizeMedium"));
        	 Actions action = new Actions(driver);
        	 action.dragAndDropBy(slider, 49, 0).perform();
        	 Thread.sleep(3000);
        	 WebElement input = driver.findElement(By.className("MuiInputBase-input"));
        	 input.clear();
        	 Thread.sleep(5000);
        	 input.sendKeys("560");
        	 Thread.sleep(5000);
             JavascriptExecutor js = (JavascriptExecutor) driver;
             WebElement select1 = driver.findElement(By.className("PrivateSwitchBase-input"));
             if(!select1.isSelected()) {
            	 select1.click();
             }
            Thread.sleep(5000);
             WebElement reimbursement = driver.findElement(By.className("MuiTypography-root"));
             String reimbursementValue = reimbursement.getText().trim();
             
             if ("$110,700".equals(reimbursementValue)) {
                 System.out.println("Total Recurring Reimbursement is correct.");
             } else {
                 System.out.println("Total Recurring Reimbursement is incorrect. Found: " + reimbursementValue);
             }
        
             driver.close();         
             System.out.println("Successfully reached");
	}
}
