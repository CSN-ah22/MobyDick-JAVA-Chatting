package com.daelim.five1.Data;

import java.io.Serializable;

public class SettingData implements Serializable {
    private String server, port;

    public  SettingData(){

    }

    public SettingData(String ser, String po){
        setServer(ser);
        setPort(po);
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
