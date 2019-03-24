package com.avl.baserecycleviewdatabinding.base.listeners;

import android.view.View;

import com.avl.baserecycleviewdatabinding.base.viewholder.BaseViewHolder;

/**
 * Created by AVL on 2/14/19.
 */
public abstract class BaseOnLongClickListener
    implements BaseListener, BaseViewHolder.OnItemLongClickListener {

  private final BaseClickHandler mBaseClickHandler;

  protected BaseOnLongClickListener() {
    this.mBaseClickHandler = new BaseClickHandler(this);
  }

  @Override
  public boolean onItemLongClicked(int position, View view) {
    return mBaseClickHandler.invokeBaseClick(position, view);
  }
}
