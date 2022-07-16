package com.radi.swaggerandrestdocs.dtos;

public class MainDTO {
    private String param01 = "value01";
    private String param02 = "value02";

    public MainDTO(String param01, String param02) {
        this.param01 = param01;
        this.param02 = param02;
    }

    public String getParam01() {
        return param01;
    }

    public void setParam01(String param01) {
        this.param01 = param01;
    }

    public String getParam02() {
        return param02;
    }

    public void setParam02(String param02) {
        this.param02 = param02;
    }
}
