package com.avl.listdemo.userlist.manager;

import com.avl.listdemo.userlist.model.UserInfoModel;

import java.util.List;

/**
 * Created by AVL on 2/14/19.
 */
public interface IUserInfoManager {
    //用户信息列表请求
    public void requestUserInfoList(int groupId, IUserInfoCallBack callBack);

    //用户信息列表回调
    public interface IUserInfoCallBack {
        public void onRequestUserInfoListSuccess(List<UserInfoModel> list);

        public void onRequestUserInfoListFailed();

        public void onRequestUserInfoListTimeout();
    }

}
