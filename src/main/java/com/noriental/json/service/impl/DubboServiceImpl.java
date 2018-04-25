package com.noriental.json.service.impl;


import com.noriental.json.service.DboService;
import com.noriental.xxsvr.bean.GetDataRequest;
import com.noriental.xxsvr.bean.GetDataRsp;
import com.noriental.xxsvr.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Discribe:dubbo service test
 * Project:xx-web
 * Package: com.noriental.service.impl
 * User: Chengwenbo
 * Date:  2015/12/1
 * Time: .15:35
 */
@Service
public class DubboServiceImpl implements DboService {
    /**
     * logger
     */
    Logger logger = LoggerFactory.getLogger(DubboServiceImpl.class);

    @Resource
    DemoService demoService;

    @Override
    public String sayHello(String var1){

        String str = demoService.sayHello(var1);

        logger.info("return string = " + str);

        return  str;
    }

    @Override
    public GetDataRsp getServiceData(GetDataRequest var1){

        GetDataRsp rsp = demoService.getServiceData(var1);

        return rsp;
    }
}
