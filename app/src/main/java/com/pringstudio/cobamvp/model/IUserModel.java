package com.pringstudio.cobamvp.model;

/**
 * Created by sucipto on 9/28/16.
 */

public interface IUserModel {
    String getUsername();
    String getPassword();
    boolean checkLogin(String username, String password);
}
