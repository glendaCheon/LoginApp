package kr.co.glenda.loginapp.login.model;

import kr.co.glenda.loginapp.login.LoginContract;
import kr.co.glenda.loginapp.login.model.datasources.DataSource;
import kr.co.glenda.loginapp.login.model.datasources.local.LocalDataSourceImpl;
import kr.co.glenda.loginapp.login.model.datasources.remote.RemoteDataSourceImpl;

public class LoginRepositoryImpl implements LoginRepository {
    LoginContract.Presenter presenter;
    DataSource localDataSource;
    DataSource remoteDataSource;

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
        localDataSource = new LocalDataSourceImpl();
        localDataSource.setRepository(this);
        remoteDataSource = new RemoteDataSourceImpl();
        remoteDataSource.setRepository(this);
    }

    @Override
    public void loginProc(User user) {
        localDataSource.loginProc(user);

        //TODO DataSource connect
//        if(localDataSource.loginProc(user)){
//            //로컬에 데이터가 없는 경우, 서버통신 한 후에 로컬에 다시 저장
//            remoteDataSource.loginProc(user);
//        } else {
//            //로컬에 데이터가 있는 경우, 5분 안에 local로 호출하는 캐싱 전략.
//            localDataSource.loginProc(user);
//        }
    }

    @Override
    public void loginDone() {
        this.presenter.loginDone();
    }
}
