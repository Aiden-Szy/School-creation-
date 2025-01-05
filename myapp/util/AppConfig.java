package com.example.myapp.util;

/**
 * AppConfig 类用于存储应用程序中常用的配置信息。
 * 这些配置信息通常包括但不限于 API 请求的基础 URL、应用版本号等。
 */
public class AppConfig {

    /**
     * 应用程序与服务器通信的基础 URL。
     * 请注意，这里的 IP 地址和端口号是针对本地开发环境设置的，
     * 在生产环境中应当替换为正式的域名或 IP 地址。
     *
     * 当前设置：
     * - IP 地址: 192.168.31.32 （这可能是一个本地网络中的服务器地址）
     * - 端口: 8080 （HTTP 默认端口，如果使用 HTTPS 则通常是 443）
     * - 路径: /renren-fast （可能是后端框架或服务的具体路径）
     *
     * 注意事项：
     * - 对于发布版本，请确保将此 URL 更新为安全的 HTTPS 地址，并且指向实际的服务器位置。
     * - 如果服务器支持 HTTPS，强烈建议使用 HTTPS 来保证数据传输的安全性。
     */
    public static final String BASE_URL = "http://192.168.31.32:8080/renren-fast";
}