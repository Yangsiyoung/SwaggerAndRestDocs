package com.radi.swaggerandrestdocs.dtos.request;

public class RequestDTO {

    private String param01;
    private String param02;
    private String param03;

    public RequestDTO(String param01, String param02, String param03) {
        this.param01 = param01;
        this.param02 = param02;
        this.param03 = param03;
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

    public String getParam03() {
        return param03;
    }

    public void setParam03(String param03) {
        this.param03 = param03;
    }
}
