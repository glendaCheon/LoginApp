package kr.co.glenda.loginapp.login.model.datasources.local;

import android.util.Log;

import kr.co.glenda.loginapp.login.common.AppDatabase;
import kr.co.glenda.loginapp.login.common.AppDatabaseProvider;
import kr.co.glenda.loginapp.login.model.LoginRepository;
import kr.co.glenda.loginapp.login.model.User;
import kr.co.glenda.loginapp.login.model.datasources.DataSource;

public class LocalDataSourceImpl implements DataSource {
    LoginRepository loginRepository;

    @Override
    public void setRepository(LoginRepository repository) {
        this.loginRepository = repository;
    }

    @Override
    public void loginProc(User user) {
        //thread 안 해주면 에러남.
        new Thread(() -> {
            try{
                //1. 동작 확인용
//                this.loginRepository.loginProc(user);

                //2. ROOM을 이용한 개발
                UserDao userDao = AppDatabaseProvider.getINSTANCE().getUserDao();
                UserEntity entity = new UserEntity();
                entity.setId(user.getId());
                entity.setPwd(user.getPwd());
                userDao.adduser(entity);

                UserEntity selectedEntity = userDao.login(user.getId(), user.getPwd());
                Log.d("DB", selectedEntity.toString());

                if(selectedEntity != null){
                    this.loginRepository.loginDone();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }).start();

    }
}
