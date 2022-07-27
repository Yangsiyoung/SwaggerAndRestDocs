package com.radi.swaggerandrestdocs.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radi.swaggerandrestdocs.utils.AES256Util;
import com.radi.swaggerandrestdocs.vo.request.RequestVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class SampleService {

    private final Map<String, String> repository = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private Logger log = LoggerFactory.getLogger(SampleService.class);

    @PostConstruct
    public void init() throws UnsupportedEncodingException, GeneralSecurityException {
        AES256Util aes256Util = new AES256Util();
        log.info(aes256Util.generateKey());

    }

    public void save(RequestVO requestVO) throws JsonProcessingException {
        repository.put(requestVO.getParam01(), objectMapper.writeValueAsString(requestVO));
        log.info("save key : " + requestVO.getParam01() + ", value : " + repository.get(requestVO.getParam01()));
    }

}
