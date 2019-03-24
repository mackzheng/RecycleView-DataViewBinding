package com.avl.baserecycleviewdatabinding.base.viewholder;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.avl.baserecycleviewdatabinding.R;


/**
 * Created by AVL on 2/14/19.
 */
public class BaseEmptyHolder  extends BaseViewHolder
{
    public BaseEmptyHolder(Context context)
    {
        super(new View(context));
    }

    @Override
    public void bindTo(Object value, int position) {

    }
}
