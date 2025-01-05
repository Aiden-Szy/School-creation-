package com.example.myapp.api;

/**
 * ApiConfig 类用于定义应用程序中 API 请求的基本配置信息。
 * 这里主要包含 API 服务器的基础 URL，所有网络请求都将基于这个地址进行构建。
 */
public class ApiConfig {

    /**
     * BASE_URL 是 API 服务器的基础 URL。
     * <p>
     * 注意事项：
     * - 确保此 URL 指向正确的服务器地址和端口。
     * - 如果服务器使用 HTTPS，请将协议部分改为 "https"。
     * - 在发布应用之前，请检查并更新此 URL 以指向正式环境的服务器。
     * - 对于本地开发环境，确保 IP 地址和端口号正确无误。
     *
     * 当前设置为本地开发服务器地址：
     * {@value} (http://192.168.31.32:8080/renren-fast)
     */
    public static final String BASE_URL = "http://192.168.31.32:8080/renren-fast";
    public static final String LOGIN = "/app/login";
    public static final String REGISTER = "/app/register";
}