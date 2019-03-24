package com.lee.world.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class RequestService {

    Logger logger = LoggerFactory.getLogger(RequestService.class);

    public Object sendRequestWithGet(String url) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity,String.class);
        logger.info("toString" + response.toString());
        logger.info("body" + response.getBody());
        ObjectMapper objMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objMapper.readTree(response.getBody());
            Integer success = jsonNode.get("success").asInt();
            if (success == 1) {
                // 说明为1 ，则进行下一步的操作
                JsonNode node = jsonNode.get("result");
                return node.get("date").asText();
            }
        } catch (IOException e) {
            logger.error("IOException");
        }
        return response;
    }
}
