package com.pringstudio.cobamvp.presenter;

import com.pringstudio.cobamvp.model.IUserModel;
import com.pringstudio.cobamvp.model.UserModel;
import com.pringstudio.cobamvp.view.ILoginView;

/**
 * Created by sucipto on 9/28/16.
 */

public class LoginPresenter implements ILoginPresenter {
    ILoginView iLoginView;
    IUserModel iUserModel;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        iUserModel = new UserModel("user","password");
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String username, String password) {
        iLoginView.onLoginResult(
                iUserModel.checkLogin(username,password)
        );
    }

    @Override
    public void setProgressVisibility(int visibility) {
        iLoginView.onSetProgressVisibility(visibility);
    }
}
