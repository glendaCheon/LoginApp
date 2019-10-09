package kr.co.glenda.loginapp.login.base;

public interface BasePresenter<T> {
    void setView(T view);
    void removeView();
}
