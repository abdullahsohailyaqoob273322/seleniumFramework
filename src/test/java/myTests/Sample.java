package myTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Date;

public class Sample {
    static ExtentReports extent;
    static WebDriver driver;
    @BeforeSuite
    static void setupAll(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public static void setup(){
        Date date=new Date();
        String path=System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Automation Report");
        extentSparkReporter.config().setDocumentTitle("TestTitle");
        extent=new ExtentReports();
        extent.attachReporter(extentSparkReporter);
        extent.setSystemInfo("Tester","Abdullah");
        driver=new ChromeDriver();
        driver.get("https://google.com/");
}
    @AfterSuite
    void tearDown(){
        driver.quit();
        extent.flush();
    }
    @Test(priority=1)
    void visitApplication(){
        extent.createTest("visitApplication");

        Assert.assertEquals(driver.getTitle(),"Google");
        //System.out.println("title------------>" + driver.getTitle());
        System.out.println(System.getProperty("user.dir"));

        }

    @Test(priority=2)
    void visitApplication2(){
        extent.createTest("visitApplication2");
        Assert.assertEquals(driver.getTitle(),"Google");
        //System.out.println("title------------>" + driver.getTitle());
        System.out.println(System.getProperty("user.dir"));

    }
    @Test(priority=3)
    void visitApplication3(){
        extent.createTest("visitApplication3");
        Assert.assertEquals(driver.getTitle(),"Google");
        //System.out.println("title------------>" + driver.getTitle());
        System.out.println(System.getProperty("user.dir"));
    }
}
