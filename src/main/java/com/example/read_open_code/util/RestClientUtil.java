package com.example.read_open_code.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RestClientUtil {

    private static RestTemplate restTemplate;

    private static String token;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        RestClientUtil.restTemplate = restTemplate;
    }

    @Value("${open.code.token}")
    public void setToken(String token) {
        RestClientUtil.token = token;
    }

    public static JSONObject executeOpenCode(String url, HttpMethod method, JSONObject param) {

        //请求头
        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);
        headers.set("cookie", "__ddg1=wpVAreYgA2fIFthw6cmt");
        headers.set("sec-ch-ua", "\" Not;A Brand\";v=\"99\", \"Google Chrome\";v=\"91\", \"Chromium\";v=\"91\"");
        headers.set("sec-ch-ua-mobile", "?0");
        headers.set("sec-fetch-dest", "empty");
        headers.set("accept-language", "zh-CN,zh;q=0.9");
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

}
