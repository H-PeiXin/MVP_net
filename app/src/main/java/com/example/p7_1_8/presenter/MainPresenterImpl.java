package com.example.p7_1_8.presenter;

import com.example.p7_1_8.base.BasePresenter;
import com.example.p7_1_8.contract.MainContract;
import com.example.p7_1_8.model.MainModelImpl;
import com.example.p7_1_8.model.UserBean;
import com.example.p7_1_8.utils.net.INetCallBack;

public class MainPresenterImpl extends BasePresenter implements MainContract.IMainPresenter {

    private MainContract.IMainView mainView;
    private final MainModelImpl mainModel;

    public MainPresenterImpl(MainContract.IMainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModelImpl(this);
    }

    @Override
    public void login() {
        mainModel.getLoginData("%E7%A6%8F%E5%88%A9/10/7", new INetCallBack<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {
                mainView.getData(userBean);
            }

            @Override
            public void onFail(String err) {

            }
        });
    }

    @Override
    public void loginResult(String result) {

    }
}
