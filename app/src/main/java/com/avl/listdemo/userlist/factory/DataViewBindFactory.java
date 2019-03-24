package com.avl.listdemo.userlist.factory;

import android.content.Context;

import com.avl.baserecycleviewdatabinding.base.adapter.BaseRecyclerViewAdapter;
import com.avl.baserecycleviewdatabinding.bizbase.BizBaseViewHolderFactory;
import com.avl.listdemo.userlist.model.UserInfoModel;
import com.avl.listdemo.userlist.model.UserInfoModel2;
import com.avl.listdemo.userlist.model.UserInfoModel3;
import com.avl.listdemo.userlist.model.UserInfoModel4;
import com.avl.listdemo.userlist.model.UserInfoModel5;
import com.avl.listdemo.userlist.view.UserInfoViewHolder;

/**
 * Created by AVL on 2/14/19.
 */
public class DataViewBindFactory extends BizBaseViewHolderFactory {

    public DataViewBindFactory(Context context) {
        super(context);
    }

    @Override
    public void bindDateToView(BaseRecyclerViewAdapter listAdapter) {
        /**
         * 1.相同UserInfo数据源，映射到不同的viewHolder，需要继承UserInfo数据结构
         * 2.不同UserInfo的数据源，也可以映射到相同的viewHolder
         *
         */
        listAdapter.bind(UserInfoModel.class,  UserInfoViewHolder.class);  //用户信息
        listAdapter.bind(UserInfoModel2.class, UserInfoViewHolder.class);  //用户信息
        listAdapter.bind(UserInfoModel3.class, UserInfoViewHolder.class);  //用户信息
        listAdapter.bind(UserInfoModel4.class, UserInfoViewHolder.class);  //用户信息
        listAdapter.bind(UserInfoModel5.class, UserInfoViewHolder.class);  //用户信息
    }
}
