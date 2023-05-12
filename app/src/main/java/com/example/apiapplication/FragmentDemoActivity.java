package com.example.apiapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.apiapplication.fragment.SecondFragment;
import com.example.apiapplication.fragment.ThirdFragment;

/**
 * https://cloud.tencent.com/developer/beta/article/1036722
 */
public class FragmentDemoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mAddBtn = null;
    private Button mRemoveBtn = null;
    private Button mReplaceBtn = null;
    private Fragment mSecondFragment = null;
    private Fragment mThirdFragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        mAddBtn = (Button) findViewById(R.id.add_btn);
        mRemoveBtn = (Button) findViewById(R.id.remove_btn);
        mReplaceBtn = (Button) findViewById(R.id.replace_btn);        // 创建和获取Fragment实例
        mSecondFragment = new SecondFragment();
        mThirdFragment = new ThirdFragment();        // 设置监听事件
        mAddBtn.setOnClickListener(this);
        mRemoveBtn.setOnClickListener(this);
        mReplaceBtn.setOnClickListener(this);    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {        // 获取到FragmentManager对象
        FragmentManager fragmentManager = getSupportFragmentManager();        // 开启一个事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();        // Fragment操作
        int id = v.getId();
        if (id == R.id.add_btn) {                // 向容器内加入Fragment
            if (!mSecondFragment.isAdded()) {
                fragmentTransaction.add(R.id.fragment_container1, mSecondFragment);
            }
            if (!mThirdFragment.isAdded()) {
                fragmentTransaction.add(R.id.fragment_container2, mThirdFragment);
            }
        } else if (id == R.id.remove_btn) {                // 从容器类移除Fragment
            fragmentTransaction.remove(mSecondFragment);
        } else if (id == R.id.replace_btn) {
            if (!mSecondFragment.isAdded()) {
                fragmentTransaction.replace(R.id.fragment_container2, mSecondFragment);
            }
        }
//        fragmentTransaction.addToBackStack(null);
        // 提交事务
        fragmentTransaction.commit();
    }}