package com.dc.lc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserInfoDTO {

    @NotBlank(message = "* UserName cannot be null.")
    @Size(min = 3, max = 15,message = "* UserName should be between 3 to 15.")
    private String userName;

    @NotBlank(message = "* Crush Name cannot be null.")
    @Size(min = 3, max = 15,message = "* Crush Name should be between 3 to 15.")
    private String crushName;

    @AssertTrue(message = "Please accept terms and condition")
    private boolean acceptTermAndCondition;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCrushName() {
        return crushName;
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }

    public boolean isAcceptTermAndCondition() {
        return acceptTermAndCondition;
    }

    public void setAcceptTermAndCondition(boolean acceptTermAndCondition) {
        this.acceptTermAndCondition = acceptTermAndCondition;
    }
}
