package kr.co.glenda.loginapp.login.model.datasources;

import kr.co.glenda.loginapp.login.model.LoginRepository;
import kr.co.glenda.loginapp.login.model.User;

public interface DataSource {
    public void setRepository(LoginRepository repository);
    public void loginProc(User user);
}
