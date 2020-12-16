package com.exa.de.controller;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import io.sentry.Sentry;


@RestController
public class demo {
    public JSONObject jsonObject = new JSONObject();
    private Logger logger = LoggerFactory.getLogger(demo.class);
    String sTime;
    java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @GetMapping(value = "/v1/demo")
    public JSONObject autoDemoData() {
        jsonObject.put("status", 200);
        jsonObject.put("msg", "provider demo");
        jsonObject.put("type", "demo");
        sTime = format1.format(new Date());
        logger.info(sTime + ":" + "客户端访问接口:/v1/demo");
        return jsonObject;
    }

    @GetMapping(value = "/v1/try")
    public JSONObject DemoData() {
        if (1 <= 1) throw new IllegalArgumentException("测试异常");
        logger.info(sTime + ":" + "客户端访问接口:/v1/demo");
        return jsonObject;
    }

    @GetMapping(value = "/v1/dsn")
    public JSONObject DemoTestEx() {
        jsonObject.put("status", 502);
        jsonObject.put("msg", "测试异常");
        jsonObject.put("type", "异常测试");
        try {
            String testC = null;
            String testb = testC.substring(0);
        } catch (Exception e) {
            Sentry.captureException(e);
        }
        return jsonObject;
    }
}
