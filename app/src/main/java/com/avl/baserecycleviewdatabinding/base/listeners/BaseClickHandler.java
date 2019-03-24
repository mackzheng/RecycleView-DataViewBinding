package com.avl.baserecycleviewdatabinding.base.listeners;

import android.os.SystemClock;
import android.view.View;

/**
 * Created by AVL on 2/14/19.
 */
public class BaseClickHandler
{

  private final static long MINIMUM_INTERVAL_MILLIS = 300;

  private long intervalMillis = MINIMUM_INTERVAL_MILLIS;
  private long previousClickTimestamp;
  private final BaseListener baseOnClickListener;

  public BaseClickHandler(BaseListener baseOnClickListener) {
    this.baseOnClickListener = baseOnClickListener;
  }

  public BaseClickHandler(BaseListener  baseOnClickListener, long intervalMillis) {
    this.baseOnClickListener = baseOnClickListener;
    this.intervalMillis = intervalMillis;
  }

  public boolean invokeBaseClick(int position, View view) {
    long currentTimestamp = SystemClock.uptimeMillis();
    boolean handled = false;
    if (currentTimestamp - previousClickTimestamp > intervalMillis) {
      handled = baseOnClickListener.onBaseClick(view, position);
      previousClickTimestamp = currentTimestamp;
    }
    return handled;
  }
}
