package com.noriental.json.service;

import com.noriental.xxsvr.bean.GetDataRequest;
import com.noriental.xxsvr.bean.GetDataRsp;

/**
 * Discribe:DubboService
 * Project:xx-web
 * Package: com.noriental.service
 * User: Chengwenbo
 * Date:  2015/11/30
 * Time: .16:22
 */
public interface DboService {

    String sayHello(String var1);

    GetDataRsp getServiceData(GetDataRequest var1);
}
