package kr.co.glenda.loginapp.login.model.datasources.remote;

import android.util.Log;

import kr.co.glenda.loginapp.login.model.LoginRepository;
import kr.co.glenda.loginapp.login.model.User;
import kr.co.glenda.loginapp.login.model.datasources.DataSource;

public class RemoteDataSourceImpl implements DataSource {
    LoginRepository loginRepository;

    @Override
    public void setRepository(LoginRepository repository) {
        this.loginRepository = repository;
    }

    @Override
    public void loginProc(User user) {
//        this.loginRepository.loginProc(user);
        Log.d("RemodeDataSourceImple]", "서버 통신은 아직 안 됨.");
        return;
    }
}
