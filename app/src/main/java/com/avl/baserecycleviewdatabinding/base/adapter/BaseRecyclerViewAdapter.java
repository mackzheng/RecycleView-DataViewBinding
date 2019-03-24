package com.avl.baserecycleviewdatabinding.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


import com.avl.baserecycleviewdatabinding.base.listeners.BaseOnClickListener;
import com.avl.baserecycleviewdatabinding.base.listeners.BaseOnLongClickListener;
import com.avl.baserecycleviewdatabinding.base.util.ListUtils;
import com.avl.baserecycleviewdatabinding.base.viewholder.BaseEmptyHolder;
import com.avl.baserecycleviewdatabinding.base.viewholder.BaseViewHolder;
import com.avl.baserecycleviewdatabinding.base.BaseViewHolderFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AVL on 2/14/19.
 */
public class BaseRecyclerViewAdapter<V> extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "BaseRecyclerViewAdapter";
    private static final int ERROR_VIEW_TYPE = -1;

    private BaseViewHolderFactory viewHolderFactory;
    private List<Class> valueClassTypes = new ArrayList<>();
    public List<V> mViewModels = new ArrayList<>();
    private BaseViewHolder.OnItemClickListener itemClickListener;
    private BaseViewHolder.OnItemLongClickListener itemLongClickListener;
    private BaseViewHolder.OnItemDragListener itemDragListener;
    private long millisIntervalToAvoidDoubleClick;

    public BaseRecyclerViewAdapter(Context context, Class valueClass,
                                   Class<? extends BaseViewHolder> viewHolderClass) {
        this(context);
        bind(valueClass, viewHolderClass);
    }

    public BaseRecyclerViewAdapter(Context context) {
        this(new BaseViewHolderFactory(context));
    }

    public BaseRecyclerViewAdapter(BaseViewHolderFactory baseBaseViewHolderFactory, Class valueClass,
                                   Class<? extends BaseViewHolder> viewHolderClass) {
        this(baseBaseViewHolderFactory);
        bind(valueClass, viewHolderClass);
    }

    public BaseRecyclerViewAdapter(BaseViewHolderFactory baseBaseViewHolderFactory) {
        this.viewHolderFactory = baseBaseViewHolderFactory;
    }

    public void bind(Class valueClass, Class<? extends BaseViewHolder> viewHolderClass) {
        valueClassTypes.add(valueClass);
        viewHolderFactory.bind(valueClass, viewHolderClass);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = null;
        if (viewType == -1) {
            Log.w("BaseRecyclerAdapter", "the viewType is error viewType = " + viewType);
            return new BaseEmptyHolder(parent.getContext());
        } else {
            viewHolder = viewHolderFactory.create(valueClassTypes.get(viewType), parent);
        }
        bindListeners(viewHolder);
        return viewHolder;
    }

    private void bindListeners(BaseViewHolder viewHolder) {
        if (viewHolder != null) {
            viewHolder.setItemClickListener(itemClickListener);
            viewHolder.setItemLongClickListener(itemLongClickListener);
            viewHolder.setItemDragListener(itemDragListener);
        }
    }

    public void setItemClickListener(final BaseViewHolder.OnItemClickListener itemClickListener) {
        this.itemClickListener = new BaseOnClickListener(millisIntervalToAvoidDoubleClick) {
            @Override
            public boolean onBaseClick(View v, int position) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(position, v);
                }
                return true;
            }
        };
    }

    public void setItemLongClickListener(
            final BaseViewHolder.OnItemLongClickListener itemLongClickListener) {
        this.itemLongClickListener = new BaseOnLongClickListener() {
            @Override
            public boolean onBaseClick(View v, int position) {
                if (itemLongClickListener != null) {
                    return itemLongClickListener.onItemLongClicked(position, v);
                }
                return false;
            }
        };
    }

    public void setItemDragListener(BaseViewHolder.OnItemDragListener itemDragListener) {
        this.itemDragListener = itemDragListener;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (holder == null) {
            return;
        }

        holder.bindTo(mViewModels.get(position), position);
    }


    @Override
    public int getItemViewType(int position) {
        int index = valueClassTypes.indexOf(mViewModels.get(position).getClass());
//      TLog.d("BaseRecyclerAdapter","the viewType name="+mViewModels.get(position).getClass().getSimpleName()+"  viewType = "+ index);
//      TLog.w(TAG ,"the viewType is  viewType = "+ mViewModels.get(position).getClass().getSimpleName());
        if (index == ERROR_VIEW_TYPE) {
            Log.w(TAG, "the viewType is error viewType = " + mViewModels.get(position).getClass().getSimpleName());
        }
        return index;
    }

    public void add(V item) {
        mViewModels.add(item);
        notifyItemRangeChanged(getItemCount() - 1, 1);
    }

    public void addAt(V item, int position) {
        boolean validIndex = isValidIndex(position);
        if (validIndex) {
            mViewModels.add(position, item);
            notifyItemInserted(position);
        }
    }

    public void addAll(List<V> items) {
        mViewModels.clear();
        append(items);
    }

    public void append(List<V> items) {
        mViewModels.addAll(items);
        notifyDataSetChanged();
    }

    public boolean remove(V item) {
        int position = getIndex(item);
        return removeAt(position);
    }

    public boolean removeAt(int position) {
        boolean validIndex = isValidIndex(position);
        if (validIndex) {
            mViewModels.remove(position);
            notifyItemRemoved(position);
        }
        return validIndex;
    }

    public void clear() {
        mViewModels.clear();
        notifyDataSetChanged();
    }

    private boolean isValidIndex(int position) {
        return (position >= 0 && position < getItemCount());
    }

    public int getIndex(V item) {
        return mViewModels.indexOf(item);
    }

    public V getItem(int position) {
        if (position < mViewModels.size()) {
            return mViewModels.get(position);
        }
        return null;
    }

    @Override
    public int getItemCount() {

        return mViewModels.size();
    }



    public void onDestroy() {
    }

    public List<Class> getValueClassTypes() {
        return valueClassTypes;
    }
}
