package com.project.findpray;

/**
 * Created by Administrator on 8/30/2016.
 */

public interface UserManagerHelper {

    public static final String DATABASE_NAME = "Findpray_login";
    public static final int DATABASE_VERSION = 1;

    public long registerUser(User user);

    public User checkUserLogin(User user);

    public int changePassword(User user);


}
