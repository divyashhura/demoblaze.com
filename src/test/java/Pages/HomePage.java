package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends Base {
    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
    WebElement monitors;
    @FindBy(xpath = "//a[contains(text(),'Apple monitor 24')]")
    WebElement appleMonitor;
    @FindBy(xpath = "//a[contains(text(),'ASUS Full HD')]")
    WebElement asusfullhd;
    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    WebElement addtocart;
    @FindBy(xpath = "//a[@id='cartur']")
    WebElement carttag;

    String actualitem;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public void Monitor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        monitors.click();
        js.executeScript("window.scrollBy(0,300)", "");
        if(prop.getProperty("Monitor").equals("Apple monitor 24")){
            actualitem="Apple monitor 24";
            appleMonitor.click();
            addtocart.click();
            carttag.click();
        }
        else{
            actualitem="ASUS Full HD";
            asusfullhd.click();
            addtocart.click();
            carttag.click();
        }
    }
    public void verifyCart(){
        Assert.assertEquals(actualitem,prop.getProperty("Monitor"),"Product is not similar");
    }
}
