package com.aprovechamiento.leones.aprovechamientodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (AccessToken.getCurrentAccessToken()==null){
            goLoginScreen();
        }


    }

    private void goLoginScreen() {
        Intent goToLogin = new Intent(this, LoginActivity.class);
        goToLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(goToLogin);
    }

    private void logout(View view){
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }
}
