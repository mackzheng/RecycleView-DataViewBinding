package com.avl.listdemo.userlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.avl.baserecycleviewdatabinding.R;
import com.avl.baserecycleviewdatabinding.base.adapter.BaseRecyclerViewAdapter;
import com.avl.baserecycleviewdatabinding.bizbase.BaseRecycleViewActivity;
import com.avl.listdemo.userlist.factory.DataViewBindFactory;
import com.avl.listdemo.userlist.manager.IUserInfoManager;
import com.avl.listdemo.userlist.manager.UserInfoManager;
import com.avl.listdemo.userlist.model.UserInfoModel;

import java.util.List;

/**
 * Created by AVL on 2/14/19.
 */
public class UserInfoListActivity extends BaseRecycleViewActivity implements IUserInfoManager.IUserInfoCallBack {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化时候，刷新
        onRefresh();
    }

    @Override
    protected RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    protected void initData()
    {
    }

    //这里是重点
    @Override
    protected BaseRecyclerViewAdapter onCreateListAdapter() {
        DataViewBindFactory factory = new DataViewBindFactory(this);
        mAdapter = new BaseRecyclerViewAdapter(factory); //可以扩展BaseRecyclerViewAdapter
        factory.bindDateToView(mAdapter);
        return mAdapter;
    }

    @Override
    protected int onCreateLayoutId() {
        return R.layout.user_info_list_layout;
    }

    //刷新
    @Override
    protected void onRefresh() {
        UserInfoManager.getUserInfoManager().requestUserInfoList(0, this);
    }

    //加载更多
    @Override
    protected void onLoadMore() {
        UserInfoManager.getUserInfoManager().requestUserInfoList(0, this);
    }

    //TODO 暂时未梳理翻页逻辑，这里只是给一个示例
    @Override
    public void onRequestUserInfoListSuccess(List<UserInfoModel> list) {
        //请求成功
        if (mAdapter != null) {
            mAdapter.clear();
            mAdapter.addAll(list);
            mAdapter.notifyDataSetChanged();
        }

        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onRequestUserInfoListFailed() {
        //请求失败
    }

    @Override
    public void onRequestUserInfoListTimeout() {

    }
}
