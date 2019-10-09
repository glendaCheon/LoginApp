package kr.co.glenda.loginapp.login;

import kr.co.glenda.loginapp.login.base.BasePresenter;
import kr.co.glenda.loginapp.login.base.BaseView;
import kr.co.glenda.loginapp.login.model.User;

public class LoginContract {
    public interface  View extends BaseView {
        void loginDone();
    }

    public interface Presenter extends BasePresenter<View> {
        void loginProc(User user);
        void loginDone();
    }
}
