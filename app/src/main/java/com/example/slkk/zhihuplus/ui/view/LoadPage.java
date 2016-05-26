package com.example.slkk.zhihuplus.ui.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.slkk.zhihuplus.R;
import com.example.slkk.zhihuplus.global.ZhihuApp;
import com.example.slkk.zhihuplus.utils.Util;

import java.util.List;

/**
 * Created by slkk on 2016/5/26.
 */
public abstract class LoadPage extends FrameLayout {


    public LoadPage(Context context) {
        this(context, null, 0);
    }

    public LoadPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLoadPage();
    }

    public enum PageState {
        STATE_LOADING, STATE_SUCCESS, STATE_ERROR,
    }

    private PageState currrentState = PageState.STATE_LOADING;
    private View errorView;
    private View successView;
    private View loadingView;

    public void initLoadPage() {
        if (loadingView == null) {
            loadingView = View.inflate(ZhihuApp.context, R.layout.page_loading, null);
        }
        this.addView(loadingView);
        if (errorView == null) {
            errorView = View.inflate(ZhihuApp.context, R.layout.page_error, null);
            Button btn_reload = (Button) errorView.findViewById(R.id.btn_reload);
            btn_reload.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    currrentState = PageState.STATE_ERROR;
                    showPage();
                    loadData();
                }
            });
        }
        this.addView(errorView);
        if (successView == null) {
            successView = createSuccessView();
        }
        if (successView != null) {
            addView(successView);
        } else {
            throw new IllegalArgumentException("The successView is not be null");
        }

        showPage();
        loadData();

    }

    private void showPage() {
        loadingView.setVisibility(INVISIBLE);
        errorView.setVisibility(INVISIBLE);
        successView.setVisibility(INVISIBLE);

        switch (currrentState) {
            case STATE_ERROR:
                errorView.setVisibility(VISIBLE);
                break;
            case STATE_LOADING:
                loadingView.setVisibility(VISIBLE);
                break;
            case STATE_SUCCESS:
                successView.setVisibility(VISIBLE);
                break;
        }
    }


    public void loadData() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                SystemClock.sleep(1000);
                Object data = onLaod();
                currrentState = checkeData(data);
                Util.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        showPage();
                    }
                });
            }
        }.start();
    }

    private PageState checkeData(Object data) {
        if (data == null) {
            return PageState.STATE_ERROR;
        } else {
            if (data instanceof List) {
                List list = (List) data;
                if (list.size() == 0) {
                    return PageState.STATE_ERROR;
                }
            }
            return PageState.STATE_SUCCESS;
        }

    }
    //交给子类去实现的方法

    protected abstract Object onLaod();

    protected abstract View createSuccessView();
}


