package com.example.myapp.entity;

public class LoginResponse {

    /**
     * msg : success
     * code : 0
     * expire : 604800
     * token : eyJ0eXAiOiKV1QiLCJhbGciOjlUzUxMi9.evJzdWiOil2liwiaWFOIOxNTKYNDG2OTQZLCJIeHAiOjE10TMWOTE3NDN9.f5SxyG60GyDI;0FcZEmPAADiLHXpATrvicxbADgvRgYurYQC5s0KAjw5XgHS4gpk-qUSwWtcIpY_njYf_2Dw
     */

    private String msg;
    private int code;
    private int expire;
    private String token;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
