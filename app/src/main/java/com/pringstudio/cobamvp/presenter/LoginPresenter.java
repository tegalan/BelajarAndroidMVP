package com.pringstudio.cobamvp.presenter;

import com.pringstudio.cobamvp.view.ILoginView;

/**
 * Created by sucipto on 9/28/16.
 */

public class LoginPresenter implements ILoginPresenter {
    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void clear() {

    }

    @Override
    public void doLogin(String username, String password) {

    }

    @Override
    public void setProgressVisibility(int visibility) {

    }
}
