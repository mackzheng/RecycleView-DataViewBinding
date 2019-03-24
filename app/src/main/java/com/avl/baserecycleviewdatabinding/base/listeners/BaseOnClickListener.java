package com.avl.baserecycleviewdatabinding.base.listeners;

import android.view.View;

import com.avl.baserecycleviewdatabinding.base.viewholder.BaseViewHolder;

/**
 * Created by AVL on 2/14/19.
 */
public abstract class BaseOnClickListener implements BaseViewHolder.OnItemClickListener, BaseListener
{

  private final BaseClickHandler mBaseClickHandler;

  protected BaseOnClickListener() {
    this.mBaseClickHandler = new BaseClickHandler(this);
  }

  protected BaseOnClickListener(long millisIntervalToAvoidDoubleClick) {
    this.mBaseClickHandler = new BaseClickHandler(this, millisIntervalToAvoidDoubleClick);
  }

  @Override
  public void onItemClick(int position, View view) {
    mBaseClickHandler.invokeBaseClick(position, view);
  }
}
