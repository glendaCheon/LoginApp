package kr.co.glenda.loginapp.login.model;

import kr.co.glenda.loginapp.login.LoginContract;

public interface LoginRepository {
    void setPresenter(LoginContract.Presenter presenter);
    void loginProc(User user);
    void loginDone();
}
