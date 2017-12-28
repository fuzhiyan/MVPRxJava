package com.mixky.mvprxjava;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mixky.mvprxjava.bean.InfoBean;
import com.mixky.mvprxjava.presenter.InfoPresenter;
import com.mixky.mvprxjava.presenter.InfoPresenterImp;
import com.mixky.mvprxjava.view.IView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

    //控件
    private ImageView imageView;
    private Button button;
    private TextView textView;
    private InfoPresenterImp infoPresenterImp;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        imageView = findViewById(R.id.main_image);
        button = findViewById(R.id.main_btn);
        textView = findViewById(R.id.main_text);
        //P层的实例
        infoPresenterImp = new InfoPresenterImp(this, this);
        //初始化进度条
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在请求获取数据,请稍等!!!");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击按钮请求数据
                infoPresenterImp.loadInfoData();
            }
        });
    }

    @Override
    public void showProgress() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void loadDataSuccess(InfoBean data) {
        List<InfoBean.AllItemsBean> list = data.all_items;
        textView.setVisibility(View.VISIBLE);
        textView.setText(list.get(4).title);
        Glide.with(this).load(list.get(4).pic_url).into(imageView);
        progressDialog.dismiss();
    }

    @Override
    public void loadDataFail(Throwable throwable) {
        String errorMsg = throwable.getMessage();
        textView.setVisibility(View.VISIBLE);
        textView.setText(errorMsg);
        progressDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        infoPresenterImp.onUnsubscribe();
    }
}
