package cn.yunlianhui.webdriverdemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import cn.yunlianhui.webdriverdemo.page.MainPage;
import cn.yunlianhui.webdriverdemo.page.WriteEmailPage;
import cn.yunlianhui.webdriverdemo.util.ExcelUtil;

public class Test02_SendEmail extends TestCaseBase{
	@Test
	public void case01_sendEmail()throws Exception{
		
		MainPage mainPage = login();    
		mainPage.clickWriteEmailLink();
		WriteEmailPage writeEmailPage = PageFactory.initElements(driver, WriteEmailPage.class);		
		   //读取用例sheet页
        ExcelUtil.setExcelFile(excelPath, "sendEmail");        
        //取得收件人
        String recipients = ExcelUtil.getCellData(2, 3);
        //取得主题
        String subject = ExcelUtil.getCellData(3, 3);
        //取得内容
        String content = ExcelUtil.getCellData(4, 3);	
		
		writeEmailPage.inputRecipients(recipients);
		writeEmailPage.inputSubject(subject);
		writeEmailPage.inputContent(content);
		writeEmailPage.clickSendButton();
		Assert.assertTrue(isContentAppeared("发送成功"));		
	}
}
