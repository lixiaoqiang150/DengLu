package com.example.lxqq.denglu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ZhuCe extends AppCompatActivity implements View.OnClickListener{

    private Button zhu_register;
    private EditText zhu_phone;
    private EditText zhu_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        zhu_password = (EditText) findViewById(R.id.zhu_password);
        zhu_phone = (EditText) findViewById(R.id.zhu_phone);
        zhu_register = (Button) findViewById(R.id.zhu_register);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zhu_register:
                Intent intent=new Intent(ZhuCe.this, MainActivity.class);
                startActivity(intent);
        }
        
    }
}
