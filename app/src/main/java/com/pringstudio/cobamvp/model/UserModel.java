package com.pringstudio.cobamvp.model;

/**
 * Created by sucipto on 9/28/16.
 */

public class UserModel implements IUserModel {

    String mUsername;
    String mPassword;

    public UserModel(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    @Override
    public String getUsername() {
        return mUsername;
    }

    @Override
    public String getPassword() {
        return mPassword;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        if(username==null||password==null||!username.equals(getUsername())||!password.equals(getPassword())){
            return  false;
        }
        return true;
    }
}
