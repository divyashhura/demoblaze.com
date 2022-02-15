package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.FileInputStream;
import java.io.IOException;


public class PurchasePage extends Base {

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    WebElement placeorderbutton;
    @FindBy(id = "name")
    WebElement name;
    @FindBy(id = "country")
    WebElement country;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id="card")
    WebElement card;
    @FindBy(id="month")
    WebElement month;
    @FindBy(id="year")
    WebElement year;
    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    WebElement purchasebutton;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement okbutton;

    String path2,cust_name,cust_country,cust_city,cust_card,card_month,card_year;
    int i;

    public PurchasePage(){
        PageFactory.initElements(driver,this);
    }

    public void placeOrder() throws IOException {
        placeorderbutton.click();
        path2 = System.getProperty("user.dir") + prop.getProperty("Path2");
        System.out.println(path2);
        FileInputStream fis = new FileInputStream(path2);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheetAt(0);
        for (i = 1; i <= sh.getLastRowNum(); i++) {
            cust_name = sh.getRow(i).getCell(0).getStringCellValue();
            name.sendKeys(cust_name);
            cust_country = sh.getRow(i).getCell(1).getStringCellValue();
            country.sendKeys(cust_country);
            cust_city = sh.getRow(i).getCell(2).getStringCellValue();
            city.sendKeys(cust_city);
            cust_card = sh.getRow(i).getCell(3).getStringCellValue();
            card.sendKeys(cust_card);
            card_month = sh.getRow(i).getCell(4).getStringCellValue();
            month.sendKeys(card_month);
            card_year = sh.getRow(i).getCell(5).getStringCellValue();
            year.sendKeys(card_year);
        }
        purchasebutton.click();
        okbutton.click();
        driver.navigate().to(prop.getProperty("url"));
    }
}
