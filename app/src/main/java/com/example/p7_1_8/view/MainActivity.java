package com.example.p7_1_8.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.p7_1_8.R;
import com.example.p7_1_8.adapter.RecAdapter;
import com.example.p7_1_8.base.BaseActivity;
import com.example.p7_1_8.contract.MainContract;
import com.example.p7_1_8.model.UserBean;
import com.example.p7_1_8.presenter.MainPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainContract.IMainView {

    private RecyclerView rec_main;

    @Override
    protected void initData() {
        rec_main.setLayoutManager(new LinearLayoutManager(this));

        presenter.login();
    }

    @Override
    protected void initView() {
        rec_main = findViewById(R.id.rec_main);
    }

    @Override
    public MainPresenterImpl add() {
        return new MainPresenterImpl(this);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void getData(UserBean string) {
        ArrayList<UserBean.ResultsBean> results = (ArrayList<UserBean.ResultsBean>) string.getResults();
        RecAdapter recAdapter = new RecAdapter(results, this);
        rec_main.setAdapter(recAdapter);
    }
}