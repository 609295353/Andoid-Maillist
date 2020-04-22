package com.ncj.maillist.Dao;

import com.ncj.maillist.Entity.Maillist;

import java.security.PublicKey;
import java.util.List;

/**
 * Created by 咸蛋糙人 on 2020/4/15.
 */

public interface MaillistDao {
    public List<Maillist> getMaillist();
    public boolean AddMail(Maillist ml);
    public boolean DelMail(String id);
    public boolean UpdateMail(Maillist ml);
    public Maillist GetOne(String id);
    public List<Maillist> SearchLikeMaillist(String s);
}
