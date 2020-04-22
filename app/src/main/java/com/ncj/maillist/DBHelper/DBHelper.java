package com.ncj.maillist.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 咸蛋糙人 on 2019/2/19.
 */

public class DBHelper extends SQLiteOpenHelper {

    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    //每次你对数据表进行编辑，添加时候，你都需要对数据库的版本进行提升

    //数据库版本
    private static final int DATABASE_VERSION=10;

    //数据库名称
    private static final String DATABASE_NAME="maillist.db";


    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据表
       String s=" CREATE TABLE maillist (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name STRING, phone, image BLOB);\n" +
               "        INSERT INTO maillist (id, name, phone, image) VALUES (1, '倪超杰', 13122791183, NULL);\n" +
               "        INSERT INTO maillist (id, name, phone, image) VALUES (2, '张宸一', 13095806070, NULL);\n" +
               "\n" +
               "        COMMIT TRANSACTION;\n" +
               "        PRAGMA foreign_keys = on;";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //如果旧表存在，删除，所以数据将会消失
//        db.execSQL("DROP TABLE IF EXISTS maillist");
//        //再次创建表
//        onCreate(db);
    }
}
