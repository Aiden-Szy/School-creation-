package com.example.myapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapp.R;
import com.example.myapp.api.Api;
import com.example.myapp.api.ApiConfig;
import com.example.myapp.api.TtitCallback;
import com.example.myapp.util.StringUtils;

import java.util.HashMap;

public class RegisterActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPwd;
    private Button btnResiter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etAccount = findViewById(R.id.et_account);
        etPwd = findViewById(R.id.et_pwd);
        btnResiter = findViewById(R.id.btn_register);
        btnResiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                register(account,pwd);
            }
        });

    }

    private void register(String account,String pwd){
        if (StringUtils.isEmpty(account)){
//            Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show();
            showToast("请输入账号");
            return;
        }
        if (StringUtils.isEmpty(pwd)){
//            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
            showToast("请输入密码");
            return;
        }

        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("mobile",account);
        params.put("password",pwd);
        Api.config(ApiConfig.REGISTER,params).postRequet(new TtitCallback() {
            @Override
            public void onSuccess(String res) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(res);
                    }
                });
            }

            @Override
            public void onFailure(String e) {
                Log.e("onFailure",e.toString());
            }
        });
    }
}