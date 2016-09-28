package com.pringstudio.cobamvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.pringstudio.cobamvp.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    EditText mLoginUser;
    EditText mLoginPassword;
    Button mLoginButton;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginUser = (EditText) findViewById(R.id.login_user);
        mLoginPassword = (EditText) findViewById(R.id.login_password);
        mLoginButton = (Button) findViewById(R.id.btn_login);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                mLoginButton.setEnabled(false);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClearText() {

    }

    @Override
    public void onLoginResult(Boolean result) {
        mLoginButton.setEnabled(true);
    }

    @Override
    public void onSetProgressVisibility(int visibility) {

    }
}
