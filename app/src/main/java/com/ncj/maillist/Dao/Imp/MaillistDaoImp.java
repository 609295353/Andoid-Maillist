package com.ncj.maillist.Dao.Imp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ncj.maillist.DBHelper.DBHelper;
import com.ncj.maillist.Dao.MaillistDao;
import com.ncj.maillist.Entity.Maillist;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 咸蛋糙人 on 2020/4/15.
 */

public class MaillistDaoImp implements MaillistDao{
    static DBHelper dbHelper ;
    public MaillistDaoImp(Context context){
        dbHelper=new DBHelper(context);
    }
    @Override
    public List<Maillist> getMaillist() {
        SQLiteDatabase db=null;
        LinkedList<Maillist> l= new LinkedList<>();
        try {
            db = dbHelper.getWritableDatabase();
            String[] str = {"id","name","phone"};
            Cursor cursor = db.query("maillist", str, null, null, null,  null,"name asc");
            while (cursor.moveToNext()) {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String phone = cursor.getString(2);
                byte[] img = null;
                Maillist ml = new Maillist(id, name, phone, img);
                l.add(ml);
            }
            db.close();
            return l;
        }catch (Exception e){
            return l;
        }finally {
            db.close();
        }
    }

    @Override
    public boolean AddMail(Maillist ml) {
        SQLiteDatabase db=null;
        try {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name",ml.getName());
            values.put("phone",ml.getPhone());
            values.put("image",ml.getImage());
            db.insert("maillist", null, values);
            db.close();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            db.close();
        }
    }

    @Override
    public boolean DelMail(String id) {
        SQLiteDatabase db=null;
        try {
            db = dbHelper.getWritableDatabase();
            db.delete("maillist","id = "+id,null);
            db.close();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            db.close();
        }
    }

    @Override
    public boolean UpdateMail(Maillist ml) {
        SQLiteDatabase db=null;
        try {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name",ml.getName());
            values.put("phone",ml.getPhone());
            values.put("image",ml.getImage());
            db.update("maillist", values, "id = "+ml.getId(),null);
            db.close();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            db.close();
        }
    }

    @Override
    public Maillist GetOne(String id) {
        SQLiteDatabase db=null;
        Maillist ml = null;
        try {
            db = dbHelper.getWritableDatabase();

            Cursor cursor = db.query("maillist", null, "id = "+id, null, null, null, null);
            while (cursor.moveToNext()) {
                String name = cursor.getString(1);
                String phone = cursor.getString(2);
                byte[] img = cursor.getBlob(3);
                ml = new Maillist(Integer.valueOf(id), name, phone, img);
            }
            db.close();
            return ml;
        }catch (Exception e){
            return ml;
        }finally {
            db.close();
        }
    }

    @Override
    public List<Maillist> SearchLikeMaillist(String s) {
        SQLiteDatabase db=null;
        List<Maillist> l = new LinkedList<>();
        try {
            db = dbHelper.getWritableDatabase();
            Cursor cursor = db.query("maillist", null, "name Like '%"+s+"%'", null, null, null, "name asc");
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String phone = cursor.getString(2);
                byte[] img = cursor.getBlob(3);
                Maillist ml = new Maillist(id, name, phone, img);
                l.add(ml);
            }
            db.close();
            return l;
        }catch (Exception e){
            return l;
        }finally {
            db.close();
        }
    }
}
