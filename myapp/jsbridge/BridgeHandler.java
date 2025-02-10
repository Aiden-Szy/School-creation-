package com.example.myapp.jsbridge;

public interface BridgeHandler {

    void handle(String data, CallBackFunction function);

    /**
     * Handles the data passed from JavaScript and optionally calls back with a result.
     *
     * @param data The data received from JavaScript.
     * @param function The callback function to call with the result, can be null.
     */

    void handler(String data, CallBackFunction function);
}