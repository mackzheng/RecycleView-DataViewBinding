package com.avl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.avl.listdemo.userlist.UserInfoListActivity;
import com.avl.baserecycleviewdatabinding.R;

/**
 * Created by AVL on 2/14/19.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button userListBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userListBtn = findViewById(R.id.user_list);
        userListBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_list:
                Intent intent = new Intent(this, UserInfoListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
