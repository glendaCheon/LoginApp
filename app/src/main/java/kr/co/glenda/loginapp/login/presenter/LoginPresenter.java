package kr.co.glenda.loginapp.login.presenter;

import kr.co.glenda.loginapp.login.base.BasePresenterImpl;
import kr.co.glenda.loginapp.login.LoginContract;
import kr.co.glenda.loginapp.login.model.LoginRepository;
import kr.co.glenda.loginapp.login.model.LoginRepositoryImpl;
import kr.co.glenda.loginapp.login.model.User;

public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter {
    LoginContract.View view;
    LoginRepository repository = new LoginRepositoryImpl();

    //View에서 Presenter 호출
    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
        repository.setPresenter(this);
    }

    @Override
    public void removeView() {
        view = null;
    }

    @Override
    public void loginProc(User user) {
        repository.loginProc(user);
    }

    //View에 다시 던져주는 역할
    @Override
    public void loginDone() {
            view.loginDone();
    }
}
