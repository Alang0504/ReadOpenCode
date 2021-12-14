package com.example.read_open_code.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
public class RestClientUtil {

    private static RestClientUtil restClientUtil;

    private static RestTemplate restTemplate;

    public static JSONObject executeOpenCode(String url, HttpMethod method, JSONObject param) {

        //请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //请求实体
        HttpEntity<JSONObject> entity = new HttpEntity<>(param, headers);

        ResponseEntity<JSONObject> response = null;
        try {
            response = restTemplate.exchange(url, method, entity, JSONObject.class);
        } catch (Exception e) {
            log.error("http请求连接异常,request URL: {}", url, e);
            throw e;
        }

        if (!response.getStatusCode().is2xxSuccessful()) {
            log.error("http请求返回异常,request URL: {}", url);
            throw new RuntimeException("http请求异常");
        }

        JSONObject result = response.getBody();
        if (result == null) {
            log.error("返回结果有问题,request URL: {}", url);
            throw new RuntimeException("返回结果有问题");
        }
        if (result.getBoolean("success")) {
            JSONObject data = result.getJSONObject("data");
            return data;
        } else {
            log.error("接口返回失败,request URL: {}", url);
            throw new RuntimeException(result.getString("message"));
        }
    }

    //加载类的构造函数之后执行
    @PostConstruct
    public void init() {
        restClientUtil = this;
        restClientUtil.restTemplate = this.restTemplate;
    }
}
