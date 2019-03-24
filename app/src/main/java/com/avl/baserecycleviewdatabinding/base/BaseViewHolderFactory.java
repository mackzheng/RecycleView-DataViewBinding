package com.avl.baserecycleviewdatabinding.base;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import com.avl.baserecycleviewdatabinding.base.adapter.BaseRecyclerViewAdapter;
import com.avl.baserecycleviewdatabinding.base.viewholder.BaseViewHolder;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AVL on 2/14/19.
 */
public class BaseViewHolderFactory {
    private static final String TAG = "BaseViewHolderFactory";

    protected Context context;

    private Map<Class, Class<? extends BaseViewHolder>> boundViewHolders = new HashMap<>();

    public BaseViewHolderFactory(Context context) {
        this.context = context;
    }

    public BaseViewHolder create(Class valueClass, ViewGroup parent) {
        try {
            Class<? extends BaseViewHolder> viewHolderClass = boundViewHolders.get(valueClass);
            Constructor<? extends BaseViewHolder> constructor;
            constructor = viewHolderClass.getDeclaredConstructor(Context.class, ViewGroup.class);
            return constructor.newInstance(context, parent);
        } catch (Throwable ex) {
            throw new RuntimeException(
                    "Unable to create ViewHolder for" + valueClass + ". " + ex.getCause().getMessage(), ex);
        }
    }

    public void bind(Class valueClass, Class<? extends BaseViewHolder> viewHolderClass) {
        boundViewHolders.put(valueClass, viewHolderClass);
    }


    public int getViewType(BaseRecyclerViewAdapter listAdapter, Class dataClass) {
        int viewType = -1;

        if (listAdapter != null) {
            List<Class> classList = listAdapter.getValueClassTypes();

            if (classList != null) {
                for (int i = 0; i < classList.size(); i++) {
                    if (dataClass.getSimpleName().equals(classList.get(i).getSimpleName())) {
                        viewType = i;
                        break;
                    }
                }
            }
        }
        Log.d(TAG, "getViewType dataClass =" + dataClass.getSimpleName() + "  viewType =" + viewType);
        return viewType;
    }
}
