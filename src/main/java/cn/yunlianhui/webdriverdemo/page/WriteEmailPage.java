package cn.yunlianhui.webdriverdemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import cn.yunlianhui.webdriverdemo.TestCaseBase;

public class WriteEmailPage {
	@FindBy(className="nui-editableAddr-ipt")
	private WebElement txtRecipients;
	
	@FindBy(xpath="//input[@type='text' and @class='nui-ipt-input' and @maxlength='256']")
	private WebElement txtSubject;
	
	@FindBy(className="APP-editor-iframe")
	private WebElement iframeEditor;	
	
	@FindBy(className="nui-scroll")
	private WebElement txtContent;
	
	@FindBys({@FindBy(className="nui-btn-text"),@FindBy(xpath="//span[text()='发送']")})
	private WebElement btnSend;
	
	public void inputRecipients(String recipient){
		txtRecipients.clear();
		txtRecipients.sendKeys(recipient);
	}
	public void inputSubject(String subject){
		txtSubject.clear();
		txtSubject.sendKeys(subject);
	}
	public void inputContent(String content) throws Exception{
		WebDriver driver = TestCaseBase.getDriver();
		driver.switchTo().frame(iframeEditor);		
		txtContent.clear();
		txtContent.sendKeys(content);
		driver.switchTo().defaultContent();
	}
	public void clickSendButton(){
		btnSend.click();
	}
}
