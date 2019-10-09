package kr.co.glenda.loginapp.login.common;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import kr.co.glenda.loginapp.login.model.datasources.local.UserDao;
import kr.co.glenda.loginapp.login.model.datasources.local.UserEntity;

@Database(entities =   {UserEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
