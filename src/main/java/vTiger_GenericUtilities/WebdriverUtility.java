package vTiger_GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of webdriver method usages
 * @author Admin
 *
 */
public class WebdriverUtility {
   /**1
    * This method will maximize the window
    */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**2
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**3
	 * This method will wait for 20 seconds for the page load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**4
	 * This method will wait until a particular web element is visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisisble(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**5
	 * This method will wait until a particular web element is clickable
	 * @param driver
	 * @param element
	 */
     public void waitForElementToBeClickable(WebDriver driver,WebElement element)
     {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    	 wait.until(ExpectedConditions.elementToBeClickable(element));
     }
     /**6
      * This method will handle drop down by index
      * @param element
      * @param index
      */
     public void handleDropdown(WebElement element,int index)
     {
    	 Select sel=new Select(element);
    	 sel.selectByIndex(index);    	 
     }
     /**7
      * This method will handle drop down by value
      * @param element
      * @param value
      */
     public void handleDropdown(WebElement element,String value)
     {
    	 Select sel=new Select(element);
    	 sel.selectByValue(value);
     }
     /**8
      * This method will perform Mouse Hover action on a web element
      * @param driver
      * @param element
      */
     public void mouseHoverAction(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.moveToElement(element).perform();
     }
     /**9
      * This method will perform right click operation anywhere on the web page
      * @param driver
      */
     public void rightClickAction(WebDriver driver)
     {
    	 Actions act=new Actions(driver);
    	 act.contextClick().perform();
     }
     /**10
      * This method will perform right click operation on particular web element
      * @param driver
      * @param element
      */
     public void rightClickAction(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.contextClick(element).perform();
     }
     /**11
      * This method will perform double click operation anywhere on the page
      * @param driver
      */
     public void doubleClickAction(WebDriver driver)
     {
    	 Actions act=new Actions(driver);
    	 act.doubleClick().perform();
     }
     /**12
      * This method will perform double click operation on particular web element
      * @param driver
      * @param element
      */
     public void doubleClickAction(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.doubleClick(element).perform();
     }
     /**13
      * This method will perform drag and drop operation from element to another
      * @param driver
      * @param srcElement
      * @param destElement
      */
     public void dragAndDropAction(WebDriver driver,WebElement srcElement,WebElement destElement)
     {
    	 Actions act=new Actions(driver);
         act.dragAndDrop(srcElement,destElement).perform();
     
     }
     /**14
      * This method will press the enter key
      * @throws AWTException 
      */
     public void pressEnterKey() throws AWTException 
     {
    	 Robot r=new Robot();
    	 r.keyPress(KeyEvent.VK_ENTER);
     }
     /**15
      * This method will release the enter key
      * @throws AWTException
      */
     public void pressReleaseKey() throws AWTException
     {
    	 Robot r=new Robot();
    	 r.keyPress(KeyEvent.VK_ENTER);
     }
     
     /**16
      * This method will handle frames with index    
      * @param driver
      * @param index
      */
     public void handleFrame(WebDriver driver,int index)
     {
    	 driver.switchTo().frame(index);
     }
     /**17
      * This method will handle frames with name or Id
      * @param driver
      * @param nameOrId
      */
     public void handleFrame(WebDriver driver,String nameOrId)
     {
    	 driver.switchTo().frame(nameOrId);
     }
     /**18
      * This method will handle the frame with web element
      * @param driver
      * @param element
      */
     public void handleFrame(WebDriver driver,WebElement element)
     {
    	 driver.switchTo().frame(element);
     }
     /**19
      * This method will switch to immediate parent frame
      * @param driver
      */
     public void handleParentFrame(WebDriver driver)
     {
    	 driver.switchTo().parentFrame();
     }
     /**20
      * This method will switch to default frame
      * @param driver
      */
     public void handleDefaultFrame(WebDriver driver)
     {
    	 driver.switchTo().defaultContent();
     }
     
     /**21
      * This method will accept alert pop up
      * @param driver
      */
     public void aceeptAlert(WebDriver driver)
     {
    	 driver.switchTo().alert().accept();
     }
     /**22
      * This method will dismiss alert pop up
      * @param driver
      */
     public void dismissAlert(WebDriver driver)
     {
    	 driver.switchTo().alert().dismiss();
     }
     /**23
      * This method will capture and return the alert text
      * @param driver
      * @return
      */
     public String getAlertText(WebDriver driver)
     {
    	 return driver.switchTo().alert().getText();
     }
     
     /**24
      * This method will take screenshot and save in screenshot folder
      * @param driver
      * @param screenshotName
      * @return
      * @throws IOException
      */
     public String takesScreenShot(WebDriver driver,String screenshotName) throws IOException
     {
    	 TakesScreenshot tsc=(TakesScreenshot)driver;
    	 File src=tsc.getScreenshotAs(OutputType.FILE);
    	 File dest=new File(".\\Screenshots\\"+screenshotName+".png");
    	 FileUtils.copyFile(src, dest);  //commons io dependency
    	 
    	 return dest.getAbsolutePath(); //used in extent reports
     }
     
     /**25
      * This method will switch to window based on partial window title
      * @param driver
      * @param partialWinTitle
      */
     public void switchToWindow(WebDriver driver,String partialWinTitle)
     {
    	 //step1:-capture all the window id's
    	 Set<String> winIds=driver.getWindowHandles();
    	 
    	 //step2:-use a for each loop and navigate to each window
    	 for(String win:winIds)
    	 {
    		 //step3:-capture the title of each window
    		 String currentTitle=driver.switchTo().window(win).getTitle();
    		 
    		 //step4:-compare the current title with partial window title
    		 if(currentTitle.contains(partialWinTitle))
    		 {
    			 break;
    		 }
    	 }
     }
     
     /**26
      * This method will scroll randomly downwards
      * @param driver
      */
     public void scrollAction(WebDriver driver)
     {
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("Window.scrollBy(0,500)", "");
     }
     /**27
      * This method will scroll down until the particular web element
      * @param driver
      * @param element
      */
     public void scrollAction(WebDriver driver,WebElement element)
     {
    	 JavascriptExecutor jse=(JavascriptExecutor)driver;
    	 int y=element.getLocation().getY();
    	 jse.executeScript("window.scrollBy(0,"+y+")", element);
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     }










































