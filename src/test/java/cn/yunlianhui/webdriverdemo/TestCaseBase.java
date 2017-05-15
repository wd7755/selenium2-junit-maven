package cn.yunlianhui.webdriverdemo;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import cn.yunlianhui.webdriverdemo.page.LoginPage;
import cn.yunlianhui.webdriverdemo.page.MainPage;
import cn.yunlianhui.webdriverdemo.util.ExcelUtil;


public class TestCaseBase {
	protected WebDriver driver;	
	//定义用例路径
	protected static String excelPath = "";
	public WebDriver getDriver() throws Exception {	    
        if (driver == null) {    
            //读取用例sheet页
            ExcelUtil.setExcelFile(excelPath, "login");        
            //打开浏览器
            String BrowserName=ExcelUtil.getCellData(1, 3);
            if (BrowserName.equalsIgnoreCase("firefox")) {
                driver=new FirefoxDriver();
            }else if (BrowserName.equalsIgnoreCase("chrome")) {            	 
            	System.setProperty("webdriver.chrome.driver", "c:\\python27\\chromedriver.exe"); // path of chromedriver 
                driver=new ChromeDriver();
            }
            //driver=new HtmlUnitDriver(true);
            driver.manage().window().maximize();
        }       
        return driver;
    }			
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		 ClassLoader classLoader = TestCaseBase.class.getClassLoader();
		 URL resource = classLoader.getResource("126MailLoginCase.xlsx");
		 excelPath = resource.getPath();
	}
	   
    @AfterClass
    public static void tearDownAfterClass() throws Exception{
	
    }
	
	/**
	 * 每个测试方法开始执行前执行该方法：获取driver并利用其打开首页
	 * @throws Exception 可能抛出异常
	 */
    @Before
    public void setUp() throws Exception {      
    	
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;      
    }	
    /**
     * 每个测试方法结束执行后执行该方法：关闭由webdriver打开的所有页面
     * @throws Exception 可能抛出异常
     */
    @After
	public void tearDown() throws Exception {
        driver.quit();
        driver = null;
    }	 
    protected MainPage login()throws Exception{
   	   //输入网址
       driver.get(ExcelUtil.getCellData(2, 3));         	
       //切换frame
       driver.switchTo().frame("x-URS-iframe");        
       //初始化page页面(注意：要放在打开浏览器之后)
       LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
       MainPage mainPage=PageFactory.initElements(driver, MainPage.class);        
       //输入账户
       loginPage.inputUsername(ExcelUtil.getCellData(3, 3));       
       //输入密码
       loginPage.inputPwd(ExcelUtil.getCellData(4, 3));       
       //单击登录
       loginPage.clickLoginButton();             
       return mainPage;
   }
    protected boolean isContentAppeared(String content) {  
        boolean status = false;  
        try {  
            driver.findElement(By.xpath("//*[contains(.,'" + content + "')]"));  
            System.out.println(content + " is appeard!");  
            status = true;  
        } catch (NoSuchElementException e) {  
            status = false;  
            System.out.println("'" + content + "' doesn't exist!");  
        }  
        return status;  
    }  
}