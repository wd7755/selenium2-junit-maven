package cn.yunlianhui.webdriverdemo.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	@FindBy(className="relogin")
	private WebElement lnkReLogin;
	
	public boolean reLoginLinkPresent(){
		try{
			lnkReLogin.isDisplayed();
    		return true;
    	}catch(NoSuchElementException e){
    		e.printStackTrace();
    		return false;
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}  	
	}
}
