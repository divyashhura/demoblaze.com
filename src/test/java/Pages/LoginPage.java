package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import static Util.TestUtil.IMPLICIT_WAIT;
import static Util.TestUtil.Sleep_Wait;


public class LoginPage extends Base {
    @FindBy(linkText = "Log in")
    WebElement logintag;
    @FindBy(id = "loginusername")
    WebElement loguname;
    @FindBy(id="loginpassword")
    WebElement logpass;
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginbutton;
    String path,username,password;
    int i;

    public LoginPage(){
        PageFactory.initElements(driver,this);}

    public void loginPage() throws IOException, InterruptedException {
        path=System.getProperty("user.dir")+prop.getProperty("Path");
        logintag.click();
        FileInputStream fis=new FileInputStream(path);
        XSSFWorkbook wb= new XSSFWorkbook(fis);
        XSSFSheet sh= wb.getSheetAt(0);
        for(i=1;i<=sh.getLastRowNum();i++){
            username=sh.getRow(i).getCell(0).getStringCellValue();
            loguname.sendKeys(username);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
            password=sh.getRow(i).getCell(1).getStringCellValue();
            logpass.sendKeys(password);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
            loginbutton.click();
        }
        Thread.sleep(Sleep_Wait);
    }
}
