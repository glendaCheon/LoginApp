package kr.co.glenda.loginapp.login.common;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseProvider {
    //SINGLETON으로 관리하기 위한 것.
    private volatile  static AppDatabase INSTANCE = null;

    //기본 constructor
    private AppDatabaseProvider(){}
    public static AppDatabase getINSTANCE() throws  Exception{
        if(INSTANCE == null){
            throw new Exception("INSTANCE MUST BE NOT NULL");
        }

        return INSTANCE;
    }

    //context를 넣었을 때 최초 생성 constructor
    public static AppDatabase getINSTANCE(Context context){
        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }

        return INSTANCE;
    }

}
