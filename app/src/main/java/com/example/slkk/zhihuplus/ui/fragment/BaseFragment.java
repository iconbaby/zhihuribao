package com.example.slkk.zhihuplus.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.slkk.zhihuplus.ui.view.LoadPage;

/**
 * Created by slkk on 2016/5/26.
 */
public abstract class BaseFragment extends Fragment {
    public LoadPage loadPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (loadPage == null) {
            loadPage = new LoadPage(getActivity()) {
                @Override
                protected Object onLaod() {
                    return getData();
                }

                @Override
                protected View createSuccessView() {
                    return getSuccessView();
                }
            };
        }
        return loadPage;

    }

    protected abstract View getSuccessView();

    protected abstract Object getData();
}
