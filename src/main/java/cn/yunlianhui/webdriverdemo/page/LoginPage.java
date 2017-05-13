package cn.yunlianhui.webdriverdemo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {   
    //用户名输入框
    @FindBy(name="email")
    private WebElement txtName;
    //密码输入框
    @FindBy(name="password")
    private WebElement txtpwd;
    //登录按钮
    @FindBy(id="dologin")
    private WebElement btnLogin;
    //继续登录按钮
    @FindBy(className="u-btn")
    private WebElement btnContinueLogin;
    
    //输入用户名
    public void  inputUsername(String userName){       
    	txtName.clear();
    	txtName.sendKeys(userName);        
    }
    //输入密码
    public void inputPwd(String passWord){
    	txtpwd.clear();
    	txtpwd.sendKeys(passWord);
    }
    //单击登录
    public void clickLoginButton(){
    	btnLogin.click();
    }
    //单击继续登录
    public void continueLogin(){
    	btnContinueLogin.click();
    }
}