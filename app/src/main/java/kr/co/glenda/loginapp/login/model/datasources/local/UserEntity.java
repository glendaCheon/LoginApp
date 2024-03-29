package kr.co.glenda.loginapp.login.model.datasources.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName =  "user")
public class UserEntity {
    @PrimaryKey(autoGenerate =  true)
    int no;
    String id;
    String pwd;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
