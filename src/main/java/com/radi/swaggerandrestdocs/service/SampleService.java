package com.radi.swaggerandrestdocs.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radi.swaggerandrestdocs.vo.request.RequestVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SampleService {

    private final Map<String, String> repository = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private Logger log = LoggerFactory.getLogger(SampleService.class);

    public void save(RequestVO requestVO) throws JsonProcessingException {
        repository.put(requestVO.getParam01(), objectMapper.writeValueAsString(requestVO));
        log.info("save key : " + requestVO.getParam01() + ", value : " + repository.get(requestVO.getParam01()));
    }

}
