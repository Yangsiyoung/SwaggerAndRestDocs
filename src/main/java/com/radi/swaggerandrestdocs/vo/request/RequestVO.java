package com.radi.swaggerandrestdocs.vo.request;

import com.radi.swaggerandrestdocs.exception.Param01EmptyException;
import com.radi.swaggerandrestdocs.exception.Param02EmptyException;

public class RequestVO {

    private String param01;
    private String param02;
    private String param03;
    private String param04;
    private String param05;

    public RequestVO(String param01, String param02, String param03, String param04, String param05) {
        this.param01 = param01;
        this.param02 = param02;
        this.param03 = param03;
        this.param04 = param04;
        this.param05 = param05;
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

    public String getParam04() {
        return param04;
    }

    public void setParam04(String param04) {
        this.param04 = param04;
    }

    public String getParam05() {
        return param05;
    }

    public void setParam05(String param05) {
        this.param05 = param05;
    }

    public void checkField() {
        if (this.param01 == null || "".equals(this.param01)) {
            throw new Param01EmptyException();
        }

        if (this.param02 == null || "".equals(this.param02)) {
            throw new Param02EmptyException();
        }
    }
}
