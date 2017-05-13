package cn.yunlianhui.webdriverdemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import cn.yunlianhui.webdriverdemo.page.LogoutPage;
import cn.yunlianhui.webdriverdemo.page.MainPage;
import cn.yunlianhui.webdriverdemo.util.ExcelUtil;

/*
 * 定位语句和测试代码分离：封装在page类中
 * 测试数据与测试代码分离：读取excel文件
 */
public class Test01_Login extends TestCaseBase{
    @Test
    public void case01_login() throws Exception {    	
    	MainPage mainPage = login();      
    	//断言登录是否成功      
        Assert.assertEquals(mainPage.getEmailText(), ExcelUtil.getCellData(3, 3)+"@126.com");
        //System.out.println("Successful_01!");
    }     
    @Test
    public void case02_logout() throws Exception{
    	MainPage mainPage = login();    
    	//断言登录是否成功      
        Assert.assertEquals(mainPage.getEmailText(), ExcelUtil.getCellData(3, 3)+"@126.com");
        mainPage.clickLogoutLink();
        LogoutPage logoutPage = PageFactory.initElements(driver, LogoutPage.class);
        Assert.assertTrue(logoutPage.reLoginLinkPresent());
        //System.out.println("Successful_02!");
    }   
}