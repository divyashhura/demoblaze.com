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


public class SignUpPage extends Base {
    @FindBy(linkText="Sign up")
    WebElement signuptag;
    @FindBy(id="sign-username")
    WebElement uname;
    @FindBy(id="sign-password")
    WebElement pass;
    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement signupbutton;

    String path,username,password;
    int i;

    public SignUpPage(){PageFactory.initElements(driver,this);}

    public void enterDetails() throws IOException {
        path=System.getProperty("user.dir")+prop.getProperty("Path");
        System.out.println(path);
        signuptag.click();
        FileInputStream fis=new FileInputStream(path);
        XSSFWorkbook wb= new XSSFWorkbook(fis);
        XSSFSheet sh= wb.getSheetAt(0);
        for(i=1;i<=sh.getLastRowNum();i++){
            username=sh.getRow(i).getCell(0).getStringCellValue();
            uname.sendKeys(username);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
            password=sh.getRow(i).getCell(1).getStringCellValue();
            pass.sendKeys(password);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
            signupbutton.click();
            driver.navigate().to(prop.getProperty("url"));
        }
    }
}
