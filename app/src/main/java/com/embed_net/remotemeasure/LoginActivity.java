package com.embed_net.remotemeasure;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dell01 on 2016/12/17.
 */

public class LoginActivity extends AppCompatActivity{
    private Button button;
    private EditText uidtext,pwdtext,urltext,porttext;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        pref = getSharedPreferences("data",MODE_PRIVATE);
//        pref = PreferenceManager.getDefaultSharedPreferences(this);
        button = (Button) findViewById(R.id.save_config);
        uidtext = (EditText)findViewById(R.id.uid_text);
        pwdtext = (EditText)findViewById(R.id.pwd_text);
        urltext = (EditText)findViewById(R.id.url_text);
        porttext = (EditText)findViewById(R.id.port_text);
        uidtext.setText(pref.getString("username","admin"));
        pwdtext.setText(pref.getString("password","password"));
        urltext.setText(pref.getString("url","192.168.0.101"));
        porttext.setText(pref.getString("port","61613"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor = pref.edit();
                editor.putString("username",uidtext.getText().toString());
                editor.putString("password",pwdtext.getText().toString());
                editor.putString("url",urltext.getText().toString());
                editor.putString("port",porttext.getText().toString());
                editor.apply();
                Toast.makeText(LoginActivity.this,pref.getString("username",""),Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
