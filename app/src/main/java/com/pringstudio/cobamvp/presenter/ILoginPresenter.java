package com.pringstudio.cobamvp.presenter;

/**
 * Created by sucipto on 9/28/16.
 */

public interface ILoginPresenter {
    void clear();
    void doLogin(String username, String password);
    void setProgressVisibility(int visibility);
}
