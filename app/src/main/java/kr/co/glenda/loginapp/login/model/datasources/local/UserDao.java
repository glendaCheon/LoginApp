package kr.co.glenda.loginapp.login.model.datasources.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Query("SELECT * FROM USER WHERE ID = :id AND PWD = :pwd")
    UserEntity login(String id, String pwd);
    @Insert
    void adduser(UserEntity user);
}
