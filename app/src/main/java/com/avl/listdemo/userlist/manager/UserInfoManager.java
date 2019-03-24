package com.avl.listdemo.userlist.manager;


import com.avl.listdemo.userlist.model.UserInfoModel;
import com.avl.listdemo.userlist.model.UserInfoModel2;
import com.avl.listdemo.userlist.model.UserInfoModel3;
import com.avl.listdemo.userlist.model.UserInfoModel4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AVL on 2/14/19.
 * 这里 后续改造层 网络请求
 */
public class UserInfoManager implements IUserInfoManager {
    private static UserInfoManager userInfoManager = new UserInfoManager();

    public static UserInfoManager getUserInfoManager() {
        return userInfoManager;
    }

    @Override
    public void requestUserInfoList(int groupId, IUserInfoCallBack callBack) {
        boolean isSuccess = true; // http response 200 ok  刷新和下拉刷新 通过index或者timestamp处理
        if (isSuccess) {
            if (callBack != null) {
                List<UserInfoModel> list = createUserInfoList();
                callBack.onRequestUserInfoListSuccess(list);
            }
        } else {
            if (callBack != null) {
                callBack.onRequestUserInfoListFailed();
            }
        }
    }

    //构建数据
    private List<UserInfoModel> createUserInfoList() {
        List<UserInfoModel> userInfoModelList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            UserInfoModel userInfoModel = new UserInfoModel();
            userInfoModel.setUserName("AVL" + i);
            userInfoModel.setUserAge("age" + i);
            userInfoModel.setUserType("type UserInfoModel");
            userInfoModelList.add(userInfoModel);
        }

        for (int i = 0; i < 5; i++) {
            UserInfoModel2 userInfoModel = new UserInfoModel2();
            userInfoModel.setUserName("AVL" + i);
            userInfoModel.setUserAge("age" + i);
            userInfoModel.setUserType("type UserInfoModel2");
            userInfoModelList.add(userInfoModel);
        }

        for (int i = 0; i < 5; i++) {
            UserInfoModel3 userInfoModel = new UserInfoModel3();
            userInfoModel.setUserName("AVL" + i);
            userInfoModel.setUserAge("age" + i);
            userInfoModel.setUserType("type UserInfoModel3");
            userInfoModelList.add(userInfoModel);
        }

        for (int i = 0; i < 5; i++) {
            UserInfoModel4 userInfoModel = new UserInfoModel4();
            userInfoModel.setUserName("AVL" + i);
            userInfoModel.setUserAge("age" + i);
            userInfoModel.setUserType("type UserInfoModel4");
            userInfoModelList.add(userInfoModel);
        }

        return userInfoModelList;
    }
}
