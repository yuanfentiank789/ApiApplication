package com.example.apiapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.apiapplication.R;

public class ThirdFragment extends BaseFragment {
 @Nullable    
 @Override    
 public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
     return inflater.inflate(R.layout.fragment_third, container, false);
}}