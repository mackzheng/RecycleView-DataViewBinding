package com.avl.baserecycleviewdatabinding.bizbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.avl.baserecycleviewdatabinding.R;
import com.avl.baserecycleviewdatabinding.base.adapter.BaseRecyclerViewAdapter;
import com.avl.baserecycleviewdatabinding.base.onLoadMoreListener;

public abstract class BaseRecycleViewActivity extends BaseAppActivity {

    protected SwipeRefreshLayout refreshLayout;
    protected RecyclerView recyclerView;
    protected BaseRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initContent();
    }

    private void initContent() {
        setContentView(onCreateLayoutId());
        refreshLayout = findViewById(R.id.swipe_refresh_layout);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(onCreateLayoutManager());
        recyclerView.setItemAnimator(new DefaultItemAnimator()); //
        mAdapter = onCreateListAdapter();
        recyclerView.setAdapter(mAdapter);

        //设置下拉时圆圈的颜色（可以尤多种颜色拼成）
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light);
        //设置下拉时圆圈的背景颜色（这里设置成白色）

        refreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        //TODO 后续 封装 SwipeRefreshLayout，增加onLoadMore操作
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                BaseRecycleViewActivity.this.onRefresh(); //刷新
            }
        });

        recyclerView.addOnScrollListener(new onLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                onLoadMore(); //加载更多
            }
        });
    }

    //可以重写，该方法
    protected RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    }

    protected abstract void initData();

    protected abstract BaseRecyclerViewAdapter onCreateListAdapter();

    protected abstract int onCreateLayoutId();

    protected abstract void onLoadMore();

    protected abstract void onRefresh();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAdapter != null) {
            mAdapter.onDestroy();
        }
    }
}