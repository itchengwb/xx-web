package com.noriental.propertises.service.impl;

import com.noriental.propertises.po.Car;
import com.noriental.propertises.po.ExampleBean;
import com.noriental.propertises.service.ProService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Discribe:glob propertis test
 * Project:xx-web
 * Package: com.noriental.service.impl
 * User: Chengwenbo
 * Date:  2015/11/30
 * Time: .16:22
 */
@Service
public class ProServiceImpl implements ProService {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ProServiceImpl.class);

    @Value("#{hostProp['zk.address']}")
    public String zkHost;

    @Autowired
    public Car car;

    @Autowired
    public ExampleBean exampleBean;


    public void pro() {
        logger.info("car={}", car);
        logger.info("exampleBean={}", exampleBean);
        logger.info("zkHost={}",zkHost);
    }
}
