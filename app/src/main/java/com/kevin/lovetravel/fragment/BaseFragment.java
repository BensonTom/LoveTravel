package com.kevin.lovetravel.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Benson_Tom on 2016/10/19.
 */

public abstract class BaseFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(),container,false);
        initEvent(view);
        return view;
    }
    protected abstract int setLayout();
    protected abstract void initEvent(View view);
}
