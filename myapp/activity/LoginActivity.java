package com.example.myapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp.R;
import com.example.myapp.api.Api;
import com.example.myapp.api.ApiConfig;
import com.example.myapp.api.TtitCallback;
import com.example.myapp.util.AppConfig;
import com.example.myapp.util.StringUtils;

import java.util.HashMap;

public class LoginActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPwd;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    private void login(String account,String pwd){
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
        Api.config(ApiConfig.LOGIN,params).postRequet(new TtitCallback() {
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

            }
        });
    }


//    private void login(String account,String pwd){
//        if (StringUtils.isEmpty(account)){
////            Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show();
//            showToast("请输入账号");
//            return;
//        }
//        if (StringUtils.isEmpty(pwd)){
////            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
//            showToast("请输入密码");
//            return;
//        }
//
//        //第一步创建OKHttpClient
//        OkHttpClient client = new OkHttpClient.Builder()
//                .build();
//        Map<String, String> map = new HashMap<>();
//        map.put("mobile", account);
//        map.put("password", pwd);
//        JSONObject jsonObject = new JSONObject(map);
//        String jsonStr = jsonObject.toString();
//        RequestBody requestBodyJson =
//                RequestBody.create(MediaType.parse("application/json;charset=utf-8")
//                        , jsonStr);
//        //第三步创建Rquest
//        Request request = new Request.Builder()
//                .url(AppConfig.BASE_URL + "/app/login")
//                .addHeader("contentType", "application/json;charset=UTF-8")
//                .post(requestBodyJson)
//                .build();
//        //第四步创建call回调对象
//        final Call call = client.newCall(request);
//        //第五步发起请求
//        call.enqueue(new Callback() {// 确保使用的是 okhttp3 的 Callback
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("onFailure", e.getMessage());
//                runOnUiThread(() -> showToast("网络请求失败，请检查网络连接"));
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (response.isSuccessful()) {
//                    final String result = response.body().string();
//                    runOnUiThread(() -> showToast(result));
//                } else {
//                    Log.e("OkHttp", "Request failed with code: " + response.code());
//                    runOnUiThread(() -> showToast("请求失败，状态码：" + response.code()));
//                }
//            }
//        });
//    }
}