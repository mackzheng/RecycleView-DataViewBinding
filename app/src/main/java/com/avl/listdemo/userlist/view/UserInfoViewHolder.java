package com.avl.listdemo.userlist.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avl.baserecycleviewdatabinding.R;
import com.avl.baserecycleviewdatabinding.base.model.BaseViewModel;
import com.avl.baserecycleviewdatabinding.base.viewholder.BaseViewHolder;
import com.avl.baserecycleviewdatabinding.base.viewholder.IBaseViewHolder;
import com.avl.listdemo.userlist.model.UserInfoModel;
/**
 * Created by AVL on 2/14/19.
 */
public class UserInfoViewHolder extends BaseViewHolder<UserInfoModel> implements IBaseViewHolder{
    private TextView userName;
    private TextView userAge;
    private TextView userType;

    public UserInfoViewHolder(Context context, ViewGroup parent)
    {
        this(context, parent, R.layout.item_view_userinfo);
    }

    public UserInfoViewHolder(Context context, ViewGroup parent, int layoutId)
    {
        super(context, parent, layoutId);
        userName = itemView.findViewById(R.id.user_name);
        userAge  = itemView.findViewById(R.id.user_age);
        userType = itemView.findViewById(R.id.user_type);
    }

    @Override
    public void bindTo(UserInfoModel value, int position) {
        resetView(value);
    }

    @Override
    public void resetView(BaseViewModel info) {
        if (info instanceof UserInfoModel)
        {
            resetView(((UserInfoModel) info));
        }
    }

    private void resetView(UserInfoModel info)
    {
        if(info == null)  return;
        userName.setText(info.getUserName());
        userAge.setText(info.getUserAge());
        userType.setText(info.getUserType());
    }
}
