package Pages;


import Pagefactory.ObjectFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties prop;
    public static ObjectFactory obj;

    public Base()
    {   try
        {   prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
                    "/src/test/java/config/configure.properties");
            prop.load(fis);
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {   e.printStackTrace();
        }
    }
    public void launch()
    {       WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
    }
}