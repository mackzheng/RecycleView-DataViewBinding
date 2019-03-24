package com.avl.baserecycleviewdatabinding.bizbase;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import com.avl.baserecycleviewdatabinding.base.BaseViewHolderFactory;
import com.avl.baserecycleviewdatabinding.base.adapter.BaseRecyclerViewAdapter;
import com.avl.baserecycleviewdatabinding.base.viewholder.BaseViewHolder;

/**
 * Created by AVL on 2/14/19.
 */
public abstract class BizBaseViewHolderFactory extends BaseViewHolderFactory
{
    private static final String TAG = "ListViewHolderFactory";
    public BaseRecyclerViewAdapter mListAdapter;

    public BizBaseViewHolderFactory(Context context)
    {
        super(context);
    }

    @Override
    public BaseViewHolder create(Class valueClass, ViewGroup parent)
    {
        BaseViewHolder item = super.create(valueClass, parent);  //这里通过反射的方式 创建viewholder对象。

        if (mListAdapter != null && item !=null )
        {
            item.setBaseRecyclerAdapter(mListAdapter);  //notice: viewHolder can get viewModelList data.
        }
        return item;
    }

    public void bindBaseDataToView(BaseRecyclerViewAdapter listAdapter)
    {
        if(listAdapter == null )
        {
            Log.e(TAG,"the listadapter is null");
            return;
        }
        bindDateToView(listAdapter);
    }

    public abstract void bindDateToView(BaseRecyclerViewAdapter listAdapter);
}
