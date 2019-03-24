package com.avl.listdemo.userlist.model;

import com.avl.baserecycleviewdatabinding.base.model.BaseViewModel;

/**
 * Created by AVL on 2/14/19.
 */
public class UserInfoModel extends BaseViewModel {
    private String userId;
    private String userName;
    private String userIcon;
    private String userAge;
    private String userType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
