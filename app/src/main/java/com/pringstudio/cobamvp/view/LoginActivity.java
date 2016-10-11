package com.pringstudio.cobamvp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.pringstudio.cobamvp.R;
import com.pringstudio.cobamvp.presenter.ILoginPresenter;
import com.pringstudio.cobamvp.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    EditText mLoginUser;
    EditText mLoginPassword;
    Button mLoginButton;
    ProgressBar mProgressBar;

    // Login Presenter
    ILoginPresenter iLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginUser = (EditText) findViewById(R.id.login_user);
        mLoginPassword = (EditText) findViewById(R.id.login_password);
        mLoginButton = (Button) findViewById(R.id.btn_login);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mLoginButton.setOnClickListener(this);

        iLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                iLoginPresenter.setProgressVisibility(View.VISIBLE);
                mLoginButton.setEnabled(false);
                iLoginPresenter.doLogin(mLoginUser.getText().toString(),mLoginPassword.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void onClearText() {
        mLoginUser.setText("");
        mLoginPassword.setText("");
        mLoginUser.requestFocus();
    }

    @Override
    public void onLoginResult(Boolean result) {
        mLoginButton.setEnabled(true);
        iLoginPresenter.setProgressVisibility(View.GONE);
        if(result){
            Toast.makeText(this,"Login success",Toast.LENGTH_SHORT).show();
            Log.d("onLoginResult","Success");
            iLoginPresenter.clear();

            // Show
            startActivity(new Intent(this,HomeActivity.class));
        }else{
            Toast.makeText(this,"Login gagal, chek kembali username dan password",Toast.LENGTH_SHORT).show();
            Log.d("onLoginResult","Failed");
        }
    }

    @Override
    public void onSetProgressVisibility(int visibility) {
        mProgressBar.setVisibility(visibility);
    }
}
