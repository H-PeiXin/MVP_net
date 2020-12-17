package com.example.p7_1_8.contract;

import com.example.p7_1_8.model.UserBean;
import com.example.p7_1_8.utils.net.INetCallBack;

public class MainContract {
    public interface IMainModel{
        <T> void getLoginData(String url, INetCallBack<T> callBack);
    }

    public interface IMainPresenter{
        void login();
        void loginResult(String result);
    }

    public interface IMainView{
        void getData(UserBean string);
    }
}
