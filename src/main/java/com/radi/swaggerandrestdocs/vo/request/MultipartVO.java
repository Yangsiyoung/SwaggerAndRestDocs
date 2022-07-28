package com.radi.swaggerandrestdocs.vo.request;

import org.springframework.web.multipart.MultipartFile;

public class MultipartVO {
    private String param01;
    private String param02;
    private String param03;
    private MultipartFile file;

    public MultipartVO(String param01, String param02, String param03, MultipartFile file) {
        this.param01 = param01;
        this.param02 = param02;
        this.param03 = param03;
        this.file = file;
    }

    public String getParam01() {
        return param01;
    }

    public String getParam02() {
        return param02;
    }

    public String getParam03() {
        return param03;
    }

    public MultipartFile getFile() {
        return file;
    }
}
