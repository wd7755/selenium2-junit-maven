package cn.yunlianhui.webdriverdemo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
	 //邮箱地址标签
    @FindBy(id="spnUid")
    private WebElement lblEmail;   
    //退出链接
    @FindBy(linkText="退出")    
    private WebElement lnkLogout;
    @FindBy(className="ga0")
    private WebElement lnkWriteEmail;    
    
	public String getEmailText(){
		return lblEmail.getText();
	}
	public void clickLogoutLink(){
		lnkLogout.click();
	}
	public void clickWriteEmailLink(){
		lnkWriteEmail.click();
	}
}
